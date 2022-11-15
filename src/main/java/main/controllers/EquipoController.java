package main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.dto.Equipo;
import main.services.EquipoService;

@RestController
@RequestMapping("/api")
public class EquipoController {

	@Autowired
	EquipoService equipoService;
	
	@GetMapping("/equipos")
	public List<Equipo> listarEquipos(){
		return equipoService.listarEquipos();
	}
	
	@GetMapping("/equipos/{numSerie}")
	public Equipo buscarEquipo(@PathVariable(name="numSerie")String numSerie) {
		return equipoService.buscarEquipo(numSerie);
	}
	
	@PostMapping("/equipos")
	public Equipo guardarEquipo(@RequestBody Equipo equipo) {
		return equipoService.guardarEquipo(equipo);
	}
	
	@PutMapping("/equipos/{numSerie}")
	public Equipo actualizarEquipo(@PathVariable(name="numSerie")String numSerie, @RequestBody Equipo equipo) {
		
		Equipo equipoSeleccionado = equipoService.buscarEquipo(numSerie);
		
		equipoSeleccionado.setNombre(equipo.getNombre());
		equipoSeleccionado.setNumSerie(equipo.getNumSerie());
		
		return equipoService.actualizarEquipo(equipoSeleccionado);
		
	}
	@DeleteMapping("/equipos/{numSerie}")
	public void eliminarEquipo(@PathVariable(name="numSerie")String numSerie) {
		equipoService.eliminarEquipo(numSerie);
	}
}
