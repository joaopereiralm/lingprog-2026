import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            //incialização
            System.out.println("\n==========================");
            System.out.println("      MENU PRINCIPAL      ");
            System.out.println("==========================");
            System.out.println("1. Calcular Nova Conta");
            System.out.println("0. Sair do Programa");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();

            if (opcao == 1) {
                System.out.println("\nNome: ");
                String nome = sc.next();
                System.out.println("Consumo anterior em kWh: ");
                float kwha = sc.nextFloat();
                System.out.println("Consumo atual em kWh: ");
                float kwhb = sc.nextFloat();

                double somak = kwha + kwhb;
                double somavalor = somak * 0.68;

                //total dos valores
                System.out.println("Total kWh: " + somak);
                System.out.println("Total de valor: R$" + somavalor);

                String classf = "";

                if (somak <= 100) {
                    classf = "Bandeira Verde";
                    somavalor += somavalor;
                } else if (somak >= 101 && somak <= 200) {
                    classf = "Bandeira Amarela";
                    somavalor += 2.0;
                } else if (somak >= 201 && somak <= 300) {
                    classf = "Bandeira Vermelha";
                    somavalor += 5.0;
                } else{
                    classf = "Bandeira Preta";
                    somavalor += 10.0;
                }

                //Resultado
                System.out.println("\nNome: " + nome);
                System.out.printf("Consumo total (Com acréscimo): R$%.2f%n", somavalor);
                System.out.println("Consumo total de kWh: " + somak);
                System.out.println(classf);
            } else if (opcao == 0) {
                System.out.println("\n==========================");
                System.out.println("      PROGRAMA ENCERRADO      ");
                System.out.println("============================");
            } else{
                System.out.println("Opção inválida");
            }
        } while (opcao != 0);
    }
}