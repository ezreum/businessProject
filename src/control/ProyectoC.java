package control;

import java.sql.SQLException;
import java.text.ParseException;

import dao.EnlaceJDBC;
import modelo.Proyecto;
import vista.Entrada;

public class ProyectoC {
	
	public static boolean insertarProyecto () throws SQLException, ParseException {
		Proyecto p = new Proyecto();
		EnlaceJDBC enlace = new EnlaceJDBC ();
		Entrada.leerProyecto(p);
		String sql="INSERT INTO proyecto (nombre_proyec,fecha_inicio,fecha_fin,cliente)VALUES('"+p.getNombreProyect()+"','"+p.getFechaInicio()+"','"+p.getFechaFin()+"','"+p.getCliente()+"')";
		return (enlace.insertar(sql));
	}
}
