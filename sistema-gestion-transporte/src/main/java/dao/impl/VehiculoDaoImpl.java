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
			String sql = "SELECT id_vehiculo, tipo_vehiculo, placa, modelo, soat, descripcion, id_carga, id_ruta, id_conductor, foto_vehiculo FROM vehiculos WHERE estado_auditoria = '1'";
			
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
			String sql = "SELECT id_vehiculo, tipo_vehiculo, placa, modelo, soat, descripcion, id_carga, id_ruta, id_conductor, foto_vehiculo FROM vehiculos WHERE estado_auditoria = '1' AND id_vehiculo = ?";
			
			PreparedStatement pstm = cn.prepareStatement(sql);
			pstm.setInt(1, id);
			
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
		Connection cn = null;
		
		try {
			cn = DatabaseAccess.getConnection();
			cn.setAutoCommit(false);
			String sql = "INSERT INTO vehiculos(tipo, placa, modelo, soat, descripcion, id_carga, id_ruta, id_conductor, foto_vehiculo) VALUES (?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement pstm = cn.prepareStatement(sql);
			pstm.setString(1, vehiculo.getTipoVehiculo());
			pstm.setString(2, vehiculo.getPlaca());
			pstm.setString(3, vehiculo.getModelo());
			pstm.setString(4, vehiculo.getSoat());
			pstm.setString(5, vehiculo.getDescripcion());
			pstm.setInt(6, vehiculo.getIdCarga());
			pstm.setInt(7, vehiculo.getIdRuta());
			pstm.setInt(8, vehiculo.getIdConductor());
			pstm.setString(9, vehiculo.getFotoVehiculo());
			
			pstm.executeUpdate();
			cn.commit();
			
			pstm.close();
			
		} catch (Exception e) {
			System.out.println(e);
			
		}finally {
			try {
				if(cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				System.out.println(e2);				
			}
		}

		
	}
	
	private Vehiculo resultSetToObject(ResultSet rs) throws Exception {
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setIdVehiculo(rs.getInt("id_vehiculo"));
		vehiculo.setTipoVehiculo(rs.getString("tipo_vehiculo"));
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
