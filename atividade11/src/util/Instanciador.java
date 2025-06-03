package util;

import model.Cheque;
import model.ContaBancaria;
import model.ContaCorrente;
import model.ContaPoupanca;
import model.Deposito;
import model.Saque;
import service.GerenciamentoContas;

import static util.EntradaSaida.lerDouble;
import static util.EntradaSaida.lerInteiro;
import static util.EntradaSaida.lerString;

public class Instanciador {

    public static void instanciarGerenciador() {
        GerenciamentoContas gerenciamentoContas = new GerenciamentoContas();
    }

    public static ContaBancaria instanciarContaPoupanca() throws Exception {
        ContaBancaria conta;
        try{
            conta = new ContaPoupanca(lerInteiro("Digite o numero de conta desejado: "),
                    lerString("Digite o titular da conta: "),
                    lerDouble("Digite o saldo inicial da conta: "),
                    lerDouble("Digite a taxa de rendimento: "));
        }catch(Exception e){
            throw new Exception("Erro ao criar conta poupança!");
        }
        return conta;
    }

    public static ContaBancaria instanciarContaCorrente() throws Exception {
        ContaBancaria conta;
        try{
            conta = new ContaCorrente(lerInteiro("Digite o numero de conta desejado: "),
                    lerString("Digite o titular da conta: "),
                    lerDouble("Digite o saldo inicial da conta: "),
                    lerDouble("Digite a taxa de operacao da conta: "),
                    lerDouble("Digite o limite de cheque especial da conta: "));
        }catch(Exception e){
            throw new Exception("Erro ao criar conta corrente!");
        }
        return conta;
    }

    public static Saque instanciarSaque(double valor, double valorTaxa) throws Exception {
        Saque saque;
        try{
            saque = new Saque(valor, valorTaxa);
        }catch (Exception e) {
            throw new Exception("Erro ao criar saque!");
        }
        return saque;
    }

    public static Deposito instanciarDeposito(double valor) throws Exception {
        Deposito deposito;
        try {
            deposito = new Deposito(valor);
        } catch (Exception e) {
            throw new Exception("Erro ao criar deposito!");
        }
        return deposito;
    }

    public static Cheque instanciarCheque( ContaBancaria conta) throws Exception {
        Cheque cheque;
        try{
            cheque = new Cheque(lerDouble("Digite o valor do cheque"),conta);
        } catch (Exception e) {
            throw new Exception("Erro ao criar Cheque");
        }
        return cheque;
    }
}
