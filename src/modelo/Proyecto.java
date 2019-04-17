package modelo;

import java.util.Date;

public class Proyecto {
	int cod_proyecto;	
	String nombre_proyecto;	
	Date fecha_inicio;	
	Date fecha_fin;
	String cliente;
	public Proyecto(int cod_proyecto, String nombre_proyecto, Date fecha_inicio, Date fecha_fin, String cliente) {
		super();
		this.cod_proyecto = cod_proyecto;
		this.nombre_proyecto = nombre_proyecto;
		this.fecha_inicio = convertUtil(fecha_inicio);
		this.fecha_fin = convertUtil(fecha_fin);
		this.cliente = cliente;
	}
	
	public Proyecto(String nombre_proyecto, Date fecha_inicio, Date fecha_fin, String cliente) {
		super();
		this.nombre_proyecto = nombre_proyecto;
		this.fecha_inicio = convertUtil(fecha_inicio);
		this.fecha_fin = convertUtil(fecha_fin);
		this.cliente = cliente;
	}

	public int getCod_proyecto() {
		return cod_proyecto;
	}
	public void setCod_proyecto(int cod_proyecto) {
		this.cod_proyecto = cod_proyecto;
	}
	public String getNombre_proyecto() {
		return nombre_proyecto;
	}
	public void setNombre_proyecto(String nombre_proyecto) {
		this.nombre_proyecto = nombre_proyecto;
	}
	public Date getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public Date getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	@Override
	public String toString() {
		return "Proyecto [cod_proyecto=" + cod_proyecto + ", nombre_proyecto=" + nombre_proyecto + ", fecha_inicio="
				+ fecha_inicio + ", fecha_fin=" + fecha_fin + ", cliente=" + cliente + "]";
	}

	public static java.sql.Date convertUtil(java.util.Date entrada) {
		java.sql.Date salida = new java.sql.Date(entrada.getTime());
		return salida;
		
	}
	
}
