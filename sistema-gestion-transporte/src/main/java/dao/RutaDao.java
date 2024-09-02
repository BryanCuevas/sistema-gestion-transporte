package dao;

import java.util.List;
import models.Ruta;

public interface RutaDao {
	public List<Ruta> listarRutas();
	public List<Ruta> listarRutas(String provincia);
	public Ruta obtenerRuta(Integer id);
	public void insertarRuta(Ruta ruta);
	
}
