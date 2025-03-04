#include <iostream>
#include <iomanip>

using namespace std;

struct Funcionario{
    char nome[100];
    int departamento;
    double horasTrab;
    double salarioBase;
    double horaExtra;
    double insalubridade;
    double bonificacao;
    double inss;
    double irpf;
    double plano = 20.00;
    double salarioLiquido;
};

void receberInfo(Funcionario &func){
    cout << "Digite o nome do funcionario: ";
    cin >> func.nome;

    fflush(stdin);

    do{
        cout << "Digite o setor: 1-Administrativo ou 2-Producao: ";
        cin >> func.departamento;
    }while(func.departamento != 1 && func.departamento != 2);

    cout << "Digite as quantidade de horas trabalhadas no mes: ";
    cin >> func.horasTrab;
}

void calcularSalarioBase(Funcionario &func){

    if(func.departamento == 1){
        func.salarioBase = func.horasTrab * 22.00;
    }else if(func.departamento == 2){
        func.salarioBase = func.horasTrab * 12.00;
    }
}

void calcularHoraExtra(Funcionario &func){

    if(func.horasTrab > 40){
        if(func.departamento == 1){
            func.horaExtra = 22.00 * 2 * (func.horasTrab - 40);
        }else if(func.departamento == 2){
            func.horaExtra = 12.00 * 2 * (func.horasTrab - 40);
        }
    }else{
        func.horaExtra = 0;
    }
}

void calcularInsalubridade(Funcionario &func){

    if(func.departamento == 2){
        func.insalubridade = func.salarioBase * 15/100;
    }else{
        func.insalubridade = 0;
    }
}

void calcularBonificacao(Funcionario &func){

    if(func.departamento == 1){
        if(func.horasTrab > 20 && func.horasTrab <= 30){
            func.bonificacao = func.salarioBase * 3/100;
        }else if(func.horasTrab > 30 && func.horasTrab < 40){
            func.bonificacao = func.salarioBase * 5/100;
        }else if(func.horasTrab >= 40){
            func.bonificacao = func.salarioBase * 10/100;
        }else{
            func.bonificacao = 0;
        }
    }else{
        func.bonificacao = 0;
    }
}

double calcularSalarioBruto(Funcionario func){
    return func.salarioBase + func.horaExtra + func.insalubridade + func.bonificacao;
}

void calcularINSS(Funcionario &func){
    func.inss = calcularSalarioBruto(func) * 7/100;
}

void calcularIRPF(Funcionario &func){
    func.irpf = calcularSalarioBruto(func) * 12/100;
}

void calcularSalarioLiquido(Funcionario &func){
    func.salarioLiquido = calcularSalarioBruto(func) - func.inss - func.irpf - func.plano;
}

void imprimirInfo(Funcionario func){
    cout << "\n\n";
    cout << "Nome do funcionario: " << func.nome << endl;
    cout << fixed << setprecision(2) << "Salario Base: R$ " << func.salarioBase << endl;
    cout << fixed << setprecision(2) << "Hora Extra: R$ " << func.horaExtra << endl;
    cout << fixed << setprecision(2) << "Insalubridade: R$ " << func.insalubridade << endl;
    cout << fixed << setprecision(2) << "Bonificacao: R$ " << func.bonificacao << endl;
    cout << fixed << setprecision(2) << "INSS: R$ " << func.inss << endl;
    cout << fixed << setprecision(2) << "IRPF: R$ " << func.irpf << endl;
    cout << fixed << setprecision(2) << "Plano de saude: R$ " << func.plano << endl;
    cout << fixed << setprecision(2) << "Salario liquido: R$ " << func.salarioLiquido << endl;
    cout << "---------------------------------------------------------------------------------" << endl;
}

int main(){

    Funcionario listaFuncionarios[5];

    for(int i = 0; i < 5; i++){

        receberInfo(listaFuncionarios[i]);

        calcularSalarioBase(listaFuncionarios[i]);

        calcularHoraExtra(listaFuncionarios[i]);

        calcularInsalubridade(listaFuncionarios[i]);

        calcularBonificacao(listaFuncionarios[i]);

        calcularINSS(listaFuncionarios[i]);

        calcularIRPF(listaFuncionarios[i]);

        calcularSalarioLiquido(listaFuncionarios[i]);

        system("cls");
    }

    for(int i = 0; i < 5; i++){
        imprimirInfo(listaFuncionarios[i]);
    }

    system("pause");

    return 0;
}
