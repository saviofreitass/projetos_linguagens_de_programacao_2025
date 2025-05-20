import javax.swing.*;

public class EntradaSaida {
    public static int lerInteiro(String mensagem){
        return Integer.parseInt(JOptionPane.showInputDialog(mensagem));
    }

    public static String lerString(String mensagem){
        return JOptionPane.showInputDialog(mensagem);
    }

    public static double lerDouble(){
        return Double.parseDouble(JOptionPane.showInputDialog("Digite um double"));
    }

    public static void exibirMensagem(String mensagem){
        JOptionPane.showMessageDialog(null, mensagem);
    }
}
