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
        int quantity = 0;
        double[] temperature;
        double average;
        double finalAverage = 0;
        double result;
        initialize();


        System.out.print("Digite o número de temperatura(s) para conversão: ");
        try {
            quantity = input.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Você precisa digitar um número inteiro, tente novamente!");
            return;
        }

        temperature = new double[quantity];

        for (int i = 0; i < quantity; i++) {
            System.out.print("Digite o valor da temperatura " + i + " : ");
            try {
                temperature[i] = input.nextDouble();
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

        for (double temp : temperature) {
            System.out.println("\nVocê vai transformar " + temp + " " + unityInput + " em " + unityOutput);

            switch (unityOutput) {
                case CELSIUS:
                    result = transformToCelsius.transform(unityInput, temp);
                    break;
                case FAHRENHEIT:
                    result = transformToFahrenheit.transform(unityInput, temp);
                    break;
                case KELVIN:
                    result = transformToKelvin.transform(unityInput, temp);
                    break;
                default:
                    result = 0;
                    break;
            }
            System.out.printf("O resultado da conversão é %.2f ", result);
            finalAverage += result;
        }
        System.out.println("\n------------------------------------/------------------------------------/------------------------------------");
        average = Arrays.stream(temperature).sum();
        average /= quantity;
        System.out.printf("A média das %d temperaturas iniciais é %.2f", quantity, average);

        finalAverage = finalAverage / quantity;
        System.out.printf("\nA média das %d temperaturas transformadas é %.2f", quantity, finalAverage);
        System.out.println("\n------------------------------------/------------------------------------/------------------------------------");
    }
}