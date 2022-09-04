public class ToKelvin {
    public double transform(UnityTemp type, double temp) {
        switch (type) {
            case CELSIUS:
                return temp + 273.15;
            case FAHRENHEIT:
                return 273.15 + ((temp - 32) * (5.0 / 9.0));
            default:
                return temp;
        }
    }
}
