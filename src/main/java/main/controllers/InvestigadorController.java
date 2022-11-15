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

import main.dto.Investigador;
import main.services.InvestigadorService;

@RestController
@RequestMapping("/api")
public class InvestigadorController {

	@Autowired
	InvestigadorService investigadorService;
	
	@GetMapping("/investigadores")
	public List<Investigador> listarInvestigadores(){
		return investigadorService.listarInvesigadores();
	}
	
	@GetMapping("/investigadores/{dni}")
	public Investigador buscarInvestigador(@PathVariable(name="dni")String dni) {
		return investigadorService.buscarInvestigador(dni);
	}
	
	@PostMapping("/investigadores")
	public Investigador guardarEquipo(@RequestBody Investigador investigador) {
		return investigadorService.guardarInvestigador(investigador);
	}
	
	@PutMapping("/investigadores/{dni}")
	public Investigador actualizarEquipo(@PathVariable(name="dni")String dni, @RequestBody Investigador investigador) {
		
		Investigador investigadorSeleccionado = investigadorService.buscarInvestigador(dni);
		
		investigadorSeleccionado.setNombre(investigador.getNombre());
		investigadorSeleccionado.setDni(investigador.getDni());
		
		return investigadorService.actualizarInvestigador(investigadorSeleccionado);
		
	}
	@DeleteMapping("/investigadores/{dni}")
	public void eliminarEquipo(@PathVariable(name="dni")String dni) {
		investigadorService.eliminarInvestigador(dni);
	}
}