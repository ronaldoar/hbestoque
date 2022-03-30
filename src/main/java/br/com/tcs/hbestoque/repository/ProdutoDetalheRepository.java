package br.com.tcs.hbestoque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.tcs.hbestoque.model.ProdutoDetalhe;
import br.com.tcs.hbestoque.model.commons.TipoEmbalagemEnum;
import br.com.tcs.hbestoque.model.commons.VolumeEnum;


public interface ProdutoDetalheRepository extends JpaRepository<ProdutoDetalhe, Long> {
	
	
	@Query("SELECT d FROM ProdutoDetalhe d WHERE d.produto.nome = ?1 AND d.tipoEmbalagem = ?2  AND d.volume = ?3")
	List<ProdutoDetalhe> pesquisarPorProdutoDetalhe(String nome, TipoEmbalagemEnum tipo, VolumeEnum volume);

	@Query("SELECT d FROM ProdutoDetalhe d WHERE d.produto.id = ?1 AND d.tipoEmbalagem = ?2  AND d.volume = ?3")
	List<ProdutoDetalhe> pesquisarPorProdutoDetalhe(Long id, TipoEmbalagemEnum tipo, VolumeEnum volume);
	
}

