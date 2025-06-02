import model.Departamento;
import model.Funcionario;

import java.util.ArrayList;

import static service.FolhaPagamento.*;
import static util.EntradaSaida.*;
import static util.Instanciador.*;

public class Main {
    public static void main(String[] args) throws Exception {
        int opc;
        ArrayList<Departamento> dps = new ArrayList<>();
        ArrayList<Funcionario> funcs = new ArrayList<>();

        do{
            opc = lerOpcoes("O que deseja fazer?",
                    new String[]{"1-Cadastrar Departamento",
                            "2-Cadastrar Funcionário",
                            "3-Listagem de salarios por departamento",
                            "4-Listagem geral de salario",
                            "5-Sair"});

            if(opc == 1) {
                try {
                    instanciarDepartamento(dps);
                }catch (Exception e) {
                    exibirMensagem(e.getMessage());
                }
            }else if (opc == 2) {
                if(dps.isEmpty()){
                    exibirMensagem("Registre um departamento primeiro");
                    try {
                        instanciarDepartamento(dps);
                    }catch (Exception e) {
                        exibirMensagem(e.getMessage());
                        continue;
                    }
                }
                int tipo = lerOpcoes("Escolha o tipo de funcionario que quer cadastrar",
                        new String[]{"1-Mensalista",
                        "2-Horistas",
                        "3-Comissionado"});
                Departamento dp = escolherDepartamento(dps);

                if(tipo == 1) {
                    try {
                        instanciarMensalista(dp, funcs);
                    }catch (Exception e) {
                        exibirMensagem(e.getMessage());
                    }
                }else if (tipo == 2) {
                    try {
                        instanciarHorista(dp, funcs);
                    }catch (Exception e) {
                        exibirMensagem(e.getMessage());
                    }
                }else if (tipo == 3) {
                    try{
                        instanciarComissionado(dp, funcs);
                    }catch (Exception e) {
                        exibirMensagem(e.getMessage());
                    }
                }
            }else if(opc == 3) {
                try {
                    Departamento dp = escolherDepartamento(dps);

                    listarSalariosFuncionariosDepartamento(dp);
                }catch(Exception e) {
                    exibirMensagem(e.getMessage());
                }
            }else if(opc == 4) {
                try {
                    listarSalarioGeral(dps);
                }catch(Exception e) {
                    exibirMensagem(e.getMessage());
                }
            }
        }while(opc != 5);
    }
}