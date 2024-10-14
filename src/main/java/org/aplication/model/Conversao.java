package org.aplication.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Conversao {
    private String moedaOrigem;
    private String moedaDestino;
    private double valorOrigem;
    private double valorConvertido;
    private LocalDateTime dataHora;

    public Conversao(String moedaOrigem, String moedaDestino, double valorOrigem, double valorConvertido) {
        this.moedaOrigem = moedaOrigem;
        this.moedaDestino = moedaDestino;
        this.valorOrigem = valorOrigem;
        this.valorConvertido = valorConvertido;
        this.dataHora = LocalDateTime.now();  // Armazena o momento da conversão
    }

    public String getDataHoraFormatada() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return dataHora.format(formatter);
    }

    @Override
    public String toString() {
        return String.format("Em %s: %.2f %s => %.2f %s",
                getDataHoraFormatada(),
                valorOrigem, moedaOrigem,
                valorConvertido, moedaDestino);
    }
}