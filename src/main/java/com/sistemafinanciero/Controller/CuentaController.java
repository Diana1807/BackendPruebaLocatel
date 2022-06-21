package com.sistemafinanciero.Controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemafinanciero.Entity.Cuenta;
import com.sistemafinanciero.Service.CuentaService;

@RestController
@RequestMapping("cuentas")
@CrossOrigin(origins = "*")
public class CuentaController {
	
	@Autowired
	CuentaService cuentaService;
	
	@PostMapping("/guardarCuenta")
	public Cuenta saveCuenta(@RequestBody Cuenta cuenta) {
		return cuentaService.saveCuenta(cuenta);
	}
	
	@GetMapping("/cuentas")
	public ArrayList<Cuenta> getCuentas(){
		//System.out.print("Entro a personas/get personas");
		return cuentaService.getCuentas();
	}
			
	@GetMapping("/cuentasActivas")
	public ArrayList<Cuenta> getCuentasActivas(){
		return cuentaService.getCuentasActivas();
	}
	
	@GetMapping("cuentaById/{id}")
	public Optional<Cuenta> getCuentaById(@PathVariable("id") Integer id){
		return this.cuentaService.getCuentaById(id);
	}
	
	@GetMapping("cuentaByIdActiva/{id}")
	public Cuenta getCuentaByIdActiva(@PathVariable("id") Integer id){
		return this.cuentaService.getCuentaByIdActiva(id);
	}
	
	@PutMapping("actualizarEstadoCuenta/{id}/{estado}")
	public ResponseEntity<String> updateEstadoCuenta( @PathVariable("id") Integer id, @PathVariable("estado") boolean estado){
		cuentaService.updateEstadoCuenta(id, estado);
		return ResponseEntity.status(HttpStatus.OK).body("Cuenta Actualizada");
	}
	
	@PostMapping("actualizarCuenta")
	public Cuenta updateCuenta(@RequestBody Cuenta cuenta) {
		return this.cuentaService.updateCuenta(cuenta);
	}
}
