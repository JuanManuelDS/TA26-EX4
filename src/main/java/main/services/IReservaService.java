package main.services;

import java.util.List;

import main.dto.Reserva;

public interface IReservaService {

	public List<Reserva> listarReservas();
	
	public Reserva buscarReserva(Long id);
	
	public Reserva guardarReserva(Reserva reserva);
	
	public Reserva actualizarReserva(Reserva reserva);
	
	public void eliminarReserva(Long id);
}
