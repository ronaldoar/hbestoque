package br.com.tcs.hbestoque.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tcs.hbestoque.model.Produto;
import br.com.tcs.hbestoque.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;
	
	public List<Produto> pesquisarPorId(Long id, boolean ativo){
		return repository.pesquisarPorId(id, ativo);
	}

	public Optional<Produto> pesquisarPorNome(String nome){
		return repository.pesquisarPorNome(nome);
	}
	
	public List<Produto> loadAll() {
		return repository.findAll();
	}
	
	public Optional<Produto> buscarPorId(Long id) {
		return repository.findById(id);
	}
	
	public Produto salvar(Produto produto) {
		return repository.save(produto);
	}

}
