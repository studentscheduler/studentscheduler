package com.studentscheduler.services;

import java.util.List;

import com.studentscheduler.dto.EventDTO;

public interface IUserService {

	List<EventDTO> getEvents(int userId);
	
	EventDTO joinEvent(EventDTO event);
}
