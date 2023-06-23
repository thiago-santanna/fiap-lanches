package com.tsswebapps.fiaplanches.adapter.database.item.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "itens")
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String referenciaFabricante;
    private String nome;
    private String descricao;
    private BigDecimal valor;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "categoria_id")
    private CategoriaEntity categoria;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<ImagemEntity> imagens = new HashSet<>();

    public ItemEntity() {
    }

    public ItemEntity(Long id, String referenciaFabricante, String nome, String descricao, BigDecimal valor, CategoriaEntity categoria, Set<ImagemEntity> imagens) {
        this.id = id;
        this.referenciaFabricante = referenciaFabricante;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
        this.imagens = imagens;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReferenciaFabricante() {
        return referenciaFabricante;
    }

    public void setReferenciaFabricante(String referenciaFabricante) {
        this.referenciaFabricante = referenciaFabricante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public CategoriaEntity getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEntity categoria) {
        this.categoria = categoria;
    }

    public Set<ImagemEntity> getImagens() {
        return imagens;
    }

    public void setImagens(Set<ImagemEntity> imagens) {
        this.imagens = imagens;
    }
}
