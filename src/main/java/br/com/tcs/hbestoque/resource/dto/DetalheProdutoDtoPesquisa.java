package br.com.tcs.hbestoque.resource.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.tcs.hbestoque.model.ProdutoDetalhe;

public class DetalheProdutoDtoPesquisa {
	
	private Long id;
	private String descricao;
	private ProdutoDtoPesquisa produto;
	private Integer categoria;
	private Integer volume;
	private Integer tipoEmbalagem;
	private LocalDateTime dtUltAlt;
	
	
	public static DetalheProdutoDtoPesquisa parse(ProdutoDetalhe detalhe) {
		DetalheProdutoDtoPesquisa dto = new DetalheProdutoDtoPesquisa();
		dto.setId(detalhe.getId());
		dto.setDescricao(detalhe.getDescricao());
		dto.setProduto(ProdutoDtoPesquisa.parse(detalhe.getProduto()));
		dto.setCategoria(detalhe.getCategoria().ordinal());
		dto.setVolume(detalhe.getVolume().ordinal());
		dto.setTipoEmbalagem(detalhe.getTipoEmbalagem().ordinal());
		dto.setDtUltAlt(detalhe.getDtUltAlt());
		return dto;
	}
	
	
	public static List<DetalheProdutoDtoPesquisa> parseToDtos(List<ProdutoDetalhe>detalhes) {
		List<DetalheProdutoDtoPesquisa>list = new ArrayList<DetalheProdutoDtoPesquisa>();
		detalhes.forEach(d -> list.add( parse(d) ));
		return list;
	}
			
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public ProdutoDtoPesquisa getProduto() {
		return produto;
	}
	public void setProduto(ProdutoDtoPesquisa produto) {
		this.produto = produto;
	}
	public Integer getCategoria() {
		return categoria;
	}
	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}
	public Integer getVolume() {
		return volume;
	}
	public void setVolume(Integer volume) {
		this.volume = volume;
	}
	public Integer getTipoEmbalagem() {
		return tipoEmbalagem;
	}
	public void setTipoEmbalagem(Integer tipoEmbalagem) {
		this.tipoEmbalagem = tipoEmbalagem;
	}
	public LocalDateTime getDtUltAlt() {
		return dtUltAlt;
	}
	public void setDtUltAlt(LocalDateTime dtUltAlt) {
		this.dtUltAlt = dtUltAlt;
	}
	@Override
	public String toString() {
		return "DetalheProdutoDtoPesquisa [id=" + id + ", descricao=" + descricao + ", produto=" + produto
				+ ", categoria=" + categoria + ", volume=" + volume + ", tipoEmbalagem=" + tipoEmbalagem + ", dtUltAlt="
				+ dtUltAlt + "]";
	}
	
}
