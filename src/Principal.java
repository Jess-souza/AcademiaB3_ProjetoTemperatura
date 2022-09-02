import java.util.Scanner;

public class Principal {

    private static double getTemp() {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o valor da temperatura: ");
        return input.nextDouble();
    }

    public static void main(String[] args) {
        double resultado;
        initialize();

        ToFahrenheit transformToFahrenheit = new ToFahrenheit();
        ToCelsius transformToCelsius = new ToCelsius();
        ToKelvin transformToKelvin = new ToKelvin();

        UnityTemp unityInput = getUnityTemp("entrada (sendo as opções CELSIUS, KELVIN e FAHRENHEIT):  ");
        UnityTemp unityOutput = getUnityTemp("saída: (sendo as opções CELSIUS, KELVIN e FAHRENHEIT):  ");
        double temp = getTemp();

        System.out.println("Você vai transformar " + temp + " " + unityInput + " em " + unityOutput);

        switch (unityOutput) {
            case CELSIUS:
                resultado = transformToCelsius.transform(unityInput, temp);
                break;
            case FAHRENHEIT:
                resultado = transformToFahrenheit.transform(unityInput, temp);
                break;
            case KELVIN:
                resultado = transformToKelvin.transform(unityInput, temp);
                break;
            default:
                resultado = 0;
                break;
        }
        System.out.printf("O resultado da conversão é %.2f ", resultado);
    }

    private static UnityTemp getUnityTemp(String io) {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite a unidade de temperatura de " + io);
        String typeString = input.nextLine();
        return UnityTemp.valueOf(typeString);
    }

    private static void initialize() {
        System.out.println("Bem vindo ao nosso conversor de temperaturas!");
    }


}