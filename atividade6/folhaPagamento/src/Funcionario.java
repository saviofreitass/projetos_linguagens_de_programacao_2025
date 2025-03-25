public class Funcionario {
    private String nome;
    private int departamento;
    private double horasTrabalhadas;
    private double salarioBase;
    private double horaExtra;
    private double insalubridade;
    private double bonificacao;
    private double salarioBruto;
    private double inss;
    private double irpf;
    private double plano = 20.00;
    private double salarioLiquido;

    public Funcionario(String nome, int departamento, double horasTrabalhadas) {
        this.nome = nome;
        this.departamento = departamento;
        this.horasTrabalhadas = horasTrabalhadas;
        salarioBase = calcularSalarioBase(this.departamento, this.horasTrabalhadas);
        horaExtra =  calcularHoraExtra(this.departamento, this.horasTrabalhadas);
        insalubridade =  calcularInsalubridade(this.departamento, this.salarioBase);
        bonificacao =  calcularBonificacao(this.departamento, this.horasTrabalhadas, this.salarioBase);
        salarioBruto =  calcularSalarioBruto(this.salarioBase, this.horaExtra, this.insalubridade, this.bonificacao);
        inss =  calcularINSS(this.salarioBruto);
        irpf =  calcularIRPF(this.salarioBruto);
        salarioLiquido = calcularSalarioLiquido(salarioBruto, this.inss, this.irpf, this.plano);
    }

    public double calcularSalarioBase(int departamento, double horasTrabalhadas) {
        if(departamento == 1){
            return horasTrabalhadas * 22.00;
        }else{
            return horasTrabalhadas * 12.00;
        }
    }

    public double calcularHoraExtra(int departamento, double horasTrabalhadas) {
        if(horasTrabalhadas > 40){
            if(departamento == 1){
                return 22.00 * 2 * (horasTrabalhadas - 40);
            }else{
                return 12.00 * 2 * (horasTrabalhadas - 40);
            }
        }else{
            return 0;
        }
    }

    public double calcularInsalubridade(int departamento, double salarioBase) {
        if(departamento == 2){
            return salarioBase * 15/100;
        }else{
            return 0;
        }
    }

    public double calcularBonificacao(int departamento, double horasTrabalhadas, double salarioBase) {
        if(departamento == 1){
            if(horasTrabalhadas > 20 && horasTrabalhadas <= 30){
                return salarioBase * 3/100;
            }else if(horasTrabalhadas > 30 && horasTrabalhadas < 40){
                return salarioBase * 5/100;
            }else if(horasTrabalhadas >= 40){
                return salarioBase * 10/100;
            }else{
                return 0;
            }
        }else{
            return 0;
        }
    }

    public double calcularSalarioBruto(double salarioBase, double horaExtra, double insalubridade, double bonificacao) {
        return salarioBase + horaExtra + insalubridade + bonificacao;
    }

    public double calcularINSS(double salarioBruto){
        return salarioBruto * 7/100;
    }

    public double calcularIRPF(double salarioBruto){
        return salarioBruto * 12/100;
    }

    public double calcularSalarioLiquido(double salarioBruto, double inss, double irpf, double plano){
        return salarioBruto - (inss + irpf + plano);
    }

    public void imprimirDados(){
        System.out.println("Nome: " + this.nome);
        System.out.println("Departamento: " + this.departamento);
        System.out.println("Horas trabalhadas: " + this.horasTrabalhadas);
        System.out.println("Salario Base: " + this.salarioBase);
        System.out.println("Hora extra: " + this.horaExtra);
        System.out.println("Insalubridade: " + this.insalubridade);
        System.out.println("Bonificacao: " + this.bonificacao);
        System.out.println("Salario Bruto: " + this.salarioBruto);
        System.out.println("Inss: " + this.inss);
        System.out.println("IRPF: " + this.irpf);
        System.out.println("Plano: " + this.plano);
        System.out.println("Salario Liquido: " + this.salarioLiquido);
        System.out.println("----------------------------------------------------");
        System.out.println();
    }
}

