package modelo;

import java.util.Date;

public class Proyecto {

	private String nombreProyect;
	private String fechaInicio;
	private String fechaFin;
	private String cliente;
	
	public String getNombreProyect() {
		return nombreProyect;
	}
	public void setNombreProyect(String nombreProyect) {
		this.nombreProyect = nombreProyect;
	}
	

	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	public Proyecto(String nombreProyect, String fechaInicio, String fechaFin, String cliente) {
		super();
		this.nombreProyect = nombreProyect;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.cliente = cliente;
	}

	public Proyecto() {
		super();
		
	}

}
