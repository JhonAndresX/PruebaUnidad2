package com.example.demo.models.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "empleado")
public class Empleado implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_empleado;
	@Column(name = "apellido", length = 45, nullable = false)
	private String apellido;
	@Column(name = "nombre", length = 45, nullable = false)
	private String nombre;
	@Column(name = "telefono", length = 15, nullable = false)
	private String telefono;
	@Column(name = "direccion", length = 45, nullable = false)
	private String direccion;
	@Column(name = "fecha_nac", nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date fecha_nacimiento;
	@Column(name = "observacion", length = 45, nullable = false)
	private String observacion;
	@Column(nullable = false)
	private int dias_trabajados;
	@Column(nullable = false)
	private double sueldo;

	public Long getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(Long id_empleado) {
		this.id_empleado = id_empleado;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public int getDias_trabajados() {
		return dias_trabajados;
	}

	public void setDias_trabajados(int dias_trabajados) {
		if (dias_trabajados < 0) {
			throw new IllegalArgumentException("El número de días trabajados no puede ser negativo");
		}
		this.dias_trabajados = dias_trabajados;
	}
	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public void calcularSueldo() {
		double sueldoBase = dias_trabajados * 15;
		double bono = 0;

		if (dias_trabajados >= 30) {
			bono = 0.05;
		} else if (dias_trabajados >= 20) {
			bono = 0.02;
		}

		this.sueldo = sueldoBase + (sueldoBase * bono);
	}
}
