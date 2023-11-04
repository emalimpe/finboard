package com.finboard.isa.isa.repo;

import java.util.List;
import java.util.Optional;

import com.finboard.isa.isa.model.Azienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;



@Repository
public interface AziendaRepository extends JpaRepository<Azienda, Long> {

    List<Azienda> findAll();
    Optional<Azienda> findByNome(String nome);

    @Override
    void deleteAll();
    void deleteByNome(String nome);

}

