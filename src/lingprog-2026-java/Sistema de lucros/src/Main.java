import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int op = 0;

        System.out.println("\n--------------------------");
        System.out.println("    Sistema de lucro    ");
        System.out.println("--------------------------");
        while (op != 2){
            System.out.println("\n1 - Efetuar cálculo de lucro");
            System.out.println("2 - Encerrar programa");

            op = sc.nextInt();

            switch (op){
                case 1:
                    System.out.print("Quantas camisetas foram feitas? R:");
                    int camiseta = sc.nextInt();

                    double valorc = 35.0;
                    double valortotal = valorc * camiseta;
                    double x = 15 * camiseta + 200;

                    System.out.print("\n--------------------------");
                    System.out.print("      Relatório       ");
                    System.out.print("--------------------------");
                    System.out.println("\nValor das camisetas a serem vendidas: R$" + valortotal);

                    //double a = -0.5;
                    //double b = 40;
                    //double c = -500;

                    // double quantidade_ideal = -b / (2 * a);
                    //double lucro_max = a*(quantidade_ideal * quantidade_ideal)  + b * quantidade_ideal - c;


                    if (x>valortotal){
                        System.out.println("Prejuízo");
                        // System.out.println ("Quantidade ideal a ser vendida, para max o lucro: " + int quantidade_ideal - camiseta);
                    }
                    else if (x<valortotal){
                        System.out.println("Lucro");
                    }
                    else{
                        System.out.println("Empate");
                    }
                    System.out.println("Valor total do custo: R$" + x);
                case 2 :
                    System.out.println("Programa encerrado");
            }
        }
    }
}