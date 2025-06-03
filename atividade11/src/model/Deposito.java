package model;

import java.time.LocalDate;

public class Deposito {
    public LocalDate dataDeposito;
    public double valor;

    public Deposito( double valor) {
        this.dataDeposito = LocalDate.now();
        this.valor = valor;
    }

    public LocalDate getDataDeposito() {
        return dataDeposito;
    }

    public double getValor() {
        return valor;
    }
}