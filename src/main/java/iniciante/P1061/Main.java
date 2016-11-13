package iniciante.P1061;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

/**
 * Created by elvis on 13/11/16.
 */
public class Main {

	static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static final BufferedOutputStream out = new BufferedOutputStream(System.out);

	public static void main(String[] args) throws IOException {
		// nao funciona porque a entrada vem negativa e o programa deles calcula errado conforme evidencia 4
		final double days, hours, minutes, seconds;
		long difference;
		final Event eventStart = readEvent(), eventEnd = readEvent();
		final Calendar calendarStart = Calendar.getInstance(), calendarEnd = Calendar.getInstance();

		fillCalendar(calendarStart, eventStart);
		fillCalendar(calendarEnd, eventEnd);

		difference = calendarEnd.getTimeInMillis() - calendarStart.getTimeInMillis();

		days = difference / 1000.0 / 60.0 / 60.0 / 24.0;
		hours = (days - (long)days) * 24.0;
		minutes = (hours - (long) hours) * 60.0;
		seconds = (minutes - (long)  minutes) * 60.0;

		out.write(Long.toString((long)days).getBytes());
		out.write(" dia(s)\n".getBytes());

		out.write(Long.toString((long)hours).getBytes());
		out.write(" hora(s)\n".getBytes());

		out.write(Long.toString((long)minutes).getBytes());
		out.write(" minuto(s)\n".getBytes());

		out.write(Long.toString((long)seconds).getBytes());
		out.write(" segundo(s)\n".getBytes());

		out.flush();
	}


	static Event readEvent() throws IOException {

		final Event event = new Event();
		final StringTokenizer dayTokenizer = new StringTokenizer(in.readLine()),
					timeTokenizer = new StringTokenizer(in.readLine()," : ");

		dayTokenizer.nextToken(); // palavra DIA

		event.day = Integer.parseInt(dayTokenizer.nextToken());
		event.hour = Integer.parseInt(timeTokenizer.nextToken());
		event.minutes = Integer.parseInt(timeTokenizer.nextToken());
		event.seconds = Integer.parseInt(timeTokenizer.nextToken());

		return event;
	}

	static void fillCalendar(Calendar c, Event e){
		c.set(Calendar.DAY_OF_MONTH, e.day);
		c.set(Calendar.HOUR_OF_DAY, e.hour);
		c.set(Calendar.MINUTE, e.minutes);
		c.set(Calendar.SECOND, e.seconds);
		c.set(Calendar.MONTH, Calendar.APRIL);
	}

	static class Event {
		int day, hour, minutes, seconds;
	}
}
