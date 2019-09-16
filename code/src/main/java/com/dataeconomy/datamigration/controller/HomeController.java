package com.dataeconomy.datamigration.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/home")
public class HomeController {


	@RequestMapping(value = "/chart", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Long> loadChartInfo() {
		Map<String, Long> chartMap = new HashMap<>();
		// TODO Need to remove commented code and add accessRights for normal users to get tasklistcount
		/*List<Task> taskList = new ArrayList<>();
		if (ThreadLocalUtil.getUser().isSadmin() || ThreadLocalUtil.getUser().isAdmin()) {
			taskList = taskService.getTaskList();
		} else {
			taskList = taskService.getTaskByAccessRight(ThreadLocalUtil.getUser().getTaskAccessRights());
		}*/
		
		return chartMap;
	}

	
	
}
