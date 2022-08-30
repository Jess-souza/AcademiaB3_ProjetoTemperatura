public class ToCelsius {

    public double transform(UnityTemp type, double temp) {
        if (type == UnityTemp.FAHRENHEIT) {
            return (temp - 32) / 1.8;
        } else if(type == UnityTemp.KELVIN) {
            return temp - 273.15;
        } else {
            return temp;
        }
    }
}