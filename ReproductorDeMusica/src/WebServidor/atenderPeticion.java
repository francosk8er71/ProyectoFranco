package WebServidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;
import BD.GestorBD;

public class atenderPeticion implements Runnable{
//	Scanner scn = new Scanner(System.in);
	private Socket socketCliente;
	private DataInputStream in;
	private DataOutputStream out;
	private String nombre;
	private boolean conectado;
	private GestorBD gestor;
	
	static Vector<atenderPeticion> ar = new Vector<>();

	public atenderPeticion(Socket socketCliente, String nombre){
		gestor = new GestorBD();
		this.socketCliente = socketCliente;
		this.nombre = nombre;
		this.conectado = true;
		ar.add(this);
		try {
  			in = new DataInputStream(socketCliente.getInputStream());
  			out = new DataOutputStream(socketCliente.getOutputStream());		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void run() {
		String mensajeRecibido;
		while(true){
			try{
				mensajeRecibido = in.readUTF();
				String []parts = mensajeRecibido.split("-");
				if(parts[0].equals("CONNECT")){
					inicarSesion(parts);
				}else{
					System.out.println(mensajeRecibido);
					if(mensajeRecibido.equals("salir")){
						this.conectado = false;
						this.socketCliente.close();
						System.out.println(this.nombre + "se desconecto");
						break;
					}
					
					StringTokenizer st = new StringTokenizer(mensajeRecibido, "#");
					String mensajeAEnviar = st.nextToken();
					String recipiente = st.nextToken();
					
					for(atenderPeticion mc : ar){
						System.out.println(mc.nombre);
						if(mc.nombre.equals(recipiente)  && mc.conectado==true){
							mc.out.writeUTF(this.nombre + " : " + mensajeAEnviar);
							out.flush();
							break;
						}
					}
				}

			}catch(IOException e){
				e.printStackTrace();
			}
		}
		try {
			this.in.close();
			this.out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	private void inicarSesion(String []parts){
		try {

			String usuario = parts[1];
			String contrasena = parts[2]; 
			
			System.out.println(usuario);
			System.out.println(contrasena);
			
	        if(gestor.existeUsuario(usuario, contrasena)){
	        	System.out.println(usuario);
					out.writeUTF("OK");
	        }
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
