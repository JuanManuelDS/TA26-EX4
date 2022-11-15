package main.services;

import java.util.List;

import main.dto.Facultad;

public interface IFacultadService {

	public List<Facultad> listarFacultades();
	
	public Facultad buscarFacultad(Long codigo);
	
	public Facultad guardarFacultad(Facultad facultad);
	
	public Facultad actualizarFacultad(Facultad facultad);
	
	public void eliminarFacultad(Long codigo);
}
