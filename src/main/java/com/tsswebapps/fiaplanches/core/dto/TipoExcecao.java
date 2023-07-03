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
    },
    CATEGORIA_NAO_ENCONTRADA {
        @Override
        public String getMessagemError() {
            return "O Recurso que foi chamado não existe, verifique os parametros e tente novamente";
        }
    },
    CODIGO_NAO_INFORMADO {
        @Override
        public String getMessagemError() {
            return "O código deve ser informado.";
        }
    },
    RECURSO_DUPLICADO {
        @Override
        public String getMessagemError() {
            return "O registro informado não pode ser duplicado.";
        }
    },
    CLIENTE_NAO_ENCONTRADO {
        @Override
        public String getMessagemError() {
            return "O Cliente informado não foi encontrado.";
        }
    };

    public abstract String getMessagemError();
}
