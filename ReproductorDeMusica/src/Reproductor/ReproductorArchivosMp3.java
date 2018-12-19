package Reproductor;
import java.io.FileInputStream;
import javazoom.jl.player.Player;
import java.io.BufferedInputStream;

import javax.swing.JOptionPane;

public class ReproductorArchivosMp3 {


	private Player player;
	private FileInputStream archivoFIS;
	private BufferedInputStream bis;
	private boolean reanudarCancion;
	private String nombreCancion;
	private int tamanoArchivo;
	private int tamanoRestante;
	private boolean permiso;

	public ReproductorArchivosMp3(){
	    this.player = null;
	    this.archivoFIS = null;
	    this.permiso = false;
	    this.bis = null;
	    this.nombreCancion = null;
	    this.tamanoArchivo = 0;
	    this.tamanoRestante = 0;
	    this.reanudarCancion = false;
	}

	public boolean estadoCancion(){
	    return this.reanudarCancion;
	}

	public void setRutaCancion(String nombre){
	    this.nombreCancion = nombre;
	}

	public void pausar(){
	    try{
	    	tamanoRestante = archivoFIS.available();
	    	player.close();
	    	archivoFIS = null;
	    	bis = null;
	    	player = null;
	    	if(permiso) reanudarCancion = true;
	    }catch(Exception e){

	    }
	}

	public void reanudar(){
	    if(!reanudarCancion) return;
	    if(play(tamanoArchivo-tamanoRestante)) reanudarCancion = false;
	}

	public boolean play(int inicio){
		permiso = true;
	    reanudarCancion = false;
	    try{
	    	archivoFIS = new FileInputStream(this.nombreCancion);
	    	tamanoArchivo = archivoFIS.available();
	    	if(inicio > -1) archivoFIS.skip(inicio);
	    	bis = new BufferedInputStream(archivoFIS);
	    	player = new Player(bis);
	   		new Thread(
	   				new Runnable(){
	   					public void run(){
	   						try{
    							player.play();
	    					}catch(Exception e){
	    						JOptionPane.showMessageDialog(null, "Error playing mp3 file");
	    						permiso = false;
	    					}
	    			}
	       }
	    ).start();
	    }catch(Exception e){
	        JOptionPane.showMessageDialog(null, "Error playing mp3 file");
	        permiso = false;
	    }
	    return permiso;
	}

}

