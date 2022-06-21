package com.sistemafinanciero.Repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sistemafinanciero.Entity.MovimientoCuenta;

public interface MovimientoCuentaRepository extends JpaRepository<MovimientoCuenta, Long>{
	
	@Query ( value = "SELECT SUM(DEBE) - SUM(HABER) AS SALDO FROM TB_MOVIMIENTOS_CUENTA WHERE ID_CUENTA = ?1 AND ESTADO_LINEA = 1", nativeQuery = true )
	double getSaldoCuenta(Integer idCuenta) ;
	
	@Query ( value = "SELECT * FROM TB_MOVIMIENTOS_CUENTA WHERE id_cuenta = ?1 AND estado_linea = 1 ORDER BY id_movimiento DESC", nativeQuery = true )
	ArrayList<MovimientoCuenta> getTransaccionesCuenta(Integer idCuenta) ;

}
