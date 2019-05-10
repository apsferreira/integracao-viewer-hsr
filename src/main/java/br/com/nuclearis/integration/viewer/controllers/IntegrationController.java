package br.com.nuclearis.integration.viewer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nuclearis.integration.viewer.model.Informations;
import br.com.nuclearis.integration.viewer.services.IntegrationService;

@RestController
@RequestMapping("/api/integration/")
public class IntegrationController {

	@Autowired
	private IntegrationService integrationService;

	@GetMapping
	public ResponseEntity<?> index() {
		return new ResponseEntity<String>("Arô to funcionando", HttpStatus.OK);
	}

	@PostMapping(path = "/execute-viewer")
	public ResponseEntity<?> executeViewer(@RequestBody Informations informations) {

		ResponseEntity<?> response = new ResponseEntity<Object>(HttpStatus.OK);

		if (integrationService.executeViewer(informations)) {
			return new ResponseEntity<String>("executou", HttpStatus.OK);
		}

		return new ResponseEntity<String>("error", HttpStatus.NO_CONTENT);
	}
}
