package main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.IInvestigadorDAO;
import main.dto.Investigador;

@Service
public class InvestigadorService implements IInvestigadorService{

	@Autowired
	IInvestigadorDAO iInvestigadorDAO;
	
	@Override
	public List<Investigador> listarInvesigadores() {
		// TODO Auto-generated method stub
		return iInvestigadorDAO.findAll();
	}

	@Override
	public Investigador buscarInvestigador(String dni) {
		// TODO Auto-generated method stub
		return iInvestigadorDAO.findById(dni).get();
	}

	@Override
	public Investigador guardarInvestigador(Investigador investigador) {
		// TODO Auto-generated method stub
		return iInvestigadorDAO.save(investigador);
	}

	@Override
	public Investigador actualizarInvestigador(Investigador investigador) {
		// TODO Auto-generated method stub
		return iInvestigadorDAO.save(investigador);
	}

	@Override
	public void eliminarInvestigador(String dni) {
		// TODO Auto-generated method stub
		iInvestigadorDAO.deleteById(dni);
	}

}
