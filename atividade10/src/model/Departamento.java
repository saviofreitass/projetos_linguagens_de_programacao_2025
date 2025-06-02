package model;

import java.util.ArrayList;

public class Departamento {
    private String descricao;
    private double valorHoraTrabalhada;
    private ArrayList<Funcionario> funcionarios;

    public Departamento(String descricao, double valorHoraTrabalhada) {
        this.descricao = descricao;
        this.valorHoraTrabalhada = valorHoraTrabalhada;
        this.funcionarios = new ArrayList<>();
    }

    public String getDescricao() {
        return descricao;
    }

    public void associarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public ArrayList<Funcionario> getFuncionarios(){
        return funcionarios;
    }

    public double getValorHoraTrabalhada() {
        return valorHoraTrabalhada;
    }


}
