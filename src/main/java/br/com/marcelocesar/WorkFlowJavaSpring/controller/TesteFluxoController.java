package br.com.marcelocesar.WorkFlowJavaSpring.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redesSociais")
public class TesteFluxoController {
	
	@PostMapping("/executar")
	public void executarRedesSociais() {
	}
}
