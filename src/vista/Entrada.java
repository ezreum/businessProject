package vista;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import control.DepartamentoC;
import control.EmpleadoC;
import modelo.Departamento;
import modelo.Fichero;
import modelo.Proyecto;

public class Entrada {
	
	public static Scanner scan = new Scanner(System.in);
	
	public static void bienvenida() {
		System.out.println("Hola, bienvenido al proyecto =D\n 1.insertar departamento, 2. obtener el id, 3. insertar empleado");
	}
	
	public static void insertar() {
		System.out.println("introduce un nombre de departamento");
	}
	
	public static String insertarTecnico() {
		System.out.println("¿el empleado será tecnico? Y/N");
		String check = scan.next();
		return check.toUpperCase();
	}
	
	public static String insertarTecnico2() {
		System.out.println("¿avanzado, medio, aprendiz?");
		String check = scan.next();
		return check.toLowerCase();
	}
	
	public static void VerId() {
		System.out.println("introduce un número de departamento");
	}
	
	public static void iniciarEmpleado() {
		System.out.println("Introduce el codigo o nombre del departamento que pertenece");
	}
	
	public static void iniciarEmpleado2() {
		System.out.println("Introduce el nombre, dirección y tipo de empleado");
	}
	
	public static void iniciarEmpleado3() {
		System.out.println("¿Mismo o distinto departamento Y/N?");
	}
	
	 public static List<Departamento>  updateDeparFichC () throws SQLException {
			// CREAR LISTA CON UPDATES NUEVOS Y VIEJOS DEPARTAMENTOS 
		 List<Departamento> carga = new ArrayList<>();
		 carga=Fichero.LecturaListaUptC();
		 int x = 1;
		 for (Departamento departamento : carga) {
			 System.out.println("nombre del departamento a cambiar: "+x+". "+departamento.getNombre()+"");
		x++;
		 }
			
			return carga;
		
		}
	 
	 public static Proyecto insertarProj() throws ParseException {
		 Proyecto proyecto = null;
		 System.out.println("Para insertar un proyecto estipule: 1. nombre");
		 String nombre = scan.next();
		 System.out.println("ahora 2. fecha de inicio, 3. fecha prevista de finalización");
		 System.out.println("Para las fechas se escribira el formato yyyy-MM-dd");
		 String fechaInicio = scan.next();
		 String fechaFin = scan.next();
		 System.out.println("Por último el nombre del cliente que encargó el proyecto");
		 String cliente = scan.next();
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		 Date fechaI = format.parse(fechaInicio);
		 Date fechaF = format.parse(fechaFin);
		 System.out.println(fechaI+""+fechaF);
		 proyecto = new Proyecto(nombre, fechaI, fechaF, cliente);
		 return proyecto;
	}

	 public static List<Departamento>  updateDeparFichN () throws SQLException {
			// CREAR LISTA CON UPDATES NUEVOS Y VIEJOS DEPARTAMENTOS 
		 List<Departamento> carga = new ArrayList<>();
		 carga=Fichero.LecturaListaUptN();
		 int x = 1;
			for (Departamento departamento : carga) {
				System.out.println("nombre del departamento a actual: "+x+". "+departamento.getNombre()+"");
			x++;
			}
			return carga;
		}
	 
	 	public static void deleteEmpleado() throws SQLException {
			// CREAR LISTA CON UPDATES NUEVOS Y VIEJOS DEPARTAMENTOS 
		 	System.out.println("Introduzca el nombre del empleado a borrar");
		 	String borrar = scan.next();
		 	DepartamentoC.borrarDepartamento(borrar);
	 }
	 	
	 	public static int[] AddTec() {
			int[] tecproj = new int[2];
	 		System.out.println("Introduce el número del proyecto");
			tecproj[0] = scan.nextInt();
			System.out.println("Introduce el número del técnico");
			tecproj[1] = scan.nextInt();
			return tecproj;
			
		}
	 	
	 	public static Date[] AddTec2() throws ParseException {
	 		Date[] fechas = new Date[2];
	 		System.out.println("introduce la fecha en la que el tecnico empieza a formar parte del proyecto \n el formato será yyyy-MM-dd");
			String fechaInicio = scan.next();
			System.out.println("introduce la fecha en la que el tecnico deja de formar parte del proyecto \n el formato será yyyy-MM-dd");
			String fechaFin = scan.next();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date fechaI = Proyecto.convertUtil(format.parse(fechaInicio));
			fechas[0]= fechaI;
			Date fechaF = Proyecto.convertUtil(format.parse(fechaFin));
			fechas[1]= fechaF;
			System.out.println(fechaI+""+fechaF);
			return fechas;	
		}
}