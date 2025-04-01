public class Hora {
    private int hora;
    private int minuto;
    private int segundo;

    public Hora(int hora, int minuto, int segundo) {
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;

        if((hora < 0 || hora > 24) || (minuto < 0 || minuto > 59) || (segundo < 0 || segundo > 59)){
            this.hora = 0;
            this.minuto = 0;
            this.segundo = 0;
        }
    }

    public int compara(Hora hora){
        if(this.hora == hora.hora && this.minuto == hora.minuto && this.segundo == hora.segundo){
            return 0;
        }else{
            int totalSegundos1 = this.hora * 60 * 60 + this.minuto * 60 + this.segundo;
            int totalSegundos2 = hora.hora * 60 * 60 + hora.minuto * 60 + hora.segundo;

            return Math.abs(totalSegundos1-totalSegundos2);
        }
    }

    public int getHora() {
        return this.hora;
    }

    public int getMinuto() {
        return this.minuto;
    }

    public int getSegundo() {
        return this.segundo;
    }

    public String displayHora(){
        return String.format("%02d", this.hora) + ":" + String.format("%02d", this.minuto) + ":" + String.format("%02d", this.segundo);
    }
}
