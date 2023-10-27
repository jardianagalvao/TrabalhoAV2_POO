package q5_JardianaGalvao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class Adivinhacao {

	private int numeroAleatorio;
	private int tentativasRestantes = 5;

	public Adivinhacao() {
		JFrame frame = new JFrame("Jogo de Adivinhação POO");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();

		numeroAleatorio = new Random().nextInt(20) + 1;

		for (int i = 1; i <= 20; i++) {
			JButton button = new JButton(Integer.toString(i));
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int escolhaUsuario = Integer.parseInt(e.getActionCommand());
					verificarAdivinhacao(escolhaUsuario);
				}
			});
			panel.add(button);
		}

		JTextField tentativasField = new JTextField("Tentativas total: " + tentativasRestantes);
		tentativasField.setEditable(false);

		panel.add(tentativasField);
		frame.add(panel);

		frame.setSize(550, 200);
		frame.setVisible(true);
	}

	private void verificarAdivinhacao(int escolhaUsuario) {
		if (tentativasRestantes > 0) {
			if (escolhaUsuario == numeroAleatorio) {
				JOptionPane.showMessageDialog(null, "Parabéns! Você acertou o número.");
				reiniciarJogo();
			} else {
				tentativasRestantes--;
				if (tentativasRestantes > 0) {
					JOptionPane.showMessageDialog(null,
							"Tente novamente. Tentativas restantes: " + tentativasRestantes);
				} else {
					JOptionPane.showMessageDialog(null, "Suas tentativas acabaram. O número era: " + numeroAleatorio);
					reiniciarJogo();
				}
			}
		}
	}

	private void reiniciarJogo() {
		numeroAleatorio = new Random().nextInt(20) + 1;
		tentativasRestantes = 5;
	}

	public static void main(String[] args) {
		new Adivinhacao();
	}
}
