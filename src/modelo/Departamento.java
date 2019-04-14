package modelo;

public class Departamento {

	private String nombre;
	private int cod_depar1;
	
	public int getCod_depar1() {
		return cod_depar1;
	}
	public void setCod_depar1(int cod_depar1) {
		this.cod_depar1 = cod_depar1;
	}
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre_depart) {
		this.nombre = nombre_depart;
	}

	public Departamento(String nombre_depart) {
		super();
		this.nombre = nombre_depart;
	}

	@Override
	public String toString() {
		return "Departamento [nombre=" + nombre + ", cod_depar1=" + cod_depar1 + "]";
	}
	public Departamento () {
		super();
	}

	public Departamento(String s, String s1, String s2) {
		
	}
	public Departamento(int cod_depar1, String nombre) {
		super();
		this.nombre = nombre;
		this.cod_depar1 = cod_depar1;
	}
	
}
