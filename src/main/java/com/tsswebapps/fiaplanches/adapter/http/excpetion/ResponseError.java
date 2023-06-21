package com.tsswebapps.fiaplanches.adapter.http.excpetion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ResponseError {
    private List<String> mensagens = new ArrayList<>();
    private String erro;
    private int codigo;
    private Date timestamp;
    private String path;
}
