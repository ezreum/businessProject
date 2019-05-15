package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.itextpdf.text.log.SysoCounter;

import control.DepartamentoC;
import control.TecnicoProyectoC;
import modelo.Departamento;
import modelo.Proyecto;

public class VentanaSecundaria implements FocusListener, ActionListener{
	public JDialog segunda;
	public JTextArea nombre;
	public JTextField departamento;
	public JPanel arriba;
	public JPanel medio;
	public JPanel abajo;
	public JButton aceptar;
	public JTextField cliente;
	public JTextArea info;
	public JTextField fechaInicio;
	public JTextField fechaFin;
	
	public VentanaSecundaria(int i) throws SQLException, ParseException {
		super();
		this.segunda = new JDialog();
		inicio();
		componentes(i);
	}
	
	public void inicio() {
		segunda.setTitle("Business focuser");
		segunda.setLocation(new Point(500, 150));
		segunda.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		segunda.setResizable(true);
		segunda.setMinimumSize(new Dimension(200, 250));
		segunda.setPreferredSize(new Dimension (350, 400));
		segunda.setLayout(new BorderLayout());
		
	}
	
	public void componentes(int r) throws SQLException, ParseException {
		
		arriba = new JPanel();
		abajo = new JPanel();
		segunda.add(arriba, BorderLayout.NORTH);
		if (r == 6) {
			medio = new JPanel();
			medio.setLayout(new BoxLayout(medio, BoxLayout.Y_AXIS));
			segunda.add(medio, BorderLayout.CENTER);
		}
		segunda.add(abajo, BorderLayout.SOUTH);
		switch (r) {
		case 1:{
			
		}break;
		case 2: {
			arriba.setLayout(new BorderLayout());
			nombre = new JTextArea("escribe el número de departamento al que pertenece");
			arriba.add(nombre, BorderLayout.NORTH);
			departamento = new JTextField("Escribe aquí");
			departamento.addFocusListener(this);
			arriba.add(departamento, BorderLayout.SOUTH);
			aceptar = new JButton("aceptar");
			aceptar.addActionListener(this);
			aceptar.setActionCommand("2");
			abajo.setLayout(new BorderLayout());
			abajo.add(aceptar, BorderLayout.CENTER);
			
		}break;
		case 3:{
			
		}break;
		case 4:{
			
		}break;
		case 5:{
		JOptionPane.showMessageDialog(null, "Introduzca el nombre del departamento a borrar");
		
		arriba.setLayout(new BorderLayout());
		nombre = new JTextArea("escribe el nombre del departamento a borrar");
		arriba.add(nombre, BorderLayout.NORTH);
		departamento = new JTextField("Escribe aquí");
		
		departamento.addFocusListener(this);
		arriba.add(departamento, BorderLayout.SOUTH);
		aceptar = new JButton("aceptar");
		aceptar.addActionListener(this);
		aceptar.setActionCommand("5");
		abajo.setLayout(new BorderLayout());
		abajo.add(aceptar, BorderLayout.CENTER);
		}break;
		case 6:{
			arriba.setLayout(new BorderLayout());
			nombre = new JTextArea("escribe a continuación: 1. el nombre");
			arriba.add(nombre, BorderLayout.NORTH);
			departamento = new JTextField("Escribe aquí el nombre");
			departamento.addFocusListener(this);
			arriba.add(departamento, BorderLayout.CENTER);
			JTextArea fechas = new JTextArea("2. la fecha de inicio y 3. fin del proyecto en formato YYYY-MM-DD (1999-02-20)");
			medio.add(fechas);
			fechaInicio = new JTextField("F.inicio");
			fechaFin = new JTextField("F.fin");
			medio.add(fechaInicio);
			medio.add(fechaFin);
			info = new JTextArea("Escriba el nombre del cliente que lo encargó");
			cliente = new JTextField("Nombre");
			aceptar = new JButton("aceptar");
			aceptar.addActionListener(this);
			aceptar.setActionCommand("6");
			abajo.setLayout(new BorderLayout());
			abajo.add(info, BorderLayout.NORTH);
			abajo.add(cliente, BorderLayout.CENTER);
			abajo.add(aceptar, BorderLayout.SOUTH);
		}break;
		case 7:{
		TecnicoProyectoC.iniciarTecProj();
		}break;
		case 8:{
	
		}break;
		}
		
		
		
		
		
		/*nombre = new JTextArea("Escribe el codigo del empleado");
		departamento = new JTextField("escribe el departamento al que pertenece");
		arriba.add(nombre, BorderLayout.NORTH);
		
		abajo.add(departamento, BorderLayout.SOUTH);*/
		/*strings[0] = nombre.getText();
		strings[1] =departamento.getText();*/
		
		segunda.pack();
		segunda.setVisible(true);
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == departamento) {
			departamento.setText(null);
		}
	}
	
	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		/*if (e.getSource() == departamento) {
			int g = Integer.parseInt(departamento.getText());
			Departamento p;
			try {
				p = DepartamentoC.idDepartamento(g);
				JOptionPane.showMessageDialog(null, "El departamento es: "+p.getNombre()+" con número: "+p.getId());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}*/
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("2")) {
			int g = Integer.parseInt(departamento.getText());
			Departamento p;
			try {
				p = DepartamentoC.idDepartamento(g);
				JOptionPane.showMessageDialog(null, "El departamento es: "+p.getNombre()+" con número: "+p.getId());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (e.getActionCommand().equals("5")) {
			String borrar = departamento.getText();
			try {
				String h = DepartamentoC.borrarDepartamento(borrar);
				JOptionPane.showMessageDialog(null, "El estado del borrado es: "+h);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (e.getActionCommand().equals("6")) {
		Proyecto proyecto = null;
		String nombre = departamento.getText();
		String fechainicio = fechaInicio.getText();
		String fechafin = fechaFin.getText();
		String ncliente = cliente.getText();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaI = null;
		Date fechaF = null;
		try {
			fechaI = format.parse(fechainicio);
			fechaF = format.parse(fechafin);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println(fechaI+""+fechaF);
		proyecto = new Proyecto(nombre, fechaI, fechaF, ncliente);
		try {
			 if (TecnicoProyectoC.crearProj(proyecto)==true) {
				 JOptionPane.showMessageDialog(null, "Todo insertado correctamente");
			 }
			 else JOptionPane.showMessageDialog(null, "fallo al insertar");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}
		}
	
	}

}
