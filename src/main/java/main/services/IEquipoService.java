package main.services;

import java.util.List;

import main.dto.Equipo;

public interface IEquipoService {

	public List<Equipo> listarEquipos();
	
	public Equipo buscarEquipo(String numSerie);
	
	public Equipo guardarEquipo(Equipo equipo);
	
	public Equipo actualizarEquipo(Equipo equipo);
	
	public void eliminarEquipo(String numSerie);
}
