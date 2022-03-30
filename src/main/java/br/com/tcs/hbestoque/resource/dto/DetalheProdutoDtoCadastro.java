package br.com.tcs.hbestoque.resource.dto;

import java.time.LocalDateTime;

import br.com.tcs.hbestoque.model.Produto;
import br.com.tcs.hbestoque.model.ProdutoDetalhe;

public class DetalheProdutoDtoCadastro {
	
	private Long idProduto;
	private String descricao;
	private Integer categoria;
	private Integer volume;
	private Integer tipoEmbalagem;
	
	
	public static ProdutoDetalhe parse(DetalheProdutoDtoCadastro dto){
		ProdutoDetalhe dt = new ProdutoDetalhe();
		dt.setDescricao(dto.getDescricao());
		dt.setProduto(new Produto(dto.getIdProduto()));
		dt.setCategoria(CommonDto.parseCategoria(dto.getCategoria()));
		dt.setVolume(CommonDto.parseVolume(dto.getVolume()));
		dt.setTipoEmbalagem(CommonDto.parseTipoEmbalabem(dto.getTipoEmbalagem()));
		dt.setDtUltAlt(LocalDateTime.now());
		return dt;
	}	
		
	public Long getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
	@Override
	public String toString() {
		return "DetalheProdutoDtoCadastro [idProduto=" + idProduto + ", descricao=" + descricao + ", categoria="
				+ categoria + ", volume=" + volume + ", tipoEmbalagem=" + tipoEmbalagem + "]";
	}
	
}
