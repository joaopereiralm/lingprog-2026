import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escreva seu nome: ");
        String nome = sc.next();
        System.out.println("Escreva sua idade: ");
        int idade = sc.nextInt();
        System.out.println("Escreva sua altura: ");
        float altura = sc.nextFloat();
        System.out.println("Escreva seu peso: ");
        float peso = sc.nextFloat();

        //calculo do IMC
        float imc = peso/(altura*altura);
        String classificacao;
        String imca = String.format("%.2f", imc);

        if (imc <= 18.5){
            classificacao = "Abaixo do peso";
        }
        else if (imc > 18.5 && imc <= 24.99){
            classificacao = "Normal";
        }
        else if (imc > 25 && imc<= 29.99){
            classificacao = "Acima do peso";
        }
        else {
            classificacao = "Obesidade";
        }

        System.out.println("\nSeu diagnóstico:");
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Seu IMC: " + imca);
        System.out.printf(classificacao);
    }
}