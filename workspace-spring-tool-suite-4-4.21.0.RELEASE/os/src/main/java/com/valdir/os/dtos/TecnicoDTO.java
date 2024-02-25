package com.valdir.os.dtos;

import java.io.Serializable;
import java.util.Objects;

import org.hibernate.validator.constraints.br.CPF;

import com.valdir.os.domain.Tecnico;

import jakarta.validation.constraints.NotEmpty;


public class TecnicoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotEmpty(message = "Insira um nome válido!")
	private String nome;
	@NotEmpty(message = "Insira um telefone Válido!")
	private String telefone;
	@CPF
	@NotEmpty(message = "Insira um CPF Válido!")
	private String cpf;
	
	public TecnicoDTO() {
		super();
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public TecnicoDTO(Tecnico obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.telefone = obj.getTelefone();
		this.cpf = obj.getCpf();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TecnicoDTO other = (TecnicoDTO) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
