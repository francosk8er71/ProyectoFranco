package app;

public class ListasUsuarios {
	private int idLista;
	private String idUsuario;
	private String nombreLista;
	
	public ListasUsuarios(int idLista, String idUsuario, String nombreLista){
		this.idLista = idLista;
		this.idUsuario = idUsuario;
		this.nombreLista = nombreLista;
	}

	public int getIdLista() {
		return idLista;
	}

	public void setIdLista(int idLista) {
		this.idLista = idLista;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreLista() {
		return nombreLista;
	}

	public void setNombreLista(String nombreLista) {
		this.nombreLista = nombreLista;
	}
}
