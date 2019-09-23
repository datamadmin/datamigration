package com.dataeconomy.migration.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dataeconomy.migration.app.service.RequestService;

@RestController
@RequestMapping("/datamigration/request")
public class RequestController {

	@Autowired
	private RequestService requestService;

	/*@GetMapping("/databases")
	public List<String> getAllRequestDatabases() {
		return requestService.getAllRequestDatabases();
	}*/
}
