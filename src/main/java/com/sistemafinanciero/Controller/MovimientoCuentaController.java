package com.sistemafinanciero.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemafinanciero.Entity.MovimientoCuenta;
import com.sistemafinanciero.Service.MovimientoCuentaService;

@RestController
@RequestMapping("movimientos")
@CrossOrigin(origins = "*")
public class MovimientoCuentaController {
	
	@Autowired
	MovimientoCuentaService movimientoCuentaService;
	
	@PostMapping("/guardarMovimientoCuenta")
	public MovimientoCuenta saveMovimientoCuenta(@RequestBody MovimientoCuenta movimientoCuenta) {
		return movimientoCuentaService.saveMovimientoCuenta(movimientoCuenta);
	}
	
	@GetMapping("/saldoCuenta/{id}")
	public double getSaldoCuenta(@PathVariable("id") Integer id){
		return movimientoCuentaService.getSaldoCuenta(id);
	}
	
	@GetMapping("/transaccionesCuenta/{id}")
	public ArrayList<MovimientoCuenta> getTransaccionesCuenta(@PathVariable("id") Integer id){
		return movimientoCuentaService.getTransaccionesCuenta(id);
	}
	
}
