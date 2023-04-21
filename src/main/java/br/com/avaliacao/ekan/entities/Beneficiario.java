package br.com.avaliacao.ekan.entities;

import java.util.Calendar;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "BENEFICIARIO")
public class Beneficiario {
	
	@Id
	@Column(name = "id", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique = true)
	private String nome;
	
	@Column(unique = true)
	private String telefone;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataNascimento;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataInclusao;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataAtualizacao;
	
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "listaDocumentos_id")
	private List<Documento> listaDocumentos;
	
	/**
	 * NAO UTILIZAR
	 * MANDATORIO PARA JPA APENAS
	 */
	@Deprecated
	public Beneficiario() {}

	/**
	 * Utilizado para criar beneficiário
	 * @param nome
	 * @param telefone
	 * @param dataNascimento
	 * @param listaDocumentos
	 */
	public Beneficiario(String nome, String telefone, Calendar dataNascimento, List<Documento> listaDocumentos) {
		this.nome = nome;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.listaDocumentos = listaDocumentos;
		this.dataInclusao = Calendar.getInstance();
		this.dataAtualizacao = Calendar.getInstance();
	}
	
	
	/**
	 * Utilizado para atualizar beneficiário
	 * @param telefone
	 * @param dataAtualizacao
	 */
	public Beneficiario(String telefone, Calendar dataAtualizacao) {
		this.telefone = telefone;
		this.dataAtualizacao = dataAtualizacao;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Calendar getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Calendar dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public String getNome() {
		return nome;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public Calendar getDataInclusao() {
		return dataInclusao;
	}

	public List<Documento> getListaDocumentos() {
		return listaDocumentos;
	}
	
	

}
