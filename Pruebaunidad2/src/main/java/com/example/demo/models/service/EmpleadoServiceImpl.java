package com.example.demo.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.dao.IEmpleadoDao;
import com.example.demo.models.entity.Empleado;

@Service
public class EmpleadoServiceImpl  implements IEmpleadoService{

	
	@Autowired
	private IEmpleadoDao EmpleadoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Empleado> findAll() {
		return (List<Empleado>) EmpleadoDao.findAll();
	}

	@Override
	@Transactional
	public Empleado save(Empleado empleado) {
		// TODO Auto-generated method stub
		return EmpleadoDao.save(empleado);
	}

	@Override
	@Transactional(readOnly = true)
	public Empleado findById(Long id_empleado) {
		// TODO Auto-generated method stub
		return EmpleadoDao.findById(id_empleado).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id_empleado) {
		// TODO Auto-generated method stub
		EmpleadoDao.deleteById(id_empleado);
		
	}


}
