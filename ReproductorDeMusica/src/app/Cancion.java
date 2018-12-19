package app;

public class Cancion {
	private int idCancion;
	private String nombreCancion;
	private String artista;
	private String album;
	private int duracion;
	private String anoPublicacion;
	
	public Cancion(int idCancion, String nombreCancion, String artista, String album, int duracion, String anoPublicacion){
		this.idCancion = idCancion;
		this.nombreCancion = nombreCancion;
		this.artista = artista;
		this.album = album;
		this.duracion = duracion;
		this.anoPublicacion = anoPublicacion;
	}

	public int getIdCancion() {
		return idCancion;
	}

	public void setIdCancion(int idCancion) {
		this.idCancion = idCancion;
	}

	public String getNombreCancion() {
		return nombreCancion;
	}

	public void setNombreCancion(String nombreCancion) {
		this.nombreCancion = nombreCancion;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getAnoPublicacion() {
		return anoPublicacion;
	}

	public void setAnoPublicacion(String anoPublicacion) {
		this.anoPublicacion = anoPublicacion;
	}
}
