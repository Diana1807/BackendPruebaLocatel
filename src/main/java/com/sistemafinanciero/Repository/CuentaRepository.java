package com.sistemafinanciero.Repository;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sistemafinanciero.Entity.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, Integer>{
	
	@Query ( value = "SELECT * FROM TB_CUENTA WHERE id_persona = ?1 ", nativeQuery = true )
	Cuenta getCuentaByIdPersona ( Integer idPersona ) ;
	
	@Query(value = "SELECT * FROM TB_CUENTA WHERE estado_linea = 1 ", nativeQuery = true)
	ArrayList<Cuenta> getCuentasActivas();
	
	@Query ( value = "SELECT * FROM TB_CUENTA WHERE id_cuenta = ?1 AND id_persona != ?2 ", nativeQuery = true )
	Cuenta getCuentaParaActualizar ( Integer idCuenta, Integer id_persona ) ;
	
	@Query ( value = "SELECT * FROM TB_CUENTA WHERE id_cuenta = ?1 AND estado_linea = 1 ", nativeQuery = true )
	Cuenta getCuentaByIdActiva ( Integer idCuenta) ;
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE TB_CUENTA SET estado_linea = ?2 WHERE id_cuenta = ?1 ", nativeQuery = true)
	void updateEstadoCuenta(Integer id_persona, Boolean estado_linea);
}
