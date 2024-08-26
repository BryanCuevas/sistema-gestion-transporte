package models;

public class Conductor {
	private Integer idConductor;
	private String nombres;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String documentoIdentidad;
	private String telefono;
	private String licencia;
	private Integer idRuta;
	private String fotoConductor;
	
	public Integer getIdConductor() {
		return idConductor;
	}
	public void setIdConductor(Integer idConductor) {
		this.idConductor = idConductor;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	public String getDocumentoIdentidad() {
		return documentoIdentidad;
	}
	public void setDocumentoIdentidad(String documentoIdentidad) {
		this.documentoIdentidad = documentoIdentidad;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getLicencia() {
		return licencia;
	}
	public void setLicencia(String licencia) {
		this.licencia = licencia;
	}
	public Integer getIdRuta() {
		return idRuta;
	}
	public void setIdRuta(Integer idRuta) {
		this.idRuta = idRuta;
	}
	public String getFotoConductor() {
		return fotoConductor;
	}
	public void setFotoConductor(String fotoConductor) {
		this.fotoConductor = fotoConductor;
	}
	
}
