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

import main.dto.Reserva;
import main.services.ReservaService;

@RestController
@RequestMapping("/api")
public class ReservaController {

	@Autowired
	ReservaService reservaService;
	
	@GetMapping("/reservas")
	public List<Reserva> listaReservas(){
		return reservaService.listarReservas();
	}
	
	@GetMapping("/reservas/{id}")
	public Reserva buscaReserva(@PathVariable(name="id")Long id) {
		return reservaService.buscarReserva(id);
	}
	
	
	@PostMapping("/reservas")
	public Reserva guardarReserva(@RequestBody Reserva reserva) {
		return reservaService.guardarReserva(reserva);
	}
	
	@PutMapping("/reservas/{id}")
	public Reserva actualizaReserva(@PathVariable(name="id")Long id, @RequestBody Reserva reserva) {
		
		 Reserva reservaSeleccionada = reservaService.buscarReserva(id);
		 
		 reservaSeleccionada.setEquipo(reserva.getEquipo());
		 reservaSeleccionada.setInvestigador(reserva.getInvestigador());
		 reservaSeleccionada.setComienzo(reserva.getComienzo());
		 reservaSeleccionada.setFin(reserva.getFin());
		 
		 return reservaService.actualizarReserva(reservaSeleccionada);
		 
	}
	
	@DeleteMapping("/reservas/{id}")
	public void eliminarReserva(@PathVariable(name="id")Long id) {
		reservaService.eliminarReserva(id);
		
	}
}