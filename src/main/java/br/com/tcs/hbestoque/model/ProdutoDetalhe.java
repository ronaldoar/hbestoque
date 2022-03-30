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
import br.com.tcs.hbestoque.model.commons.TipoEmbalagemEnum;
import br.com.tcs.hbestoque.model.commons.VolumeEnum;

/**
 * Class <code>Produto</code></br>
 * Define a entidade produto
 * @version 1.0.0
 * @author ronaldoar
 * 
 *
 */

@Entity
@Table(name="TB_PRODUTO_DETALHE")
public class ProdutoDetalhe {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CD_PRODUTO_DETALHE", nullable=false)
	private Long id;
		
	@Column(name="DESC_PRODUTO", length=120, nullable=true)
	private String descricao;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CD_PRODUTO", nullable=false)
	private Produto produto;

	@Enumerated(EnumType.STRING)
	@Column(name="CATEGORIA", nullable=false)
	private CategoriaProdutoEnum categoria;
	
	@Enumerated(EnumType.STRING)
	@Column(name="VOLUME", nullable=false)
	private VolumeEnum volume;
	
	@Enumerated(EnumType.STRING)
	@Column(name="TIPO_EMBALAGEM", nullable=false)
	private TipoEmbalagemEnum tipoEmbalagem;
			
	@Column(name="DT_ULT_ALT", nullable=false)
	private LocalDateTime dtUltAlt;

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

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public CategoriaProdutoEnum getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaProdutoEnum categoria) {
		this.categoria = categoria;
	}

	public VolumeEnum getVolume() {
		return volume;
	}

	public void setVolume(VolumeEnum volume) {
		this.volume = volume;
	}

	public TipoEmbalagemEnum getTipoEmbalagem() {
		return tipoEmbalagem;
	}

	public void setTipoEmbalagem(TipoEmbalagemEnum tipoEmbalagem) {
		this.tipoEmbalagem = tipoEmbalagem;
	}

	public LocalDateTime getDtUltAlt() {
		return dtUltAlt;
	}

	public void setDtUltAlt(LocalDateTime dtUltAlt) {
		this.dtUltAlt = dtUltAlt;
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
		ProdutoDetalhe other = (ProdutoDetalhe) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "ProdutoDetalhe [id=" + id + ", descricao=" + descricao + ", produto=" + produto + ", categoria="
				+ categoria + ", volume=" + volume + ", tipoEmbalagem=" + tipoEmbalagem + ", dtUltAlt=" + dtUltAlt
				+ "]";
	}
	
}
