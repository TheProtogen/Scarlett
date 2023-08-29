package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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
		String ip = "ipconfig";
		
		
		try {
			Process p = Runtime.getRuntime().exec(ip);
			InputStream pInput = p.getInputStream();
			InputStreamReader pReader = new InputStreamReader(pInput);
			BufferedReader pBuffer = new BufferedReader(pReader);
			
			String pLinha = pBuffer.readLine();
			while (pLinha != null) {
				
				if (pLinha.contains("IPv4")) {
					System.out.println(pLinha);
				}
				
				pLinha = pBuffer.readLine();
			}
			
		} catch (IOException e) {
			
			System.err.println(e);
		}
		
		return null;
	}
	
}
