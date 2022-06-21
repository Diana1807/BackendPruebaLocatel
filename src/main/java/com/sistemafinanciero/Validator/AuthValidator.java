package com.sistemafinanciero.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import com.sistemafinanciero.Dto.UsuarioApi;
import com.sistemafinanciero.Exception.Apiunauthorized;

@Component
public class AuthValidator {
	
	/*private static final String CLIENT_CREDENTIALS3 = "client_credentials";
	private static final String client_id3 = "diana_id";
	private static final String client_secret3 = "diana_secret";*/
	
	private String CLIENT_CREDENTIALS = "";
	private String client_id= "";
	private String client_secret = "";

	public void validate(MultiValueMap<String, String> paramMap, String granType) throws Apiunauthorized {
		
		UsuarioApi user = UsuarioApi.builder().nombre("Diana Miranda").client_credentials("client_credentials")
				.client_id("diana_id").client_secret("diana_secret").activo(true).build();
		UsuarioApi user2 = UsuarioApi.builder().nombre("Diana Miranda 2").client_credentials("cliente_diana 2")
				.client_id("diana_id 2").client_secret("diana_secret 2").activo(true).build();
		
		List<UsuarioApi> usuariosApi = new ArrayList<UsuarioApi>();
		
		usuariosApi.add(user);
		usuariosApi.add(user2);
		
		for(int i=0;i<usuariosApi.size();i++)
        {	
			
            if(granType.equals(usuariosApi.get(i).getClient_credentials()) &&
            		paramMap.getFirst("client_id").equals(usuariosApi.get(i).getClient_id())&&
            		paramMap.getFirst("client_secret").equals(usuariosApi.get(i).getClient_secret())&& 
            		usuariosApi.get(i).isActivo() == true
            		) {
            	//System.out.println("exiete el usuario api");
            	CLIENT_CREDENTIALS = usuariosApi.get(i).getClient_credentials();
    			client_id = usuariosApi.get(i).getClient_id();
    			client_secret = usuariosApi.get(i).getClient_secret();
            }
			/*System.out.println(client_id);
            System.out.println(client_secret);*/
        }

		if (granType.isEmpty() || !granType.equals(CLIENT_CREDENTIALS)) {
			message("El campo grant_type es invalido");
		}

		if (Objects.isNull(paramMap) || paramMap.getFirst("client_id").isEmpty()
				|| paramMap.getFirst("client_secret").isEmpty() || !paramMap.getFirst("client_id").equals(client_id)
				|| !paramMap.getFirst("client_secret").equals(client_secret)) {
				message("client_id y/o client_secret son invalidos");
		}
		 
	}

	private void message(String message) throws Apiunauthorized {
		throw new Apiunauthorized(message);
	}

}
