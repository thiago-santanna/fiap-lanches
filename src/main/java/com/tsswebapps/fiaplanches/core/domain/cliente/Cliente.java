package com.tsswebapps.fiaplanches.core.domain.cliente;

import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Objects;

public class Cliente {
        private Long id;
        @NotBlank(message = "Nome do cliente deve ser informado")
        private String nome;
        @NotBlank(message = "E-mail do cliente deve ser informado")
        @Email
        private String email;
        @NotBlank(message = "CPF do cliente deve ser informado")
        @Pattern(regexp = "^(\\d{3}\\.?){2}\\d{3}-?\\d{2}$", message = "CPF inválido, informe corretamente.")
        private String cpf;

        public Cliente() {
        }

        public Cliente(Long id, String nome, String email, String cpf) {
                this.id = id;
                this.nome = nome;
                this.email = email;
                this.cpf = cpf;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getNome() {
                return nome;
        }

        public void setNome(String nome) {
                this.nome = nome;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getCpf() {
                return cpf;
        }

        public void setCpf(String cpf) {
                this.cpf = cpf;
        }
}
