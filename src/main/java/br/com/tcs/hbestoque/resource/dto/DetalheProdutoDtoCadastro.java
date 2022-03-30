package br.com.tcs.hbestoque.resource.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.tcs.hbestoque.model.Produto;
import br.com.tcs.hbestoque.model.ProdutoDetalhe;
import br.com.tcs.hbestoque.model.commons.TipoEmbalagemEnum;
import br.com.tcs.hbestoque.model.commons.VolumeEnum;

public class DetalheProdutoDtoCadastro {
	
	private Long idProduto;
	private BigDecimal custoUnidade;
	private BigDecimal precoUnitario;
	private Integer tipoEmbalagem;
	private Integer volume;
	
	
	public static ProdutoDetalhe parse(DetalheProdutoDtoCadastro dto){
		ProdutoDetalhe dt = new ProdutoDetalhe();
		dt.setProduto(new Produto(dto.getIdProduto()));
		dt.setTipoEmbalagem(TipoEmbalagemEnum.values()[dto.getTipoEmbalagem()]);
		dt.setPrecoUnitario(dto.getPrecoUnitario());
		dt.setCustoUnidade(dto.getCustoUnidade());
		dt.setVolume(VolumeEnum.values()[dto.getVolume()]);
		dt.setDtUltAlt(LocalDateTime.now());
		return dt;
	}	
		
	public Long getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
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
}
