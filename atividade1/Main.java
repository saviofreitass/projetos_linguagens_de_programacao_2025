public class Main {
    public static void main(String[] args) {

        try{
            validarIdade(17);
        }catch(IllegalArgumentException e){
            System.out.println("Erro: " + e);
        }finally {
            System.out.println("Sua idade foi verificada!");
        }
    }

    public static void validarIdade(int idade){
        if(idade < 18){
            throw new IllegalArgumentException("Sua idade deve ser maior ou igual a 18");
        }
        System.out.println("Idade válida: " + idade + " anos");
    }
}