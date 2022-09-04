import java.util.Arrays;
import java.util.Scanner;

public class Principal {

    private static void initialize() {
        System.out.println("Bem vindo ao nosso conversor de temperaturas!");
    }

    private static UnityTemp getUnityTemp(String io) {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite a unidade de temperatura de " + io);
        String typeString = input.nextLine();
        return UnityTemp.valueOf(typeString);
    }

    private static double getTemp() {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o valor da temperatura: ");
        return input.nextDouble();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int quantidade;
        double[] temperaturas;
        double media;
        double mediaFinal = 0;
        double resultado;
        initialize();

        System.out.print("Digite o número de temperatura(s) para conversão: ");
        quantidade = input.nextInt();

        temperaturas = new double[quantidade];

        for (int i = 0; i < quantidade; i++) {
            System.out.println("Digite o valor da temperatura: " + i);
            temperaturas[i] = input.nextDouble();
        }

        ToFahrenheit transformToFahrenheit = new ToFahrenheit();
        ToCelsius transformToCelsius = new ToCelsius();
        ToKelvin transformToKelvin = new ToKelvin();

        UnityTemp unityInput = getUnityTemp("entrada (sendo as opções CELSIUS, KELVIN e FAHRENHEIT):  ");
        UnityTemp unityOutput = getUnityTemp("saída (sendo as opções CELSIUS, KELVIN e FAHRENHEIT):  ");

        for (double temp : temperaturas) {

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

            mediaFinal += resultado;
        }

        media = Arrays.stream(temperaturas).sum();
        media /= quantidade;
        System.out.printf("\nA média das %d temperaturas iniciais é %.2f", quantidade, media);

        mediaFinal = mediaFinal / quantidade;
        System.out.printf("\nA média das %d temperaturas finais é %.2f", quantidade, mediaFinal);
    }

}