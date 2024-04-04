import java.util.Scanner;
import java.util.Random;

public class MontyHall
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("*********************************");
        System.out.println("Bem-vindo ao jogo Monty Hall!");
        System.out.println("*********************************");

        int portaPremiada = random.nextInt(3) + 1;
        int portaEscolhida;

        do {
            System.out.println("Escolha uma porta (1, 2 ou 3):");
            portaEscolhida = scanner.nextInt();
        } while (portaEscolhida < 1 || portaEscolhida > 3);

        int portaVazia;
        do {
            portaVazia = random.nextInt(3) + 1;
        } while (portaVazia == portaPremiada || portaVazia == portaEscolhida);

        System.out.println("O apresentador abriu a porta " + portaVazia + " que está vazia.");

        System.out.println("Você deseja trocar para a outra porta? (s/n):");
        String trocarPorta = scanner.next();

        switch (trocarPorta.toLowerCase()) {
            case "s":
                if (portaEscolhida == portaPremiada) {
                    System.out.println("Você perdeu. A porta premiada era a " + portaPremiada + ".");
                } else {
                    System.out.println("Parabéns! Você ganhou! A porta premiada era a " + portaPremiada + ".");
                }
                break;
            case "n":
                if (portaEscolhida == portaPremiada) {
                    System.out.println("Parabéns! Você ganhou! A porta premiada era a " + portaPremiada + ".");
                } else {
                    System.out.println("Você perdeu. A porta premiada era a " + portaPremiada + ".");
                }
                break;
            default:
                System.out.println("Opção inválida. Por favor, responda com 's' ou 'n'.");
        }
    }
}
