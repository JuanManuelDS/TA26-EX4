package main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import main.dto.Reserva;

public interface IReservaDAO extends JpaRepository<Reserva, Long> {

}
