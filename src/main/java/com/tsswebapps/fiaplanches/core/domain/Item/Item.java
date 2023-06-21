package com.tsswebapps.fiaplanches.core.domain.Item;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Item {
    private final String referenciaFabricante;
    private final String nome;
    private final String descricao;
    private final BigDecimal valor;
    private final Categoria categoria;
    private Set<String> imagens = new HashSet<>();

    public Item(String referenciaFabricante, String nome, String descricao, BigDecimal valor, Categoria categoria,
                Set<String> imagens) {
        this.referenciaFabricante = referenciaFabricante;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
        this.imagens = imagens;
    }

    public Set<String> getImagens() {
        return Collections.unmodifiableSet(this.imagens);
    }
    public String getReferenciaFabricante() {
        return referenciaFabricante;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(referenciaFabricante, item.referenciaFabricante) && Objects.equals(nome, item.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(referenciaFabricante, nome);
    }

    @Override
    public String toString() {
        return "Item{" +
                "referenciaFabricante='" + referenciaFabricante + '\'' +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", categoria=" + categoria +
                ", imagens=" + imagens +
                '}';
    }
}
