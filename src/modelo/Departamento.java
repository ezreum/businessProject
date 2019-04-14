package modelo;

public class Departamento {

	private String nombre;
	private int id;
	
	public Departamento(int i, String nombre) {
		super();
		this.nombre = nombre;
		this.id=i;
	}
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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
		return "Departamento [nombre=" + nombre + ", id=" + id + "]";
	}

	
}
