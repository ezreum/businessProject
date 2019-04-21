package vista;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import control.DepartamentoC;
import modelo.Departamento;
import modelo.Empleado;
import modelo.Proyecto;

public class Entrada {
	public static Scanner scan = new Scanner (System.in);

	public static Departamento leerDepartamento () {
		Departamento dm = new Departamento();
		System.out.println("Inserte el nombre del departamento: ");
		dm.setNombre(scan.next());
		return dm;
	}
	
	public static Empleado leerEmpleado(Empleado emple) {
	
		System.out.println("Inserte los datos del trabajador: ");
		System.out.println("NOMBRE:");
		emple.setNombre(scan.next());
		System.out.println("DIRECCIÓN:");
		emple.setDireccion(scan.next());
		System.out.println("TIPO: ");
		emple.setTipo(scan.next());
		scan.close();
	    return emple;
		}
	
	public static void  updateDepar () throws SQLException {
		Departamento dm = new Departamento();
		System.out.println("Inserte el nombre del departamento a cambiar: ");
		dm.setNombre(scan.next());
		String nuevo;
		System.out.println("Inserte el nuevo departamento: ");
		nuevo=scan.next();
		DepartamentoC.updateConsola(nuevo, dm.getNombre());
		
	}
	
	public static String deleteDepar () {
		String vnombre;
		System.out.print("Inserte el nombre del departamento que desea eliminar: ");
		vnombre=scan.next();
		return vnombre;
	}
	
	public static void iniciarEmpleado() {
		System.out.println("Introduce el codigo del departamento que pertenece");
	}
	
	public static void insertarEmpleado2() {
		System.out.println("Introduce el nombre, dirección y tipo de empleado");
	}

	public static void insertarEmpleado3() {
		System.out.println("¿Mismo o distinto departamento Y/N?");
	}
	
	public static String insertarTecnico() {
		String insertar=null;
		System.out.println("¿Quieres insertar un técnico (Y/N)?");
		insertar=scan.next();
		return insertar;
	}
	
	public static String insertarTecnicoNivel() {
		String nivel=null;
		System.out.println("¿Cuál es el nivel del técnico a insertar (bajo, medio o alto)?");
		nivel=scan.next();
		return nivel;
		
	
	}
	public static Proyecto leerProyecto(Proyecto p) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("Inserte los datos del proyecto. ");
		System.out.println("Nombre del proyecto:");
		p.setNombreProyect(scan.next());
		System.out.println("Fecha de inicio del proyecto en un formato(anio-mes-dia):");
	    String fechaI = scan.next();
	    System.out.println((sdf.parse(fechaI)));
	    p.setFechaInicio(fechaI);
		System.out.println("Fecha final del proyecto en un formato(anio-mes-dia):");
	    String fechaF = scan.next();
	    System.out.println((sdf.parse(fechaF)));
	    p.setFechaFin(fechaF);
	    System.out.println("Inserte el nombre del cliente: ");
		p.setCliente(scan.next());
	    return p;
		}
}
	

