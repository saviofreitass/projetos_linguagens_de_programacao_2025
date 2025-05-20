
public class Main {
    public static void main(String[] args) throws Exception {
        try {
            Campeonato camp = new Campeonato(EntradaSaida.lerString("Digite o nome do campeonato:"));

            int opc = 0;
            while (opc != 3) {
                opc = EntradaSaida.lerInteiro("Escolha uma opcao: 1-Cadastrar time  2-Simular jogos manualmente  3-Sair   4-Simular todos jogos automaticamente");
                switch (opc) {
                    case 1:
                        Time time = new Time(EntradaSaida.lerString("Digite o nome do time:"));
                        camp.cadastrarTime(time.getNome());
                        break;
                    case 2:
                        try {
                            camp.simularJogos(EntradaSaida.lerInteiro("Escolha um time: " + camp.imprimirListaTimes()), EntradaSaida.lerInteiro("Escolha o segundo time:" + camp.imprimirListaTimes()));
                        }catch (Exception e) {
                            EntradaSaida.exibirMensagem("Erro: " + e.getMessage());
                        }
                        break;
                    case 3:
                        System.out.println(camp.imprimirTabela());
                        break;
                    case 4:
                        try{
                            camp.simularAutomaticamente();
                        }catch (Exception e) {
                            EntradaSaida.exibirMensagem("Erro: " + e.getMessage());
                        }
                        break;
                    default:
                        EntradaSaida.exibirMensagem("Opção inválida!");
                        break;
                }
            }
        }catch (Exception e) {
            EntradaSaida.exibirMensagem("Erro: " + e.getMessage());
        }


    }
}