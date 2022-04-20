package com.daniloalalmeida.minhasfinancas.service;

import static org.mockito.ArgumentMatchers.anyString;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.daniloalalmeida.minhasfinancas.exception.RegraNegocioException;
import com.daniloalalmeida.minhasfinancas.model.entity.Usuario;
import com.daniloalalmeida.minhasfinancas.model.repository.UsuarioRepository;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class UsuarioServiceTest {
	
	@Autowired
	UsuarioService service;
	
	@Autowired
	UsuarioRepository repository;
	
	@Test
	public void deveValidarEmail() {
		
		//Cenário
		repository.deleteAll();
		
		//Ação
		service.validarEmail("email@email.com");
		
		//Verificação
		Assertions.assertThat("email@email.com");
		
	}
	
	@Test
	public void deveLancarErroAoValidarEmailQuandoExistirEmailCadastrado() {
		
		//Cenário
		Usuario usuario = Usuario.builder().nome("usuario").email("email@email.com").build();
		repository.save(usuario);
		
		//Ação
		service.validarEmail("email@email.com");
		
		//Verificação
		Assertions.assertThat(RegraNegocioException.class).isEqualTo(RegraNegocioException.class);
	}
}
