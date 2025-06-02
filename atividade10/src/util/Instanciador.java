package util;

import model.Comissionado;
import model.Departamento;
import model.Funcionario;
import model.Horista;
import model.Mensalista;

import java.util.ArrayList;

import static util.EntradaSaida.lerDouble;
import static util.EntradaSaida.lerString;

public class Instanciador {
    public static void instanciarDepartamento(ArrayList<Departamento> dps) throws Exception {
        try {
            Departamento departamento = new Departamento(lerString("Digite o nome do departamento"),
                    lerDouble("Digite o valor da hora trabalhada"));
            dps.add(departamento);
        }catch (Exception e){
            throw new Exception("Erro ao instanciar Departamento");
        }
    }

    public static void instanciarMensalista(Departamento dp, ArrayList<Funcionario> funcs) throws Exception {
        try {
            Funcionario func = new Mensalista(lerString("Digite o nome do funcionario"),
                    lerString("Digite a cidade do funcionario"),
                    lerString("Digite o estado do funcionario"),
                    lerDouble("Digite quantas horas o funcionario trabalhou"),
                    dp, lerDouble("Digite o salario do funcionario"));
            funcs.add(func);
        }catch (Exception e){
            throw new Exception("Erro ao instanciar funcionário tipo mensalista");
        }
    }

    public static void instanciarHorista(Departamento dp, ArrayList<Funcionario> funcs) throws Exception {
        try {
            Funcionario func = new Horista(lerString("Digite o nome do funcionario"),
                    lerString("Digite a cidade do funcionario"),
                    lerString("Digite o estado do funcionario"),
                    lerDouble("Digite quantas horas o funcionario trabalhou"),
                    dp);
            funcs.add(func);
        }catch (Exception e){
            throw new Exception("Erro ao instanciar funcionário tipo horista");
        }
    }

    public static void instanciarComissionado(Departamento dp, ArrayList<Funcionario> funcs) throws Exception {
        try {
            Funcionario func = new Comissionado(lerString("Digite o nome do funcionario"),
                    lerString("Digite a cidade do funcionario"),
                    lerString("Digite o estado do funcionario"),
                    lerDouble("Digite quantas horas o funcionario trabalhou"),
                    dp, lerDouble("Digite quanto o funcionario vendeu"),
                    lerDouble("Digite qual a porcentagem de comissao do funcionario"));
            funcs.add(func);
        }catch (Exception e){
            throw new Exception("Erro ao instanciar funcionário tipo comissionado");
        }
    }
}
