import javax.swing.*;

public class Triangulo {
    private double ladoA;
    private double ladoB;
    private double ladoC;
    private double area;
    private double perimetro;

    public Triangulo(int ladoA, int ladoB, int ladoC) {
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = ladoC;
        this.perimetro = ladoA + ladoB + ladoC;
    }

    public void calcularArea(){
        double semiperimetro = (ladoA + ladoB + ladoC)/2;
        this.area = Math.sqrt(semiperimetro * (semiperimetro - ladoA) * (semiperimetro - ladoB) * (semiperimetro - ladoC));
    }

    public boolean validarTriangulo(){
        return ((ladoA + ladoB) > ladoC && (ladoB + ladoC) > ladoA && (ladoC + ladoA) > ladoB);
    }

    public void tipoTriangulo(){
        if(!validarTriangulo()){
            JOptionPane.showMessageDialog(null,"Essas retas nao conseguem formar um triangulo");
        }else if(ladoA == ladoB && ladoB == ladoC){
            JOptionPane.showMessageDialog(null ,"Triangulo equilatero");
        }else if((ladoA == ladoB) || (ladoB == ladoC) || ladoA == ladoC){
            JOptionPane.showMessageDialog(null ,"Triangulo isosceles");
        }else{
            JOptionPane.showMessageDialog(null ,"Triangulo escaleno");
        }
    }

    public void mostrarInfo(){
        if(validarTriangulo()) {
            JOptionPane.showMessageDialog(null, "Area do triangulo: " + String.format("%.2f", this.area) + "\nPerimetro: " + this.perimetro);
        }
    }
}
