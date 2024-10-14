package org.aplication;
import org.aplication.service.ConversorService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversorService conversorService = new ConversorService();

        while (true) {
            System.out.println("*****************************************");
            System.out.println("Seja bem-vindo/a ao Conversor de Moeda =]");
            System.out.println("1) Dólar => Peso argentino");
            System.out.println("2) Peso argentino => Dólar");
            System.out.println("3) Dólar => Real brasileiro");
            System.out.println("4) Real brasileiro => Dólar");
            System.out.println("5) Dólar => Peso colombiano");
            System.out.println("6) Peso colombiano => Dólar");
            System.out.println("7) Euro => Dólar");
            System.out.println("8) Dólar => Euro");
            System.out.println("9) Libra esterlina => Dólar");
            System.out.println("10) Dólar => Libra esterlina");
            System.out.println("11) Exibir histórico de conversões");
            System.out.println("12) Sair");
            System.out.println("Escolha uma opção válida:");
            System.out.println("*****************************************");

            int opcao = scanner.nextInt();

            if (opcao == 12) {
                System.out.println("Saindo...");
                break;
            }

            if (opcao == 11) {
                conversorService.exibirHistorico();
                continue;
            }

            String moedaOrigem = "";
            String moedaDestino = "";

            switch (opcao) {
                case 1:
                    moedaOrigem = "USD";
                    moedaDestino = "ARS";
                    break;
                case 2:
                    moedaOrigem = "ARS";
                    moedaDestino = "USD";
                    break;
                case 3:
                    moedaOrigem = "USD";
                    moedaDestino = "BRL";
                    break;
                case 4:
                    moedaOrigem = "BRL";
                    moedaDestino = "USD";
                    break;
                case 5:
                    moedaOrigem = "USD";
                    moedaDestino = "COP";
                    break;
                case 6:
                    moedaOrigem = "COP";
                    moedaDestino = "USD";
                    break;
                case 7:
                    moedaOrigem = "EUR";
                    moedaDestino = "USD";
                    break;
                case 8:
                    moedaOrigem = "USD";
                    moedaDestino = "EUR";
                    break;
                case 9:
                    moedaOrigem = "GBP";
                    moedaDestino = "USD";
                    break;
                case 10:
                    moedaOrigem = "USD";
                    moedaDestino = "GBP";
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    continue;
            }

            System.out.print("Digite o valor a ser convertido: ");
            double valor = scanner.nextDouble();

            // Chama o serviço de conversão
            double taxa = conversorService.obterTaxaDeCambio(moedaOrigem, moedaDestino);
            if (taxa != -1) {
                double valorConvertido = valor * taxa;
                System.out.printf("Resultado: %.2f %s = %.2f %s\n", valor, moedaOrigem, valorConvertido, moedaDestino);
                conversorService.registrarConversao(moedaOrigem, moedaDestino, valor, valorConvertido); // Registra a conversão
            }
        }

        scanner.close();
    }
}