package br.com.tcs.hbestoque.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class Pedido {

	private Long id;
	private Integer qtd;
	private BigDecimal total;
	private LocalDate dataReserva;
	private LocalDateTime dtCadastro;
	private LocalDateTime dtUltAlt;
	private boolean ativo;
}
