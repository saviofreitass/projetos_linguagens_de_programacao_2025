package model;

public class Horista extends Funcionario {

    public Horista(String nome, String cidade, String estado, double horasTrabalhadas, Departamento departamento) {
        super(nome, cidade, estado, horasTrabalhadas, departamento);
    }

    @Override
    public double calcularSalario() {
        return getHorasTrabalhadas() * getDepartamento().getValorHoraTrabalhada();
    }
}
