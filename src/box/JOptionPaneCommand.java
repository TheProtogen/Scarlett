package box;

import javax.swing.JOptionPane;

public class JOptionPaneCommand {
	
	public int PaneOpcao() {
		//Define um vetor que pode ser extendido com mais strings
		//String[2]        (    0          1          2    )
		String[] escolha = {"Opção 1", "Opção 2", "Opção 3"};
		
		//Usa as strings para fornecer opções ao usuário, convertendo para inteiro.
		//Valor já é tratado na declaração do int para ficar mais fácil.
		int escolhaPane = JOptionPane.showOptionDialog(null, "Escolha:",
				"Guhh?", JOptionPane.INFORMATION_MESSAGE, 
				JOptionPane.CANCEL_OPTION , null, escolha, escolha[0]);
		
		// -1 é quando o usuário clicou em cancela (no X).
		// 0 - 1 - 2 é o valor escolhido caso ele não cancele.
		System.out.println(escolhaPane);
		return escolhaPane;
	}

	
	//Em construção
}
