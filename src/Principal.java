import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    private static void initialize() {
        System.out.println("Bem vindo ao nosso conversor de temperaturas!");
        System.out.println("------------------------------------/------------------------------------/------------------------------------");
    }

    private static UnityTemp getUnityTemp(String io) {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite a unidade de temperatura de " + io);
        String typeString = input.nextLine();
        try {
            return UnityTemp.valueOf(typeString.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.err.println("Você digitou uma opção inexistente, digite Celsius, Kelvin ou Fahrenheit");
            return getUnityTemp(io);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int quantidade = 0;
        double[] temperaturas;
        double media;
        double mediaFinal = 0;
        double resultado;
        initialize();

        System.out.print("Digite o número de temperatura(s) para conversão: ");
        try {
            quantidade = input.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Você precisa digitar um número inteiro, tente novamente!");
            return;
        }

        temperaturas = new double[quantidade];

        for (int i = 0; i < quantidade; i++) {
            System.out.print("Digite o valor da temperatura " + i + " : ");
            try {
                temperaturas[i] = input.nextDouble();
            } catch (InputMismatchException e) {
                System.err.println("Você precisa digitar um número real, tente novamente!");
                return;
            }
        }
        System.out.println("------------------------------------/------------------------------------/------------------------------------");

        ToFahrenheit transformToFahrenheit = new ToFahrenheit();
        ToCelsius transformToCelsius = new ToCelsius();
        ToKelvin transformToKelvin = new ToKelvin();

        UnityTemp unityInput = getUnityTemp("entrada (sendo as opções Celsius, Kelvin ou Fahrenheit):  ");
        UnityTemp unityOutput = getUnityTemp("saída (sendo as opções Celsius, Kelvin ou Fahrenheit):  ");
        System.out.println("------------------------------------/------------------------------------/------------------------------------");

        for (double temp : temperaturas) {
            System.out.println("\nVocê vai transformar " + temp + " " + unityInput + " em " + unityOutput);

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
        System.out.println("\n------------------------------------/------------------------------------/------------------------------------");
        media = Arrays.stream(temperaturas).sum();
        media /= quantidade;
        System.out.printf("A média das %d temperaturas iniciais é %.2f", quantidade, media);

        mediaFinal = mediaFinal / quantidade;
        System.out.printf("\nA média das %d temperaturas transformadas é %.2f", quantidade, mediaFinal);
        System.out.println("\n------------------------------------/------------------------------------/------------------------------------");
    }
}