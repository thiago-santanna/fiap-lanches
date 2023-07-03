package com.tsswebapps.fiaplanches.adapter.database.pedido;

import com.tsswebapps.fiaplanches.adapter.database.cliente.repository.ClienteSpringDataJPARepository;
import com.tsswebapps.fiaplanches.adapter.database.pedido.entity.PedidoEntity;
import com.tsswebapps.fiaplanches.adapter.database.pedido.repository.PedidoSprinfDataJpaRepository;
import com.tsswebapps.fiaplanches.adapter.mapper.PedidoMapper;
import com.tsswebapps.fiaplanches.core.domain.pedido.Pedido;
import com.tsswebapps.fiaplanches.core.domain.pedido.ports.PedidoCriadoResponse;
import com.tsswebapps.fiaplanches.core.domain.pedido.ports.out.PedidoRepository;
import com.tsswebapps.fiaplanches.core.dto.TipoExcecao;
import com.tsswebapps.fiaplanches.core.exception.ApplicationException;
import org.springframework.stereotype.Repository;

@Repository
public class PedidoRepositorySpringDataJpaImpl implements PedidoRepository {
    private final PedidoSprinfDataJpaRepository repository;
    private final ClienteSpringDataJPARepository clienteRepository;
    private final PedidoMapper mapper;

    public PedidoRepositorySpringDataJpaImpl(PedidoSprinfDataJpaRepository repository, ClienteSpringDataJPARepository clienteRepository, PedidoMapper mapper) {
        this.repository = repository;
        this.clienteRepository = clienteRepository;
        this.mapper = mapper;
    }

    @Override
    public PedidoCriadoResponse criarPedido(Pedido pedido) {
        PedidoEntity entity = mapper.toPedidoEntity(pedido);

        setCliente(pedido, entity);

        PedidoEntity pedidoEntity = repository.save(entity);
        return new PedidoCriadoResponse(pedidoEntity.getComanda());
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
