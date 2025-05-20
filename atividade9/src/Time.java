public class Time {
    private String nome;
    private int pontos;
    private int vitorias;
    private int empates;
    private int derrotas;
    private int golsPro;
    private int golsContra;
    private int jogos;

    public Time(String nome) {
        this.nome = nome;
        this.pontos = 0;
    }

    public void adicionarPontos(int pontos) {
        this.pontos += pontos;
    }

    public void adicionarGols(int pro, int contra){
        this.golsPro += pro;
        this.golsContra += contra;
    }

    public void adicionarVitorias(int vitorias) {this.vitorias += vitorias;}

    public void adicionarEmpates(int empates) {this.empates += empates;}

    public void adicionarDerrotas(int derrotas) {this.derrotas += derrotas;}

    public void adicionarJogos(int jogos){ this.jogos += jogos;}

    public String getNome() {
        return nome;
    }

    public int getPontos() { return pontos; }

    public int getGolsPro() { return golsPro; }

    public int getGolsContra() { return golsContra; }

    public int getVitorias() { return vitorias; }

    public int getEmpates() { return empates; }

    public int getDerrotas() { return derrotas; }

    public int getJogos() { return jogos; }
}
