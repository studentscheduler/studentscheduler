package com.studentscheduler.services;

import com.studentscheduler.dto.CalendarDTO;

public interface ICalendarService {
	
	CalendarDTO fetchById(int id);
	
	void save(CalendarDTO calendarDTO);
}
