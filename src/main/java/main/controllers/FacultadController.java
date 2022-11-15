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

import main.dto.Facultad;
import main.services.FacultadService;

@RestController
@RequestMapping("/api")
public class FacultadController {

	@Autowired
	FacultadService facultadService;
	
	@GetMapping("/facultades")
	public List<Facultad> listarFacultades(){
		return facultadService.listarFacultades();
	}
	
	@GetMapping("/facultades/{codigo}")
	public Facultad buscarFacultad(@PathVariable(name="codigo")Long codigo) {
		return facultadService.buscarFacultad(codigo);
	}
	
	@PostMapping("/facultades")
	public Facultad guardarFacultad(@RequestBody Facultad facultad) {
		return facultadService.guardarFacultad(facultad);
	}
	
	@PutMapping("/facultades/{codigo}")
	public Facultad actualizarFacultad(@PathVariable(name="codigo") Long codigo, @RequestBody Facultad facultad) {
		
		Facultad facultadSeleccionada = facultadService.buscarFacultad(codigo);
		
		facultadSeleccionada.setNombre(facultad.getNombre());
		
		return facultadService.actualizarFacultad(facultadSeleccionada);
	}
	
	@DeleteMapping("/facultades/{codigo}")
	public void eliminarFacultad(@PathVariable(name="codigo")Long codigo) {
		facultadService.eliminarFacultad(codigo);
	}
}
