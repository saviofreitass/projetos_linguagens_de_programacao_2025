package model;

public class Cheque {
    private double valor;
    private ContaBancaria contaDeposito;

    public Cheque(double valor, ContaBancaria contaDeposito) {
        this.valor = valor;
        this.contaDeposito = contaDeposito;
    }

    public double getValor() {
        return valor;
    }

    public ContaBancaria getContaDeposito() {
        return contaDeposito;
    }
}
