import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n==========================");
        System.out.println(" JAVA LANCHES ");
        System.out.println("==========================");

            System.out.println("101 - Cachorro Quente (R$10,00)");
            System.out.println("102 - X-Burger (R$15,00");
            System.out.println("103 - X-Salada (R$12,00");
            System.out.println("Escolha: ");
            int op = sc.nextInt();
            System.out.println("Idade: ");
            int id = sc.nextInt();

            String lanche = "";

            double preco = 0;

            switch (op) {
                case 101:
                    lanche = "Sua escolha: 101 - Cachorro Quente";
                    preco = 10.00;
                    break;
                case 102:
                    lanche = "Sua escolha: 102 - X-Burger";
                    preco = 15.00;
                    break;
                case 103:
                    lanche = "Sua escolha: 103 - X-Salada";
                    preco = 12.00;
                    break;
                default:
                    System.out.println("Código inválido (Erro)");
                    return;
            }
            double precofinal = preco;

            if (id < 12) {
                System.out.println("Desconto de 50% Aplicado");
                precofinal = preco * 0.5;
            } else if (id >= 12 && id <= 60) {
                System.out.println("Não possui desconto");
            } else {
                System.out.println("Desconto de 30% Aplicado");
                precofinal = preco / 0.3;
            }
            //total
            System.out.println("\n--- RESUMO DO PEDIDO ---");
            System.out.println("Pedido: " + lanche);
            System.out.printf("Valor total: R$%.2f%n", precofinal);
    }
}