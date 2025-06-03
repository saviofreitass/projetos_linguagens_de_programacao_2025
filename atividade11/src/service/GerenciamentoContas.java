package service;

import model.Cheque;
import model.ContaBancaria;
import model.ContaPoupanca;
import model.Deposito;
import model.Saque;

import java.util.ArrayList;

import static util.EntradaSaida.escolherConta;
import static util.EntradaSaida.exibirMensagem;
import static util.EntradaSaida.lerDouble;
import static util.EntradaSaida.lerOpcoes;
import static util.Instanciador.instanciarContaCorrente;
import static util.Instanciador.instanciarContaPoupanca;

public class GerenciamentoContas {
    private ArrayList<ContaBancaria> contas;

    public GerenciamentoContas() {
        contas = new ArrayList<>();
    }

    public ArrayList<ContaBancaria> getContas() {
        return contas;
    }

    public void criarConta() throws Exception {
        int opc = lerOpcoes("Qual tipo de conta voce deseja criar?", new String[]{"1-Poupança", "2-Corrente"});
        if(opc == 1){
            adicionarConta(instanciarContaPoupanca());
        }else{
            adicionarConta(instanciarContaCorrente());
        }
    }

    public void adicionarConta(ContaBancaria conta) {
        contas.add(conta);
    }

    public boolean validarConta(ContaBancaria conta) {
        return contas.contains(conta);
    }


    public void deposito(ContaBancaria conta) throws IllegalAccessException {
        if(!validarConta(conta)) {
            throw new IllegalAccessException("Essa conta não está sendo administrada por esse gerenciador!");
        }
        try {
            conta.depositar(lerDouble("Digite o valor do deposito"));
        }catch(Exception e) {
            exibirMensagem(e.getMessage());
        }
    }

    public void deposito(ContaBancaria conta, Cheque cheque) throws IllegalAccessException {
        if(!validarConta(conta)) {
            throw new IllegalAccessException("Essa conta não está sendo administrada por esse gerenciador!");
        }

        try{
            conta.depositar(cheque);
        }catch(Exception e) {
            exibirMensagem(e.getMessage());
        }
    }

    public void saque(ContaBancaria conta) throws IllegalAccessException {
        if(!validarConta(conta)) {
            throw new IllegalAccessException("Essa conta não está sendo administrada por esse gerenciador!");
        }

        try{
            conta.sacar(lerDouble("Digite o valor do saque"));
        }catch(Exception e) {
            exibirMensagem(e.getMessage());
        }
    }

    public void transferencia(double valor){
        if(contas.isEmpty() || contas.size() == 1){
            throw new IllegalArgumentException("Deve existir pelo menos duas contas registradas!");
        }
        try{
            escolherConta(contas, "Escolha a conta que vai sair do dinheiro").sacar(valor);
            escolherConta(contas, "Escolha a conta que vai receber o dinheiro").depositar(valor);
        }catch (Exception e) {
            exibirMensagem(e.getMessage());
        }
    }

    public void listarInfoConta(ContaBancaria conta) {
        String info = "Conta: " + conta.getNumeroConta() + "\n" +
                "Titular: " + conta.getTitular() + "\n" +
                "Saldo: " + conta.getSaldo() + "\n" +
                "Tipo conta: " + (conta instanceof ContaPoupanca ? "Poupanca" : "Corrente");
        exibirMensagem(info);
    }

    public void listarInfoContas(){
        if(contas.isEmpty()){
            throw new IllegalArgumentException("Não há contas registradas!");
        }
        StringBuilder info = new StringBuilder();
        for(ContaBancaria conta : contas){
            info.append("Conta: ").append(conta.getNumeroConta())
                    .append(" || Titular: ").append(conta.getTitular())
                    .append(" || Saldo: ").append(conta.getSaldo())
                    .append(" || Tipo conta: ").append(conta instanceof ContaPoupanca ? "Poupanca" : "Corrente").append("\n");
        }
        exibirMensagem(info.toString());
    }

    public void listarSaque(ContaBancaria conta){
        StringBuilder saques = new StringBuilder();
        for (Saque saque : conta.getSaques()) {
            saques.append("Data saque: ").append(saque.getData()).append(" Valor: ").append(saque.getValor()).append("\n");
        }
        exibirMensagem(saques.toString());
    }

    public void listarDeposito(ContaBancaria conta){
        StringBuilder depositos = new StringBuilder();
        for(Deposito deposito : conta.getDepositos()){
            depositos.append("Data deposito/recebimento transf: ").append(deposito.getDataDeposito()).append(" Valor: ").append(deposito.getValor()).append("\n");
        }
        exibirMensagem(depositos.toString());
    }
}