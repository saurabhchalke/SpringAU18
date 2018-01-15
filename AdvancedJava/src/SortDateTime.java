import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Iterator;

public class SortDateTime {
	
	public static void main(String[] args) {
		
		List<ZonedDateTime> dateTime = new ArrayList<>();
		
		Instant now = Instant.now();
		dateTime.add(ZonedDateTime.ofInstant(now, ZoneId.of("America/Los_Angeles")));
		dateTime.add(ZonedDateTime.ofInstant(now, ZoneId.of("Asia/Calcutta")));
		dateTime.add(ZonedDateTime.ofInstant(now, ZoneId.of("Asia/Hong_Kong")));
		dateTime.add(ZonedDateTime.ofInstant(now, ZoneId.of("Europe/Berlin")));
		dateTime.add(ZonedDateTime.ofInstant(now, ZoneId.of("Australia/Adelaide")));
		
		Collections.sort(dateTime);

		Iterator<ZonedDateTime> it = dateTime.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
			
	}
	
}
