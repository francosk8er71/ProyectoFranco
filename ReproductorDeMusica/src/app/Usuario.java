package app;

public class Usuario {
	private String nombreUsuario;
	private String contraseña;
	private String nombre;
	private String apellidos;
	private String email;
	private String conectado;
	
	
	public Usuario(){
		this.nombreUsuario = null;
		this.contraseña = null;
		this.nombre = null;
		this.apellidos = null;
		this.email = null;
		this.conectado = null;
	}
	public Usuario(String nombreUsuario, String contraseña, String nombre, String apellidos, String email, String conectado){
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.conectado = conectado;
	}


	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario){
		this.nombreUsuario = nombreUsuario;
	}

	public String getContraseña(){
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String isConectado() {
		return conectado;
	}

	public void setConectado(String conectado) {
		this.conectado = conectado;
	}
	
	public String toString(){
		return "Nombre Usuario: " + this.nombreUsuario + "\r\n" 
			 + "Contraseña: " + this.getContraseña() + "\r\n"
			 + "Nombre: " + this.getNombre();
	}
}
