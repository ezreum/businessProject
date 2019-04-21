package control;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

import modelo.Departamento;
import modelo.Empleado;
import modelo.Fichero;
import vista.Entrada;
import vista.Salida;

public class MainEmpresa {
	public static Scanner scan = new Scanner (System.in);
	
public static void main(String[] args) throws SQLException, IOException, ParseException {
		
		int opcion;
		System.out.println("Elija un numero dependiendo de lo que necesite: "
				+ "\n 1.-Insertar departamentos a través de un fichero."
				+ "\n 2.-Insertar un departamento a través de consola."
				+ "\n 3.-Insertar un empleado a través de un fichero."
				+ "\n 4.-Insertar un empleado a través de consola."
				+ "\n 5.-Actualizar un departamento a través de consola."
				+ "\n 6.-Actualizar un departamento a través de un fichero."
				+ "\n 7.-Borrar un departamento."
				+ "\n 8.-Insertar un proyecto.");
		opcion=scan.nextInt();
		switch (opcion) {
		
		case 1: {DepartamentoC.cargarDepartamento(Fichero.lecturaDepar());;}
		  break;
		case 2: {DepartamentoC.insertarDepartamento(Entrada.leerDepartamento());;}
		  break;
		case 3: {EmpleadoC.cargarEmpleados(Fichero.LecturaLista());}//no funciona, cambiar método al de la profesora
		  break;
		case 4: {Entrada.iniciarEmpleado();
			EmpleadoC.iniciarEmpleadoC(DepartamentoC.idDepartamento(scan.nextInt()));;}
		  break;
		  case 5: {
			  DepartamentoC.updateFichero(Fichero.updateNewD(),Fichero.updateOldD()); 
			  ;}
		  break;
		  case 6: {Entrada.updateDepar();
			  ;}
		  break;
		  case 7: {
			  DepartamentoC.borrarDepartamento(Entrada.deleteDepar());
			   }
		  break;
		  case 8: {
			  ProyectoC.insertarProyecto();
		  }
		  break;
		  default: {System.out.println("Error");}
			 
		}
		scan.close();
		
		}

	}
	