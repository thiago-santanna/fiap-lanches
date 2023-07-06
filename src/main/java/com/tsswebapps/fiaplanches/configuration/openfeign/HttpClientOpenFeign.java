package com.tsswebapps.fiaplanches.configuration.openfeign;

import com.tsswebapps.fiaplanches.core.domain.pedido.PagamentoResponse;
import com.tsswebapps.fiaplanches.core.domain.pedido.PedidoPagar;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
@FeignClient(value = "pagamento", url = "${apipag}")
public interface HttpClientOpenFeign {
    @PostMapping()
    PagamentoResponse plugPay(PedidoPagar pedidoPagar);
}
