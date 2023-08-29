package view;

import javax.swing.JOptionPane;

import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		RedesController RC = new RedesController();
		
		//Chama o método e coloca numa String
		
		String[] escolha = {"Opção 1", "Opção 2", "Opção 3"};
		
		int escolhaPane = JOptionPane.showOptionDialog(null, "Escolha:",
				"Guhh?", JOptionPane.INFORMATION_MESSAGE, 
				JOptionPane.CANCEL_OPTION , null, escolha, escolha[0]) + 1;
		
		while (escolhaPane != 3 && escolhaPane != 0) {
		  
			switch(escolhaPane) {
			case 1:
				String osName = RC.getOs();
				JOptionPane.showMessageDialog(null, osName);
				break;
			case 2:
				RC.ip();
				break;
			case 3:
				break;
			}
			
			//bleh
			
			escolhaPane = JOptionPane.showOptionDialog(null, "Escolha:",
					"Guhh?", JOptionPane.INFORMATION_MESSAGE, 
					JOptionPane.CANCEL_OPTION , null, escolha, escolha[0]) + 1;
			
		}
		
	}

}
