package com.dataeconomy.migration.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dataeconomy.migration.app.model.ConnectionDto;
import com.dataeconomy.migration.app.model.DMUBasketDto;
import com.dataeconomy.migration.app.model.HistoryMainDto;
import com.dataeconomy.migration.app.service.DMURequestService;

@RestController
@RequestMapping("/datamigration/request")
public class DMURequestController {

	@Autowired
	private DMURequestService dmuRequestService;

	@PostMapping("/save")
	public List<ConnectionDto> saveRequest(@RequestBody HistoryMainDto historyMainDto) {
		return dmuRequestService.saveRequest(historyMainDto);
	}

	@GetMapping("/all")
	public List<String> getAllDatabases() {
		return dmuRequestService.getAllRequestDatabases();
	}

	@GetMapping("/all/{databaseName}")
	public List<DMUBasketDto> getAllTablesForGivenDatabase(@PathVariable(name = "databaseName") String databaseName) {
		return dmuRequestService.getAllTablesForGivenDatabase(databaseName);
	}

}
