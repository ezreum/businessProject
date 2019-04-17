package control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import dao.EnlaceJDBC;
import modelo.Proyecto;
import modelo.Tecnico;
import vista.Entrada;

public class TecnicoProyectoC {
	
	public static boolean crearProj(Proyecto entrada) throws ParseException, SQLException {
		boolean ok = false;
		EnlaceJDBC enlace = new EnlaceJDBC();
		String sql = "INSERT INTO proyecto(nombre_proyecto, fecha_inicio, fecha_fin, cliente) "
		+ "values('"+entrada.getNombre_proyecto()+"','"+entrada.getFecha_inicio()+"','"+entrada.getFecha_fin()+"','"+entrada.getCliente()+"')";
		if (enlace.insertar(sql) == true) {
			ok=true;}
			return ok;
	}
	
	public static Tecnico getTech(int idTecnico) throws SQLException {
		String sql="select * from tecnico where num_empleado = "+idTecnico+"";
		EnlaceJDBC enlace = new EnlaceJDBC();
		ResultSet consulta=null;
		consulta = enlace.seleccionRegistros(sql);
		Tecnico tecnico = null;
		while (consulta.next()) {
		tecnico = new Tecnico(consulta.getInt("num_empleado"), consulta.getString("nivel"));
		}
		return tecnico;
	}
	
	public static Proyecto getProj(int num_proj) throws SQLException {
		EnlaceJDBC enlace = new EnlaceJDBC();
		Proyecto proyecto= null;
		ResultSet rs = null;
		String sql = "select * from projecto where cod_proyecto = "+num_proj+"";
		rs = enlace.seleccionRegistros(sql);
		while (rs.next()) {
		proyecto = new Proyecto(rs.getInt("cod_proyecto"), rs.getString("nombre_proyecto"), rs.getDate("fecha_inicio"), rs.getDate("fecha_fin"), rs.getString("cliente"));
		}
		return proyecto;
	}
	
}
