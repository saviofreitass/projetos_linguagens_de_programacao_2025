import java.time.Month;

public class Data {
    private int dia, mes, ano;

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;

        if((mes == 2 && dia > 28 && !(ano%4==0)) || (mes == 2 && dia > 29) || mes > 12 || (( mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30) || dia > 31 ) {
            this.dia = 01;
            this.mes = 01;
            this.ano = 0001;
        }
    }

    public int compara(Data data) {
        if(this.dia == data.dia && this.mes == data.mes && this.ano == data.ano){
            return 0;
        }else if(this.ano > data.ano || (this.ano == data.ano && this.mes > data.mes) || (this.ano == data.ano && this.mes == data.mes && this.dia > data.dia)){
            return 1;
        }else{
            return -1;
        }
    }

    public int getDia() {
        return this.dia;
    }

    public int getMes() {
        return this.mes;
    }

    public int getAno() {
        return this.ano;
    }

    public String getMesExtenso(){
        return Month.of(this.mes).toString();
    }

    @Override
    public String toString() {
        return "Data{" +
                "dia=" + dia +
                ", mes=" + mes +
                ", ano=" + ano +
                '}';
    }
}
