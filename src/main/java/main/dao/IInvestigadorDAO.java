package main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import main.dto.Investigador;

public interface IInvestigadorDAO extends JpaRepository<Investigador, String> {

}
