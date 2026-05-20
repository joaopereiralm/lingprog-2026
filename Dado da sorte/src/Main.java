import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String resp;


        System.out.println("---------------------");
        System.out.println(" DADO DA SORTE  ");
        System.out.println("---------------------");

            System.out.println("Girar dado?");
            System.out.println("Sim ou Não: ");
            String op = sc.next();

            do{
            switch (op.toLowerCase()){
                case "sim":
                    System.out.println("Quantas vezes o dado deve ser lançado? : ");
                    int quantidade = sc.nextInt();
                    System.out.println("Qual dado deseja acertar? (1-6) : ");
                    int num = sc.nextInt();

                    if (num < 1 && num > 6){
                        System.out.println("Opção invalida, tente novamente");
                        break;
                    }

                    int acerto = 0;

                    for (int i = 1; i <= quantidade; i++) {
                        float dado = (float) Math.random() * 6 + 1;
                        System.out.println("Número sorteado: " + (int) dado);

                        if ((int)dado == num) {
                            acerto++;
                        }
                    }
                    System.out.println("\nQuantidade de acerto: " + acerto);

                    System.out.println("% De acertos: " + (acerto * 100 / quantidade) + "%");
                    break;
                case "nao":
                    System.out.println("Programa finalizado");
                    break;
            }
            System.out.println("\n============================");
            System.out.println("\nGirar dado novamente?");
            System.out.println("Sim ou Não: ");
            resp = sc.next();
        } while (resp.equalsIgnoreCase("sim"));
    }
}