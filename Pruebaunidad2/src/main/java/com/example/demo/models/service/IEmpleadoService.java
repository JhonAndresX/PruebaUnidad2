package com.example.demo.models.service;

import java.util.List;

import com.example.demo.models.entity.Empleado;

public interface IEmpleadoService {
	
	public List<Empleado> findAll();

	public Empleado save(Empleado id_empleado);
	
	public Empleado findById(Long id_empleado);

	public void delete (Long id_empleado);

}
