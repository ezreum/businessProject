package control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dao.EnlaceJDBC;
import modelo.Departamento;

public class DepartamentoC {

	public static void iniciarDepartamentos(List<Departamento> carga)throws SQLException  {
		/*Departamento d1 = new Departamento ("IT");
		Departamento d2 = new Departamento ("Marketing");
		Departamento d3 = new Departamento ("Ventas");
		Departamento [] departamentos = {d1,d2,d3};*/
			for (Departamento departamento : carga) {
				insertarDepartamento(departamento);
				System.out.println("Registro insertado correctamente");
				System.out.println("Nombre del departamento: "+departamento);
			}
			
		}
	
	
	public static String borrarDepartamento(String entrada) throws SQLException {
		EnlaceJDBC enlace=new EnlaceJDBC();
		String ok;
		
		String sqlUpdate = "DELETE FROM departamento WHERE nombre_depar='"+entrada+"'";
		if(enlace.insertar(sqlUpdate)==true) {
			 ok="UPDATED";
		}else { ok="NOT OK" ;}
		return ok;
	}
	
	public static boolean insertarDepartamento(Departamento d) throws SQLException {
		EnlaceJDBC enlace = new EnlaceJDBC ();
		String sql="INSERT into departamento (nombre_depar) VALUES ('"+d.getNombre()+"')";
		System.out.println(sql);
		return enlace.insertar(sql);
	}
	
	public static String actualizarDepartamento() throws SQLException {
		EnlaceJDBC enlace=new EnlaceJDBC();
		String ok;
		String sqlUpdate = "UPDATE departamento SET nombre_depar='ventas' WHERE nombre_depar='customer_service'";
		if(enlace.insertar(sqlUpdate)==true) {
			 ok="UPDATED";
		}else { ok="NOT OK" ;}
		return ok;
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
		System.out.println(d.getId()+" "+d.getNombre());
		return d;
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
	
	
	public static void updateFichero(List<Departamento> cargaC, List<Departamento> cargaN) throws SQLException {
		EnlaceJDBC enlace=new EnlaceJDBC();
		String ok;
		for (int i = 0; i < cargaN.size(); i++) {
			String sqlUpdate = "UPDATE departamento SET nombre_depar='"+cargaN.get(i).getNombre()+"' WHERE nombre_depar='"+cargaC.get(i).getNombre()+"'";
			if(enlace.insertar(sqlUpdate)==true) {
				 ok="UPDATED";
			}else { ok="NOT OK" ;}

		}
		
	}
	
	public static String borrarDepartamento() throws SQLException {
		EnlaceJDBC enlace=new EnlaceJDBC();
		String ok;
		
		String sqlUpdate = "DELETE FROM departamento WHERE cod_depar=7";
		if(enlace.insertar(sqlUpdate)==true) {
			 ok="UPDATED";
		}else { ok="NOT UPDATED" ;}
		return ok;
	}
	
	public static int getId (Departamento d) throws SQLException {
		String sql="SELECT cod_depar FROM departamento where= '"+d.getNombre()+"'";
		System.out.println(sql);
		EnlaceJDBC enlace = new EnlaceJDBC();
		ResultSet rs=null;
		rs=enlace.seleccionRegistros(sql);
		int id=0;
		rs.next();
		id=rs.getInt(1);
		
		return id;
	}
	
	
}
