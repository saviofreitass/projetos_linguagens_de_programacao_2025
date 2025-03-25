import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Funcionario> funcionarios = new ArrayList<Funcionario>();

        for (int i = 0; i < 5; i++) {
            String nome = JOptionPane.showInputDialog(null, "Digite o nome do funcionario: ");
            int departamento = JOptionPane.showOptionDialog(null,
                    "Escolha uma opção",
                    null, JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null,
                    new String[]{"1-ADM", "2-PROD"},
                    null);
            double horasTrabalhadas = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite a quantidade de horas trabalhadas:"));

            Funcionario func = new Funcionario(nome, departamento + 1, horasTrabalhadas);
            funcionarios.add(func);
        }

        for (Funcionario funcionario : funcionarios) {
            funcionario.imprimirDados();
        }
    }
}