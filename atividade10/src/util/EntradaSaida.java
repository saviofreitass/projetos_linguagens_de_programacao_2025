package util;

import javax.swing.JOptionPane;
import model.Departamento;

import java.util.List;

public class EntradaSaida {
    public static String lerString(String mensagem){
        return JOptionPane.showInputDialog(mensagem);
    }

    public static double lerDouble(String mensagem){
        return Double.parseDouble(JOptionPane.showInputDialog(mensagem));
    }

    public static int lerOpcoes(String mensagem, String[] opcoes){
       return JOptionPane.showOptionDialog(null,
                mensagem,
                null, JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, null,
                opcoes,
                null) + 1;
    }

    public static Departamento escolherDepartamento(List<Departamento> departamentos) {
        if (departamentos.isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Não há departamentos cadastrados");
        }

        Object[] opcoes = new Object[departamentos.size()];
        for (int i = 0; i < departamentos.size(); i++) {
            opcoes[i] = (i + 1) + " - " + departamentos.get(i).getDescricao();
        }

        int escolha = JOptionPane.showOptionDialog(
                null,
                "Escolha um departamento:",
                "Departamentos",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes,
                null
        );

        return departamentos.get(escolha);
    }

    public static void exibirMensagem(String mensagem){
        JOptionPane.showMessageDialog(null, mensagem);
    }

    public static void exibirConsole(String mensagem){
        System.out.println(mensagem);
    }

}
