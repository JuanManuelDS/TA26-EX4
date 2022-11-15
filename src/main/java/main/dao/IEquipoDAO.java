package main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import main.dto.Equipo;

public interface IEquipoDAO extends JpaRepository<Equipo, String> {

}
