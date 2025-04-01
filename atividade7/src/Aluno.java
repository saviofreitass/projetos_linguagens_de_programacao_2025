import javax.swing.*;

public class Aluno {
    private int matricula;
    private String nome;
    private double notaProva1, notaProva2, notaTrabalho;

    public Aluno(int matricula, String nome, double notaProva1, double notaProva2, double notaTrabalho) {
        this.matricula = matricula;
        this.nome = nome;
        this.notaProva1 = notaProva1;
        this.notaProva2 = notaProva2;
        this.notaTrabalho = notaTrabalho;

        if(notaProva1 > 3 || notaProva2 > 3 || notaTrabalho > 4){
            throw new IllegalArgumentException("Notas informadas não respeitam a nota máxima!");
        }
    }

    public double notaTotal(){
        double notaTotal = this.notaProva1 + this.notaProva2 + this.notaTrabalho;
        return notaTotal;
    }

    public String isAprovado(){
        if(notaTotal() >= 10*0.6){
            return "Aprovado com sucesso!";
        }else{
            return "Reprovado!";
        }
    }

    public void mostrarInfo(){
        JOptionPane.showMessageDialog(null, "Matricula do aluno: " + this.matricula + "\n Nome do aluno: " + this.nome + "\n Nota prova 1: "
                + this.notaProva1 + "\n Nota prova 2: " + this.notaProva2 + "\n Nota trabalho: " + this.notaTrabalho + "\n Nota total: " + notaTotal() +
                "\n Resultado: " + isAprovado());
    }
}
