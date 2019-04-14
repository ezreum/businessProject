package modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Fichero {
	public static List<Empleado> LecturaLista() {
	List<Empleado> carga= new ArrayList();
	Path salida=Paths.get("Ficheros\\empleados.csv");
	String h=null;
	int x=0;
	try {
		BufferedReader b = Files.newBufferedReader(salida);
		while ((h=b.readLine()) != null) {
		String[] Paco=h.split(";");
		carga.add(new Empleado(Paco[x++],Paco[x++],Paco[x++],Integer.parseInt(Paco[x++])));
		x=0;}
		System.out.println(carga.toString());
			//Inserción de un nuevo Alumno
		
	} catch (IOException e1) {
		
		e1.printStackTrace();

	}
	return carga;	
	
}

	public static List<Departamento> LecturaListaInDe() {
		List<Departamento> carga= new ArrayList();
		Path salida=Paths.get("Ficheros\\UpdateDepartN.csv");
		String h=null;
		try {
			BufferedReader b = Files.newBufferedReader(salida);
			while ((h=b.readLine()) != null) {
			h.split(";");
			carga.add(new Departamento(h));
			}
				//Inserción de un nuevo Alumno
			
		} catch (IOException e1) {
			
			e1.printStackTrace();

		}
		return carga;	
		
	}
	
	public static List<Departamento> LecturaListaUptN() {
		List<Departamento> carga= new ArrayList();
		Path salida=Paths.get("Ficheros\\UpdateDepartN.csv");
		String h=null;
		int x=0;
		try {
			BufferedReader b = Files.newBufferedReader(salida);
			while ((h=b.readLine()) != null) {
			String[] Paco=h.split(";");
			carga.add(new Departamento(Paco[x++]));
			x=0;}
				//Inserción de un nuevo Alumno
			
		} catch (IOException e1) {
			
			e1.printStackTrace();

		}
		return carga;	
		
	}
	
	public static List<Departamento> LecturaListaUptC() {
		List<Departamento> carga= new ArrayList();
		Path salida=Paths.get("Ficheros\\UpdateDepartC.csv");
		String h=null;
		int x=0;
		try {
			BufferedReader b = Files.newBufferedReader(salida);
			while ((h=b.readLine()) != null) {
			String[] Paco=h.split(";");
			carga.add(new Departamento(Paco[x++]));
			x=0;}
				//Inserción de un nuevo Alumno
			
		} catch (IOException e1) {
			
			e1.printStackTrace();

		}
		return carga;	
		
	}
}
