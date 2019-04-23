package modelo;

import java.sql.Date;

public class TecnicoProyecto {
	private int num_empleado;
	private int cod_proyecto;
	private java.sql.Date fecha_asignacion;
	private java.sql.Date fecha_cese;
	public TecnicoProyecto(int num_empleado, int cod_proyecto, Date fecha_asignacion, Date fecha_cese) {
		super();
		this.num_empleado = num_empleado;
		this.cod_proyecto = cod_proyecto;
		this.fecha_asignacion = fecha_asignacion;
		this.fecha_cese = fecha_cese;
	}
	public int getNum_empleado() {
		return num_empleado;
	}
	public void setNum_empleado(int num_empleado) {
		this.num_empleado = num_empleado;
	}
	public int getCod_proyecto() {
		return cod_proyecto;
	}
	public void setCod_proyecto(int cod_proyecto) {
		this.cod_proyecto = cod_proyecto;
	}
	public java.sql.Date getFecha_asignacion() {
		return fecha_asignacion;
	}
	public void setFecha_asignacion(java.sql.Date fecha_asignacion) {
		this.fecha_asignacion = fecha_asignacion;
	}
	public java.sql.Date getFecha_cese() {
		return fecha_cese;
	}
	public void setFecha_cese(java.sql.Date fecha_cese) {
		this.fecha_cese = fecha_cese;
	}
	@Override
	public String toString() {
		return "TecnicoProyecto [num_empleado=" + num_empleado + ", cod_proyecto=" + cod_proyecto
				+ ", fecha_asignacion=" + fecha_asignacion + ", fecha_cese=" + fecha_cese + "]";
	}
	
	
}
