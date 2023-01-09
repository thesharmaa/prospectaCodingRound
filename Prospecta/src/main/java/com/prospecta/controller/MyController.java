package com.prospecta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.prospecta.entity.Datas;
import com.prospecta.entity.DatasDTO;
import com.prospecta.exception.ClientException;
import com.prospecta.service.myService;

@RestController

public class MyController {

	@Autowired
	private myService myService;

	@GetMapping("/{category}")
	public ResponseEntity<List<DatasDTO>> getDatas(@PathVariable("category") String category) throws ClientException {

		return new ResponseEntity<List<DatasDTO>>(myService.entries(category), HttpStatus.ACCEPTED);
	}

	@PostMapping("/entries")
	public ResponseEntity<Datas> getDatas(@RequestBody Datas data) throws ClientException {

		return new ResponseEntity<Datas>(myService.save(data), HttpStatus.OK);
	}
}
