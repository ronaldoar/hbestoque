	package br.com.tcs.hbestoque.resource.dto;

import java.time.LocalDateTime;

import br.com.tcs.hbestoque.model.Fornecedor;
import br.com.tcs.hbestoque.model.Produto;
import br.com.tcs.hbestoque.model.commons.CategoriaProdutoEnum;
import br.com.tcs.hbestoque.model.commons.TipoEnvazamentoEnum;

public class ProdutoDtoCadastro {

	private Long idFornecedor;
	private String nome;
	private Integer categoria;
	private Integer tipoEnvazamento;
	private boolean ativo;
	
	public static Produto parse(ProdutoDtoCadastro dto) {
		Produto p = new Produto();
		p.setNome(dto.getNome());
		p.setFornecedor(new Fornecedor(dto.getIdFornecedor()));
		p.setCategoria(CategoriaProdutoEnum.values()[dto.getCategoria()]);
		p.setTipoEnvazamento(TipoEnvazamentoEnum.values()[dto.getTipoEnvazamento()]);
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
	public Integer getCategoria() {
		return categoria;
	}
	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}
	public Integer getTipoEnvazamento() {
		return tipoEnvazamento;
	}
	public void setTipoEnvazamento(Integer tipoEnvazamento) {
		this.tipoEnvazamento = tipoEnvazamento;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
}
