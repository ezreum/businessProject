package modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import control.DepartamentoC;

public class Fichero {

	public static List <Departamento> lecturaDepar () throws IOException, SQLException {
		
		List <Departamento> list= new ArrayList <Departamento>();
		//SIEMPRE PONER BARRA DOBLE PORQUE ASÍ ES EN WINDOWS Y UNA ES DE ESCAPE
		Path file = Paths.get("Ficheros\\departamentos.csv");
		BufferedReader reader = null;
		try {
			reader = Files.newBufferedReader(file, StandardCharsets.UTF_8);
		 String line = null;
	    while ((line = reader.readLine()) != null) {
	    	String[] elementos=line.split(";");
	    		   list.add(new Departamento(line));
	    }
	} catch (IOException x) {
	    System.err.format("IOException: %s%n", x);
	}finally {
       reader.close();
   	}System.out.println(list);
	return list;
}
	public static List <Departamento> cargaNuevoD () throws IOException, SQLException {
		
		List <Departamento> list= new ArrayList <Departamento>();
		//SIEMPRE PONER BARRA DOBLE PORQUE ASÍ ES EN WINDOWS Y UNA ES DE ESCAPE
		Path file = Paths.get("Ficheros\\UpdateDepartN.csv");
		BufferedReader reader = null;
		try {
			reader = Files.newBufferedReader(file, StandardCharsets.UTF_8);
		 String line = null;
	    while ((line = reader.readLine()) != null) {
	    	String[] elementos=line.split(";");
	    		   list.add(new Departamento(line));
	    }
	} catch (IOException x) {
	    System.err.format("IOException: %s%n", x);
	}finally {
       reader.close();
   	}System.out.println(list);
	return list;
}
public static List <Departamento> cargaAntiguoD () throws IOException, SQLException {
		
		List <Departamento> list= new ArrayList <Departamento>();
		//SIEMPRE PONER BARRA DOBLE PORQUE ASÍ ES EN WINDOWS Y UNA ES DE ESCAPE
		Path file = Paths.get("Ficheros\\UpdateDepartC.csv");
		BufferedReader reader = null;
		try {
			reader = Files.newBufferedReader(file, StandardCharsets.UTF_8);
		 String line = null;
	    while ((line = reader.readLine()) != null) {
	    	String[] elementos=line.split(";");
	    		   list.add(new Departamento(line));
	    }
	} catch (IOException x) {
	    System.err.format("IOException: %s%n", x);
	}finally {
       reader.close();
   	}System.out.println(list);
	return list;
}
	
    public static List <Departamento> updateNewD () throws IOException, SQLException {
    	List <Departamento> nuevoD = new ArrayList <Departamento> ();
    	nuevoD=cargaNuevoD();
    	for(Departamento depar : nuevoD) {
    		System.out.println("nombre del nuevo departamento: "+depar.getNombre()+" ");
    	}
    	
    	return nuevoD;
    }
    public static List <Departamento> updateOldD () throws IOException, SQLException {
    	List <Departamento> oldD = new ArrayList <Departamento> ();
    	oldD=cargaAntiguoD();
    	for(Departamento depar : oldD) {
    		System.out.println("nombre del departamento a cambiar: "+depar.getNombre()+" ");
    	}
    	
    	return oldD;
    }
	public static List<Empleado> LecturaLista() {
	List<Empleado> carga= new ArrayList <Empleado>();
	Path salida=Paths.get("Ficheros\\empleados.csv");
	String h=null;
	int x=0;
	try {
		BufferedReader b = Files.newBufferedReader(salida);
		while ((h=b.readLine()) != null) {
		String[] elemetos=h.split(";");
		carga.add(new Empleado(elemetos[x++],elemetos[x++],elemetos[x++],Integer.parseInt(elemetos[x++])));
		x=0;}
		System.out.println(carga.toString());
			//Inserción de un nuevo Alumno
		
	} catch (IOException e1) {
		
		e1.printStackTrace();

	}
	return carga;	
	
}

}