package WebServidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import interfazGrafica.ventanaServidor;

public class Servidor {
	private ServerSocket socket;
	private int numClientes;
	
	public Servidor(){
		ExecutorService pool = Executors.newFixedThreadPool(30);
		numClientes = 0;
		try {
			this.socket = new ServerSocket(6000);
			ventanaServidor ventana = new ventanaServidor(this);
			ventana.mostrarInterfaz();
			System.out.println("Servidor comenzado");
			while(true){
				try{
					final Socket conexion = this.socket.accept();
					
					System.out.println("Nueva peticion de cliente recibido: " + conexion);
					System.out.println("Creando un manejador para este nuevo cliente...");
					System.out.println("Añadiendo cliente a lista de clientes activa...");
					pool.execute( new atenderPeticion(conexion, "Cliente " + numClientes));
					numClientes++;
					ventana.setNumClientes(getNumClientes());
					System.out.println("Cliente " + getNumClientes() + " conectado");
				}catch (IOException e){
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pool.shutdown();
	}
	
	public int getNumClientes(){
		return this.numClientes;
	}

//	public static void main(String []args){
//		ExecutorService pool = Executors.newFixedThreadPool(30);
//		numClientes = 0;
//		try {
//			socket = new ServerSocket(6000);
//			System.out.println("Servidor comenzado");
//			while(true){
//				try{
//					
//					final Socket conexion = socket.accept();
//					numClientes++;
//					System.out.println("Nueva peticion de cliente recibido: " + conexion);
//					System.out.println("Creando un manejador para este nuevo cliente...");
//					System.out.println("Añadiendo cliente a lista de clientes activa...");
//					pool.execute( new atenderPeticion(conexion, "Cliente " + numClientes));
//					
//					System.out.println("Cliente " + numClientes + " conectado");
//				}catch (IOException e){
//					e.printStackTrace();
//				}
//				
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		pool.shutdown();
//
//	}
}
