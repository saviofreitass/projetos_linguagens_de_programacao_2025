package model;

import java.util.ArrayList;

abstract public class ContaBancaria {
    protected int numeroConta;
    protected String titular;
    protected double saldo;
    protected ArrayList<Saque> saques;
    protected ArrayList<Deposito> depositos;

    public ContaBancaria(int numeroConta, String titular, double saldo) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = saldo;
        this.saques = new ArrayList<>();
        this.depositos = new ArrayList<>();
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public ArrayList<Saque> getSaques() {
        return saques;
    }

    public ArrayList<Deposito> getDepositos() {
        return depositos;
    }

    abstract public void sacar(double valor) throws Exception;
    abstract public void depositar(double valor) throws Exception;
    abstract public void depositar(Cheque cheque) throws Exception;

}
