package com.studentscheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class StudentschedulerApplication 
{

	public static void main(String[] args) 
	{
		SpringApplication.run(StudentschedulerApplication.class, args);
	}
	
    @GetMapping("/meetings")
    public ResponseEntity<List<Meeting>> getMeetings() {
        String url = "jdbc:sqlserver:DESKTOP-P2ELUL7;databaseName=StudentSchedule";
        String username = "Schedule";
        String password = "P@ssw0rd";

        List<Meeting> meetings = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement stmt = connection.createStatement()) {

            String sql = "SELECT * FROM Meetings";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("MeetingId");
                String title = rs.getString("MeetingTitle");
                Date date = rs.getDate("MeetingDateTime");
                String duration = rs.getString("MeetingDuration");
                boolean reminder = rs.getBoolean("MeetingReminder");

                Meeting meeting = new Meeting(id, title, date, duration, reminder);
                meetings.add(meeting);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.ok(meetings);
    }
}

class Meeting {
    private int id;
    private String title;
    private Date date;
    private String duration;
    private boolean reminder;

    public Meeting(int id, String title, Date date, String duration, boolean reminder) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.duration = duration;
        this.reminder = reminder;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Date: " + date + ", Duration: " + duration + ", Reminder: " + reminder;
    }
}