package br.com.tcs.hbestoque.resource.dto;

import java.time.LocalDateTime;

import br.com.tcs.hbestoque.model.Fornecedor;
import br.com.tcs.hbestoque.model.Produto;
import br.com.tcs.hbestoque.model.commons.CategoriaProdutoEnum;
import br.com.tcs.hbestoque.model.commons.VolumeEnum;

public class ProdutoDto {

	private Long idFornecedor;
	private String nome;
	private String descricao;
	private Integer categoria;
	private Integer volume;
	
	
	
	public static Produto parse(ProdutoDto dto) {
		Produto p = new Produto();
		p.setFornecedor(new Fornecedor(dto.getIdFornecedor()));
		p.setAtivo(false);
		p.setCategoria(parseCategoriaEnum(dto.getCategoria()));
		p.setDescricao(dto.getDescricao());
		p.setDtCadastro(LocalDateTime.now());
		p.setDtUltAlt(LocalDateTime.now());
		p.setNome(dto.getNome());
		p.setVolume(parseEnum(dto.getVolume()));		
		return p;
	}
	
	public static VolumeEnum parseEnum(Integer volume) {
		VolumeEnum[]volumes = VolumeEnum.values();
		VolumeEnum vselect  = null;
		
		for(VolumeEnum v : volumes) {
			if(v.ordinal() == volume) {
				vselect = v;
			}
		}
		return vselect;
	}
	
	public static CategoriaProdutoEnum parseCategoriaEnum(Integer categoria) {
		CategoriaProdutoEnum[]categorias = CategoriaProdutoEnum.values();
		CategoriaProdutoEnum cselect  = null;
		
		for(CategoriaProdutoEnum c : categorias) {
			if(c.ordinal() == categoria) {
				cselect = c;
			}
		}
		return cselect;
	}
	
	public Long getIdFornecedor() {
		return idFornecedor;
	}

	public void setIdFornecedor(Long idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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


	
//	private CategoriaProdutoEnum categoria;
	
}
