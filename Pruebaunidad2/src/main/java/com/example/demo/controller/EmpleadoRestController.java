package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.entity.Empleado;
import com.example.demo.models.service.IEmpleadoService;

@RestController
@RequestMapping("/api")
public class EmpleadoRestController {

	@Autowired
	private IEmpleadoService empleadoservice;

	@GetMapping("/empleado")
	public List<Empleado> indext() {
		return empleadoservice.findAll();

	}

	@GetMapping("/empleado/{id_empleado}")
	public Empleado show(@PathVariable Long id_empleado) {
		return empleadoservice.findById(id_empleado);
	}

	@PostMapping("/empleado")
	@ResponseStatus(HttpStatus.CREATED)
	public Empleado create(@RequestBody Empleado empleado) {
		empleado.calcularSueldo();
		return empleadoservice.save(empleado);
	}

	@PutMapping("/empleado/{id_empleado}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Empleado update(@RequestBody Empleado empleado, @PathVariable Long id_empleado) {
		Empleado empleadoactual = empleadoservice.findById(id_empleado);
		empleadoactual.setNombre(empleado.getNombre());
		empleadoactual.setApellido(empleado.getApellido());
		empleadoactual.setTelefono(empleado.getTelefono());
		empleadoactual.setDireccion(empleado.getDireccion());
		empleadoactual.setFecha_nacimiento(empleado.getFecha_nacimiento());
		empleadoactual.setObservacion(empleado.getObservacion());
		empleadoactual.setDias_trabajados(empleado.getDias_trabajados());
		empleadoactual.calcularSueldo();
		return empleadoservice.save(empleadoactual);
	}

	@DeleteMapping("/empleado/{id_empleado}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id_empleado) {
		empleadoservice.delete(id_empleado);
	}

}
