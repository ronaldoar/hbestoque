package br.com.tcs.hbestoque.resource.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.tcs.hbestoque.model.Fornecedor;
import br.com.tcs.hbestoque.model.Produto;

public class FornecedorDto {
	
	private Long id;
	private String nome;
	private Long cnpj;
	private boolean ativo;
	
	public static Fornecedor parse(FornecedorDto dto) {
		Fornecedor f = new Fornecedor();
		f.setAtivo(true);
		f.setCnpj(dto.getCnpj());
		f.setDtCadastro(LocalDateTime.now());
		f.setDtUltAlt(LocalDateTime.now());
		f.setNome(dto.getNome());
		return f;
	}
	
	public static FornecedorDto parse(Fornecedor f) {
		FornecedorDto dto = new FornecedorDto();
		dto.setAtivo(true);
		dto.setCnpj(dto.getCnpj());
		dto.setNome(dto.getNome());
		return dto;
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
	public Long getCnpj() {
		return cnpj;
	}
	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
}
