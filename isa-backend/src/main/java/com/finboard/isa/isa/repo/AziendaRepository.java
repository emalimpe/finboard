package com.finboard.isa.isa.repo;

import java.util.List;
import java.util.Optional;

import com.finboard.isa.isa.model.Azienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;


/**
 * repository which interfaces the database and interacts
 * directly with the aziende relation
 * Implements JpaRepository*/
@Repository
public interface AziendaRepository extends JpaRepository<Azienda, Long> {

    List<Azienda> findAll();

    /**
     * allows to find the required azienda record
     * searching for the matching name,*/
    Optional<Azienda> findByNome(String nome);

    @Override
    void deleteAll();

    /**
     * allows to delete the required azienda record
     * searching for the matching name,*/
    void deleteByNome(String nome);

}

