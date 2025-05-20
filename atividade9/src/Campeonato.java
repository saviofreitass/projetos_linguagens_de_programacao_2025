import javax.naming.SizeLimitExceededException;
import java.util.*;

public class Campeonato {
    private String nome;
    private ArrayList<Time> times;
    private ArrayList<Jogo> jogos;
    private Set<String> jogosRealizados;

    public Campeonato(String nome) {
        this.nome = nome;
        this.times = new ArrayList<>();
        this.jogos = new ArrayList<>();
        this.jogosRealizados = new HashSet<>();
    }

    public void cadastrarTime(String nome) throws SizeLimitExceededException {
        if(this.times.size()==10){
            throw new SizeLimitExceededException();
        }
        Time time = new Time(nome);
        this.times.add(time);
    }

    boolean primeiraSimulacao = true;

    public void simularJogos(int timeA, int timeB) throws Exception {

        if(!validarFinalCamp()){
            throw new Exception("Todos os jogos possíveis já foram realizados! Utilize Sair para finalizar o campeonato!");
        };

        String jogoA = times.get(timeA).getNome() + "-" + times.get(timeB).getNome();
        String jogoB = times.get(timeB).getNome() + "-" + times.get(timeA).getNome();

        if(jogosRealizados.contains(jogoA) || jogosRealizados.contains(jogoB)){
            throw new Exception("Este jogo já foi realizado! Escolha outra dupla de times");
        }
        jogosRealizados.add(jogoA);

        ArrayList<Time> timesJogo = new ArrayList<>();
        timesJogo.add(times.get(timeA));
        timesJogo.add(times.get(timeB));
        Jogo jogo = new Jogo(timesJogo);
        jogos.add(jogo);

        Random random = new Random();
        int golsTimeA = random.nextInt(6);
        int golsTimeB = random.nextInt(6);

        jogo.encerrarJogo(golsTimeA, golsTimeB);
        primeiraSimulacao = false;
    }

    public boolean validarFinalCamp(){
        return jogosRealizados.size() != ((times.size() * (times.size() - 1) / 2));
    }

    public String imprimirTabela(){
        Collections.sort(times, new Comparator<Time>(){
            public int compare(Time time1, Time time2){
                return Integer.compare(time2.getPontos(), time1.getPontos());
            }
        } );

        StringBuilder tabela = new StringBuilder();
        tabela.append(String.format("%-15s %5s %8s %7s %8s %8s %13s %14s %8s\n",
                "Nome do Time |", "Jogos |", "Vitória |", "Empate |", "Derrota |", "Pontos |", "Gols Marcados |", "Gols Sofridos |", "Saldo Gols"));

        tabela.append("-".repeat(105)).append("\n");

        for (Time time : times) {
            tabela.append(String.format("%-15s %3d %8d %7d %8d %8d %13d %14d %14d\n",
                    time.getNome(),
                    time.getJogos(),
                    time.getVitorias(),
                    time.getEmpates(),
                    time.getDerrotas(),
                    time.getPontos(),
                    time.getGolsPro(),
                    time.getGolsContra(),
                    time.getGolsPro() - time.getGolsContra()
            ));
        }

        return !times.isEmpty() ? tabela.toString() : "Nenhum time cadastrado no campeonato!";
    }

    public String imprimirListaTimes(){
        StringBuilder lista = new StringBuilder();
        int i = 0;
        for(Time time : times){
            lista.append(i).append("-").append(time.getNome()).append(" || ");
            i++;
        }
        return lista.toString();
    }

    public void simularAutomaticamente() throws Exception {

        if(!primeiraSimulacao){
            throw new Exception("Ja foi iniciada a simulação manual, conclua por meio dela!");
        }

        if(!validarFinalCamp()){
            throw new Exception("Todos os jogos possíveis já foram realizados! Utilize SAIR para finalizar o campeonato!");
        };

        for(int i = 0; i < times.size(); i++){
            for(int j = i+1; j < times.size(); j++){
                String jogoA = times.get(i).getNome() + "-" + times.get(j).getNome();
                String jogoB = times.get(j).getNome() + "-" + times.get(i).getNome();

                if(jogosRealizados.contains(jogoA) || jogosRealizados.contains(jogoB)){
                    throw new Exception("Este jogo já foi realizado! Escolha outra dupla de times");
                }
                jogosRealizados.add(jogoA);

                ArrayList<Time> timesJogo = new ArrayList<>();
                timesJogo.add(times.get(i));
                timesJogo.add(times.get(j));
                Jogo jogo = new Jogo(timesJogo);
                jogos.add(jogo);

                Random random = new Random();
                int golsTimeA = random.nextInt(6);
                int golsTimeB = random.nextInt(6);

                jogo.encerrarJogo(golsTimeA, golsTimeB);
            }
        }
    }
}
