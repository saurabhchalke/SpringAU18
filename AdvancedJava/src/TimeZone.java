import java.time.*;

public class TimeZone {
	public static void main(String[] args) {
		
		Instant now = Instant.now();
		ZoneId zoneId = ZoneId.of("America/Los_Angeles");
		ZonedDateTime dateAndTime = ZonedDateTime.ofInstant(now, zoneId);
		System.out.println(dateAndTime);
		
		now = Instant.now();
		zoneId = ZoneId.of("Asia/Calcutta");
		dateAndTime = ZonedDateTime.ofInstant(now, zoneId);
		System.out.println(dateAndTime);
		
		now = Instant.now();
		zoneId = ZoneId.of("Asia/Hong_Kong");
		dateAndTime = ZonedDateTime.ofInstant(now, zoneId);
		System.out.println(dateAndTime);
		
		now = Instant.now();
		zoneId = ZoneId.of("Europe/Berlin");
		dateAndTime = ZonedDateTime.ofInstant(now, zoneId);
		System.out.println(dateAndTime);
		
		now = Instant.now();
		zoneId = ZoneId.of("Australia/Adelaide");
		dateAndTime = ZonedDateTime.ofInstant(now, zoneId);
		System.out.println(dateAndTime);
		
	}
}
