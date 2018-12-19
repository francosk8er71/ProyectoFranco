package WebServidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ChatHabla implements Runnable{

	private Socket socketCliente;
	protected DataInputStream in;
	protected  DataOutputStream out;
	
	public ChatHabla(Socket socketCliente){
		this.socketCliente = socketCliente;
		try {
		    in = new DataInputStream(this.socketCliente.getInputStream());
		    out = new DataOutputStream(this.socketCliente.getOutputStream());
		}catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		public void run() {
			Scanner scn = new Scanner(System.in);
			while(true){
					String mensaje;
					try{
						mensaje = scn.nextLine();
						if(mensaje.equals("salir")){
							break;
						}
						out.writeUTF(mensaje);
					}catch(IOException e){
						e.printStackTrace();
						
					}
			}

			
		}
}