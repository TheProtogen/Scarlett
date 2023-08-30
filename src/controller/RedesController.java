package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

import view.Main;

public class RedesController {

	//Método privado que pega a property do sistema, no caso, o nome da SO.
	private String os(){
		String osName = System.getProperty("os.name");
		return osName;
	}
	
	//Tive que criar essa public, já que não consigo chamar a private pelo main.
	public String getOs() {
		return os();
	}
	
	
	
	public String ip() {
		
		String osName = getOs();
		
		String ip = "";
		
		if (osName.contains("Windows")) {
			ip = "ipconfig";
		} else if (osName.contains("Linux")){
			ip = "ifconfig";
		}
		
		String ipv4Result = "";
		
		try {
			Process p = Runtime.getRuntime().exec(ip);
			InputStream pInput = p.getInputStream();
			InputStreamReader pReader = new InputStreamReader(pInput);
			BufferedReader pBuffer = new BufferedReader(pReader);
			
			String pLinha = pBuffer.readLine();
			while (pLinha != null) {
				
				if (pLinha.contains("IPv4")) {
					ipv4Result = ipv4Result.concat(pLinha+"\n");
				}
				
				pLinha = pBuffer.readLine();
			}
			JOptionPane.showMessageDialog(null, ipv4Result);
			
		} catch (IOException e) {
			
			System.err.println(e);
		}
		
		return null;
	}
	
	public String ping() {
		
		String osName = getOs();
		
		String ping = "";
		
		if (osName.contains("Windows")) {
			ping = "ping -4 -n 10 www.google.com.br";
		} else if (osName.contains("Linux")) {
			ping = "ping -4 -c 10 www.google.com.br";
		}
		
		String pingResult = "";
		
		try {
			Process p = Runtime.getRuntime().exec(ping);
			InputStream pInput = p.getInputStream();
			InputStreamReader pReader = new InputStreamReader(pInput);
			BufferedReader pBuffer = new BufferedReader(pReader);
			
			String pLinha = pBuffer.readLine();
			while (pLinha != null) {
				
				if (pLinha.contains("nimo")) {
					//Foi o único jeito que achei para funcionar, já que as letras "í, á, é" não aparecem
					pingResult = pLinha;
				}
				
				pLinha = pBuffer.readLine();
			}
			JOptionPane.showMessageDialog(null, pingResult);
			
		} catch (IOException e) {
			
			System.err.println(e);
		}
		
		return null;
	}
	
}
