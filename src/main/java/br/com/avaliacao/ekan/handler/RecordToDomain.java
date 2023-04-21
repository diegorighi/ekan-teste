package br.com.avaliacao.ekan.handler;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import br.com.avaliacao.ekan.dto.BeneficiarioInboundRecord;
import br.com.avaliacao.ekan.entities.Beneficiario;
import br.com.avaliacao.ekan.interfaces.Utils;
import br.com.avaliacao.ekan.entities.Documento;

@Component
public class RecordToDomain implements Utils<BeneficiarioInboundRecord, Beneficiario>{

	@Override
	public Beneficiario parse(BeneficiarioInboundRecord inbound) {
		List<Documento> listaDocumentos = new ArrayList<Documento>();

		inbound.listaDocumentos().forEach(doc -> {
			listaDocumentos.add(new Documento(doc.tipoDocumento(), doc.descricao()));
		});
		
		return new Beneficiario(
				inbound.nome(), 
				inbound.telefone(), 
				inbound.dataNascimento(),
				listaDocumentos);
	}
	
}
