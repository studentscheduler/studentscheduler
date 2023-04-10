package com.studentscheduler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentScheduleraController {
	
	@RequestMapping("/start")
	public String start() {
		return "start";
	}
	
}
