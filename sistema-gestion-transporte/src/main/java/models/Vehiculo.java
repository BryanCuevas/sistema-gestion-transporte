package models;

public class Vehiculo {
	private Integer idVehiculo;
	private char tipo;
	private String placa;
	private String modelo;
	private String soat;
	private String descripcion;
	private Integer idCarga;
	private Integer idRuta;
	private Integer idConductor;
	private String fotoVehiculo;
	
	public Integer getIdVehiculo() {
		return idVehiculo;
	}
	public void setIdVehiculo(Integer idVehiculo) {
		this.idVehiculo = idVehiculo;
	}
	public char getTipo() {
		return tipo;
	}
	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getSoat() {
		return soat;
	}
	public void setSoat(String soat) {
		this.soat = soat;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getIdCarga() {
		return idCarga;
	}
	public void setIdCarga(Integer idCarga) {
		this.idCarga = idCarga;
	}
	public Integer getIdRuta() {
		return idRuta;
	}
	public void setIdRuta(Integer idRuta) {
		this.idRuta = idRuta;
	}
	public Integer getIdConductor() {
		return idConductor;
	}
	public void setIdConductor(Integer idConductor) {
		this.idConductor = idConductor;
	}
	public String getFotoVehiculo() {
		return fotoVehiculo;
	}
	public void setFotoVehiculo(String fotoVehiculo) {
		this.fotoVehiculo = fotoVehiculo;
	}
	
}
