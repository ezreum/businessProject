package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.EnlaceJDBC;
import modelo.Departamento;
import modelo.Empleado;
import vista.Entrada;

public class EmpleadoC {
	public static Scanner scan = new Scanner (System.in);
	
	public static void iniciarEmpleado (Empleado e) throws SQLException {
        Empleado [] plantilla = new Empleado[1];
        plantilla [0]=e;
        for(Empleado emple : plantilla) {
        	insertarEmpleadoTecnico(emple);
        	System.out.println("Registro realizado adecuadamente");
        }
		System.out.println("Todo ha sido insertado");
	}
	
	public static boolean insertarEmpleado (Empleado a) throws SQLException {
			EnlaceJDBC enlace = new EnlaceJDBC ();
			int codDepar=DepartamentoC.getId(a.getCod_depar());
			String sql="INSERT INTO empleado (nombre,direccion,tipo,cod_depar)VALUES('"+a.getNombre()+"','"+a.getDireccion()+"','"+a.getTipo()+"',"+codDepar+")";
			return (enlace.insertar(sql));
		}
	public static boolean insertarEmpleadoTecnico (Empleado e) throws SQLException {
		boolean check=false;
		String sql1,sql2;
		EnlaceJDBC enlace = new EnlaceJDBC();
		EnlaceJDBC en = new EnlaceJDBC();
		if(Entrada.insertarTecnico().equals("Y")) {
	sql1="INSERT INTO empleado (nombre,direccion,tipo,cod_depar)VALUES('"+e.getNombre()+"','"+e.getDireccion()+"','"+e.getTipo()+"',"+e.getCod_depar1()+")";
	sql2="INSERT INTO tecnico(num_empleado,nivel)VALUES("+e.getCod_depar1()+",'"+Entrada.insertarTecnicoNivel()+"')";
	enlace.insertar(sql1);
	en.insertar(sql2);
	check=true;
		}
		else {sql1="INSERT INTO empleado (nombre,direccion,tipo,cod_depar)VALUES('"+e.getNombre()+"','"+e.getDireccion()+"','"+e.getTipo()+"',"+e.getCod_depar1()+")";
			enlace.insertar(sql1);
		System.out.println(sql1);
		}

	return check;
	}
	

	public static void iniciarEmpleadoC(Departamento codDep)throws SQLException  {
		Entrada.insertarEmpleado2();
		String nombre=scan.nextLine();
		String direccion=scan.nextLine();
		String tipo=scan.nextLine();
		//Entrada.insertarEmpleado3();
		Empleado prueba= new Empleado(nombre,direccion,tipo,codDep.getCod_depar1());
	Empleado[] emple=new Empleado[1];
		emple[0]=prueba;
			for (Empleado empleado : emple) {
				insertarEmpleadoTecnico(empleado);
				System.out.println("Registro insertado correctamente");
			}
				System.out.println("Todo ha sido insertado");
		}
	
	public static void cargarEmpleados(List<Empleado> emple)throws SQLException  {
		Entrada.insertarEmpleado3();;
		List<Empleado> carga=new ArrayList<>();
		carga=emple;
				for (Empleado empleado : carga) {
					insertarEmpleado(empleado);
					System.out.println("Registro insertado correctamente");
					Entrada.insertarEmpleado3();
				}
					System.out.println("Todo ha sido insertado");
			}
}
