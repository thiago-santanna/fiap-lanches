package com.tsswebapps.fiaplanches.adapter.integracao;

import com.tsswebapps.fiaplanches.configuration.openfeign.HttpClientOpenFeign;
import com.tsswebapps.fiaplanches.core.domain.pedido.PagamentoResponse;
import com.tsswebapps.fiaplanches.core.domain.pedido.PedidoPagar;
import com.tsswebapps.fiaplanches.core.domain.pedido.ports.out.PagarPedidoIntegracaoPort;
import com.tsswebapps.fiaplanches.core.dto.TipoExcecao;
import com.tsswebapps.fiaplanches.core.exception.ApplicationException;
import org.springframework.stereotype.Service;

@Service
public class PagarPedidoIntegracaoImpl implements PagarPedidoIntegracaoPort {

    private final HttpClientOpenFeign clientOpenFeign;

    public PagarPedidoIntegracaoImpl(HttpClientOpenFeign clientOpenFeign) {
        this.clientOpenFeign = clientOpenFeign;
    }

    @Override
    public PagamentoResponse executar(PedidoPagar pedidoPagar) {
        try {
            return clientOpenFeign.plugPay(pedidoPagar);
        }catch (RuntimeException exception) {
            throw new ApplicationException(TipoExcecao.ERRO);
        }
    }
}
