package br.com.avaliacao.ekan.exceptions;

import java.io.Serializable;

public class RegistroDuplicadoException extends Exception implements Serializable {

	private static final long serialVersionUID = 4046570557226350291L;

	public static final String ID = "id";
	
	private String menssagem = null;
	private String idInformado = null;
	
	public RegistroDuplicadoException(String idInformado) {
		this.idInformado = idInformado;
		this.menssagem = String.format("Dados duplicados para o beneficiario %s", idInformado);
	}
	
	public String getIdInformado() {
		return this.idInformado;
	}
	
	public String getMenssagem() {
		return this.menssagem;
	}
}
