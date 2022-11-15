package main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.IFacultadDAO;
import main.dto.Facultad;

@Service
public class FacultadService implements IFacultadService{

	@Autowired
	IFacultadDAO iFacultadDAO;

	@Override
	public List<Facultad> listarFacultades() {
		// TODO Auto-generated method stub
		return iFacultadDAO.findAll();
	}

	@Override
	public Facultad buscarFacultad(Long codigo) {
		// TODO Auto-generated method stub
		return iFacultadDAO.findById(codigo).get();
	}

	@Override
	public Facultad guardarFacultad(Facultad facultad) {
		// TODO Auto-generated method stub
		return iFacultadDAO.save(facultad);
	}

	@Override
	public Facultad actualizarFacultad(Facultad facultad) {
		// TODO Auto-generated method stub
		return iFacultadDAO.save(facultad);
	}

	@Override
	public void eliminarFacultad(Long codigo) {
		// TODO Auto-generated method stub
		iFacultadDAO.deleteById(codigo);
	}
	
	
}
