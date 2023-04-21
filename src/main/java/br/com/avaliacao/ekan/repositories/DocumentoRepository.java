package br.com.avaliacao.ekan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.avaliacao.ekan.entities.Documento;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Integer>{

}
