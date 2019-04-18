package control;

import java.sql.Date;
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
	
	public static void iniciarTecProj() throws SQLException, ParseException {
		EnlaceJDBC enlace= new EnlaceJDBC();
		ResultSet rs = null;
		ResultSet tec = null;
		int[] datos = Entrada.AddTec();
		String consultaSQL = "SELECT * FROM proyecto where cod_proyecto = "+datos[0]+"";
		String consulta ="SELECT * FROM tecnico where num_empleado = "+datos[1]+"";
		rs = enlace.seleccionRegistros(consultaSQL);
		tec = enlace.seleccionRegistros(consulta);
		Proyecto numero = null;
		int idproj = 0, idtec = 0;
		Date inicio = null;
		Date ffin = null;
		String sql = null;
		while ((rs.next()) && (tec.next())) {
			idtec = tec.getInt("num_empleado");
			idproj = rs.getInt("cod_proyecto");
			java.util.Date[] fechas = Entrada.AddTec2();
			sql = "INSERT INTO tecnico_proyecto() values("+idtec+","+idproj+",'"+fechas[0]+"','"+fechas[1]+"')";
		}
		 
		if (enlace.insertar(sql) == true) {
		System.out.println("inserción correcta");	
		}
		else System.out.println("Fallo al insertar");
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
