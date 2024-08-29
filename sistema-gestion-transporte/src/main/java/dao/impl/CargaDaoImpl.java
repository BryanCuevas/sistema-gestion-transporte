package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import config.DatabaseAccess;
import dao.CargaDao;
import models.Carga;

public class CargaDaoImpl implements CargaDao {

	@Override
	public List<Carga> listarCargas() {
		Connection cn = null;
		List<Carga> cargas = null;
		try {
			cn = DatabaseAccess.getConnection();
			String sql = "SELECT id_carga, tipo, descripcion, peso FROM cargas WHERE estado_auditoria='1'";
			
			PreparedStatement pstm = cn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			cargas = new ArrayList();
			
			while (rs.next()) {
				cargas.add(resultSetToObject(rs));
			}
			rs.close();
			pstm.close();
			
		} catch (Exception e) {
			System.out.println(e);
			cargas = null;
			
		} finally {
			try {
				if (cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				System.out.println(e2);				
			}
		}
		
		return cargas;
	}

	@Override
	public Carga obtenerCarga(Integer id) {
		Connection cn = null;
		Carga carga = null;
		
		try {
			cn = DatabaseAccess.getConnection();
			String sql = "SELECT id_carga, tipo, descripcion, peso FROM CARGAS WHERE estado_auditoria='1' AND id_carga= ?";
			
			PreparedStatement pstm = cn.prepareStatement(sql);
			pstm.setInt(1, id);
			
			ResultSet rs = pstm.executeQuery();
			
			if (rs.next()) {
				carga = resultSetToObject(rs);
			}
			
			rs.close();
			pstm.close();
			
		} catch (Exception e) {
			System.out.println(e);
			carga = null;
			
		} finally {
			try {
				if (cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				System.out.println(e2);				
			}
		}
		
		return carga;
	}

	@Override
	public void insertarCarga(Carga carga) {
		Connection cn = null;
		
		try {
			cn = DatabaseAccess.getConnection();
			cn.setAutoCommit(false);
			String sql = "INSERT INTO cargas(tipo, descripcion, peso) VALUES (?,?,?)";
			
			PreparedStatement pstm = cn.prepareStatement(sql);
			pstm.setString(1, carga.getTipo());
			pstm.setString(2, carga.getDescripcion());
			pstm.setInt(3, carga.getPeso());
			
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
	
	private Carga resultSetToObject(ResultSet rs) throws Exception {
		Carga carga = new Carga();
		carga.setIdCarga(rs.getInt("id_carga"));
		carga.setTipo(rs.getString("tipo"));
		carga.setDescripcion(rs.getString("descripcion"));
		carga.setPeso(rs.getInt("peso"));
		
		return carga;
	}

}
