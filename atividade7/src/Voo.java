public class Voo {
    private int numVoo;
    private Data dataVoo;
    private Hora horaVoo;
    private int[] cadeiras = new int [100];

    public Voo(int numVoo, Data dataVoo, Hora horaVoo) {
        this.numVoo = numVoo;
        this.dataVoo = dataVoo;
        this.horaVoo = horaVoo;
    }

    public int proximoLivre(){
        int i = 0;
        while(cadeiras[i] == 1){
            i++;
        }
        return i;
    }

    public int verifica(int cadeira){
        if(cadeiras[cadeira] == 0){
            return 1;
        }else{
            return 0;
        }
    }

    public String ocupa(int cadeira){
        if(verifica(cadeira) == 1){
            cadeiras[cadeira] = 1;
            return "A cadeira estava livre, ocupação realizada com sucesso!";
        }else{
            return "Essa cadeira ja á está ocupada, use proximoLivre() para verificar a próxima cadeira disponivel!";
        }
    }

    public int vagas(){
        int i = 0;
        for(int lugar: cadeiras){
            if(lugar == 0){
                i += 1;
            }
        }
        return i;
    }

    public int getVoo(){
        return this.numVoo;
    }

    public Data getData(){
        return this.dataVoo;
    }
}
