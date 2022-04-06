package br.com.tcs.hbestoque.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PEDIDOITEM")
public class PedidoItem {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CD_PEDIDOITEM", nullable = false)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CD_PEDIDO", nullable = false)
	private Pedido pedido;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CD_PRODUTO_DETALHE")
	private ProdutoDetalhe produtoDetalhe;
	
	@Column(name = "PRECO_UNITARIO", length = 100, nullable = false)
	private BigDecimal precoUnitario;
	
	@Column(name = "PRECO_TOTAL", length = 100, nullable = false)
	private BigDecimal precoTotal;
	
	@Column(name = "ATIVO", nullable = false)
	private boolean ativo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public ProdutoDetalhe getProdutoDetalhe() {
		return produtoDetalhe;
	}

	public void setProdutoDetalhe(ProdutoDetalhe produtoDetalhe) {
		this.produtoDetalhe = produtoDetalhe;
	}

	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(BigDecimal precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public BigDecimal getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(BigDecimal precoTotal) {
		this.precoTotal = precoTotal;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
		
}
