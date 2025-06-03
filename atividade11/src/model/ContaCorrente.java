package model;

import java.time.LocalDate;
import java.util.ArrayList;

import static util.EntradaSaida.exibirMensagem;
import static util.Instanciador.instanciarDeposito;
import static util.Instanciador.instanciarSaque;

public class ContaCorrente extends ContaBancaria{
    private double taxaOperacao;
    private double limiteChequeEspecial;

    public ContaCorrente(int numeroConta, String titular, double saldo, double taxaOperacao, double limiteChequeEspecial) {
        super(numeroConta, titular, saldo);
        this.taxaOperacao = taxaOperacao;
        this.limiteChequeEspecial = limiteChequeEspecial;
        this.saques = new ArrayList<>();
    }

    @Override
    public void sacar(double valor) throws Exception {
        double taxaValor = valor * taxaOperacao/100;
        double totalSaque = valor + taxaValor;

        if(totalSaque > saldo){
            exibirMensagem("Utilizando cheque especial!");
            double valorSerUsadoChequeEspecial = totalSaque - saldo;

            if(valorSerUsadoChequeEspecial <= limiteChequeEspecial){
                saldo -= totalSaque;
                limiteChequeEspecial -= valorSerUsadoChequeEspecial;
                saques.add(instanciarSaque(valor, taxaValor));
            }else{
                throw new IllegalArgumentException("Voce não tem esse valor disponivel no cheque especial! Valor disponivel: R$" + limiteChequeEspecial);
            }
        }else {
            saldo -= totalSaque;
            saques.add(instanciarSaque(valor, taxaValor));
        }
    }

    @Override
    public void depositar(double valor) throws Exception {
        checarDeposito(valor);
    }

    @Override
    public void depositar(Cheque cheque) throws Exception {
        checarDeposito(cheque.getValor());
    }

    public void checarDeposito(double valor) throws Exception {
        if(valor <= 0){
            throw new IllegalArgumentException("Valor inválido para depósito!");
        }
        if(saldo < 0){
            double valorUsadoChequeEspecial = -saldo;
            if(valor > -saldo) {
                limiteChequeEspecial += valorUsadoChequeEspecial;
                saldo += valor;
            }else{
                limiteChequeEspecial += valor;
                saldo += valor;
            }
        }else{
            saldo += valor;
        }
        depositos.add(instanciarDeposito(valor));
    }
}
