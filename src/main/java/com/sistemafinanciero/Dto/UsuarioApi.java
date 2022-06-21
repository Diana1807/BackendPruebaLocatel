package com.sistemafinanciero.Dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioApi {

	private String nombre;
	private String client_credentials;
	private String client_id;
	private String client_secret;
	private boolean activo;
	
}
