public class ToFahrenheit {

    public double transform(UnityTemp type, double temp) {
        switch (type) {
            case CELSIUS:
                return (temp * 1.8) + 32;
            case KELVIN:
                return (temp - 273.15) * 1.8 + 32;
            default:
                return temp;
        }
    }
}