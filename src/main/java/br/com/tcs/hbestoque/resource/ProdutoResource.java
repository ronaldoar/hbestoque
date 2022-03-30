package br.com.tcs.hbestoque.resource;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.tcs.hbestoque.model.Produto;
import br.com.tcs.hbestoque.model.ProdutoDetalhe;
import br.com.tcs.hbestoque.model.commons.TipoEmbalagemEnum;
import br.com.tcs.hbestoque.model.commons.VolumeEnum;
import br.com.tcs.hbestoque.resource.dto.DetalheProdutoDtoCadastro;
import br.com.tcs.hbestoque.resource.dto.ProdutoDetalheDtoPesquisa;
import br.com.tcs.hbestoque.resource.dto.ProdutoDtoCadastro;
import br.com.tcs.hbestoque.resource.dto.ProdutoDtoPesquisa;
import br.com.tcs.hbestoque.service.ProdutoDetalheService;
import br.com.tcs.hbestoque.service.ProdutoService;

@RestController
@RequestMapping(value = "/v1/produtos")
public class ProdutoResource {
	private final Logger logger = LoggerFactory.getLogger(ProdutoResource.class);
	
		@Autowired
		private ProdutoService produtoService;
		
		@Autowired
		private ProdutoDetalheService produtoDetalheService;
		
		/**
		 * 
		 * @param dto
		 * @return
		 */
		@PostMapping(value = "/cadastrar-produto", produces = MediaType.APPLICATION_JSON_VALUE)
		@PreAuthorize("hasAnyAuthority('ROLE_GERENTE')")
		public ResponseEntity<?> cadastrarProduto(@RequestBody ProdutoDtoCadastro dto){
			
			try {
				Optional<Produto>produto = produtoService.pesquisarPorNome(dto.getNome());
				
				if(produto.isEmpty()) {
					Produto p = ProdutoDtoCadastro.parse(dto);
					produtoService.salvar(p);
					Optional<Produto> retorno = produtoService.pesquisarPorNome(dto.getNome());
					return new ResponseEntity<>(ProdutoDtoPesquisa.parse(retorno.get()), HttpStatus.CREATED);
					
				}else {
					return new ResponseEntity<>("Produto já cadastrado.", HttpStatus.CONFLICT);
				}
				
			}catch(Exception ex) {
				logger.error("[CADASTRAR-PRODUTOS]", ex.fillInStackTrace());
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		/**
		 * 
		 * @param dto
		 * @return
		 */
		@PostMapping(value = "/cadastrar-detalhe", produces = MediaType.APPLICATION_JSON_VALUE)
		@PreAuthorize("hasAnyAuthority('ROLE_GERENTE')")
		public ResponseEntity<?> cadastrarDetalhe(@RequestBody DetalheProdutoDtoCadastro dto){
			
			try {
				Long idProd              = dto.getIdProduto();
				TipoEmbalagemEnum tipo   = TipoEmbalagemEnum.values()[dto.getTipoEmbalagem()];
				VolumeEnum volume	     = VolumeEnum.values()[dto.getVolume()];
				List<ProdutoDetalhe>list = produtoDetalheService.persquisarPorDetalhe(idProd, tipo, volume);
				
				if(list.isEmpty()) {
					ProdutoDetalhe p = DetalheProdutoDtoCadastro.parse(dto);
					produtoDetalheService.salvar(p);
					return new ResponseEntity<>(p,HttpStatus.CREATED);
					
				}else {
					return new ResponseEntity<>("Produto já cadastrado.", HttpStatus.CONFLICT);
				}
				
			}catch(Exception ex) {
				logger.error("[CADASTRAR-DETALHE]", ex.fillInStackTrace());
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		/**
		 * 
		 * @return
		 */
		@GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
		@PreAuthorize("hasAnyAuthority('ROLE_HBEER')")
		public ResponseEntity<?> listar(){
			
			try {
				return new ResponseEntity<>(ProdutoDtoPesquisa.parseList(produtoService.loadAll()), HttpStatus.OK);			
				
			}catch(Exception ex) {
				logger.error("[LISTAR-PRODUTOS]", ex.fillInStackTrace());
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		/**
		 * 
		 * @param nome
		 * @param volume
		 * @return
		 */
		@GetMapping(value = "/pesquisar", produces = MediaType.APPLICATION_JSON_VALUE)
		@PreAuthorize("hasAnyAuthority('ROLE_HBEER')")
		public ResponseEntity<?> pesquisarPorProduto(@RequestParam String nome, @RequestParam Integer volume, @RequestParam Integer embalagem){
			
			try {
				VolumeEnum vl = VolumeEnum.values()[volume];
				TipoEmbalagemEnum tipo   = TipoEmbalagemEnum.values()[embalagem];
				return new ResponseEntity<>(ProdutoDetalheDtoPesquisa.parseToDtos(produtoDetalheService.persquisarPorDetalhe(nome, tipo, vl)), HttpStatus.OK);			
				
			}catch(Exception ex) {
				logger.error("[LISTAR-PRODUTOS]", ex.fillInStackTrace());
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
}
