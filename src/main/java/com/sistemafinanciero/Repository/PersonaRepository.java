package com.sistemafinanciero.Repository;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sistemafinanciero.Entity.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer>{
	
	@Query ( value = "SELECT * FROM TB_PERSONA WHERE numero_documento = ?1 ", nativeQuery = true )
	Persona getPersonaByNumeroDocumento ( String numero_documento ) ;
	
	@Query(value = "SELECT * FROM TB_PERSONA WHERE estado_linea = 1 ", nativeQuery = true)
	ArrayList<Persona> getPersonasActivas();
	
	@Query ( value = "SELECT * FROM TB_PERSONA WHERE numero_documento = ?1 AND id_persona != ?2 ", nativeQuery = true )
	Persona getPersonaParaActualizar ( String numero_documento, Integer id_persona ) ;
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE TB_PERSONA SET estado_linea = ?2 WHERE id_persona = ?1 ", nativeQuery = true)
	void updateEstadoPersona(Integer id_persona, Boolean estado_linea);
	
}
