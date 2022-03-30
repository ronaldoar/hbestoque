package br.com.tcs.hbestoque.resource.dto;

import java.time.LocalDateTime;

import br.com.tcs.hbestoque.model.Fornecedor;

public class FornecedorDto {
	
	private Long id;
	private String nome;
	private Long cnpj;
	private LocalDateTime dtCadastro;
	private LocalDateTime dtUltAlt;
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
	
	public static FornecedorDto parse(Fornecedor fornecedor) {
		FornecedorDto dto = new FornecedorDto();
		dto.setAtivo(fornecedor.isAtivo());
		dto.setCnpj(fornecedor.getCnpj());
		dto.setNome(fornecedor.getNome());
		dto.setDtUltAlt(fornecedor.getDtUltAlt());
		dto.setDtCadastro(fornecedor.getDtCadastro());
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
	public LocalDateTime getDtCadastro() {
		return dtCadastro;
	}
	public void setDtCadastro(LocalDateTime dtCadastro) {
		this.dtCadastro = dtCadastro;
	}
	public LocalDateTime getDtUltAlt() {
		return dtUltAlt;
	}
	public void setDtUltAlt(LocalDateTime dtUltAlt) {
		this.dtUltAlt = dtUltAlt;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "FornecedorDto [id=" + id + ", nome=" + nome + ", cnpj=" + cnpj + ", dtCadastro=" + dtCadastro
				+ ", dtUltAlt=" + dtUltAlt + ", ativo=" + ativo + "]";
	}
	
}
