package br.com.tcs.hbestoque.model;

import java.math.BigDecimal;

public class PedidoItem {
	
	private Long id;
	private Pedido pedido;
	private ProdutoDetalhe produtoDetalhe;
	private BigDecimal precoUnitario;
	private BigDecimal precoTotal;
	private boolean ativo;
	
}
