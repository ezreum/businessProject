package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.log.SysoCounter;

import control.DepartamentoC;
import control.EmpleadoC;
import control.MainEmpresa;
import control.TecnicoProyectoC;
import modelo.Fichero;

public class Keypad implements ActionListener{
	JFrame principal;
	JPanel norte;
	JPanel centro;
	JPanel sur;
	JTextField nortero;
	JButton a;
	JButton b;
	JButton c;
	JButton d;
	JButton e;
	JButton f;
	JButton g;
	JButton h;
	
	public Keypad() {
		super();
		this.principal = new JFrame("Business Organizator 3000");
		inicio();
		componentes();
	}

	private void inicio() {
		principal.setLocation(new Point(500, 150));
		principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		principal.setResizable(true);
		principal.setMinimumSize(new Dimension(200, 250));
		principal.setPreferredSize(new Dimension (350, 400));
		principal.setLayout(new BorderLayout());
	}

	private void componentes() {
		// TODO Auto-generated method stub
		norte = new JPanel();
		centro = new JPanel();
		sur = new JPanel();
		norte.setLayout(new BorderLayout());
		nortero = new JTextField("Elija una opción");
		norte.add(nortero);
		norte.setPreferredSize(new Dimension(150, 50));
		a = new JButton("Cargar lista Departamentos");
		a.addActionListener(this);
		a.setActionCommand("1");
		b = new JButton("Ver el id de un departamento");
		b.addActionListener(this);
		b.setActionCommand("2");
		c = new JButton("Cargar lista empleados");
		c.addActionListener(this);
		c.setActionCommand("3");
		d = new JButton("Reestructurar departamento(s)");
		d.addActionListener(this);
		d.setActionCommand("4");
		e = new JButton("Eliminar departamento");
		e.addActionListener(this);
		e.setActionCommand("5");
		f = new JButton("Insertar projecto");
		f.addActionListener(this);
		f.setActionCommand("6");
		g = new JButton("incluir tecnicos en proyecto");
		g.addActionListener(this);
		g.setActionCommand("7");
		h = new JButton("Exportar en un pdf técnicos");
		h.addActionListener(this);
		h.setActionCommand("8");
		centro.setLayout(new GridLayout(4,3));
		centro.add(a);
		centro.add(b);
		centro.add(c);
		centro.add(d);
		centro.add(e);
		centro.add(f);
		centro.add(g);
		centro.add(h);
		principal.add(norte, BorderLayout.NORTH);
		principal.add(centro, BorderLayout.CENTER);
		principal.add(sur, BorderLayout.SOUTH);
		principal.pack();
		principal.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand() != null);{
		int g = Integer.parseInt(e.getActionCommand());
		try {
			switch (g) {
			case 1: {
				Entrada.insertar();
				DepartamentoC.iniciarDepartamentos(Fichero.LecturaListaInDe());
			}
			break;
			case 2: {
				//ver el id de un departamento
				VentanaSecundaria secundaria = new VentanaSecundaria(g);
				
			}
			break;
			case 3: {
			/*	Entrada.iniciarEmpleado();*/
				
				EmpleadoC.cargarEmpleados(Fichero.LecturaLista());
			}
			break;
			case 4: {
				DepartamentoC.updateFichero(Entrada.updateDeparFichC(), Entrada.updateDeparFichN());
			}
			break;
			case 5: {
				//borrar departamento
				VentanaSecundaria secundaria = new VentanaSecundaria(g);
			}
			break;
			case 6: {
				VentanaSecundaria secundaria = new VentanaSecundaria(g);
			}
			break;
			case 7: {
				VentanaSecundaria secundaria = new VentanaSecundaria(g);
			}
			break;
			case 8: {
				Fichero.pdfWrite(TecnicoProyectoC.allTec());	
			}
			break;
			}
			
		} catch (FileNotFoundException | SQLException | DocumentException | ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
		
	}
	
	
	public void close() {
		principal.setVisible(false);
		principal.dispose();
	}
	
	
	
	
	
}
