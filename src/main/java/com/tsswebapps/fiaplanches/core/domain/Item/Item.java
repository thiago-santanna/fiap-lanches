package com.tsswebapps.fiaplanches.core.domain.Item;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

import java.util.Objects;
import java.util.Set;

public class Item {
        private Long id;
        @NotBlank(message = "A referencia do fabricante é obrigatória.")
        private String referenciaFabricante;
        @NotBlank(message = "A nome do item deve ser informado.")
        private String nome;
        @NotBlank(message = "A descrição do item deve ser informado.")
        private String descricao;
        @Positive(message = "O valor do item deve ser informado")
        private BigDecimal valor;
        @Valid
        private Categoria categoria;
        private Set<Imagem> imagens;

        public Item() {
        }

        public Item(Long id, String referenciaFabricante, String nome, String descricao, BigDecimal valor,
                    Categoria categoria, Set<Imagem> imagens) {
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

        public Categoria getCategoria() {
                return categoria;
        }

        public void setCategoria(Categoria categoria) {
                this.categoria = categoria;
        }

        public Set<Imagem> getImagens() {
                return imagens;
        }

        public void setImagens(Set<Imagem> imagens) {
                this.imagens = imagens;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Item item = (Item) o;
                return Objects.equals(id, item.id) && Objects.equals(referenciaFabricante, item.referenciaFabricante);
        }

        @Override
        public int hashCode() {
                return Objects.hash(id, referenciaFabricante);
        }
}

