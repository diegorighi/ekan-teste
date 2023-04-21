package br.com.avaliacao.ekan.controllers;

import java.util.List;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import br.com.avaliacao.ekan.dto.BeneficiarioAtualizarRecord;
import br.com.avaliacao.ekan.dto.BeneficiarioCreatedRecord;
import br.com.avaliacao.ekan.dto.BeneficiarioInboundRecord;
import br.com.avaliacao.ekan.dto.BeneficiarioOutboundRecord;
import br.com.avaliacao.ekan.dto.BeneficiarioRemoverRecord;
import br.com.avaliacao.ekan.services.BeneficiarioService;

/**
 * Refere-se aos servicos de beneficiarios
 * @author Diego Righi
 */

@RestController
@RequestMapping("beneficiario")
public class BeneficiarioController {
	
	@Autowired	
	private BeneficiarioService service;

	@PostMapping
	public ResponseEntity<BeneficiarioOutboundRecord> cadastrar(
			@RequestBody @Validated BeneficiarioInboundRecord beneficiario, 
			UriComponentsBuilder uriBuilder){
		
		BeneficiarioOutboundRecord registro = service.cadastraBeneficiario(beneficiario);
		URI uri = uriBuilder.path("/{id}").buildAndExpand(registro).toUri();
		
		if(registro.jaExisteNaBaseDeDados()) {
			return ResponseEntity.ok().body(registro);
		}else {
			return ResponseEntity.created(uri).body(registro);
		}
		
	}
	
	/**
	 * TODO Realizar paginacao 
	 * Como nao faz parte do escopo nao foi implementada
	 * 
	 * @return Lista completa de beneficiarios
	 */
	@GetMapping
	public ResponseEntity<List<BeneficiarioCreatedRecord>> listar() {
		List<BeneficiarioCreatedRecord> listarTodos = service.listarTodos();
		
		if(listarTodos.isEmpty())
			return ResponseEntity.noContent().build();
		else
			return ResponseEntity.ok().body(listarTodos);
	}
	
	/**
	 * Utilizado verbo PATCH 
	 * Sendo assim PATCH remete a um atributo do domain ou a < 50% dele
	 * @param update
	 * @return status
	 */
	@PatchMapping
	public ResponseEntity<BeneficiarioAtualizarRecord> atualizarCadastro(@RequestBody @Validated BeneficiarioInboundRecord update) {
		BeneficiarioAtualizarRecord promisse = service.confirmaAtualiza(update);
		return ResponseEntity.ok().body(promisse);
	}
	
	/**
	 * @param remove
	 * @return status
	 */
	@DeleteMapping
	public ResponseEntity<BeneficiarioRemoverRecord> remover(@RequestBody @Validated BeneficiarioInboundRecord remove) {
		BeneficiarioRemoverRecord promisse = service.removerBeneficiario(remove);
		return ResponseEntity.ok().body(promisse);
	}
	
}
