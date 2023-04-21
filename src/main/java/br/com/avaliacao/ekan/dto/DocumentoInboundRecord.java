package br.com.avaliacao.ekan.dto;

import jakarta.annotation.Nonnull;

public record DocumentoInboundRecord(
		@Nonnull String tipoDocumento,
		@Nonnull String descricao) {

}
