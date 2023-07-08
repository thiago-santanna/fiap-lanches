package com.tsswebapps.fiaplanches.adapter.database.pedido;

import com.tsswebapps.fiaplanches.adapter.database.cliente.repository.ClienteSpringDataJPARepository;
import com.tsswebapps.fiaplanches.adapter.database.item.entity.ItemEntity;
import com.tsswebapps.fiaplanches.adapter.database.item.repository.ItemSpringDataJpaRepository;
import com.tsswebapps.fiaplanches.adapter.database.pedido.entity.ItemPedidoEntity;
import com.tsswebapps.fiaplanches.adapter.database.pedido.entity.PedidoEntity;
import com.tsswebapps.fiaplanches.adapter.database.pedido.repository.PedidoSprinfDataJpaRepository;
import com.tsswebapps.fiaplanches.adapter.mapper.PedidoMapper;
import com.tsswebapps.fiaplanches.core.domain.pedido.*;
import com.tsswebapps.fiaplanches.core.domain.pedido.ports.out.PedidoRepository;
import com.tsswebapps.fiaplanches.core.dto.TipoExcecao;
import com.tsswebapps.fiaplanches.core.exception.ApplicationException;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Set;

@Repository
public class PedidoRepositorySpringDataJpaImpl implements PedidoRepository {
    private final PedidoSprinfDataJpaRepository repository;
    private final ClienteSpringDataJPARepository clienteRepository;
    private final ItemSpringDataJpaRepository itemSpringDataJpaRepository;

    private final PedidoMapper mapper;

    public PedidoRepositorySpringDataJpaImpl(PedidoSprinfDataJpaRepository repository, ClienteSpringDataJPARepository clienteRepository, ItemSpringDataJpaRepository itemSpringDataJpaRepository, PedidoMapper mapper) {
        this.repository = repository;
        this.clienteRepository = clienteRepository;
        this.itemSpringDataJpaRepository = itemSpringDataJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public PedidoCriadoResponse criarPedido(Pedido pedido) {
        PedidoEntity entity = mapper.toPedidoEntity(pedido);

        setCliente(pedido, entity);

        PedidoEntity pedidoEntity = repository.save(entity);
        return new PedidoCriadoResponse(pedidoEntity.getComanda());
    }

    @Override
    @Transactional
    public ItemPedidoResponse adicionarItemAopedido(String comanda, ItemPedido pedidoItemAdicionado) {
        PedidoEntity pedidoEntity = getPedidoEntity(comanda);

        ItemEntity itemEntity = itemSpringDataJpaRepository.findByReferenciaFabricante(
                pedidoItemAdicionado.getItem().getReferenciaFabricante()).orElseThrow(
                () -> new ApplicationException(TipoExcecao.RECURSO_NAO_ENCONTRADO)
        );

        ItemPedidoEntity itemPedidoEntity = new ItemPedidoEntity();
        itemPedidoEntity.setQuantidade(pedidoItemAdicionado.getQuantidade());
        itemPedidoEntity.setItem(itemEntity);

        pedidoEntity.adicionarItemPedidoEntity(itemPedidoEntity);
        pedidoEntity.setValorTotal(pedidoEntity.getValorTotal().add(itemPedidoEntity.getItem().getValor().multiply(
                BigDecimal.valueOf(itemPedidoEntity.getQuantidade()))));
        repository.save(pedidoEntity);

        return new ItemPedidoResponse(
                itemPedidoEntity.getItem().getReferenciaFabricante(),
                itemPedidoEntity.getItem().getNome(),
                itemPedidoEntity.getItem().getDescricao(),
                itemPedidoEntity.getItem().getValor());
    }

    @Override
    @Transactional
    public void removerItemDoPedido(String comanda, String referenciaItem) {
        PedidoEntity pedidoEntity = getPedidoEntity(comanda);
        Set<ItemPedidoEntity> itensPedido = pedidoEntity.getItensPedido();

        ItemPedidoEntity itemPedidoEntity = itensPedido
                .stream()
                .filter(itens -> itens.getItem().getReferenciaFabricante().equals(referenciaItem))
                .findFirst()
                .orElseThrow(() -> new ApplicationException(TipoExcecao.RECURSO_NAO_ENCONTRADO));

        BigDecimal valorItemRemovido = itemPedidoEntity.getItem().getValor();
        itensPedido.remove(itemPedidoEntity);
        pedidoEntity.setValorTotal(pedidoEntity.getValorTotal().subtract(valorItemRemovido));
        repository.save(pedidoEntity);
    }

    @Override
    @Transactional
    public void confirmarPedido(String comanda) {
        PedidoEntity pedidoEntity = getPedidoEntity(comanda);
        pedidoEntity.setSituacaoPedido(SituacaoPedido.RECEBIDO);
        repository.save(pedidoEntity);
    }

    @Override
    @Transactional
    public void confirmarPagamentoPedido(String comanda) {
        PedidoEntity pedidoEntity = getPedidoEntity(comanda);
        pedidoEntity.setSituacaoPedido(SituacaoPedido.EM_PREPARACAO);
        repository.save(pedidoEntity);
    }

    @Override
    public Pedido getPedido(String comanda) {
        return mapper.toPedido(getPedidoEntity(comanda));
    }

    @Override
    public void finalizarPedido(String comanda) {
        PedidoEntity pedidoEntity = getPedidoEntity(comanda);
        pedidoEntity.setSituacaoPedido(SituacaoPedido.FINALIZADO);
        repository.save(pedidoEntity);
    }

    @Override
    public void entregarPedido(String comanda) {
        PedidoEntity pedidoEntity = getPedidoEntity(comanda);
        pedidoEntity.setSituacaoPedido(SituacaoPedido.PRONTO);
        repository.save(pedidoEntity);
    }

    @Override
    public AndamentoPedido checarAndamentoPedido(String comanda) {
        PedidoEntity pedidoEntity = getPedidoEntity(comanda);

        return new AndamentoPedido(
                pedidoEntity.getComanda(),
                pedidoEntity.getDataHoraPedido(),
                pedidoEntity.getSituacaoPedido());
    }

    private PedidoEntity getPedidoEntity(String comanda) {
        return repository.findByComanda(comanda).orElseThrow(
                () -> new ApplicationException(TipoExcecao.RECURSO_NAO_ENCONTRADO)
        );
    }

    private void setCliente(Pedido pedido, PedidoEntity entity) {
        if (pedido.getCliente() != null) {
            if(pedido.getCliente().getCpf() != null) {
                entity.setCliente(clienteRepository.findByCpf(pedido.getCliente().getCpf()).orElseThrow(
                        () -> new ApplicationException(TipoExcecao.CLIENTE_NAO_ENCONTRADO)
                ));
            }
        }
    }
}
