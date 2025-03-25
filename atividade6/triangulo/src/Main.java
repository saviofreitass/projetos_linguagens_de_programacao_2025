import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        int ladoA = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o lado A: "));
        int ladoB = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o lado B: "));
        int ladoC = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o lado C: "));

        Triangulo triangulo = new Triangulo(ladoA, ladoB, ladoC);

        triangulo.calcularArea();
        triangulo.tipoTriangulo();
        triangulo.mostrarInfo();
    }
}