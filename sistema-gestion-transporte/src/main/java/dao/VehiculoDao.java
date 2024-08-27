package dao;

import java.util.List;
import models.Vehiculo;

public interface VehiculoDao {
	public List<Vehiculo> listarVehiculos();
	public Vehiculo obtenerVehiculo(Integer id);
	public void insertarVehiculo(Vehiculo vehiculo);
	
}
