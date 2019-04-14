package control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.EnlaceJDBC;
import modelo.Departamento;
import modelo.Empleado;
import vista.Entrada;

public class EmpleadoC {
	public static Scanner scan=new Scanner(System.in);
	
	public static boolean insertarEmpleado(Empleado prueba)throws SQLException  {
		boolean check = false;
		String sql, sql2;
		EnlaceJDBC enlace = new EnlaceJDBC();
		if (Entrada.insertarTecnico().equals("Y")) {
			sql="INSERT into empleado (nombre, direccion, tipo, cod_depar) values ('"+prueba.getNombre()+"','"+prueba.getDireccion()+"','"+prueba.getTipo()+"','"+prueba.getCod_depar1()+"')";
			sql2="INSERT into tecnico (num_empleado, nivel) values("+getIdEmp(prueba)+",'"+Entrada.insertarTecnico2()+"')";
			enlace.insertar(sql);
			enlace.insertar(sql2);
			check=true;
		}
		else {sql="INSERT into empleado (nombre, direccion, tipo, cod_depar) values ('"+prueba.getNombre()+"','"+prueba.getDireccion()+"','"+prueba.getTipo()+"','"+prueba.getCod_depar1()+"')";
		enlace.insertar(sql);}
		System.out.println(sql);
		return check;
		}
	
	public static void iniciarEmpleado(Departamento codDep)throws SQLException  {
	Entrada.iniciarEmpleado2();
	String nombre=scan.nextLine();
	String direccion=scan.nextLine();
	String tipo=scan.nextLine();
	Entrada.iniciarEmpleado3();
	Empleado prueba= new Empleado(nombre,direccion,tipo,codDep.getId());
		Empleado[] emple=new Empleado[1];
		emple[0]=prueba;
			for (Empleado empleado : emple) {
				insertarEmpleado(empleado);
				System.out.println("Registro insertado correctamente");
			}
				System.out.println("Todo ha sido insertado");
		}
	
	public static int getIdEmp (Empleado busca) throws SQLException {
		String sql="SELECT num_emple FROM empleado where nombre= '"+busca.getNombre()+"'";
		System.out.println(sql);
		EnlaceJDBC enlace = new EnlaceJDBC();
		ResultSet rs=null;
		rs=enlace.seleccionRegistros(sql);
		int id=0;
		rs.next();
		id=rs.getInt(1);
		
		return id;
	}
	
	public static void cargarEmpleados(List<Empleado> emple)throws SQLException  {
		Entrada.iniciarEmpleado3();
		List<Empleado> carga=new ArrayList<>();
		carga=emple;
				for (Empleado empleado : carga) {
					insertarEmpleado(empleado);
					System.out.println("Registro insertado correctamente");
					Entrada.iniciarEmpleado3();
				}
					System.out.println("Todo ha sido insertado");
			}
	
	public static boolean insertarDepartamento(Departamento d) throws SQLException {
		EnlaceJDBC enlace = new EnlaceJDBC ();
		String sql="INSERT into Departamento (nombre_depar) VALUES ('"+d.getNombre()+"')";
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
	
	
	
}
