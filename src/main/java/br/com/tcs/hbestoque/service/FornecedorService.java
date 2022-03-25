package br.com.tcs.hbestoque.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tcs.hbestoque.model.Fornecedor;
import br.com.tcs.hbestoque.repository.FornecedorRepository;

@Service
public class FornecedorService {

	@Autowired
	private FornecedorRepository repository;
	
	public List<Fornecedor> pesquisarPorId(Long id, boolean ativo){
		return repository.pesquisarPorId(id, ativo);
	}

	public Fornecedor pesquisarPorCnpj(Long cnpj, String nome){
		return repository.pesquisarPorCnpj(cnpj, nome);
	}

	
	public List<Fornecedor> loadAll() {
		return repository.findAll();
	}
	
	public Optional<Fornecedor> buscarPorId(Long id) {
		return repository.findById(id);
	}
	
	public Fornecedor salvar(Fornecedor produto) {
		return repository.save(produto);
	}

}
