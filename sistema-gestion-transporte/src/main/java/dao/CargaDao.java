package dao;

import java.util.List;
import models.Carga;

public interface CargaDao {
	public List<Carga> listarCargas();
	public Carga obtenerCarga(Integer id);
	public void insertarCarga(Carga carga);
	
}
