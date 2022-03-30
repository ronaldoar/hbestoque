package br.com.tcs.hbestoque.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.tcs.hbestoque.model.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	@Query("SELECT p FROM Produto p WHERE p.id = ?1 AND p.ativo = ?2")
	List<Produto> pesquisarPorId(Long id, boolean ativo);
	
	@Query("SELECT p FROM Produto p WHERE p.nome = ?1")
	Optional<Produto> pesquisarPorNome(String nome);

}

