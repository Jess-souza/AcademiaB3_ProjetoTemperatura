public class ToFahrenheit {

    public double transform(UnityTemp type, double temp) {
        if (type == UnityTemp.CELSIUS) {
            return (temp * 1.8) + 32;
        } else if (type == UnityTemp.KELVIN) {
            return (temp * 1.8) - 459.67;
        } else {
            return temp;
        }
    }
}