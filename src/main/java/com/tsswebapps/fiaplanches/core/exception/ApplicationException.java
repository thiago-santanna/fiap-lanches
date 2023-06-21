package com.tsswebapps.fiaplanches.core.exception;

import com.tsswebapps.fiaplanches.core.dto.TipoExcecao;

public class ApplicationException extends RuntimeException {
    private TipoExcecao tipoExcecao;

    public ApplicationException(TipoExcecao tipoExcecao) {
        this.tipoExcecao = tipoExcecao;
    }

    public ApplicationException() {
    }

    public TipoExcecao getTipoExcecao() {
        return tipoExcecao;
    }

    public void setTipoExcecao(TipoExcecao tipoExcecao) {
        this.tipoExcecao = tipoExcecao;
    }
}
