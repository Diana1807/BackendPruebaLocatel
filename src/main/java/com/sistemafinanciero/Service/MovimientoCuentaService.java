package com.sistemafinanciero.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemafinanciero.Entity.MovimientoCuenta;
import com.sistemafinanciero.Exception.ConflictException;
import com.sistemafinanciero.Repository.MovimientoCuentaRepository;

@Service
public class MovimientoCuentaService {
	
	@Autowired
	MovimientoCuentaRepository movimientoCuentaRepository;
	
	public MovimientoCuenta saveMovimientoCuenta(MovimientoCuenta movimientoCuenta) {
			
		Integer idCuenta = movimientoCuenta.getCuenta().getIdCuenta();
		
		String tipoTransaccion = movimientoCuenta.getTipoTransaccion();
		
		double saldo = getSaldoCuenta(idCuenta);
		
		if(tipoTransaccion.equals("Retiro")) {
			double retiro = movimientoCuenta.getHaber();
			if(saldo >= retiro) {
				return movimientoCuentaRepository.save(movimientoCuenta);
			}else {
				throw new ConflictException("El saldo actual no es suficiente para este retiro");
			}
		}else {
			return movimientoCuentaRepository.save(movimientoCuenta);
		}
	}
	
	public double getSaldoCuenta (Integer idCuenta) {
		return movimientoCuentaRepository.getSaldoCuenta(idCuenta);
	}
	
	public ArrayList<MovimientoCuenta> getTransaccionesCuenta(Integer idCuenta){
		return (ArrayList<MovimientoCuenta>) movimientoCuentaRepository.getTransaccionesCuenta(idCuenta);
	}
	
}
