import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        initialize();
        ToFahrenheit transformToFahrenheit = new ToFahrenheit();
        ToCelsius transformToCelsius = new ToCelsius();

        UnityTemp unityInput = getUnityTemp("entrada");

        UnityTemp unityOutput = getUnityTemp("saída");

        transformToCelsius.transform(UnityTemp.KELVIN, 10);
        transformToCelsius.transform(UnityTemp.CELSIUS, 10);


        double temp = getDouble();
        double fahrenheit = transformToFahrenheit.transform(temp);

        System.out.printf("O resultado da conversão é %f", fahrenheit);
    }

    private static UnityTemp getUnityTemp(String io) {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite a unidade de temperatura de " + io);
        String typeString = input.nextLine();
        return UnityTemp.valueOf(typeString);
    }

    private static void initialize() {
        System.out.println("Bem vindo ao nosso conversor de temperaturas.");
    }

    private static double getDouble() {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite um número real: ");
        return input.nextDouble();
    }
}