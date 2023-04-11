package com.studentscheduler.services;

import com.studentscheduler.dto.CalendarDTO;
import com.studentscheduler.dto.EventDTO;

public interface ICalendarService {
	
	CalendarDTO fetchEvent(int eventId);
	
	CalendarDTO createEvent(EventDTO event);
	
	CalendarDTO alterEvent(EventDTO event);
	
	CalendarDTO deleteEvent(int eventId);
	
	void save(CalendarDTO calendarDTO);
}
