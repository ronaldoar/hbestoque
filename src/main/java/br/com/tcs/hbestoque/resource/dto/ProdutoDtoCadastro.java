	package br.com.tcs.hbestoque.resource.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.tcs.hbestoque.model.Fornecedor;
import br.com.tcs.hbestoque.model.Produto;

public class ProdutoDtoCadastro {

	private Long idFornecedor;
	private String nome;
	private BigDecimal valorUnidade;
	private boolean ativo;
	
	public static Produto parse(ProdutoDtoCadastro dto) {
		Produto p = new Produto();
		p.setNome(dto.getNome());
		p.setFornecedor(new Fornecedor(dto.getIdFornecedor()));
		p.setValorUnidade(dto.getValorUnidade());
		p.setDtCadastro(LocalDateTime.now());
		p.setDtUltAlt(LocalDateTime.now());
		p.setAtivo(dto.isAtivo());
		return p;
	}

	public Long getIdFornecedor() {
		return idFornecedor;
	}
	public void setIdFornecedor(Long idFornecedor) {
		this.idFornecedor = idFornecedor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigDecimal getValorUnidade() {
		return valorUnidade;
	}
	public void setValorUnidade(BigDecimal valorUnidade) {
		this.valorUnidade = valorUnidade;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
}
