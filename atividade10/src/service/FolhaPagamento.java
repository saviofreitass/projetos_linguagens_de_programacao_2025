package service;

import model.Departamento;
import model.Funcionario;

import java.util.ArrayList;

import static util.EntradaSaida.exibirConsole;

public class FolhaPagamento {

    public static void listarSalariosFuncionariosDepartamento(Departamento departamento) {
        if(departamento.getFuncionarios().isEmpty()){
            throw new ArrayIndexOutOfBoundsException("Nao existem funcionarios cadastrados");
        }

       exibirConsole("Folha salarial do departamento: " + departamento.getDescricao());
        for(Funcionario func: departamento.getFuncionarios()){
            exibirConsole("Nome: " + func.getNome() + " | Salario: " + func.calcularSalario());
        }
       exibirConsole("Salario total do departamento " + departamento.getDescricao() +" é: " + somaTotalSalariosDepartamento(departamento) + "\n");
    }

    public static void listarSalarioGeral(ArrayList<Departamento> dps) {
        if (dps.isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Não há departamentos cadastrados");
        }

        double somaTotal = 0;
        for(Departamento dp: dps){
            exibirConsole("Departamento: " + dp.getDescricao());
            for(Funcionario func: dp.getFuncionarios()){
                exibirConsole("Nome: " + func.getNome() +
                        " ||  Departamento: " +func.getDepartamento().getDescricao() +
                        " ||  Salario: " + func.calcularSalario());
            }
            exibirConsole("Salario total do departamento " + dp.getDescricao() +" é: " + somaTotalSalariosDepartamento(dp) + "\n");
            somaTotal += somaTotalSalariosDepartamento(dp);
        }
        exibirConsole("A folha salarial geral é: " + somaTotal + "\n");
    }

    static double somaTotalSalariosDepartamento(Departamento departamento) {
        double salarioTotal = 0;
        for(Funcionario func: departamento.getFuncionarios()){
            salarioTotal += func.calcularSalario();
        }
        return salarioTotal;
    }
}