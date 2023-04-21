package br.com.avaliacao.ekan.services;

import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.avaliacao.ekan.dto.BeneficiarioAtualizarRecord;
import br.com.avaliacao.ekan.dto.BeneficiarioCreatedRecord;
import br.com.avaliacao.ekan.dto.BeneficiarioInboundRecord;
import br.com.avaliacao.ekan.entities.Beneficiario;
import br.com.avaliacao.ekan.handler.DomainToRecord;
import br.com.avaliacao.ekan.handler.RecordToDomain;
import br.com.avaliacao.ekan.repositories.BeneficiarioRepository;
import br.com.avaliacao.ekan.dto.BeneficiarioOutboundRecord;
import br.com.avaliacao.ekan.dto.BeneficiarioRemoverRecord;
import jakarta.transaction.Transactional;


@Service
public class BeneficiarioService {
	
	@Autowired
	private RecordToDomain parseToDomain;
	@Autowired
	private DomainToRecord parseToRecord;
	
	@Autowired
	private BeneficiarioRepository repository;

	@Transactional
	public BeneficiarioOutboundRecord cadastraBeneficiario(BeneficiarioInboundRecord beneficiario) {
		Optional<Beneficiario> outbound = confirmaSeRegistroJaExiste(beneficiario);
		Boolean jaExiste = false;
		
		//VERIFICAR SE JÁ EXISTE O REGISTRO
		if(outbound.isEmpty()) {
			Beneficiario novoBeneficiario = parseToDomain.parse(beneficiario);
			
			repository.save(novoBeneficiario);

			BeneficiarioCreatedRecord beneficiarioRecord = parseToRecord.parse(novoBeneficiario);
			
			return new BeneficiarioOutboundRecord(beneficiarioRecord, jaExiste);
		}else {
			jaExiste = true;
			return new BeneficiarioOutboundRecord(parseToRecord.parse(outbound.get()), jaExiste);
		}
		
	}


	@Transactional
	public List<BeneficiarioCreatedRecord> listarTodos() {
		List<BeneficiarioCreatedRecord> listaBeneficiarioRecord = new ArrayList<BeneficiarioCreatedRecord>();
		
		repository.findAll().forEach(beneficiario -> {
			listaBeneficiarioRecord.add(parseToRecord.parse(beneficiario));
		});
		
		return listaBeneficiarioRecord;
	}
	
	
	private Optional<Beneficiario> confirmaSeRegistroJaExiste(BeneficiarioInboundRecord beneficiario) {
		return repository.findByNome(beneficiario.nome());
	} 
	
	@Transactional
	public BeneficiarioAtualizarRecord confirmaAtualiza(BeneficiarioInboundRecord beneficiario) {
		String mensagem = null;
		Boolean atualizado = false;
		
		Optional<Beneficiario> optional = repository.findByNome(beneficiario.nome());
		
		if(optional.isEmpty()) {
			mensagem = "O registro nao existe. Portanto nao podera ser atualizado";
		}else {
			Calendar calendarUpdated = Calendar.getInstance();
			mensagem = 
					String.format("Seu registro foi atualizado no dia %s com o conteudo %s", 
							calendarUpdated.getTime(), beneficiario.telefone());
			atualizado = true;
			Beneficiario outbound = optional.get();
			outbound.setTelefone(beneficiario.telefone());
			outbound.setDataAtualizacao(calendarUpdated);
			
			repository.save(outbound);
		}
		
		return new BeneficiarioAtualizarRecord(atualizado, mensagem);
		
	} 
	
	@Transactional
	public BeneficiarioRemoverRecord removerBeneficiario(BeneficiarioInboundRecord beneficiario) {
		String mensagem = null;
		Boolean isRemovido = false;
		Optional<Beneficiario> optional = repository.findByNome(beneficiario.nome());
		
		if(optional.isEmpty()) {
			mensagem = "O registro nao existe. Portanto nao podera ser removido";
		}else {
			repository.deleteByNome(beneficiario.nome());
			isRemovido = true;
			mensagem = String.format("Seu registro foi removido");		
		}
		
		return new BeneficiarioRemoverRecord(isRemovido, mensagem);
	}
	
}
