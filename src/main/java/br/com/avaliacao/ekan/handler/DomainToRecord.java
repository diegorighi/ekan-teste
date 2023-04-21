package br.com.avaliacao.ekan.handler;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import br.com.avaliacao.ekan.dto.BeneficiarioCreatedRecord;
import br.com.avaliacao.ekan.entities.Beneficiario;
import br.com.avaliacao.ekan.interfaces.Utils;
import br.com.avaliacao.ekan.dto.DocumentoInboundRecord;

@Component
public class DomainToRecord implements Utils<Beneficiario, BeneficiarioCreatedRecord>{

	@Override
	public BeneficiarioCreatedRecord parse(Beneficiario outbound) {
		
		List<DocumentoInboundRecord> listaDocumento = new ArrayList<DocumentoInboundRecord>();
		outbound.getListaDocumentos().forEach(documento -> {
			listaDocumento.add(new DocumentoInboundRecord(documento.getTipoDocumento(), documento.getDescricao()));
		});
		
		return new BeneficiarioCreatedRecord(
				outbound.getNome(),
				outbound.getTelefone(),
				outbound.getDataNascimento(),
				outbound.getDataInclusao(),
				listaDocumento);
	}
	
}
