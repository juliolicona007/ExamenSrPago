package com.prueba.julio.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.prueba.julio.service.InfoRQService;
import com.prueba.julio.model.InfoRQ;
import com.prueba.julio.util.Response;

@RestController
@RequestMapping(value = "/infoRQ", produces = { MediaType.APPLICATION_JSON_VALUE })
public class InfoRQController {

	@Autowired
	private InfoRQService service;

	public InfoRQService getService() {
		return service;
	}

	public void setService(InfoRQService service) {
		this.service = service;
	}

	@PostMapping("/payment")
	public ResponseEntity<Response> receivePayment(@Valid @RequestBody InfoRQ info, BindingResult result) {
		Response response = new Response();
		if(result.hasErrors()) {
			List<String> errores = result.getFieldErrors()
				.stream()
				.map(err -> err.getField() + " -> " + err.getDefaultMessage())
				.collect(Collectors.toList());
			response.setSuccess(false);
			response.setError(errores);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			service.save(info);
			response.setSuccess(true);
			response.setMessage("Informacion correcta");
			response.setError(null);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch(Exception e) {
			response.setSuccess(false);
			List<String> errores = new ArrayList<>();
			errores.add(e.getMessage());
			response.setError(errores);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/payments")
	public List<InfoRQ> getAll(){
		return service.findAll();
	}
	
}
