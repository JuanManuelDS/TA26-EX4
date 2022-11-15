package main.services;

import java.util.List;


import main.dto.Investigador;

public interface IInvestigadorService {

	public List<Investigador> listarInvesigadores();
	
	public Investigador buscarInvestigador(String dni);
	
	public Investigador guardarInvestigador(Investigador investigador);
	
	public Investigador actualizarInvestigador(Investigador investigador);
	
	public void eliminarInvestigador(String dni);
}
