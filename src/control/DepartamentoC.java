package control;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.EnlaceJDBC;
import modelo.Departamento;
import modelo.Fichero;
import vista.Entrada;

public class DepartamentoC {


	
	public static void iniciarDepartamentos()throws SQLException  {
		Departamento d1 = new Departamento ("IT");
		Departamento d2 = new Departamento ("Marketing");
		Departamento d3 = new Departamento ("Ventas");
		Departamento [] departamentos = {d1,d2,d3};
		
			for(int i=0;i<3;i++) {
				if (DepartamentoC.insertarDepartamento(departamentos [i])) {
					
					}	
				System.out.println("Registro insertado correctamente");
			}
		}
	
	public static boolean insertarDepartamento(Departamento d) throws SQLException {
		EnlaceJDBC enlace = new EnlaceJDBC ();
		String sql="INSERT into Departamento (nombre_depar) VALUES ('"+d.getNombre()+"')";
		System.out.println(sql);
		return enlace.insertar(sql);
	}
	
	public static boolean cargarDepartamento (List <Departamento> e) throws IOException, SQLException {
		boolean valido=true;
		//List<Departamento> listaD=new ArrayList<Departamento>();
		e=Fichero.lecturaDepar();
		EnlaceJDBC enlace=new EnlaceJDBC();
		for(Departamento d: e) {
			enlace.insertarDepartamento(d);
			System.out.println(d.toString());
		}
		return valido;
	}
	
	
	public static String updateConsola(String orden, String up) throws SQLException {
		EnlaceJDBC enlace=new EnlaceJDBC();
		String ok ="hola";
		
	    String sqlUpdate = "UPDATE departamento SET nombre_depar='"+orden+"' WHERE nombre_depar='"+up+"'";
	   
	    if(enlace.insertar(sqlUpdate)==true) {
			 ok="UPDATED";
		}else { ok="NOT OK" ;}
	    System.out.println(ok);
	    return ok;
	}
	
	public static void updateFichero(List<Departamento> cargaN, List<Departamento> cargaC) throws SQLException {
		EnlaceJDBC enlace=new EnlaceJDBC();
		String ok;
		for (int i = 0; i < cargaN.size(); i++) {
			String sqlUpdate = "UPDATE departamento SET nombre_depar='"+cargaN.get(i).getNombre()+"' WHERE nombre_depar='"+cargaC.get(i).getNombre()+"'";
			if(enlace.insertar(sqlUpdate)==true) {
				 ok="UPDATED";
			}else { ok="NOT OK" ;}

		}
		
	}
	
	
	public static String borrarDepartamento(String nombre) throws SQLException {
		EnlaceJDBC enlace=new EnlaceJDBC();
		String ok;
		System.out.println("");
		String sqlUpdate = "DELETE FROM departamento WHERE nombre_depar='"+nombre+"'";
		if(enlace.insertar(sqlUpdate)==true) {
			 System.out.println(ok="DELETED");
		}else {  System.out.println(ok="NOT DELETED") ;}
		return nombre;
	}
	
	
	public static int getId (Departamento d) throws SQLException {
		String sql="SELECT cod_depar FROM departamento where nombre_depar ='"+d.getNombre()+"'";
		System.out.println(sql);
		EnlaceJDBC enlace = new EnlaceJDBC();
		ResultSet rs=null;
		rs=enlace.seleccionRegistros(sql);
		int id=0;
		rs.next();
		id=rs.getInt(1);
		System.out.println(id);
		return id;
	}
	
	public static Departamento idDepartamento(int i) throws SQLException {
		EnlaceJDBC enlace=new EnlaceJDBC();
		ResultSet depart= null;
		String sql = "SELECT * FROM departamento WHERE cod_depar="+i+"";
		depart=enlace.seleccionRegistros(sql);
		int s=0;
		String g= null;
		Departamento d=null;
		if (depart.next()==true) {
			s=depart.getInt("cod_depar");
			g=depart.getString("nombre_depar");
		d=new Departamento(s,g);}
		System.out.println(d.getCod_depar1()+" "+d.getNombre());
		return d;
	}

	
}
