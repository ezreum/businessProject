package modelo;

public class Empleado {

	private String nombre;
	private String direccion;
	private String tipo;
	private Departamento cod_depar;
	private int cod_depar1;
	
	public Empleado(String nombre, String direccion, String tipo, int cod_depar1) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.tipo = tipo;
		this.cod_depar1 = cod_depar1;
	}
	
	
	public int getCod_depar1() {
		return cod_depar1;
	}


	public void setCod_depar1(int cod_depar1) {
		this.cod_depar1 = cod_depar1;
	}


	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Departamento getCod_depar() {
		return cod_depar;
	}
	public void setCod_depar(Departamento cod_depar) {
		this.cod_depar = cod_depar;
	}
	
	
	public Empleado(String nombre, String direccion, String tipo, Departamento cod_depar) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.tipo = tipo;
		this.cod_depar = cod_depar;
	}

	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", direccion=" + direccion + ", tipo=" + tipo +", cod_depar1=" + cod_depar1 + "]";
	}
	
}
