package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import config.DatabaseAccess;
import dao.ConductorDao;
import models.Conductor;

public class ConductorDaoImpl implements ConductorDao {

	@Override
	public List<Conductor> listarConductores() {
		Connection cn = null;
		List<Conductor> conductores = null;
		try {
			cn = DatabaseAccess.getConnection();
			String sql = "SELECT id_conductor, nombres, apellido_paterno, apellido_materno, documento_identidad, telefono, licencia, id_ruta, foto_conductor FROM conductores WHERE estado_auditoria = '1'";
			
			PreparedStatement pstm = cn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			conductores = new ArrayList();
			
			while (rs.next()) {
				conductores.add(resultSetToObject(rs));
			}
			rs.close();
			pstm.close();
			
		} catch (Exception e) {
			System.out.println(e);
			conductores = null;
			
		} finally {
			try {
				if(cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				System.out.println(e2);				
			}
		}
		
		return conductores;
	}

	@Override
	public Conductor obtenerConductor(Integer id) {
		Connection cn = null;
		Conductor conductor = null;
		
		try {
			cn = DatabaseAccess.getConnection();
			String sql = "SELECT id_conductor, nombres, apellido_paterno, apellido_materno, documento_identidad, telefono, licencia, id_ruta, foto_conductor FROM conductores WHERE estado_auditoria = '1' AND id_conductor = ?";
			
			PreparedStatement pstm = cn.prepareStatement(sql);
			pstm.setInt(1, id);
			
			ResultSet rs = pstm.executeQuery();
			
			if (rs.next()) {
				conductor = resultSetToObject(rs);
			}
			
			rs.close();
			pstm.close();
			
		} catch (Exception e) {
			System.out.println(e);
			conductor = null;
			
		} finally {
			try {
				if (cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				System.out.println(e2);				
			}
		}
		
		return conductor;
	}

	@Override
	public void insertarConductor(Conductor conductor) {
		Connection cn = null;
		try {
			cn = DatabaseAccess.getConnection();
			cn.setAutoCommit(false);
			String sql = "INSERT INTO conductores(nombres, apellido_paterno, apellido_materno, documento_identidad, telefono, licencia, id_ruta, foto_conductor) VALUES (?,?,?,?,?,?,?,?)";
			
			PreparedStatement pstm = cn.prepareStatement(sql);
			pstm.setString(1, conductor.getNombres());
			pstm.setString(2, conductor.getApellidoPaterno());
			pstm.setString(3, conductor.getApellidoMaterno());
			pstm.setString(4, conductor.getDocumentoIdentidad());
			pstm.setString(5, conductor.getTelefono());
			pstm.setString(6, conductor.getLicencia());
			pstm.setInt(7, conductor.getIdRuta());
			pstm.setString(8, conductor.getFotoConductor());
			
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
	
	private Conductor resultSetToObject(ResultSet rs) throws Exception {
		Conductor conductor = new Conductor();
		conductor.setIdConductor(rs.getInt("id_conductor"));
		conductor.setNombres(rs.getString("nombres"));
		conductor.setApellidoPaterno(rs.getString("apellido_paterno"));
		conductor.setApellidoMaterno(rs.getString("apellido_materno"));
		conductor.setDocumentoIdentidad(rs.getString("documento_identidad"));
		conductor.setTelefono(rs.getString("telefono"));
		conductor.setLicencia(rs.getString("licencia"));
		conductor.setIdRuta(rs.getInt("id_ruta"));
		conductor.setFotoConductor(rs.getString("foto_conductor"));
		
		return conductor;
	}

}
