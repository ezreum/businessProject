package control;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.Departamento;
import modelo.Empleado;
import modelo.Fichero;
import vista.Entrada;
import vista.Salida;

public class MainEmpresa {
	

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		Entrada.bienvenida();
		
		switch (scan.nextInt()) {
		case 1: {
			Entrada.insertar();
			DepartamentoC.iniciarDepartamentos(Fichero.LecturaListaInDe());
		}
		break;
		case 2: {
			Entrada.VerId();
		}
		break;
		case 3: {
			Entrada.iniciarEmpleado();
			
			EmpleadoC.iniciarEmpleado(DepartamentoC.idDepartamento(scan.nextInt()));
			//EmpleadoC.cargarEmpleados(Fichero.LecturaLista());
		}
		break;
		case 4: {
			DepartamentoC.updateFichero(Entrada.updateDeparFichC(), Entrada.updateDeparFichN());
		}
		break;
		case 5: {
			Entrada.deleteEmpleado();
		}
		}
		/*DepartamentoC.iniciarDepartamentos(scan.nextLine());*/
		
		
		//DepartamentoC.insertarDepartamento(c);
		
		//DepartamentoC.iniciarDepartamentos();
		//DepartamentoC.actualizarDepartamento();
		//DepartamentoC.borrarDepartamento();
		
		
		
		
		
		
		
	}
	}

