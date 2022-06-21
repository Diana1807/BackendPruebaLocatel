package com.sistemafinanciero.Service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemafinanciero.Entity.Cuenta;
import com.sistemafinanciero.Exception.BadRequestException;
import com.sistemafinanciero.Exception.ConflictException;
import com.sistemafinanciero.Repository.CuentaRepository;

@Service
public class CuentaService {

	@Autowired
	CuentaRepository cuentaRepository;

	public Cuenta saveCuenta(Cuenta cuenta) {

		Integer idPersona = cuenta.getPersona().getIdPersona();

		Cuenta validarCuenta = getCuentaByIdPersona(idPersona);

		if (validarCuenta == null) {
			if (cuenta.getPersona().getIdPersona() == 0) {
				throw new BadRequestException("La persona de la cuenta no puede estar vacia");
			}
			if (cuenta.getTipoCuenta().isEmpty()) {
				throw new BadRequestException("El tipo de cuenta no puede estar vacio");
			}
			return cuentaRepository.save(cuenta);
		} else {
			throw new ConflictException("La persona que intenta crear ya existe ");
		}

	}

	public Cuenta getCuentaByIdPersona(Integer idPersona) {
		return cuentaRepository.getCuentaByIdPersona(idPersona);
	}

	public ArrayList<Cuenta> getCuentas() {
		return (ArrayList<Cuenta>) cuentaRepository.findAll();
	}

	public ArrayList<Cuenta> getCuentasActivas() {
		return (ArrayList<Cuenta>) cuentaRepository.getCuentasActivas();
	}

	public Optional<Cuenta> getCuentaById(Integer id) {
		return cuentaRepository.findById(id);
	}
	
	public Cuenta getCuentaByIdActiva(Integer id) {
		return cuentaRepository.getCuentaByIdActiva(id);
	}

	public Cuenta updateCuenta(Cuenta cuenta) {
		return cuentaRepository.save(cuenta);
	}

	public Cuenta getCuentaParaActualizar(Integer idCuenta, Integer idPersona) {
		return cuentaRepository.getCuentaParaActualizar(idCuenta, idPersona);
	}

	public void updateEstadoCuenta(Integer id, Boolean estado) {
		cuentaRepository.updateEstadoCuenta(id, estado);
	}
}
