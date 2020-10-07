package ekaterina.chehuta.temperature.model;

public class Model {
    private String stringOut;

    public void convertTemperatureToFahrenheit(String stringInput) {
        double number = Double.parseDouble(stringInput) * 1.8 + 32;
        stringOut = String.valueOf(number);
    }

    public void convertTemperatureToKelvin(String stringInput) {
        double number = Double.parseDouble(stringInput) + 273.15;
        stringOut = String.valueOf(number);
    }

    public String getStringOut() {
        return stringOut;
    }
}
