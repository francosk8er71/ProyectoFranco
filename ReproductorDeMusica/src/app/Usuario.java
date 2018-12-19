package app;

public class Usuario {
	private String nombreUsuario;
	private String contrase�a;
	private String nombre;
	private String apellidos;
	private String email;
	private String conectado;
	
	
	public Usuario(){
		this.nombreUsuario = null;
		this.contrase�a = null;
		this.nombre = null;
		this.apellidos = null;
		this.email = null;
		this.conectado = null;
	}
	public Usuario(String nombreUsuario, String contrase�a, String nombre, String apellidos, String email, String conectado){
		this.nombreUsuario = nombreUsuario;
		this.contrase�a = contrase�a;
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

	public String getContrase�a(){
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
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
			 + "Contrase�a: " + this.getContrase�a() + "\r\n"
			 + "Nombre: " + this.getNombre();
	}
}
