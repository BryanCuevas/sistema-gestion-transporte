package models;

public class Ruta {
	private Integer idRuta;
	private String provincia;
	private String nombreRuta;
	private String latitudOrigen;
	private String longitudOrigen;
	private String latidudDestino;
	private String longitudDestino;
	
	public Integer getIdRuta() {
		return idRuta;
	}
	public void setIdRuta(Integer idRuta) {
		this.idRuta = idRuta;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getNombreRuta() {
		return nombreRuta;
	}
	public void setNombreRuta(String nombreRuta) {
		this.nombreRuta = nombreRuta;
	}
	public String getLatitudOrigen() {
		return latitudOrigen;
	}
	public void setLatitudOrigen(String latitudOrigen) {
		this.latitudOrigen = latitudOrigen;
	}
	public String getLongitudOrigen() {
		return longitudOrigen;
	}
	public void setLongitudOrigen(String longitudOrigen) {
		this.longitudOrigen = longitudOrigen;
	}
	public String getLatidudDestino() {
		return latidudDestino;
	}
	public void setLatidudDestino(String latidudDestino) {
		this.latidudDestino = latidudDestino;
	}
	public String getLongitudDestino() {
		return longitudDestino;
	}
	public void setLongitudDestino(String longitudDestino) {
		this.longitudDestino = longitudDestino;
	}
	
}
