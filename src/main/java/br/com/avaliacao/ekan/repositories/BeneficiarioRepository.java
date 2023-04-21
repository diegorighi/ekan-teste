package br.com.avaliacao.ekan.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.avaliacao.ekan.entities.Beneficiario;

@Repository
public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Integer>{

	Optional<Beneficiario> findByNome(String nome);

	void deleteByNome(String nome);

}
