package model;

import java.time.LocalDate;
import java.util.ArrayList;

import static util.EntradaSaida.exibirMensagem;
import static util.Instanciador.instanciarDeposito;
import static util.Instanciador.instanciarSaque;

public class ContaPoupanca extends ContaBancaria{
    private double taxaRendimento;
    private int saquesGratisDisponiveis;

    public ContaPoupanca(int numeroConta, String titular, double saldo, double taxaRendimento) {
        super(numeroConta, titular, saldo);
        this.taxaRendimento = taxaRendimento;
        this.saquesGratisDisponiveis = 12;
        this.saques = new ArrayList<>();
    }

    @Override
    public void sacar(double valor) throws Exception {
        if((valor > this.saldo) || ((valor + 1 > this.saldo) && (saquesGratisDisponiveis == 0))) {
            if(saquesGratisDisponiveis==0){
                exibirMensagem("Lembrando que cada operacao tem custo de R$1,00, já que seus saques grátis acabaram!");
            }
            throw new IllegalArgumentException("Saldo insuficiente! Saldo disponivel: R$" + this.saldo);
        }else if(saquesGratisDisponiveis == 0){
            exibirMensagem("Você já atingiu numero maximo de saques grátis mensais, cada operação de saque custará R$1,00");
            this.saldo -= valor + 1;
            saques.add(instanciarSaque(valor, 1));
        }else{
            this.saldo -= valor;
            this.saquesGratisDisponiveis--;
            saques.add(instanciarSaque(valor, 0));
        }
    }

    @Override
    public void depositar(double valor) throws Exception {
        if(valor <= 0){
            throw new IllegalArgumentException("Valor inválido para depósito!");
        }

        this.saldo += valor;
        depositos.add(instanciarDeposito(valor));
    }

    @Override
    public void depositar(Cheque cheque) throws Exception {
        if(cheque.getValor() <= 0){
            throw new IllegalArgumentException("Valor inválido para depósito!");
        }

        this.saldo += cheque.getValor();
        depositos.add(instanciarDeposito(cheque.getValor()));
    }
}
