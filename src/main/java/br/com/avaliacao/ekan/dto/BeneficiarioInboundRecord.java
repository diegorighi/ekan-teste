package br.com.avaliacao.ekan.dto;

import java.util.Calendar;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.annotation.Nonnull;

public record BeneficiarioInboundRecord(
		@Nonnull String nome, 
		@Nonnull String telefone,
		@Nonnull @JsonFormat(pattern="yyyy-MM-dd") Calendar dataNascimento,
		List<DocumentoInboundRecord> listaDocumentos) {}
