package WebServidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import interfazGrafica.ventanaChat;


public class Cliente{

	private static Socket socketCliente;
	protected static DataInputStream in;
	protected  static DataOutputStream out;
	public static void main(String []args){
		ExecutorService pool = Executors.newFixedThreadPool(3);
		//ventanaChat ventana = new ventanaChat();
		try {
			socketCliente = new Socket ("localhost", 6000);
			out = new DataOutputStream(socketCliente.getOutputStream());
		    in = new DataInputStream(socketCliente.getInputStream());
		    String usu;
			usu = iniciarSesion();
			
            out.writeUTF(usu);
            
            String ok = in.readUTF();
            System.out.println(ok);
            if(ok.equals("OK")){
    			pool.execute(new ChatEscucha(socketCliente));
    			pool.execute(new ChatHabla(socketCliente));
            }else{
                socketCliente.close();
            }

			

		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
//	private List<String> registrarNuevoUsuario(){
//		Scanner scn = new Scanner(System.in);
//		String nombreUsuario = null;
//		String contrasena = null;
//		String nombre = null; 
//		String apellido = null;
//		String email = null;
//		List<String> usu = new ArrayList<>();
//		
//		System.out.println("              CREANDO NUEVO USUARIO");
//		System.out.println("------------------------------------------------------");
//		System.out.print("Nombre de Usuario: ");
//		nombreUsuario = scn.nextLine();
//		usu.add(nombreUsuario);
//		System.out.print("Contraseña: ");
//		contrasena = scn.nextLine();
//		usu.add(contrasena);
//		System.out.print("Nombre: ");
//		nombre = scn.nextLine();
//		usu.add(nombre);
//		System.out.print("Apellido: ");
//		apellido = scn.nextLine();
//		usu.add(apellido);
//		System.out.print("Email: ");
//		email = scn.nextLine();
//		usu.add(email);
//		
//		return usu;
//	}
	
	
	private static String iniciarSesion(){
		Scanner scn = new Scanner(System.in);
		
		System.out.print("Usuario: ");
		String usuario = scn.nextLine();
		
		System.out.println("Constraseña: ");
		String contrasena = scn.nextLine();
		
		return "CONNECT" + "-"  + usuario + "-" +contrasena;
	}
}