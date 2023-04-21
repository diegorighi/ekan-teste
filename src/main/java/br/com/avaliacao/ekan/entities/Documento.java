package br.com.avaliacao.ekan.entities;

import java.util.Calendar;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "DOCUMENTO")
public class Documento {

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String tipoDocumento;
	
	private String descricao;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataInclusao;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataAtualizacao;
	
	@ManyToOne
	@JoinColumn(name = "beneficiario_id")
	private Beneficiario beneficiario;
	
	@Deprecated
	public Documento() {}
	
	/**
	 * Utilizado para criação do documento
	 * @param tipoDocumento
	 * @param descricao
	 */
	public Documento(String tipoDocumento, String descricao) {
		this.tipoDocumento = tipoDocumento;
		this.descricao = descricao;
	}
	
	/**
	 * Utilizado para atualizacao do documento
	 * @param descricao
	 */
	public Documento(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Calendar dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public Calendar getDataInclusao() {
		return dataInclusao;
	}
	
	
	
}
