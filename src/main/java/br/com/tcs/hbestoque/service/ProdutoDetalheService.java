package br.com.tcs.hbestoque.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tcs.hbestoque.model.ProdutoDetalhe;
import br.com.tcs.hbestoque.model.commons.TipoEmbalagemEnum;
import br.com.tcs.hbestoque.model.commons.VolumeEnum;
import br.com.tcs.hbestoque.repository.ProdutoDetalheRepository;

@Service
public class ProdutoDetalheService {

	@Autowired
	private ProdutoDetalheRepository repository;
		
	public List<ProdutoDetalhe> loadAll() {
		return repository.findAll();
	}

	public List<ProdutoDetalhe> persquisarPorDetalhe(String nome, TipoEmbalagemEnum tipo, VolumeEnum volume) {
		return repository.pesquisarPorProdutoDetalhe(nome, tipo, volume);
	}

	public List<ProdutoDetalhe> persquisarPorDetalhe(Long id, TipoEmbalagemEnum tipo, VolumeEnum volume) {
		return repository.pesquisarPorProdutoDetalhe(id, tipo, volume);
	}

	public Optional<ProdutoDetalhe> buscarPorId(Long id) {
		return repository.findById(id);
	}
	
	public ProdutoDetalhe salvar(ProdutoDetalhe produto) {
		return repository.save(produto);
	}

}
