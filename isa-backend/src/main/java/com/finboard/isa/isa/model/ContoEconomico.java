package com.finboard.isa.isa.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashMap;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jdk.jfr.DataAmount;
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

    public ContoEconomico() {
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Azienda getIdAzienda() {
        return idAzienda;
    }

    public void setIdAzienda(Azienda idAzienda) {
        this.idAzienda = idAzienda;
    }

    public Date getStilatura() {
        return stilatura;
    }

    public void setStilatura(Date stilatura) {
        this.stilatura = stilatura;
    }

    public float getValoreProduzione() {
        return valoreProduzione;
    }

    public void setValoreProduzione(float valoreProduzione) {
        this.valoreProduzione = valoreProduzione;
    }

    public float getValoreAggiunto() {
        return valoreAggiunto;
    }

    public void setValoreAggiunto(float valoreAggiunto) {
        this.valoreAggiunto = valoreAggiunto;
    }

    public float getMargineOperativoLordo() {
        return margineOperativoLordo;
    }

    public void setMargineOperativoLordo(float margineOperativoLordo) {
        this.margineOperativoLordo = margineOperativoLordo;
    }

    public float getRedditoOperativo() {
        return redditoOperativo;
    }

    public void setRedditoOperativo(float redditoOperativo) {
        this.redditoOperativo = redditoOperativo;
    }

    public float getRedditoCorrente() {
        return redditoCorrente;
    }

    public void setRedditoCorrente(float redditoCorrente) {
        this.redditoCorrente = redditoCorrente;
    }

    public float getRedditoAnteImposte() {
        return redditoAnteImposte;
    }

    public void setRedditoAnteImposte(float redditoAnteImposte) {
        this.redditoAnteImposte = redditoAnteImposte;
    }

    public float getRedditoNetto() {
        return redditoNetto;
    }

    public void setRedditoNetto(float redditoNetto) {
        this.redditoNetto = redditoNetto;
    }

    public float getVariazioniSuMaterie(){
        return (this.valoreProduzione - this.valoreAggiunto);
    }

    public float getCostoPersonale(){
        return (this.valoreAggiunto - this.margineOperativoLordo);
    }

    public float getAmmortamenti(){
        return (this.margineOperativoLordo - this.redditoOperativo);
    }

    public float getSaldoAreaFinanziaria(){
        return (this.redditoOperativo - this.redditoCorrente);
    }

    public float getSaldoAreaStraordinaria(){
        return (this.redditoCorrente - this.redditoAnteImposte);
    }

    public float getImposteSulReddito(){
        return (this.redditoAnteImposte - this.redditoNetto);
    }

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
