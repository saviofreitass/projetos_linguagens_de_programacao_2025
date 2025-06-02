package model;

public abstract class Funcionario {
    private String nome;
    private String cidade;
    private String estado;
    private double horasTrabalhadas;
    private Departamento departamento;

    public Funcionario(String nome, String cidade, String estado, double horasTrabalhadas, Departamento departamento) {
        this.nome = nome;
        this.cidade = cidade;
        this.estado = estado;
        this.horasTrabalhadas = horasTrabalhadas;
        this.departamento = departamento;
        departamento.associarFuncionario(this);
    }

    public String getNome() {
        return nome;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public double getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public abstract double calcularSalario();
}
