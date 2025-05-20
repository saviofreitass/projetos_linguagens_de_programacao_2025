import java.util.ArrayList;

public class Jogo {
    private ArrayList<Time> times;
    private int[] placar = new int[2];
    private String vencedor;

    public Jogo(ArrayList<Time> times){
        this.times = times;
    }

    public void encerrarJogo(int gols1, int gols2){
        placar[0] = gols1;
        placar[1] = gols2;

        if(gols1 > gols2){
            this.vencedor = times.getFirst().getNome();
            times.getFirst().adicionarPontos(3);
            times.getFirst().adicionarVitorias(1);
            times.get(1).adicionarDerrotas(1);
            this.vencedor = times.getFirst().getNome();
        }else if(gols1 < gols2){
            this.vencedor = times.get(1).getNome();
            times.get(1).adicionarPontos(3);
            times.get(1).adicionarVitorias(1);
            times.getFirst().adicionarDerrotas(1);
            this.vencedor = times.get(1).getNome();
        }else{
            times.get(0).adicionarPontos(1);
            times.get(1).adicionarPontos(1);
            times.get(0).adicionarEmpates(1);
            times.get(1).adicionarEmpates(1);
        }

        times.getFirst().adicionarGols(gols1, gols2);
        times.get(1).adicionarGols(gols2, gols1);
        times.get(0).adicionarJogos(1);
        times.get(1).adicionarJogos(1);
    }
}
