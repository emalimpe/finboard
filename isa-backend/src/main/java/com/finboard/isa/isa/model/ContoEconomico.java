package com.finboard.isa.isa.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashMap;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jdk.jfr.DataAmount;

/**
 * Class ContoEconomico, entity "conto_economico" for relation creation into the database
 * author emanuele malimpensa
 * version 0.1
 * */

@Entity
@Transactional
@Table(name="conto_economico")

public class ContoEconomico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_conto_economico")
    Long id;
   // @OneToOne(targetEntity = Azienda.class)
   @ManyToOne
   @JoinColumn(name = "id")
   Azienda idAzienda;
    Date stilatura;
    float valoreProduzione;
    float valoreAggiunto;
    float margineOperativoLordo;
    float redditoOperativo;
    float redditoCorrente;
    float redditoAnteImposte;
    float redditoNetto;

    /**
     *params null, empty constructor for database relation creation with hybernate
     *return class ContoEconomico instance*/
    public ContoEconomico() {
    }

    /**
     * Constructor method for instance creation
     *params Long id, Azienda idAzienda, Date stilatura, float valoreProduzione, float valoreAggiunto, float margineOperativoLordo, float redditoOperativo, float redditoCorrente, float redditoAnteImposte, float redditoNetto
     *return class ContoEconomico instance*/
    public ContoEconomico(Long id, Azienda idAzienda, Date stilatura, float valoreProduzione, float valoreAggiunto, float margineOperativoLordo, float redditoOperativo, float redditoCorrente, float redditoAnteImposte, float redditoNetto) {
        this.id = id;
        this.idAzienda = idAzienda;
        this.stilatura = stilatura;
        this.valoreProduzione = valoreProduzione;
        this.valoreAggiunto = valoreAggiunto;
        this.margineOperativoLordo = margineOperativoLordo;
        this.redditoOperativo = redditoOperativo;
        this.redditoCorrente = redditoCorrente;
        this.redditoAnteImposte = redditoAnteImposte;
        this.redditoNetto = redditoNetto;
    }

    /**
     * get the conto economico's Id
     *params null
     *return Long*/
    public Long getId() {
        return id;
    }

    /**
     * set the conto economico's Id
     *params Long
     *return void*/
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * get the conto economico's azienda
     *params null
     *return Azienda*/
    public Azienda getIdAzienda() {
        return idAzienda;
    }

    /**
     * set the conto economico's azienda instance reference
     *params Azienda
     *return void*/
    public void setIdAzienda(Azienda idAzienda) {
        this.idAzienda = idAzienda;
    }

    /**
     * get the conto economico's stilatura date
     *params null
     *return Date*/
    public Date getStilatura() {
        return stilatura;
    }

    /**
     * set the conto economico's stilatura
     *params Date
     *return void*/
    public void setStilatura(Date stilatura) {
        this.stilatura = stilatura;
    }

    /**
     * get the conto economico's valore della produzione
     *params null
     *return float*/
    public float getValoreProduzione() {
        return valoreProduzione;
    }

    /**
     * set the conto economico's valore della produzione
     *params float
     *return void*/
    public void setValoreProduzione(float valoreProduzione) {
        this.valoreProduzione = valoreProduzione;
    }

    /**
     * get the conto economico's valore aggiunto
     *params null
     *return float*/
    public float getValoreAggiunto() {
        return valoreAggiunto;
    }

    /**
     * set the conto economico's valore aggiunto
     *params float
     *return void*/
    public void setValoreAggiunto(float valoreAggiunto) {
        this.valoreAggiunto = valoreAggiunto;
    }

    /**
     * get the conto economico's margine operativo lordo
     *params null
     *return float*/
    public float getMargineOperativoLordo() {
        return margineOperativoLordo;
    }

    /**
     * set the conto economico's margine operativo lordo
     *params float
     *return void*/
    public void setMargineOperativoLordo(float margineOperativoLordo) {
        this.margineOperativoLordo = margineOperativoLordo;
    }

    /**
     * get the conto economico's reddito operativo
     *params null
     *return float*/
    public float getRedditoOperativo() {
        return redditoOperativo;
    }

    /**
     * set the conto economico's reddito operativo
     *params float
     *return void*/
    public void setRedditoOperativo(float redditoOperativo) {
        this.redditoOperativo = redditoOperativo;
    }

    /**
     * get the conto economico's reddito corrente
     *params null
     *return float*/
    public float getRedditoCorrente() {
        return redditoCorrente;
    }

    /**
     * set the conto economico's reddito corrente
     *params float
     *return void*/
    public void setRedditoCorrente(float redditoCorrente) {
        this.redditoCorrente = redditoCorrente;
    }

    /**
     * get the conto economico's reddito ante imposte
     *params null
     *return float*/
    public float getRedditoAnteImposte() {
        return redditoAnteImposte;
    }

    /**
     * set the conto economico's reddito ante imposte
     *params float
     *return void*/
    public void setRedditoAnteImposte(float redditoAnteImposte) {
        this.redditoAnteImposte = redditoAnteImposte;
    }

    /**
     * get the conto economico's reddito netto
     *params null
     *return float*/
    public float getRedditoNetto() {
        return redditoNetto;
    }

    /**
     * set the conto economico's reddito netto
     *params float
     *return void*/
    public void setRedditoNetto(float redditoNetto) {
        this.redditoNetto = redditoNetto;
    }

    /**
     * get the conto economico's variazioni sulle materie, calculated as (valore della produzione - valore aggiunto)
     *params null
     *return float*/
    public float getVariazioniSuMaterie(){
        return (this.valoreProduzione - this.valoreAggiunto);
    }

    /**
     * get the conto economico's costo del personale amount, calculated as (valore aggiunto - margine operativo lordo)
     *params null
     *return float*/
    public float getCostoPersonale(){
        return (this.valoreAggiunto - this.margineOperativoLordo);
    }

    /**
     * get the conto economico's ammortamenti amount, calculated as (margine operativo lordo - reddito operativo)
     *params null
     *return float*/
    public float getAmmortamenti(){
        return (this.margineOperativoLordo - this.redditoOperativo);
    }

    /**
     * get the conto economico's saldo area finanziaria amount, calculated as (reddito operativo - reddito corrente)
     *params null
     *return float*/
    public float getSaldoAreaFinanziaria(){
        return (this.redditoOperativo - this.redditoCorrente);
    }

    /**
     * get the conto economico's area straordinaria amount, calculated as (reddito corrente - reddito ante imposte)
     *params null
     *return float*/
    public float getSaldoAreaStraordinaria(){
        return (this.redditoCorrente - this.redditoAnteImposte);
    }

    /**
     * get the conto economico's imposte sul reddito amount, calculated as (reddito ante imposte - reddito netto)
     *params null
     *return float*/
    public float getImposteSulReddito(){
        return (this.redditoAnteImposte - this.redditoNetto);
    }

    /**
     * method which allows to construct an object containing every field of the instance
     * and every calculated value (e.g. ammortamenti or imposte sul reddito), mapped with a key value
     *params null
     *return HashMap[String,Float]*/
    public HashMap<String,Float> dizionarioValori(){
        HashMap<String,Float> toRet = new HashMap<>();
        toRet.put("valoreProduzione",this.getValoreProduzione());
        toRet.put("valoreAggiunto",this.getValoreAggiunto());
        toRet.put("MOL",this.getMargineOperativoLordo());
        toRet.put("redditoOperativo",this.getRedditoOperativo());
        toRet.put("redditoNetto",this.getRedditoNetto());
        toRet.put("imposteSulReddito",this.getImposteSulReddito());
        toRet.put("saldoAreaStraordinaria",this.getSaldoAreaStraordinaria());
        toRet.put("saldoAreaFinanziaria",this.getSaldoAreaFinanziaria());
        toRet.put("ammortamenti",this.getAmmortamenti());
        toRet.put("costoDelPersonale",this.getCostoPersonale());
        toRet.put("variazioniSulleMateriePrime",this.getVariazioniSuMaterie());

        return toRet;
    }

    /**
     * toString method override
     *params null
     *return String toString instance stamp*/
    @Override
    public String toString() {
        return "ContoEconomico{" +
                "id=" + id +
                ", idAzienda=" + idAzienda +
                ", stilatura=" + stilatura +
                ", valoreProduzione=" + valoreProduzione +
                ", valoreAggiunto=" + valoreAggiunto +
                ", margineOperativoLordo=" + margineOperativoLordo +
                ", redditoOperativo=" + redditoOperativo +
                ", redditoCorrente=" + redditoCorrente +
                ", redditoAnteImposte=" + redditoAnteImposte +
                ", redditoNetto=" + redditoNetto +
                '}';
    }
}
