package vista;

import java.util.List;
import java.util.Map;

import modelo.Departamento;

public class Salida {
	public static void mostrar(List<Departamento> listaD) {
		for (Departamento d:listaD) {
			System.out.println(d.toString());
		}
		
			
		
	}
	
}