package dao;

import java.util.List;
import models.Conductor;

public interface ConductorDao {
	public List<Conductor> listarConductores();
	public Conductor obtenerConductor(Integer id);
	public void insertarConductor(Conductor conductor);
	
}
