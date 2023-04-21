package br.com.avaliacao.ekan.dto;

import java.util.Calendar;
import java.util.List;

public record BeneficiarioCreatedRecord(
		String nome, 
		String telefone, 
		Calendar dataNascimento,
		Calendar dataInclusao,
		List<DocumentoInboundRecord> listaDocumentos) {

}
