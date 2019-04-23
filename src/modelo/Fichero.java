package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.log.SysoCounter;
import com.itextpdf.text.pdf.PdfWriter;

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
	
	public static void pdfWrite(List<TecnicoProyecto> tecnicos) throws DocumentException, FileNotFoundException {
		Document hoja=new Document();
		FileOutputStream output= new FileOutputStream("Ficheros/Tecnicos.pdf");
		PdfWriter.getInstance(hoja, output);
		hoja.open();
		for (int i = 0; i < tecnicos.size(); i++) {
		hoja.add(new Paragraph(tecnicos.get(i).toString(), FontFactory.getFont("verdana", 16, Font.NORMAL, BaseColor.BLACK)));
		}
		hoja.close();
		Path check = Paths.get("Fichero/Tecnicos.pdf");
		if (check.getFileName() != null) {
			System.out.println("Su archivo se creó satisfactoriamente");
		}
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
