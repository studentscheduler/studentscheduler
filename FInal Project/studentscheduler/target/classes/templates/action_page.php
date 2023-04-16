<?php
$servername = "DESKTOP-P2ELUL7";
$username = "Schedule";
$password = "P@ssw0rd";
$dbname = "StudentSchedule";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}
echo "Connected successfully";

// Get the form data
$title = $_POST['title'];
$time = $_POST['datetime'];
$duration = $_POST['duration'];
$location = $_POST['location'];
$reminder = isset($_POST['reminder']) ? 1 : 0;

// Insert the data into the database
$sql = "INSERT INTO Meetings (MeetingTitle, MeetingDateTime, MeetingDuration, MeetingLocation, MeetingReminder) VALUES ('$title', '$datetime', '$duration', '$location', '$reminder')";

if ($conn->query($sql) === TRUE) {
  echo "Meeting added successfully";
} else {
  echo "Error: " . $sql . "<br>" . $conn->error;
}

$conn->close();
?>
