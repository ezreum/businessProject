package vista;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import control.DepartamentoC;
import control.EmpleadoC;
import modelo.Departamento;
import modelo.Fichero;

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
}