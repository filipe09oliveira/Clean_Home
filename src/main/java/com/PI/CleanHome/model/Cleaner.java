package com.PI.CleanHome.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity(name = "cleaner")
public class Cleaner implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Column(nullable = false, length = 20)
	@NotBlank(message = "Nome é uma informação obrigatória.")
	String nomecompleto;

	@Column(nullable = false, length = 14, unique = true)
	@NotEmpty(message = "CPF é uma informação obrigatória.")
	String cpf;

	@Column(nullable = false, length = 9)
	@NotBlank(message = "RG é uma informação obrigatória.")
	String rg;

	@Column(nullable = false, length = 62)
	@NotBlank(message = "E-mail é uma informação obrigatória.")
	String email;

	@Column(nullable = false, length = 15)
	@NotBlank(message = "Telefone é uma informação obrigatória.")
	private String telefone1;

	@Column(length = 15)
	private String telefone2;

	@Column(length = 50)
	private String endereco;

	@Column(length = 50)
	private String bairro;

	@Column(length = 50)
	private String cidade;

	@Column(length = 3)
	private String uf;

	@Column(length = 50)
	private String cep;

	@Column(length = 80)
	private String senha = "cleaner12345";

	@Column(length = 8)
	private String Role = "cleaner";

	@Column(length = 20)
	private String status = "pendente";

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getNomecompleto() {
		return nomecompleto;
	}

	public void setNomecompleto(String nomecompleto) {
		this.nomecompleto = nomecompleto;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Cleaner [id=" + id + ", nomecompleto=" + nomecompleto + ", cpf=" + cpf + ", rg=" + rg + ", email="
				+ email + ", telefone1=" + telefone1 + ", telefone2=" + telefone2 + ", endereco=" + endereco
				+ ", bairro=" + bairro + ", cidade=" + cidade + ", uf=" + uf + ", cep=" + cep + ", senha=" + senha
				+ ", Role=" + Role + ", status=" + status + "]";
	}
}
