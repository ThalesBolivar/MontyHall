import javax.swing.*;
import java.util.Random;

public class MontyHallGUI extends JFrame {
    private JPanel panel;
    private JButton playButton;

    public MontyHallGUI() {
        setTitle("Jogo Monty Hall");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        playButton = new JButton("Jogar");
        playButton.addActionListener(e -> startGame());

        panel.add(playButton);
        add(panel);

        setVisible(true);
    }

    private void startGame() {
        Random random = new Random();
        int portaPremiada = random.nextInt(3) + 1;
        int portaEscolhida;
        String input;

        do {
            input = JOptionPane.showInputDialog(null, "Escolha uma porta (1, 2 ou 3):");
            portaEscolhida = Integer.parseInt(input);
        } while (portaEscolhida < 1 || portaEscolhida > 3);

        int portaVazia;
        do {
            portaVazia = random.nextInt(3) + 1;
        } while (portaVazia == portaPremiada || portaVazia == portaEscolhida);

        JOptionPane.showMessageDialog(null, "O apresentador abriu a porta " + portaVazia + " que está vazia.");

        input = JOptionPane.showInputDialog(null, "Você deseja trocar para a outra porta? (s/n):");
        switch (input.toLowerCase()) {
            case "s":
                if (portaEscolhida == portaPremiada) {
                    JOptionPane.showMessageDialog(null, "Você perdeu. A porta premiada era a " + portaPremiada + ".");
                } else {
                    JOptionPane.showMessageDialog(null, "Parabéns! Você ganhou! A porta premiada era a " + portaPremiada + ".");
                }
                break;
            case "n":
                if (portaEscolhida == portaPremiada) {
                    JOptionPane.showMessageDialog(null, "Parabéns! Você ganhou! A porta premiada era a " + portaPremiada + ".");
                } else {
                    JOptionPane.showMessageDialog(null, "Você perdeu. A porta premiada era a " + portaPremiada + ".");
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida. Por favor, responda com 's' ou 'n'.");
        }
    }

    public static void main(String[] args) {
        new MontyHallGUI();
    }
}
