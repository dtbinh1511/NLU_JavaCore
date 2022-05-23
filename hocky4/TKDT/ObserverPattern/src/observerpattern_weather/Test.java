package observerpattern_weather;

public class Test {
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
		StatictisDisplay statisticsDisplay = new StatictisDisplay(weatherData);
		CurrentConditionDisplay currentDisplay = new CurrentConditionDisplay(weatherData);
		
		weatherData.setMeansurements(25, 65, 30.4f);
		System.out.println("------------------------");
		weatherData.setMeansurements(32, 70, 29.2f);
		System.out.println("------------------------");
		weatherData.setMeansurements(10, 90, 29.2f);

	}
}
