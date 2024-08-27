package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import config.DatabaseAccess;
import dao.RutaDao;
import models.Ruta;

public class RutaDaoImpl implements RutaDao {

	@Override
	public List<Ruta> obtenerRutas() {
		Connection cn = null;
		List<Ruta> rutas = null;
		try {
			cn = DatabaseAccess.getConnection();
			String sql = "query";
			
			PreparedStatement pstm = cn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			rutas = new ArrayList();
			
			while (rs.next()) {
				rutas.add(resultSetToObject(rs));
			}
			rs.close();
			pstm.close();
			
		} catch (Exception e) {
			System.out.println(e);
			rutas = null;
			
		} finally {
			try {
				if(cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				System.out.println(e2);				
			}
		}
		
		return rutas;
	}

	@Override
	public Ruta obtenerRuta(Integer id) {
		Connection cn = null;
		Ruta ruta = null;
		
		try {
			cn = DatabaseAccess.getConnection();
			String sql = "query";
			
			PreparedStatement pstm = cn.prepareStatement(sql);
			pstm.setInt(1,id);
			
			ResultSet rs = pstm.executeQuery();
			
			if (rs.next()) {
				ruta = resultSetToObject(rs);
			}
			
			rs.close();
			pstm.close();
			
		} catch (Exception e) {
			System.out.println(e);
			ruta = null;
			
		} finally {
			try {
				if (cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				System.out.println(e2);				
			}
		}
		
		return ruta;
	}

	@Override
	public void insertarRuta(Ruta ruta) {
		// TODO Auto-generated method stub
		
	}
	
	private Ruta resultSetToObject(ResultSet rs) throws Exception {
		Ruta ruta = new Ruta();
		ruta.setIdRuta(rs.getInt("id_ruta"));
		ruta.setProvincia(rs.getString("provincia"));
		ruta.setLatitudOrigen(rs.getString("latitud_origen"));
		ruta.setLongitudOrigen(rs.getString("longitud_origen"));
		ruta.setLatidudDestino(rs.getString("latitud_destino"));
		ruta.setLongitudDestino(rs.getString("longitud_destino"));
		
		return ruta;
	}

}
