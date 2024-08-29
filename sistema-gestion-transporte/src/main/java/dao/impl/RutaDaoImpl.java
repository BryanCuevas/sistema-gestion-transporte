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
			String sql = "SELECT id_ruta, provincia, latitud_origen, longitud_origen, latitud_destino, longitud_destino FROM rutas WHERE estado_auditoria = '1'";
			
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
			String sql = "SELECT id_ruta, provincia, latitud_origen, longitud_origen, latitud_destino, longitud_destino FROM rutas WHERE estado_auditoria = '1' AND id_ruta = ?";
			
			PreparedStatement pstm = cn.prepareStatement(sql);
			pstm.setInt(1, id);
			
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
		Connection cn = null;
		
		try {
			cn = DatabaseAccess.getConnection();
			cn.setAutoCommit(false);
			String sql = "INSERT INTO rutas(provincia, latitud_origen, longitud_origen, latitud_destino, longitud_destino) VALUES (?,?,?,?,?)";
			
			PreparedStatement pstm = cn.prepareStatement(sql);
			pstm.setString(1, ruta.getProvincia());
			pstm.setString(2, ruta.getLatitudOrigen());
			pstm.setString(3, ruta.getLongitudOrigen());
			pstm.setString(4, ruta.getLatidudDestino());
			pstm.setString(5, ruta.getLongitudDestino());
			
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
