package chat.kafka;

import org.joda.time.DateTime;

public class Utils {
	
	public static Long getEpochMillis() {
		
		return new DateTime().getMillis();
	}

}
