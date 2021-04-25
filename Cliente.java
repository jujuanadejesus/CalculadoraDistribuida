package Cliente;

import java.net.*;
import java.io.*;

public class Cliente extends Thread {
	

	
	private static boolean fim = false;
	public static void main(String args[]) {
		try {						
							
				Socket connect = new Socket("127.0.0.1", 12345);		
				Thread x = new Cliente(connect);
			
				PrintStream out = new PrintStream(connect.getOutputStream());
				BufferedReader input = new BufferedReader(new InputStreamReader(connect.getInputStream()));		
				BufferedReader LerTeclado = new BufferedReader(new InputStreamReader(System.in));
				x.start();			
									
			String line;
			Double auxiliar;
			while (true) {
				
				System.out.println(" ");				
				System.out.println("Digite o número da operação desejada ");
				System.out.println(" [1] Subtracao ");
				System.out.println(" [2] Adicao ");
				System.out.println(" [3] Divisao");
				System.out.println(" [4] Multiplicacao");
				System.out.println(" [5] Porcentagem");	
				System.out.println(" [6] Potencia");
				System.out.println(" [7] Raiz Quadrada");
				System.out.println(" [0] Encerrar");
				System.out.print(" -> ");
				line = LerTeclado.readLine();
				
				try{				    			
					if(Integer.parseInt(line) > 8){
						System.out.println("Opcao Invalida!");	
						continue;
					}
				
				
				}catch (Exception e){
					System.out.println("Opcao Invalida!");	
					continue;
				}
				out.println(line);
				
				if(Integer.parseInt(line) >= 1 && Integer.parseInt(line) <= 4 ){
					System.out.print("Digite o primeiro numero: ");
					line = LerTeclado.readLine();
					try{ auxiliar = Double.parseDouble(line);}catch(Exception e){System.out.println("Numero Invalido!");continue;}
					out.println(line);
					System.out.print("Digite o segundo numero: ");
					line = LerTeclado.readLine();
					try{ auxiliar = Double.parseDouble(line);}catch(Exception e){System.out.println("Numero Invalido!");continue;}
					out.println(line);
				}else if( Integer.parseInt(line) == 5){
					System.out.print("Digite o numero: ");
					line = LerTeclado.readLine();
					out.println(line);
					System.out.print("Digite o percentual: ");
					line = LerTeclado.readLine();
					out.println(line);					
				}else if(Integer.parseInt(line) == 6){
					System.out.print("Digite o numero: ");
					line = LerTeclado.readLine();
					out.println(line);
					System.out.print("Digite o expoente: ");
					line = LerTeclado.readLine();
					out.println(line);					
				}else if(Integer.parseInt(line) == 0){
					connect.close();
					fim = true;
					break;
				}else{
					System.out.print("Digite o numero: ");
					line = LerTeclado.readLine();
					out.println(line);					
					line = "2";
					out.println(line);
				}

				line = input.readLine();
				System.out.println("Resultado: " + line);

			}
		}
		catch (IOException e) {

			System.out.println("Servidor Indisponivel");			
			
		}
		
	}

	private Socket conect;


	public Cliente(Socket s) {
		conect = s;
	}
		
	

	public void run() {	}
}
