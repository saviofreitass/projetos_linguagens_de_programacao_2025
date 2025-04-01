import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Atividade 1

        int matricula = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a matricula do aluno: "));
        String nome = JOptionPane.showInputDialog(null, "Digite o nome do aluno: ");
        double notaProva1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite a nota da primeira prova (0-3): ")),
                notaProva2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite a nota da segunda prova (0-3): ")),
                notaTrabalho = Double.parseDouble(JOptionPane.showInputDialog(null, " Digite a nota da trabalho (0-4): "));
        try {
            Aluno aluno1 = new Aluno(matricula, nome, notaProva1, notaProva2, notaTrabalho);
            aluno1.mostrarInfo();
        }catch (IllegalArgumentException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        //------------------------------------------------------------------//---------------------------------------------------------------------//

        //Atividade 2

        List<Data> listaData = new ArrayList<Data>();

        for(int i = 1; i < 3; i++) {
            JOptionPane.showMessageDialog(null, "Digite a data " + i + ":");

            int dia = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o dia: "));
            int mes = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o mes: "));
            int ano = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a ano: "));

            Data data = new Data(dia, mes, ano);

            listaData.add(data);
        }

        int result = listaData.get(0).compara(listaData.get(1));

        if(result == 0) {
            JOptionPane.showMessageDialog(null ,"Datas iguais!");
        }else if(result == 1) {
            JOptionPane.showMessageDialog(null ,"Data 1 é maior!");
        }else{
            JOptionPane.showMessageDialog(null, "Data 2 é maior!");
        }

        for(Data data : listaData) {
            JOptionPane.showMessageDialog(null, "Dia: " + data.getDia() + "\nMes: " + data.getMes()
            + "\nAno: " + data.getAno() + "\nMês extenso: " + data.getMesExtenso());
        }

        //------------------------------------------------------------------//---------------------------------------------------------------------//


        //Atividade 3

        List<Hora> listaHora = new ArrayList<Hora>();

        for (int i = 1; i < 3; i++) {
            JOptionPane.showMessageDialog(null, "Digite a " + i + "° hora");

            int horas = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a hora: "));
            int minutos = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a minuto: "));
            int segundos = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a segundo: "));

            Hora hora = new Hora(horas, minutos, segundos);
            listaHora.add(hora);
        }

        JOptionPane.showMessageDialog(null, "A diferença de segundos entre as horas é de: " + listaHora.get(0).compara(listaHora.get(1)) + "s" );

        for(Hora hora : listaHora){
            JOptionPane.showMessageDialog(null, "Horas: " + hora.getHora() + "\nMinutos: " + hora.getMinuto() + "\nSegundos: " + hora.getSegundo()
            + "\nHora Display: " + hora.displayHora());
        }

        //------------------------------------------------------------------//---------------------------------------------------------------------//

        //Atividade 4

        int numVoo = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero do voo: "));

        Voo voo1 = new Voo(numVoo, listaData.getFirst(), listaHora.getFirst());

        JOptionPane.showMessageDialog(null,"Proxima cadeira livre: " + voo1.proximoLivre());

        int cadeira = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a cadeira para verificar: "));

        if(voo1.verifica(cadeira) == 1){
            JOptionPane.showMessageDialog(null, "Cadeira escolhia está vazia!");
        }else{
            JOptionPane.showMessageDialog(null, "Cadeira escolhida está ocupada!");
        }

        cadeira = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a cadeira para ocupar: "));

        JOptionPane.showMessageDialog(null, voo1.ocupa(cadeira));

        JOptionPane.showMessageDialog(null, "Ainda há " + voo1.vagas() + " cadeiras disponiveis no voo!");

        JOptionPane.showMessageDialog(null, "Numero do voo: " + voo1.getVoo());

        JOptionPane.showMessageDialog(null, "Data voo: " + voo1.getData().toString());

        //------------------------------------------------------------------//---------------------------------------------------------------------//

        //Atividade 5

        int escolha = JOptionPane.showOptionDialog(null, "Deseja atribuir um valor na hora da instanciação?", null, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"1-Sim", "2-Não"}, null);

        NumeroInteiro numeroInt = null;

        if(escolha == 0){
            int num = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o valor: "));
            numeroInt = new NumeroInteiro(num);
        }else{
            numeroInt = new NumeroInteiro();
        }

        int somar = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero para somar: "));

        JOptionPane.showMessageDialog(null, "Numero " + numeroInt.getNumero()  + " somado de " + somar + " é: " + numeroInt.soma(somar));

        int subtrair = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero para subtrair: "));

        JOptionPane.showMessageDialog(null, "Numero " + numeroInt.getNumero()+ " subtraido de " + subtrair + " é: " + numeroInt.subtrai(subtrair));

        boolean primo = numeroInt.isPrimo(numeroInt.getNumero());

        if(primo){
            JOptionPane.showMessageDialog(null, "O numero " + numeroInt.getNumero()+ " é primo!");
        }else{
            JOptionPane.showMessageDialog(null, "O numero " + numeroInt.getNumero() + " não é primo!");
        }

        JOptionPane.showMessageDialog(null, "O proximo número primo após " + numeroInt.getNumero() + " é: " + numeroInt.getNextPrimo());
   }
}