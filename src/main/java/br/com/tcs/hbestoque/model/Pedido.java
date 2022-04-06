package br.com.tcs.hbestoque.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="TB_PEDIDO")
public class Pedido {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CD_PEDIDO", nullable=false)
	private Long id;
	
	@Column(name="QTD", length=13, nullable=false, unique = true)
	private Integer qtd;
	
	@Column(name="TOTAL", length=13, nullable=false, unique = true)
	private BigDecimal total;
	
	@Column(name="DT_RESERVA", nullable=false)
	private LocalDate dataReserva;
	
	@Column(name="DT_CADASTRO", nullable=false)
	private LocalDateTime dtCadastro;
	
	@Column(name="DT_ULT_ALT", nullable=false)
	private LocalDateTime dtUltAlt;
	
	@Column(name="ATIVO", length=100, nullable=false)
	private boolean ativo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public LocalDate getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(LocalDate dataReserva) {
		this.dataReserva = dataReserva;
	}

	public LocalDateTime getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(LocalDateTime dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public LocalDateTime getDtUltAlt() {
		return dtUltAlt;
	}

	public void setDtUltAlt(LocalDateTime dtUltAlt) {
		this.dtUltAlt = dtUltAlt;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}




}

