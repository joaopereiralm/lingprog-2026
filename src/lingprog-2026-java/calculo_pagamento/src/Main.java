import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int oppagamento;
        String nome;
        double pagamento;
        double valorproduto;
        String op;

        System.out.println("Digite seu nome: ");
        nome = sc.next();
        System.out.println("Valor do produto: R$");
        valorproduto = sc.nextDouble();

        do{
            System.out.println("\n----------");
            System.out.println("Pagamento:");
            System.out.println("----------");
            System.out.println("1 - Á vista.");
            System.out.println("2 - Parcelado no cartão (Até 5x sem juros)");
            System.out.println("3 - Crediário na loja");
            oppagamento = sc.nextInt();

            switch (oppagamento){
                case 1:
                    double avista = valorproduto - valorproduto * 0.15;
                    System.out.println("Valor com 15% de desconto: R$" + avista);
                    break;
                case 2:
                    System.out.println("Até quantos deseja parcelar (Até 5x): ");
                    int parcelas = sc.nextInt();
                    for (int i = 1; i <= parcelas; i++){
                        float valorparcelas = (float) valorproduto / parcelas;
                        System.out.println("Valor da " + i + "° Parcela: R$" + valorparcelas);
                    }
                    break;
                case 3:
                    System.out.println("2% ao mês de juros, 10 parcelas de: R$" + (valorproduto * 1.20) / 10);
                    break;
                default:
                    System.out.println("Opção inválida");
            }
            System.out.println("\nDeseja outra opção de pagamento?");
            System.out.println("S = Sim / N = Não");
            op = sc.next();
        }while(op.equalsIgnoreCase("s") || op.equalsIgnoreCase("Sim"));
    }
}