package br.com.tcs.hbestoque.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.tcs.hbestoque.model.commons.CategoriaProdutoEnum;
import br.com.tcs.hbestoque.model.commons.TipoEnvazamentoEnum;

/**
 * Class <code>Produto</code></br>
 * Define a entidade produto
 * @version 1.0.0
 * @author ronaldoar
 * 
 *
 */

@Entity
@Table(name="TB_PRODUTO")
public class Produto {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CD_PRODUTO", nullable=false)
	private Long id;
		
	@Column(name="NOME_PRODUTO", length=100, nullable=false, unique = true)
	private String nome;
	
	@Enumerated(EnumType.STRING)
	@Column(name="CATEGORIA", nullable=false)
	private CategoriaProdutoEnum categoria;
	
	@Column(name="TIPO_ENVAZAMENTO", length=10, nullable=false)
	private TipoEnvazamentoEnum tipoEnvazamento;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="CD_FORNECEDOR", nullable=false)
	private Fornecedor fornecedor;

	@Column(name="DT_CADASTRO", nullable=false)
	private LocalDateTime dtCadastro;

	@Column(name="DT_ULT_ALT", nullable=false)
	private LocalDateTime dtUltAlt;
		
	@Column(name="ATIVO", length=100, nullable=false)
	private boolean ativo;

	public Produto() {}
	
	public Produto(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public CategoriaProdutoEnum getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaProdutoEnum categoria) {
		this.categoria = categoria;
	}

	public TipoEnvazamentoEnum getTipoEnvazamento() {
		return tipoEnvazamento;
	}

	public void setTipoEnvazamento(TipoEnvazamentoEnum tipoEnvazamento) {
		this.tipoEnvazamento = tipoEnvazamento;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", categoria=" + categoria + ", tipoEnvazamento="
				+ tipoEnvazamento + ", fornecedor=" + fornecedor + ", dtCadastro=" + dtCadastro + ", dtUltAlt="
				+ dtUltAlt + ", ativo=" + ativo + "]";
	}
	
}
