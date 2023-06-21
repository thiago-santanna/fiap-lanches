package com.tsswebapps.fiaplanches.core.dto;

public enum TipoExcecao {

    DADOS_OBRIGATORIOS {
        @Override
        public String getMessagemError() {
            return "Todos os campos devem ser informados.";
        }
    };

    public abstract String getMessagemError();
}
