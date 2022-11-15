package main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.IReservaDAO;
import main.dto.Reserva;

@Service
public class ReservaService implements IReservaService{

	@Autowired
	IReservaDAO iReservaDAO;
	
	@Override
	public List<Reserva> listarReservas() {
		// TODO Auto-generated method stub
		return iReservaDAO.findAll();
	}

	@Override
	public Reserva buscarReserva(Long id) {
		// TODO Auto-generated method stub
		return iReservaDAO.findById(id).get();
	}

	@Override
	public Reserva guardarReserva(Reserva reserva) {
		// TODO Auto-generated method stub
		return iReservaDAO.save(reserva);
	}

	@Override
	public Reserva actualizarReserva(Reserva reserva) {
		// TODO Auto-generated method stub
		return iReservaDAO.save(reserva);
	}

	@Override
	public void eliminarReserva(Long id) {
		// TODO Auto-generated method stub
		iReservaDAO.deleteById(id);
	}

}
