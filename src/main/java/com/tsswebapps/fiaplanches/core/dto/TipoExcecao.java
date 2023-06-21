package com.tsswebapps.fiaplanches.core.dto;

public enum TipoExcecao {

    DADOS_OBRIGATORIOS {
        @Override
        public String getMessagemError() {
            return "Todos os campos devem ser informados.";
        }
    },
    CPF_DEVE_SER_INFORMADO {
        @Override
        public String getMessagemError() {
            return "O CPF do cliente deve ser informado ao iniciar um pedido.";
        }
    },
    ERRO {
        @Override
        public String getMessagemError() {
            return "Erro ao realizar a operação.";
        }
    },
    RECURSO_NAO_ENCONTRADO {
        @Override
        public String getMessagemError() {
            return "O Recurso que foi chamado não existe, verifique os parametros e tente novamente";
        }
    };

    public abstract String getMessagemError();
}
