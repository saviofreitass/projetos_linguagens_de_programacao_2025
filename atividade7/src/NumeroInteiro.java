public class NumeroInteiro {
    private int numero;

    public NumeroInteiro() {
        this.numero = 0;
    }

    public NumeroInteiro(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public int soma(int num){
        return this.numero + num;
    }

    public int subtrai(int num){
        return this.numero - num;
    }

    public boolean isPrimo(int num){
        if(num <= 1){
            return false;
        }

        for(int i = 2; i<= Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }

        return true;
    }

    public int getNextPrimo(){
        int nextPrimo = this.numero + 1;

        while(!isPrimo(nextPrimo)){
            nextPrimo++;
        }

        return nextPrimo;
    }
}
