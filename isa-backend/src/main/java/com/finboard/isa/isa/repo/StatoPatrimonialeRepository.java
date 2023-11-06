package com.finboard.isa.isa.repo;


import com.finboard.isa.isa.model.Azienda;
import com.finboard.isa.isa.model.ContoEconomico;
import com.finboard.isa.isa.model.StatoPatrimoniale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface StatoPatrimonialeRepository extends JpaRepository<StatoPatrimoniale,Long> {

    public List<StatoPatrimoniale> findAll();

    /*
     * allows to find the required conto_economico records
     * searching for the matching azienda record*/
    public List<StatoPatrimoniale> findByIdAzienda(Azienda a);

    @Override
    void deleteAll();

    /*
     * allows to find the current conto_economico records,
     * the ones stored during the current year*/
    @Query(value = "select * from stato_patrimoniale where YEAR(stilatura) = YEAR(CURRENT_DATE());", nativeQuery = true)
    public List<StatoPatrimoniale> statiPatrimonialiAnnuali();

    /*
     * allows to find the stato_patrimoniale records which
     * have been stored during the past 10 years*/
    @Query(value = "select * from stato_patrimoniale where YEAR(stilatura) = YEAR(CURRENT_DATE())" +
            " union select * from stato_patrimoniale where YEAR(stilatura) = YEAR(CURRENT_DATE())-1" +
            " union select * from stato_patrimoniale where YEAR(stilatura) = YEAR(CURRENT_DATE())-2" +
            " union select * from stato_patrimoniale where YEAR(stilatura) = YEAR(CURRENT_DATE())-3" +
            " union select * from stato_patrimoniale where YEAR(stilatura) = YEAR(CURRENT_DATE())-4" +
            " union select * from stato_patrimoniale where YEAR(stilatura) = YEAR(CURRENT_DATE())-5" +
            " union select * from stato_patrimoniale where YEAR(stilatura) = YEAR(CURRENT_DATE())-6" +
            " union select * from stato_patrimoniale where YEAR(stilatura) = YEAR(CURRENT_DATE())-7" +
            " union select * from stato_patrimoniale where YEAR(stilatura) = YEAR(CURRENT_DATE())-8" +
            " union select * from stato_patrimoniale where YEAR(stilatura) = YEAR(CURRENT_DATE())-9" +
            ";", nativeQuery = true)
    public List<StatoPatrimoniale> statiPatrimonialiDieciAnni();

}
