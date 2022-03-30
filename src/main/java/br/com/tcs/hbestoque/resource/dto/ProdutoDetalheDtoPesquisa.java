package br.com.tcs.hbestoque.resource.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.tcs.hbestoque.model.ProdutoDetalhe;

public class ProdutoDetalheDtoPesquisa {
	
	private Long id;
	private ProdutoDtoPesquisa produto;
	private BigDecimal custoUnidade;
	private BigDecimal precoUnitario;
	private Integer tipoEmbalagem;
	private Integer volume;
	private LocalDateTime dtUltAlt;
	
	public static ProdutoDetalheDtoPesquisa parse(ProdutoDetalhe detalhe) {
		ProdutoDetalheDtoPesquisa dto = new ProdutoDetalheDtoPesquisa();
		dto.setId(detalhe.getId());
		dto.setProduto(ProdutoDtoPesquisa.parse(detalhe.getProduto()));
		dto.setCustoUnidade(detalhe.getCustoUnidade());
		dto.setPrecoUnitario(detalhe.getPrecoUnitario());
		dto.setVolume(detalhe.getVolume().ordinal());
		dto.setTipoEmbalagem(detalhe.getTipoEmbalagem().ordinal());
		dto.setDtUltAlt(detalhe.getDtUltAlt());
		return dto;
	}
	
	
	public static List<ProdutoDetalheDtoPesquisa> parseToDtos(List<ProdutoDetalhe>detalhes) {
		List<ProdutoDetalheDtoPesquisa>list = new ArrayList<ProdutoDetalheDtoPesquisa>();
		detalhes.forEach(d -> list.add( parse(d) ));
		return list;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ProdutoDtoPesquisa getProduto() {
		return produto;
	}
	public void setProduto(ProdutoDtoPesquisa produto) {
		this.produto = produto;
	}
	
	public BigDecimal getCustoUnidade() {
		return custoUnidade;
	}


	public void setCustoUnidade(BigDecimal custoUnidade) {
		this.custoUnidade = custoUnidade;
	}


	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}


	public void setPrecoUnitario(BigDecimal precoUnitario) {
		this.precoUnitario = precoUnitario;
	}


	public Integer getTipoEmbalagem() {
		return tipoEmbalagem;
	}
	public void setTipoEmbalagem(Integer tipoEmbalagem) {
		this.tipoEmbalagem = tipoEmbalagem;
	}
	public Integer getVolume() {
		return volume;
	}
	public void setVolume(Integer volume) {
		this.volume = volume;
	}
	public LocalDateTime getDtUltAlt() {
		return dtUltAlt;
	}
	public void setDtUltAlt(LocalDateTime dtUltAlt) {
		this.dtUltAlt = dtUltAlt;
	}
	
}
