package com.tsswebapps.fiaplanches.adapter.database.item.entity;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "imagens")
public class ImagemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String path;

    public ImagemEntity() {
    }

    public ImagemEntity(Long id, String path) {
        this.id = id;
        this.path = path;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Imagem{" +
                "id=" + id +
                ", path='" + path + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImagemEntity imagemEntity = (ImagemEntity) o;
        return Objects.equals(id, imagemEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
