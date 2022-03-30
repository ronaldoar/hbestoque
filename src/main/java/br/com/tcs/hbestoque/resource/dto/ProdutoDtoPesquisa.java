	package br.com.tcs.hbestoque.resource.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.tcs.hbestoque.model.Produto;

public class ProdutoDtoPesquisa {

	private Long id;
	private Long idFornecedor;
	private String nomeFornecedor;
	private String nome;
	private BigDecimal valorUnidade;
	private boolean ativo;
	

	public static ProdutoDtoPesquisa parse(Produto produto) {
		ProdutoDtoPesquisa dto = new ProdutoDtoPesquisa();
		dto.setId(produto.getId());
		dto.setIdFornecedor(produto.getFornecedor().getId());
		dto.setNomeFornecedor(produto.getFornecedor().getNome());
		dto.setNome(produto.getNome());
		dto.setValorUnidade(produto.getValorUnidade());
		dto.setAtivo(produto.isAtivo());
		return dto;
	}
	
	
	public static List<ProdutoDtoPesquisa> parseList(List<Produto>lista){
		List<ProdutoDtoPesquisa>dtos = new ArrayList<ProdutoDtoPesquisa>();
		
		for(Produto p : lista) {
			ProdutoDtoPesquisa pDto = parse(p);
			dtos.add(pDto);
		}
		return dtos;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdFornecedor() {
		return idFornecedor;
	}
	public void setIdFornecedor(Long idFornecedor) {
		this.idFornecedor = idFornecedor;
	}
	public String getNomeFornecedor() {
		return nomeFornecedor;
	}
	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
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
