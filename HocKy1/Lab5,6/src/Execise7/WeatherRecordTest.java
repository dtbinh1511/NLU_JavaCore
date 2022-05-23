package Execise7;

import junit.framework.TestCase;

public class WeatherRecordTest extends TestCase {
	public void testWeatherRecordConstructor() {
		Date d1 = new Date(15, 11, 2001);
		TemperatureRange T = new TemperatureRange(15, 35);
		TemperatureRange N = new TemperatureRange(10, 38);
		TemperatureRange R = new TemperatureRange(0, 40);

		WeatherRecord w1 = new WeatherRecord(d1, T, N, R, 1000);
	}

	public void testWithinRange() {
		Date d1 = new Date(15, 11, 2001);
		TemperatureRange T = new TemperatureRange(15, 35);
		TemperatureRange N = new TemperatureRange(10, 38);
		TemperatureRange R = new TemperatureRange(0, 40);
		WeatherRecord w1 = new WeatherRecord(d1, T, N, R, 1000);
		assertTrue(w1.withinRange());
	}

	public void testRainyDay() {
		Date d1 = new Date(15, 11, 2001);
		TemperatureRange T = new TemperatureRange(15, 35);
		TemperatureRange N = new TemperatureRange(10, 38);
		TemperatureRange R = new TemperatureRange(0, 40);
		WeatherRecord w1 = new WeatherRecord(d1, T, N, R, 1000);
		assertTrue(w1.rainyDay(100));

	}
	public void testRecordDay() {
		Date d1 = new Date(15, 11, 2001);
		TemperatureRange T = new TemperatureRange(15, 35);
		TemperatureRange N = new TemperatureRange(10, 38);
		TemperatureRange R = new TemperatureRange(0, 40);
		WeatherRecord w1 = new WeatherRecord(d1, T, N, R, 1000);
		WeatherRecord w2 = new WeatherRecord(d1, T, N, R, 500);
		assertFalse(w1.recordDay());
		
	}
}
