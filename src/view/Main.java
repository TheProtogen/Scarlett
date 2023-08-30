package view;

import javax.swing.JOptionPane;

import controller.RedesController;

//Para fazer:
// - Colocar mais comentários;
// - Erm, saber como fazer esses caractéres "corrompidos" voltarem ao normal;
// - Um pouco de design talvez?

public class Main {

	public static void main(String[] args) {
		RedesController RC = new RedesController();
		
		//Chama o método e coloca numa String
		
		String[] escolha = {"Verificar SO", "Chamar IP", "Chamar Ping", "Sair"};
		
		int escolhaPane = JOptionPane.showOptionDialog(null, "Escolha:",
				"Beep Boop", JOptionPane.INFORMATION_MESSAGE, 
				JOptionPane.CANCEL_OPTION , null, escolha, escolha[0]) + 1;
		
		while (escolhaPane != 4 && escolhaPane != 0) {
		  
			switch(escolhaPane) {
			case 1:
				String osName = RC.getOs();
				JOptionPane.showMessageDialog(null, osName);
				break;
			case 2:
				RC.ip();
				break;
			case 3:
				RC.ping();
				break;
			case 4:
				break;
			}
			
			
			escolhaPane = JOptionPane.showOptionDialog(null, "Escolha:",
					"Guhh?", JOptionPane.INFORMATION_MESSAGE, 
					JOptionPane.CANCEL_OPTION , null, escolha, escolha[0]) + 1;
			
		}
		
	}

}
