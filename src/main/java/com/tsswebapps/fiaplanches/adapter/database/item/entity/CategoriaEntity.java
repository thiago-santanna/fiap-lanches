package com.tsswebapps.fiaplanches.adapter.database.item.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "categorias")
public class CategoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String descricao;
    @OneToMany(mappedBy = "categoria")
    private List<ItemEntity> itens = new ArrayList<>();

    public CategoriaEntity() {
    }

    public CategoriaEntity(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public CategoriaEntity(Long id, String descricao, List<ItemEntity> itens) {
        this.id = id;
        this.descricao = descricao;
        this.itens = itens;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<ItemEntity> getItens() {
        return itens;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setItens(List<ItemEntity> itens) {
        this.itens = itens;
    }

    @Override
    public String toString() {
        return "CategoriaEntity{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", itens=" + itens +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoriaEntity that = (CategoriaEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
