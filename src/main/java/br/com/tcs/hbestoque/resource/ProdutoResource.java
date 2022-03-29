package br.com.tcs.hbestoque.resource;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tcs.hbestoque.model.Produto;
import br.com.tcs.hbestoque.model.commons.VolumeEnum;
import br.com.tcs.hbestoque.resource.dto.ProdutoDto;
import br.com.tcs.hbestoque.service.ProdutoService;

@RestController
@RequestMapping(value = "/v1/produtos")
public class ProdutoResource {
	private final Logger logger = LoggerFactory.getLogger(ProdutoResource.class);
	
		@Autowired
		private ProdutoService produtoService;
		
		@PostMapping(value = "/cadastrar", produces = MediaType.APPLICATION_JSON_VALUE)
		@PreAuthorize("hasAnyAuthority('ROLE_GERENTE')")
		public ResponseEntity<?> cadastrar(@RequestBody ProdutoDto dto){
			
			try {
				List<Produto> lista = produtoService.pesquisarPorProduto(dto.getNome(), ProdutoDto.parseEnum(dto.getVolume()));
				
				if(lista.isEmpty()) {
					Produto p = ProdutoDto.parseToProduto(dto);
					produtoService.salvar(p);
					return new ResponseEntity<>(p,HttpStatus.CREATED);
					
				}else {
					return new ResponseEntity<>("Produto já cadastrado.", HttpStatus.CONFLICT);
				}
				
			}catch(Exception ex) {
				logger.error("[CADASTRAR-PRODUTOS]", ex.fillInStackTrace());
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		
		@GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
		@PreAuthorize("hasAnyAuthority('ROLE_HBEER')")
		public ResponseEntity<?> listar(){
			
			try {
				
				return new ResponseEntity<>(ProdutoDto.parseList(produtoService.loadAll()), HttpStatus.OK);			
				
			}catch(Exception ex) {
				logger.error("[LISTAR-PRODUTOS]", ex.fillInStackTrace());
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@GetMapping(value = "/pesquisarPorProduto/{nome}/{volume}", produces = MediaType.APPLICATION_JSON_VALUE)
		@PreAuthorize("hasAnyAuthority('ROLE_HBEER')")
		public ResponseEntity<?> pesquisarPorProduto(@PathVariable String nome, @PathVariable String volume){
			
			try {
				VolumeEnum vl = VolumeEnum.fromText(volume);
				return new ResponseEntity<>(ProdutoDto.parseList(produtoService.pesquisarPorProduto(nome, vl)), HttpStatus.OK);			
				
			}catch(Exception ex) {
				logger.error("[LISTAR-PRODUTOS]", ex.fillInStackTrace());
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		
		
}
