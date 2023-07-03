package com.tsswebapps.fiaplanches.core.domain.pedido;

import java.util.Random;

class GerarComandas {
    static String executar(int digits) {
        Random random = new Random();
        StringBuilder code = new StringBuilder();

        for (int i = 0; i < digits; i++) {
            int digito = random.nextInt(10);
            code.append(digito);
        }
        return code.toString();
    }
}
