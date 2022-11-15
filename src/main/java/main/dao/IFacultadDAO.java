package main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import main.dto.Facultad;

public interface IFacultadDAO extends JpaRepository<Facultad, Long>{

}
