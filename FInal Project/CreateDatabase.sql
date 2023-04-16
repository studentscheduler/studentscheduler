CREATE LOGIN Schedule
WITH PASSWORD = 'P@ssw0rd';

CREATE DATABASE StudentSchedule;

CREATE TABLE Meetings (
MeetingId smallint PRIMARY KEY IDENTITY(1,1),
MeetingTitle varchar(25),
MeetingDateTime datetime,
MeetingDuration varchar(25),
MeetingLocation varchar(25),
MeetingReminder BIT)

