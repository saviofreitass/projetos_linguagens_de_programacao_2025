package util;

import model.ContaBancaria;

import javax.swing.JOptionPane;
import java.util.List;

public class EntradaSaida {
    public static String lerString(String mensagem){
        return JOptionPane.showInputDialog(mensagem);
    }

    public static double lerDouble(String mensagem){
        return Double.parseDouble(JOptionPane.showInputDialog(mensagem));
    }

    public static int lerInteiro(String mensagem){
        return Integer.parseInt(JOptionPane.showInputDialog(mensagem));
    }

    public static void exibirMensagem(String mensagem){
        JOptionPane.showMessageDialog(null, mensagem);
    }

    public static int lerOpcoes(String mensagem, String[] opcoes){
        return JOptionPane.showOptionDialog(null,
                mensagem,
                null, JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, null,
                opcoes,
                null) + 1;
    }

    public static ContaBancaria escolherConta(List<ContaBancaria> contas, String mensagem) {
        if (contas.isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Não há contas registradas");
        }

        Object[] opcoes = new Object[contas.size()];
        for (int i = 0; i < contas.size(); i++) {
            opcoes[i] = (i + 1) + " - " + contas.get(i).getNumeroConta();
        }

        int escolha = JOptionPane.showOptionDialog(
                null,
                mensagem,
                null,
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes,
                null
        );

        return contas.get(escolha);
    }
}