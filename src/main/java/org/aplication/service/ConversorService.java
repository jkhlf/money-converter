package org.aplication.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.github.cdimascio.dotenv.Dotenv;
import org.aplication.model.Conversao;

public class ConversorService {

    // Carregar variáveis do arquivo .env
    private static final Dotenv dotenv = Dotenv.load();
    private static final String API_KEY = dotenv.get("API_KEY");
    private List<Conversao> historicoConversoes = new ArrayList<>();  // Armazena o histórico

    // Função para obter a taxa de câmbio
    public double obterTaxaDeCambio(String moedaOrigem, String moedaDestino) {
        try {
            String url = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + moedaOrigem + "/" + moedaDestino;
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Usando Gson para processar a resposta JSON
            Gson gson = new Gson();
            JsonObject jsonResponse = gson.fromJson(response.body(), JsonObject.class);

            return jsonResponse.get("conversion_rate").getAsDouble();

        } catch (Exception e) {
            System.out.println("Erro ao obter taxa de câmbio: " + e.getMessage());
            return -1;
        }
    }

    // Função para registrar uma conversão
    public void registrarConversao(String moedaOrigem, String moedaDestino, double valorOrigem, double valorConvertido) {
        Conversao conversao = new Conversao(moedaOrigem, moedaDestino, valorOrigem, valorConvertido);
        historicoConversoes.add(conversao);
    }

    // Exibir o histórico de conversões
    public void exibirHistorico() {
        if (historicoConversoes.isEmpty()) {
            System.out.println("Nenhuma conversão realizada ainda.");
        } else {
            System.out.println("Histórico de Conversões:");
            for (Conversao conversao : historicoConversoes) {
                System.out.println(conversao);
            }
        }
    }
}