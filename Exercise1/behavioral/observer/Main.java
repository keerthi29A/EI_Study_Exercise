public class Main {
    public static void main(String[] args) {
        // Create the WeatherStation (Subject)
        WeatherStation weatherStation = new WeatherStation();

        // Create DisplayUnits (Observers)
        DisplayUnit phoneDisplay = new DisplayUnit("Phone Display");
        DisplayUnit tvDisplay = new DisplayUnit("TV Display");
        DisplayUnit laptopDisplay = new DisplayUnit("Laptop Display");

        // Register observers to the WeatherStation
        weatherStation.addObserver(phoneDisplay);
        weatherStation.addObserver(tvDisplay);
        weatherStation.addObserver(laptopDisplay);

        // Simulate temperature updates
        weatherStation.setTemperature(25.5f);
        weatherStation.setTemperature(30.2f);
        weatherStation.setTemperature(28.4f);

        // Remove one observer and update temperature again
        weatherStation.removeObserver(tvDisplay);
        weatherStation.setTemperature(26.0f);
    }
}
