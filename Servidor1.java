package Servidor1;

import java.net.*;
import java.io.*;
import java.util.*;

public class Servidor1 extends Thread  {

  private static List<String> ServerOpBasica = new ArrayList<String>();
  private static List<String> ServerOpEsp = new ArrayList<String>();


  private Integer OpAux = 0;
  private Integer EspAux = 0;
  
  public static void main(String args[]) {
		ServerOpBasica.add("127.0.0.1"); 
		
		ServerOpEsp.add("127.0.0.1");

		try {
			System.out.println("Servidor Iniciado!");
			ServerSocket s = new ServerSocket(12345);
			while (true) {				

				Socket connect = s.accept();
				System.out.println("Conexão Nova!");

				Thread x = new Servidor(connect);
				x.start();
			}
		}
		catch (IOException e) {

			System.out.println("IOException: " + e);
		}
	}

	private Socket connection;	
	private Socket connections;	

	public Servidor1(Socket s) {
            connection = s;
	}
	private Servidor1(Socket s, Boolean a){
		connections = s;
	}
	public String op1;
	public String op2;
	public String opcao;
	public String teste = "teste";
	public Integer Search = 0;
	
	

	public void run() {
		try {		  
		
			  System.out.println("Cliente Conectado");
			BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			PrintStream out = new PrintStream(connection.getOutputStream());
			op1 = null;
			op2 = null;
			opcao = null;
			

			String line = "x";
			
			
			while (true && line != null) {
				
				try{
					line = input.readLine();
				}catch (IOException e){
					connection.close();
					break;
				}

				System.out.println(".> " + line);
				
				if(op1 != null && op2 == null)
					op2 = line;				
				if(op1 == null && opcao != null)
					op1 = line;
				if(op1 == null && op2 == null) {
					opcao = line;
					try{
						if(Integer.parseInt(opcao) == 0 || Integer.parseInt(opcao) > 7){
							op1 = "0"; 
							op2="0";
							}
					}catch (Exception e){

						connection.close();
						break;
					}									
				}
				

				if(op1 != null && op2 != null && opcao != null){
					if(Integer.parseInt(opcao) >= 1 && Integer.parseInt(opcao) <= 4){
						try {
							Socket connections = new Socket(ServerOpBasica.get(OpAux),12347);
							
							BufferedReader inpuTs = new BufferedReader(new	InputStreamReader(connections.getInputStream()));						
							PrintStream outs = new PrintStream(connections.getOutputStream());
							System.out.println("Conexao Servidor("+Integer.toString(OpAux) +") Escravo Tipo A..."  );
							OpAux++;													
							if(OpAux > ServerOpBasica.size() - 1) OpAux = 0;
															
							outs.println(opcao);
							outs.println(op1);
							outs.println(op2);
							line = inpuTs.readLine();	
							System.out.println("Return: " + line);
							out.println(line);
							connections.close();
							op1 = null;
							op2 = null;
							opcao = null;
							System.out.println("Conexao Encerrada!");
							
						}catch (IOException e){
							   connections = null;
							if(connections == null){ 								
								while (connections == null){
									System.out.println("ERROR: Conexao Servidor("+Integer.toString(OpAux)+") Inexistente.");							
									OpAux++;
									if(OpAux > (ServerOpBasica.size() - 1)){OpAux = 0;	}

									try{
										Search++;										
										connections = new Socket(ServerOpBasica.get(OpAux),12347);	
										
									}catch (IOException j){										
										if(Search == ServerOpBasica.size()){
											Search = 0;
											out.println("ERROR: Todos Servidores Indisponiveis!");
											op1 = null;
											op2 = null;
											opcao = null;
											connections = null;
											break;
										}
									}									
								}
							}
							if(opcao == null){continue;}
							
							BufferedReader entradaS = new BufferedReader(new	InputStreamReader(connections.getInputStream()));						
							PrintStream saidaS = new PrintStream(connections.getOutputStream());
							System.out.println("Conexao Servidor("+Integer.toString(OpAux) +") Escravo Tipo A..."  );

							OpAux++;													
							if(OpAux > ServerOpBasica.size() - 1) OpAux = 0;
															

							saidaS.println(opcao);
							saidaS.println(op1);
							saidaS.println(op2);
							line = entradaS.readLine();	
							System.out.println("Retorno: " + line);
							out.println(line);
							connections.close();
							op1 = null;
							op2 = null;
							opcao = null;
							System.out.println("Conexao Encerrada!");	
							
						}	
												
					}else if(Integer.parseInt(opcao) >=1 & Integer.parseInt(opcao) < 8){
						
						try {

							Socket connects = new Socket(ServerOpEsp.get(EspAux),12348);
							
							BufferedReader inputS = new BufferedReader(new	InputStreamReader(connects.getInputStream()));						
							PrintStream outs = new PrintStream(connects.getOutputStream());
							System.out.println("Conexao Servidor("+Integer.toString(EspAux) +") Escravo Tipo B..."  );
							EspAux++;													
							if(EspAux > ServerOpEsp.size() - 1) EspAux = 0;
															

							outs.println(opcao);
							outs.println(op1);
							outs.println(op2);
							line = inputS.readLine();	
							System.out.println("Retorno: " + line);
							out.println(line);
							connects.close();
							op1 = null;
							op2 = null;
							opcao = null;
							System.out.println("Conexao Com Servidor Encerrada!");
							
						}catch (IOException e){

							connections = null;
							if(connections == null){ 								
								while (connections == null){
									System.out.println("ERROR: Conexao Servidor("+Integer.toString(OpAux)+") Inexistente.");							
									EspAux++;
									if(EspAux > (ServerOpEsp.size() - 1)){EspAux = 0;	}

									try{
										Search++;										
										connections = new Socket(ServerOpEsp.get(EspAux),12348);	
										
									}catch (IOException j){										
										if(Search == ServerOpEsp.size()){
											Search = 0;
											out.println("ERROR: Indisponivel!");
											op1 = null;
											op2 = null;
											opcao = null;
											connections = null;
											break;
										}
									}									
								}
							}
							if(opcao == null){continue;}
							
							BufferedReader inpuTs = new BufferedReader(new	InputStreamReader(connections.getInputStream()));						
							PrintStream outs = new PrintStream(connections.getOutputStream());
							System.out.println("Conexao Servidor("+Integer.toString(EspAux) +") Escravo Tipo A..."  );

							EspAux++;													
							if(EspAux > ServerOpEsp.size() - 1) EspAux = 0;
															

							outs.println(opcao);
							outs.println(op1);
							outs.println(op2);
							line = inpuTs.readLine();	
							System.out.println("return: " + line);
							out.println(line);
							connections.close();
							op1 = null;
							op2 = null;
							opcao = null;
							System.out.println("Conexao Encerrada!");	
							
						}	

							
					}else if(Integer.parseInt(opcao) == 0){

						connection.close();
					}else{
						System.out.println("Opcao Invalida!");
						op1 = null;
						op2 = null;
						opcao = null;
					}
				}
			}
			
		System.out.println("Conexao Encerrada!");			  

		}
		catch (IOException e) {
			
			System.out.println("IOException: " + e);
		}
	}

}
