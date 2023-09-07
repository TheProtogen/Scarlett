package box;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

//Programa que pega um input, e tenta executar como se fosse no prompt de comando;
//O programa então lê o output, e mostra ao usuário;
//A variável "commandList" pode ser alterada para outros comandos;
//Dependendo do SO, os comandos podem ser diferentes.

public class RuntimeCommand {
	public static void main(String[] args) {
		String commandList = "";

		//Verifica o sistema operacional, e atribui o comando correto para a variável.
		if(os().contains("Windows")) {
			commandList = "TASKLIST /FO TABLE";
		} else if (os().contains("Linux")) {
			commandList = " ps -ef";
		}
		
		//Programa vai tentar executar o código no prompt de comando.
		try {
			//exec() irá executar o comando/string que atribuimos na variável.
			Process p = Runtime.getRuntime().exec(commandList);
			
			//Se der certo, o programa vai pegar o output e colocar num BufferedReader.
			InputStream pInput = p.getInputStream();
			InputStreamReader pReader = new InputStreamReader(pInput);
			BufferedReader pBuffer = new BufferedReader(pReader);
			
			//Leitura do reader.
			String pLinha = pBuffer.readLine();
			while (pLinha != null) {
				System.out.println(pLinha);
				pLinha = pBuffer.readLine();
			}
		//Caso algo dê errado...	
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	//Método para descobrir o SO.
	public static String os() {
		return System.getProperty("os.name");
	}
}
