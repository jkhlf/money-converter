package org.aplication.model;

public class TaxaCambio {
    private String moedaOrigem;
    private String moedaDestino;
    private double taxa;

    public TaxaCambio(String moedaOrigem, String moedaDestino, double taxa) {
        this.moedaOrigem = moedaOrigem;
        this.moedaDestino = moedaDestino;
        this.taxa = taxa;
    }

    public String getMoedaOrigem() {
        return moedaOrigem;
    }

    public String getMoedaDestino() {
        return moedaDestino;
    }

    public double getTaxa() {
        return taxa;
    }

    @Override
    public String toString() {
        return String.format("Taxa de câmbio: %s -> %s = %.2f", moedaOrigem, moedaDestino, taxa);
    }
}