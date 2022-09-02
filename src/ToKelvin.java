public class ToKelvin {
    public double transform(UnityTemp type, double temp) {
        switch (type) {
            case CELSIUS:
                return temp - 273.15;
            case FAHRENHEIT:
                return (temp * 1.8) - 459.67;
            default:
                return temp;
        }
    }
}
