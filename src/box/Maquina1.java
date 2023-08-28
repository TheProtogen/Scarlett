package box;

import javax.swing.JOptionPane;

public class Maquina1 {

	public static void main(String[] args) {
		// Criado em: [27/08/2023]
		// Update em: ...
		
		String[] escolha = {"Opção 1", "Opção 2", "Opção 3"};
		
		//Usa as strings para fornecer opções ao usuário, convertendo para inteiro.
		//Valor já é tratado na declaração do int para ficar mais fácil.
		int escolhaPane = JOptionPane.showOptionDialog(null, "Escolha:",
				"Guhh?", JOptionPane.INFORMATION_MESSAGE, 
				JOptionPane.CANCEL_OPTION , null, escolha, escolha[0]) + 1;
		
		// 0 é quando o usuário clicou em cancela (no X).
		// 1 - 2 - 3 é o valor escolhido caso ele não cancele.
		System.out.println(escolhaPane);
		
	}

}
