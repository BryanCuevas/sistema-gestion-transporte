package models;

public class Carga {
	private Integer idCarga;
	private String tipoCarga;
	private String descripcion;
	private Integer peso;
	
	public Integer getIdCarga() {
		return idCarga;
	}
	public void setIdCarga(Integer idCarga) {
		this.idCarga = idCarga;
	}
	public String getTipoCarga() {
		return tipoCarga;
	}
	public void setTipoCarga(String tipoCarga) {
		this.tipoCarga = tipoCarga;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getPeso() {
		return peso;
	}
	public void setPeso(Integer peso) {
		this.peso = peso;
	}
	
}
