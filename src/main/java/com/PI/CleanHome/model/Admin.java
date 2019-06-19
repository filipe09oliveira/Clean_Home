package com.PI.CleanHome.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity(name= "admin")
public class Admin implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 40)
	@NotBlank(message = "Nome é uma informação obrigatória.")
	private String nome;
	
	@Column(nullable = false, length = 35)
	@NotBlank(message = "Email é uma informação obrigatória.")
	private String email;
	
	@Column(nullable = false, length = 80)
	@NotBlank(message = "Senha é uma informação obrigatória.")
	private String senha;
	
	@Column(length = 8)
	private String Role = "admin";

	public Admin() {
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", Role=" + Role + "]";
	}

	
}
