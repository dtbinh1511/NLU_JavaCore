package observerpattern_weather;

import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class CurrentConditionDisplay implements Observer, DisplayElement {

	private float temperature;
	private float humidity;
	private float pressure;

	private Observable weatherData;

	public CurrentConditionDisplay(Observable weatherData) {
		this.weatherData = weatherData;
		weatherData.addObserver(this);
	}

	@Override
	public void display() {
		System.out.println("Current temperature: " + temperature + " degress & humidiy: " + humidity + " %");
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof WeatherData) {
			WeatherData weatherData = (WeatherData) o;
			this.temperature = weatherData.getTemperature();
			this.humidity = weatherData.getHumidity();

			display();
		}
	}

}
