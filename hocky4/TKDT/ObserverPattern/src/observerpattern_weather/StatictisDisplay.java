package observerpattern_weather;

import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class StatictisDisplay implements Observer, DisplayElement {
	private float sumTemp = 0f;
	private float tempMax = 0f;
	private float tempMin = 0f;
	private int numReadings = 0;
	private Observable weatherData;

	public StatictisDisplay(Observable weatherData) {
		this.weatherData = weatherData;
		weatherData.addObserver(this);
	}

	@Override
	public void display() {
		System.out.println("Avg/Max/Min temperature: " + sumTemp / numReadings + "/" + tempMax + "/" + tempMin);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof WeatherData) {
			WeatherData weatherData = (WeatherData) o;
			sumTemp += weatherData.getTemperature();
			numReadings++;

			if (tempMax < weatherData.getTemperature())
				tempMax = weatherData.getTemperature();
			if (tempMin > weatherData.getTemperature())
				tempMin = weatherData.getTemperature();

			display();
		}
	}

}
