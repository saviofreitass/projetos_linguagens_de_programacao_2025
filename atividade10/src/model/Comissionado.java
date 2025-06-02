package model;

public class Comissionado extends Funcionario {
    public double valorVendas;
    public double percentualComissao;

    public Comissionado(String nome, String cidade, String estado, double horasTrabalhadas, Departamento departamento, double valorVendas, double percentualComissao) {
        super(nome, cidade, estado, horasTrabalhadas, departamento);
        this.valorVendas = valorVendas;
        this.percentualComissao = percentualComissao;
    }

    @Override
    public double calcularSalario() {
        return valorVendas * percentualComissao/100;
    }
}
