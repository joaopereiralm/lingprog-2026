import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String op;
        do {
            System.out.println("-----------");
            System.out.println(" Vetores ");
            System.out.println("-----------");
            System.out.println("Deseja calcular notas?");
            System.out.println("S = Sim / N = Não");
            op = sc.next();

            float [] nota = new float [5];
            float soma = 0;

            switch (op){
                case "s":
                case "sim":
                    for (int i = 0; i<5; i++){
                        System.out.println(i + 1 + "° nota: ");
                        nota [i] = sc.nextFloat();
                        soma += nota[i];
                    }

                    System.out.println("");

                    for (int i = 0; i<5; i++){
                        System.out.println("Posição do vetor: " + i + " é: " + (int) nota[i]);
                    }

                    System.out.println("\nMédia dos vetores: " + soma/5);
                    break;

                case "n":
                case "nao":
                    System.out.println("Programa encerrado.");
                    break;

                default:
                    System.out.println("Valor inválido // Programa encerrado.");
                    break;
            }

        }while(op.equalsIgnoreCase("s") || op.equalsIgnoreCase("sim"));

    }
}