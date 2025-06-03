package model;

import java.time.LocalDate;

public class Saque {
    public LocalDate dataSaque;
    public double valor;
    public double valorTaxa;

    public Saque(double valor, double valorTaxa) {
        this.dataSaque = LocalDate.now();
        this.valor = valor;
        this.valorTaxa = valorTaxa;
    }

    public LocalDate getData() {
        return dataSaque;
    }

    public double getValor() {
        return valor;
    }
}
