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

import control.MainEmpresa;

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
		nortero = new JTextField("Escriba aquí sus dudas");
		norte.add(nortero);
		norte.setPreferredSize(new Dimension(150, 50));
		a = new JButton("primero");
		a.addActionListener(this);
		a.setActionCommand("1");
		b = new JButton("segundo");
		b.addActionListener(this);
		b.setActionCommand("2");
		c = new JButton("tercero");
		c.addActionListener(this);
		c.setActionCommand("3");
		d = new JButton("cuarto");
		d.addActionListener(this);
		d.setActionCommand("4");
		e = new JButton("quinto");
		e.addActionListener(this);
		e.setActionCommand("5");
		f = new JButton("sexto");
		f.addActionListener(this);
		f.setActionCommand("6");
		g = new JButton("septimo");
		g.addActionListener(this);
		g.setActionCommand("7");
		h = new JButton("octavo");
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
			MainEmpresa.suichi(g);
		} catch (FileNotFoundException | SQLException | ParseException | DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
		
	}
	
	
	
	
	
	
	
	
}
