package modelo;

public class Tecnico {
	public int id;
	public String nivel;
	
	public Tecnico(int id, String nivel) {
		super();
		this.id = id;
		this.nivel = nivel;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	@Override
	public String toString() {
		return "Tecnico [id=" + id + ", nivel=" + nivel + "]";
	}
	
}
