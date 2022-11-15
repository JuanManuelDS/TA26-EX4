package main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.IEquipoDAO;
import main.dto.Equipo;

@Service
public class EquipoService implements IEquipoService {

	@Autowired
	IEquipoDAO iEquipoDAO;

	@Override
	public List<Equipo> listarEquipos() {
		// TODO Auto-generated method stub
		return iEquipoDAO.findAll();
	}

	@Override
	public Equipo buscarEquipo(String numSerie) {
		// TODO Auto-generated method stub
		return iEquipoDAO.findById(numSerie).get();
	}

	@Override
	public Equipo guardarEquipo(Equipo equipo) {
		// TODO Auto-generated method stub
		return iEquipoDAO.save(equipo);
	}

	@Override
	public Equipo actualizarEquipo(Equipo equipo) {
		// TODO Auto-generated method stub
		return iEquipoDAO.save(equipo);
	}

	@Override
	public void eliminarEquipo(String numSerie) {
		// TODO Auto-generated method stub
		iEquipoDAO.deleteById(numSerie);
	}
}
