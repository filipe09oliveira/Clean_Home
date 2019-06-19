package com.PI.CleanHome.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity(name = "cliente")
public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 35)
	@NotEmpty(message = "Nome é uma informação obrigatória.")
	private String nome;

	@Column(nullable = false, length = 14, unique = true)
	@NotEmpty(message = "CPF é uma informação obrigatória.")
	private String cpf;
	
	@Column(nullable = false, length = 14, unique = true)
	@NotEmpty(message = "CPF é uma informação obrigatória.")
	private String rg;

	@Column(nullable = false, length = 12)
	@NotEmpty(message = "CEP é uma informação obrigatória.")
	private String cep;

	@Column(nullable = false, length = 45)
	@NotEmpty(message = "Endereço é uma informação obrigatória.")
	private String endereco;

	@Column(nullable = false, length = 25)
	@NotEmpty(message = "Cidade é uma informação obrigatória.")
	private String cidade;

	@Column(nullable = false, length = 2)
	@NotEmpty(message = "UF é uma informação obrigatória.")
	private String uf;

	@Column(nullable = false, length = 50)
	@NotEmpty(message = "Bairro é uma informação obrigatória.")
	private String bairro;
	
	@Column(nullable = false, length = 15)
	@NotEmpty(message = "E-mail é uma informação obrigatória.")
	private String telefone;

	@Column(nullable = false, length = 62, unique = true)
	@NotEmpty(message = "E-mail é uma informação obrigatória.")
	private String email;

	@Column(length = 80)
	@NotEmpty(message = "Senha é uma informação obrigatória.")
	@Size(min = 8, message = "A senha deve conter no mínimo 8 caracteres.")
	private String senha;
	
//	@Transient
//	@Size(min = 8, message = "A senha deve conter no mínimo 8 caracteres.")
//	private String senhaNova;

	@Column(nullable = false, length = 50)
	private String Role = "cliente";
	
	

	public Cliente() {

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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
		return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", cep=" + cep + ", endereco="
				+ endereco + ", cidade=" + cidade + ", uf=" + uf + ", bairro=" + bairro + ", telefone=" + telefone
				+ ", email=" + email + ", senha=" + senha + ", Role=" + Role + "]";
	}



	
}
