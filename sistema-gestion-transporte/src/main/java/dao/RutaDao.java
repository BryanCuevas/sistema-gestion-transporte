package dao;

import java.util.List;
import models.Ruta;

public interface RutaDao {
	public List<Ruta> obtenerRutas();
	public Ruta obtenerRuta(Integer id);
	public void insertarRuta(Ruta ruta);
	
}
