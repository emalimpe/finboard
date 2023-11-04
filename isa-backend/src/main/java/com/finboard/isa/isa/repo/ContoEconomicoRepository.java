package com.finboard.isa.isa.repo;

import java.util.Collection;
import java.util.List;


import com.finboard.isa.isa.model.Azienda;
import com.finboard.isa.isa.model.ContoEconomico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.*;
@Repository
public interface ContoEconomicoRepository extends JpaRepository<ContoEconomico,Long> {

    List<ContoEconomico> findAll();

    @Override
    void deleteAll();

    public List<ContoEconomico> findByIdAzienda(Azienda a);
    @Query(value = "select * from conto_economico where YEAR(stilatura) = YEAR(CURRENT_DATE());", nativeQuery = true)
    public List<ContoEconomico> contiAnnuali();

    @Query(value = "select * from conto_economico where YEAR(stilatura) = YEAR(CURRENT_DATE())" +
            " union select * from conto_economico where YEAR(stilatura) = YEAR(CURRENT_DATE())-1" +
            " union select * from conto_economico where YEAR(stilatura) = YEAR(CURRENT_DATE())-2" +
            " union select * from conto_economico where YEAR(stilatura) = YEAR(CURRENT_DATE())-3" +
            " union select * from conto_economico where YEAR(stilatura) = YEAR(CURRENT_DATE())-4" +
            " union select * from conto_economico where YEAR(stilatura) = YEAR(CURRENT_DATE())-5" +
            " union select * from conto_economico where YEAR(stilatura) = YEAR(CURRENT_DATE())-6" +
            " union select * from conto_economico where YEAR(stilatura) = YEAR(CURRENT_DATE())-7" +
            " union select * from conto_economico where YEAR(stilatura) = YEAR(CURRENT_DATE())-8" +
            " union select * from conto_economico where YEAR(stilatura) = YEAR(CURRENT_DATE())-9" +
            ";", nativeQuery = true)
    public List<ContoEconomico> contiDieciAnni();

}
