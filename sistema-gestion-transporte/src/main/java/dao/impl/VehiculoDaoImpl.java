package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import config.DatabaseAccess;
import dao.VehiculoDao; 
import models.Vehiculo;

public class VehiculoDaoImpl implements VehiculoDao {

	@Override
	public List<Vehiculo> listarVehiculos() {
		Connection cn = null;
		List<Vehiculo> vehiculos = null;
		try {
			cn = DatabaseAccess.getConnection();
			String sql = "query";
			
			PreparedStatement pstm = cn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			vehiculos = new ArrayList();
			
			while (rs.next()) {
				vehiculos.add(resultSetToObject(rs));
			}
			rs.close();
			pstm.close();
			
		} catch (Exception e) {
			System.out.println(e);
			vehiculos = null;
			
		} finally {
			try {
				if(cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				System.out.println(e2);				
			}
		}
		
		return vehiculos;
	}

	@Override
	public Vehiculo obtenerVehiculo(Integer id) {
		Connection cn = null;
		Vehiculo vehiculo = null;
		
		try {
			cn = DatabaseAccess.getConnection();
			String sql = "query";
			
			PreparedStatement pstm = cn.prepareStatement(sql);
			pstm.setInt(1,id);
			
			ResultSet rs = pstm.executeQuery();
			
			if (rs.next()) {
				vehiculo = resultSetToObject(rs);
			}
			
			rs.close();
			pstm.close();
			
		} catch (Exception e) {
			System.out.println(e);
			vehiculo = null;
		} finally {
			try {
				if (cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				System.out.println(e2);				
			}
		}
		
		return vehiculo;
	}

	@Override
	public void insertarVehiculo(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		
	}
	
	private Vehiculo resultSetToObject(ResultSet rs) throws Exception {
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setIdVehiculo(rs.getInt("id_vehiculo"));
		vehiculo.setTipo((char)rs.getInt("tipo"));
		vehiculo.setPlaca(rs.getString("placa"));
		vehiculo.setModelo(rs.getString("modelo"));
		vehiculo.setSoat(rs.getString("soat"));
		vehiculo.setDescripcion(rs.getString("descripcion"));
		vehiculo.setIdCarga(rs.getInt("id_carga"));
		vehiculo.setIdRuta(rs.getInt("id_ruta"));
		vehiculo.setIdConductor(rs.getInt("id_conductor"));
		vehiculo.setFotoVehiculo(rs.getString("foto_vehiculo"));

		return vehiculo;
	}

}
