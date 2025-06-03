import model.ContaBancaria;
import service.GerenciamentoContas;

import java.util.List;

import static util.EntradaSaida.escolherConta;
import static util.EntradaSaida.exibirMensagem;
import static util.EntradaSaida.lerDouble;
import static util.EntradaSaida.lerInteiro;
import static util.EntradaSaida.lerOpcoes;
import static util.Instanciador.instanciarCheque;

public class Main {
    public static void main(String[] args) throws Exception {
        int opc;
        List<Integer> opcs = List.of(1,2,3,4,5,6,7,8,9);

        GerenciamentoContas gerenciador = new GerenciamentoContas();

        do{
            opc = lerInteiro("Escolha uma opção: \n 1-Cadastrar conta \n " +
                    "2-Sacar \n 3-Depositar \n 4-Listar histórico saques \n 5-Listar historico depósitos \n " +
                    "6-Transferir \n 7-Buscar info conta \n 8-Listar todas contas \n 9-Sair");

            try {
                if (!opcs.contains(opc)) {
                    exibirMensagem("Opcao invalida!");

                } else if (opc == 1) {
                    gerenciador.criarConta();

                } else if (opc == 2) {
                    ContaBancaria conta = escolherConta(gerenciador.getContas(), "Escolha a conta para sacar");
                    gerenciador.saque(conta);

                } else if (opc == 3) {
                    ContaBancaria conta = escolherConta(gerenciador.getContas(), "Escolha a conta para depositar");
                    int tipoDeposito = lerOpcoes("Escolha o tipo de deposito: ", new String[]{"1-Dinheiro", "2-Cheque"});

                    if (tipoDeposito == 1) {
                        gerenciador.deposito(conta);
                    } else if (tipoDeposito == 2) {
                        gerenciador.deposito(conta, instanciarCheque(conta));
                    }
                } else if (opc == 4) {
                    ContaBancaria conta = escolherConta(gerenciador.getContas(), "Escolha a conta para listar os saques");
                    gerenciador.listarSaque(conta);

                } else if (opc == 5) {
                    ContaBancaria conta = escolherConta(gerenciador.getContas(), "Escolha a conta para listar os depositos");
                    gerenciador.listarDeposito(conta);

                } else if (opc == 6) {
                    if(gerenciador.getContas().size() < 2) {
                        exibirMensagem("Devem existir pelo menos duas contas registradas");
                        continue;
                    }
                    gerenciador.transferencia(lerDouble("Digite o valor para transferir"));

                } else if (opc == 7) {
                    ContaBancaria conta = escolherConta(gerenciador.getContas(), "Escolha a conta para listar as info");
                    gerenciador.listarInfoConta(conta);

                } else if (opc == 8) {
                    gerenciador.listarInfoContas();
                }

            }catch (Exception e) {
                exibirMensagem(e.getMessage());
            }

        }while(opc != 9);
    }
}