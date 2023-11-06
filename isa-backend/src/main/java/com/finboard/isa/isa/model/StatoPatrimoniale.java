package com.finboard.isa.isa.model;

import java.sql.Date;
import java.util.HashMap;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jdk.jfr.DataAmount;


/**
 * Class StatoPatrimoniale, entity "stato_patrimoniale" for relation creation into the database
 * author emanuele malimpensa
 * version 0.1
 * */

@Entity
@Transactional
@Table(name="stato_patrimoniale")
public class StatoPatrimoniale {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_stato_patrimoniale")
    Long id;
    @ManyToOne
    @JoinColumn(name = "id")
    Azienda idAzienda;

    float immobilizzazioniMateriali;
    float immobilizzazioniImmateriali;
    float immobilizzazioniFinanziarie;
    float rimanenzeMagazzino;
    float liquiditaDifferite;
    float liquiditaImmediate;
    float capitaleSociale;
    float riservaLegale;
    float riservaStraordinaria;
    float riservaPartecipazioni;
    float tfrConsolidato;
    float debitiBancheConsolidati;
    float debitiFornitoriConsolidati;
    float debitiTributariConsolidati;
    float tfrCorrente;
    float debitiBancheCorrenti;
    float debitiFornitoriCorrenti;
    float debitiTitoliAzionari;
    float debitiTributariCorrenti;
    float debitiAzionisti;
    Date stilatura;

    /**
     * get the stilatura field
     *param
     *return Date*/
    public Date getStilatura() {
        return stilatura;
    }

    /**
     * set the stilatura field
     *param stilatura Date
     *return void*/
    public void setStilatura(Date stilatura) {
        this.stilatura = stilatura;
    }


    /**
     * empty constructor for database relation creation with hybernate
     *param
     *return class StatoPatrimoiale instance*/
    public StatoPatrimoniale() {
    }


    /**
     * Constructor method for instance creation
     *param id Long, idAzienda Azienda, immobilizzazioniMateriali float, immobilizzazioniImmateriali float, immobilizzazioniFinanziarie float, rimanenzeMagazzino float, liquiditaDifferite float, liquiditaImmediate float, capitaleSociale float, riservaLegale float, riservaStraordinaria float, riservaPartecipazioni float, tfrConsolidato float, debitiBancheConsolidati float, debitiFornitoriConsolidati float, debitiTributariConsolidati float, tfrCorrente float, debitiBancheCorrenti float, debitiFornitoriCorrenti float, debitiTitoliAzionari float, debitiTributariCorrenti float, debitiAzionisti float
     *return StatoPatrimoniale instance*/
    public StatoPatrimoniale(Long id, Azienda idAzienda, float immobilizzazioniMateriali, float immobilizzazioniImmateriali, float immobilizzazioniFinanziarie, float rimanenzeMagazzino, float liquiditaDifferite, float liquiditaImmediate, float capitaleSociale, float riservaLegale, float riservaStraordinaria, float riservaPartecipazioni, float tfrConsolidato, float debitiBancheConsolidati, float debitiFornitoriConsolidati, float debitiTributariConsolidati, float tfrCorrente, float debitiBancheCorrenti, float debitiFornitoriCorrenti, float debitiTitoliAzionari, float debitiTributariCorrenti, float debitiAzionisti) {
        this.id = id;
        this.idAzienda = idAzienda;
        this.immobilizzazioniMateriali = immobilizzazioniMateriali;
        this.immobilizzazioniImmateriali = immobilizzazioniImmateriali;
        this.immobilizzazioniFinanziarie = immobilizzazioniFinanziarie;
        this.rimanenzeMagazzino = rimanenzeMagazzino;
        this.liquiditaDifferite = liquiditaDifferite;
        this.liquiditaImmediate = liquiditaImmediate;
        this.capitaleSociale = capitaleSociale;
        this.riservaLegale = riservaLegale;
        this.riservaStraordinaria = riservaStraordinaria;
        this.riservaPartecipazioni = riservaPartecipazioni;
        this.tfrConsolidato = tfrConsolidato;
        this.debitiBancheConsolidati = debitiBancheConsolidati;
        this.debitiFornitoriConsolidati = debitiFornitoriConsolidati;
        this.debitiTributariConsolidati = debitiTributariConsolidati;
        this.tfrCorrente = tfrCorrente;
        this.debitiBancheCorrenti = debitiBancheCorrenti;
        this.debitiFornitoriCorrenti = debitiFornitoriCorrenti;
        this.debitiTitoliAzionari = debitiTitoliAzionari;
        this.debitiTributariCorrenti = debitiTributariCorrenti;
        this.debitiAzionisti = debitiAzionisti;
    }

    /**
     * get the ID field
     *param
     *return Long Id*/
    public Long getId() {
        return id;
    }

    /**
     * set the Id field
     *param id Long
     *return void*/
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * get the Azienda field
     *param
     *return Azienda */
    public Azienda getIdAzienda() {
        return idAzienda;
    }

    /**
     * set the Azienda field
     *param  idAzienda Azienda
     *return void*/
    public void setIdAzienda(Azienda idAzienda) {
        this.idAzienda = idAzienda;
    }

    /**
     * get the Immobilizzazioni materiali field
     *param
     *return float*/
    public float getImmobilizzazioniMateriali() {
        return immobilizzazioniMateriali;
    }

    /**
     * set the Immobilizzazioni materiali field
     *param immobilizzazioniMateriali float
     *return void*/
    public void setImmobilizzazioniMateriali(float immobilizzazioniMateriali) {
        this.immobilizzazioniMateriali = immobilizzazioniMateriali;
    }

    /**
     * get the immobilizzazioni immateriali field
     *param
     *return float */
    public float getImmobilizzazioniImmateriali() {
        return immobilizzazioniImmateriali;
    }

    /**
     * set the immobilizzazioni immateriali field
     *param immobilizzazioniImmateriali float
     *return void*/
    public void setImmobilizzazioniImmateriali(float immobilizzazioniImmateriali) {
        this.immobilizzazioniImmateriali = immobilizzazioniImmateriali;
    }

    /**
     * get the immobilizzazioni finanziarie field
     *param
     *return float*/
    public float getImmobilizzazioniFinanziarie() {
        return immobilizzazioniFinanziarie;
    }

    /**
     * set the immobilizzazioni finanziarie field
     *param immobilizzazioniFinanziarie float
     *return void*/
    public void setImmobilizzazioniFinanziarie(float immobilizzazioniFinanziarie) {
        this.immobilizzazioniFinanziarie = immobilizzazioniFinanziarie;
    }

    /**
     * get the rimanenze di magazzino field
     *param
     *return float*/
    public float getRimanenzeMagazzino() {
        return rimanenzeMagazzino;
    }

    /**
     * set the rimanenze di magazzino field
     *param rimanenzeMagazzino float
     *return void*/
    public void setRimanenzeMagazzino(float rimanenzeMagazzino) {
        this.rimanenzeMagazzino = rimanenzeMagazzino;
    }

    /**
     * get the liquidita differite field
     *param
     *return float*/
    public float getLiquiditaDifferite() {
        return liquiditaDifferite;
    }

    /**
     * set the liquidita differite field
     *param liquiditaDifferite float
     *return void*/
    public void setLiquiditaDifferite(float liquiditaDifferite) {
        this.liquiditaDifferite = liquiditaDifferite;
    }

    /**
     * get the liquidita immediate field
     *param
     *return float*/
    public float getLiquiditaImmediate() {
        return liquiditaImmediate;
    }

    /**
     * set the liquidita immediate field
     *param float
     *return void*/
    public void setLiquiditaImmediate(float liquiditaImmediate) {
        this.liquiditaImmediate = liquiditaImmediate;
    }

    /**
     * get the capitale sociale field
     *params null
     *return float*/
    public float getCapitaleSociale() {
        return capitaleSociale;
    }

    /**
     * set the capitale sociale field
     *params float
     *return void*/
    public void setCapitaleSociale(float capitaleSociale) {
        this.capitaleSociale = capitaleSociale;
    }

    /**
     * get the riserva legale field
     *params null
     *return float*/
    public float getRiservaLegale() {
        return riservaLegale;
    }

    /**
     * set the riserva legale field
     *params float
     *return void*/
    public void setRiservaLegale(float riservaLegale) {
        this.riservaLegale = riservaLegale;
    }

    /**
     * get the riserva straordinaria field
     *params null
     *return float*/
    public float getRiservaStraordinaria() {
        return riservaStraordinaria;
    }

    /**
     * set the riserva straordinaria field
     *params float
     *return void*/
    public void setRiservaStraordinaria(float riservaStraordinaria) {
        this.riservaStraordinaria = riservaStraordinaria;
    }

    /**
     * get the riserva partecipazioni field
     *params null
     *return float*/
    public float getRiservaPartecipazioni() {
        return riservaPartecipazioni;
    }

    /**
     * set the riserva partecipazioni field
     *params float
     *return void*/
    public void setRiservaPartecipazioni(float riservaPartecipazioni) {
        this.riservaPartecipazioni = riservaPartecipazioni;
    }

    /**
     * get the tfr consolidato field
     *params null
     *return float*/
    public float getTfrConsolidato() {
        return tfrConsolidato;
    }

    /**
     * set the tfr consolidato field
     *params float
     *return void*/
    public void setTfrConsolidato(float tfrConsolidato) {
        this.tfrConsolidato = tfrConsolidato;
    }

    /**
     * get the debiti banche consolidati field
     *params null
     *return float*/
    public float getDebitiBancheConsolidati() {
        return debitiBancheConsolidati;
    }

    /**
     * set the debiti banche consolidati field
     *params float
     *return void*/
    public void setDebitiBancheConsolidati(float debitiBancheConsolidati) {
        this.debitiBancheConsolidati = debitiBancheConsolidati;
    }

    /**
     * get the debiti fornitori consolidati field
     *params null
     *return float*/
    public float getDebitiFornitoriConsolidati() {
        return debitiFornitoriConsolidati;
    }

    /**
     * set the debiti fornitori consolidati field
     *params float
     *return void*/
    public void setDebitiFornitoriConsolidati(float debitiFornitoriConsolidati) {
        this.debitiFornitoriConsolidati = debitiFornitoriConsolidati;
    }

    /**
     * get the debiti tributari consolidati field
     *params null
     *return float*/
    public float getDebitiTributariConsolidati() {
        return debitiTributariConsolidati;
    }

    /**
     * set the debiti tributari consolidati field
     *params float
     *return void*/
    public void setDebitiTributariConsolidati(float debitiTributariConsolidati) {
        this.debitiTributariConsolidati = debitiTributariConsolidati;
    }

    /**
     * get the tfr corrente field
     *params null
     *return float*/
    public float getTfrCorrente() {
        return tfrCorrente;
    }

    /**
     * set the tfr corrente field
     *params float
     *return void*/
    public void setTfrCorrente(float tfrCorrente) {
        this.tfrCorrente = tfrCorrente;
    }

    /**
     * get the debiti banche correnti field
     *params null
     *return float*/
    public float getDebitiBancheCorrenti() {
        return debitiBancheCorrenti;
    }

    /**
     * set the debiti banche correnti field
     *params float
     *return void*/
    public void setDebitiBancheCorrenti(float debitiBancheCorrenti) {
        this.debitiBancheCorrenti = debitiBancheCorrenti;
    }

    /**
     * get the debiti fornitori correnti field
     *params null
     *return float*/
    public float getDebitiFornitoriCorrenti() {
        return debitiFornitoriCorrenti;
    }

    /**
     * set the debiti fornitori correnti field
     *params float
     *return void*/
    public void setDebitiFornitoriCorrenti(float debitiFornitoriCorrenti) {
        this.debitiFornitoriCorrenti = debitiFornitoriCorrenti;
    }

    /**
     * get the debiti titoli azionari field
     *params null
     *return float*/
    public float getDebitiTitoliAzionari() {
        return debitiTitoliAzionari;
    }

    /**
     * set the debiti titoli azionari field
     *params float
     *return void*/
    public void setDebitiTitoliAzionari(float debitiTitoliAzionari) {
        this.debitiTitoliAzionari = debitiTitoliAzionari;
    }

    /**
     * get the debiti tributari correnti field
     *params null
     *return float*/
    public float getDebitiTributariCorrenti() {
        return debitiTributariCorrenti;
    }

    /**
     * set the debiti tributari correnti field
     *params float
     *return void*/
    public void setDebitiTributariCorrenti(float debitiTributariCorrenti) {
        this.debitiTributariCorrenti = debitiTributariCorrenti;
    }

    /**
     * get the debiti azionisti field
     *params null
     *return float*/
    public float getDebitiAzionisti() {
        return debitiAzionisti;
    }

    /**
     * set the debiti azionisti field
     *params float
     *return void*/
    public void setDebitiAzionisti(float debitiAzionisti) {
        this.debitiAzionisti = debitiAzionisti;
    }

    /**
     * get the attivo circolante amount, which is calculated as (liquidita_differite + liquidita_immediate)
     *params null
     *return float*/
    public float getAttivoCircolante(){
        return (this.rimanenzeMagazzino + this.liquiditaDifferite + this.liquiditaImmediate);
    }

    /**
     * get the impieghi amount, which is calculated as (immobilizzazioni finanziarie + immobilizzazioni materiali + immobilizzazioni immateriali)
     *params null
     *return float*/
    public float getImpieghi(){
        return (this.immobilizzazioniFinanziarie + this.immobilizzazioniMateriali + this.immobilizzazioniImmateriali);
    }

    /**
     * get the attivo amount, which is calculated as (impieghi + attivo circolante)
     *params null
     *return float*/
    public float getAttivo(){
        return (getImpieghi() + getAttivoCircolante());
    }

    /**
     * get the riserve amount, which is calculated as (riserva legale + riserva partecipazioni + riserva straordinaria)
     *params null
     *return float*/
    public float getRiserve(){
        return (this.riservaLegale + this.riservaPartecipazioni + this.riservaStraordinaria);
    }

    /**
     * get the patrimonio netto amount, which is calculated as (capitale sociale + riserve)
     *params null
     *return float*/
    public float getPatrimonioNetto(){
        return (this.capitaleSociale + getRiserve());
    }

    /**
     * get the passivita correnti amount, which is calculated as (debiti banche correnti + debiti fornitori correnti + debiti tributari correnti + debiti azionisti + debiti titoli azionari + tfr corrente)
     *params null
     *return float*/
    public float getPassivitaCorrenti(){
        return (this.debitiBancheCorrenti + this.debitiFornitoriCorrenti +
                this.debitiTributariCorrenti + this.tfrCorrente +
                this.debitiTitoliAzionari + this.debitiAzionisti);
    }

    /**
     * get the passivita consolidate amount, which is calculated as (tfr consolidato + debiti banche consolidati + debiti fornitori consolidati + debiti tributari consolidati)
     *params null
     *return float*/
    public float getPassivitaConsolidate(){
        return (this.tfrConsolidato + this.debitiBancheConsolidati +
                this.debitiFornitoriConsolidati + this.debitiTributariConsolidati);
    }

    /**
     * get the passivo amount, which is calculated as (patrimonio netto + passivita consolidate + passivita correnti)
     *params null
     *return float*/
    public float getPassivo(){
        return (getPatrimonioNetto() + getPassivitaConsolidate() + getPassivitaCorrenti());
    }

    /**
     * method which allows to construct an object containing every field of the instance
     * and every calculated value (e.g. passivo or attivo), mapped with a key value
     *params null
     *return HashMap[String,Float]*/
    public HashMap<String,Float> dizionarioValori(){
        HashMap<String,Float> toRet = new HashMap<>();
        toRet.put("passivo",this.getPassivo());
        toRet.put("passivitaConsolidate",this.getPassivitaConsolidate());
        toRet.put("passivitaCorrenti",this.getPassivitaCorrenti());
        toRet.put("patrimonioNetto",this.getPatrimonioNetto());
        toRet.put("riserve",this.getRiserve());
        toRet.put("attivo",this.getAttivo());
        toRet.put("impieghi",this.getImpieghi());
        toRet.put("attivoCircolante",this.getAttivoCircolante());
        toRet.put("debitiAzionisti",this.getDebitiAzionisti());
        toRet.put("debitiTributariCorrenti",this.getDebitiTributariCorrenti());
        toRet.put("debitiTitoliAzionario",this.getDebitiTitoliAzionari());
        toRet.put("debitiFornitoriCorrenti",this.getDebitiFornitoriCorrenti());
        toRet.put("debitiBancheCorrenti",this.getDebitiBancheCorrenti());
        toRet.put("tfrCorrenti",this.getTfrCorrente());
        toRet.put("debitiTributariConsolidati",this.getDebitiTributariConsolidati());
        toRet.put("debitiVersoFornitoriConsolidati",this.getDebitiFornitoriConsolidati());
        toRet.put("debitiVersoBancheConsolidati",this.getDebitiBancheConsolidati());
        toRet.put("tfrConsolidato",this.getTfrConsolidato());
        toRet.put("riservaPartecipazioni",this.getRiservaPartecipazioni());
        toRet.put("riservaStraordinaria",this.getRiservaStraordinaria());
        toRet.put("riservaLegale",this.getRiservaLegale());
        toRet.put("capitaleSociale",this.getCapitaleSociale());
        toRet.put("liquiditaImmediate",this.getLiquiditaImmediate());
        toRet.put("liquiditaDifferite",this.getLiquiditaDifferite());
        toRet.put("rimanenzeDiMagazzino",this.getRimanenzeMagazzino());
        toRet.put("immobilizzazioniFinanziarie",this.getImmobilizzazioniFinanziarie());
        toRet.put("immobilizzazioniImmateriali",this.getImmobilizzazioniImmateriali());
        toRet.put("immobilizzazioniMateriali",this.getImmobilizzazioniMateriali());

        return toRet;
    }


    /**
     * toString method override
     *params null
     *return String toString instance stamp*/
    @Override
    public String toString() {
        return "StatoPatrimoniale{" +
                "id=" + id +
                ", idAzienda=" + idAzienda +
                ", immobilizzazioniMateriali=" + immobilizzazioniMateriali +
                ", immobilizzazioniImmateriali=" + immobilizzazioniImmateriali +
                ", immobilizzazioniFinanziarie=" + immobilizzazioniFinanziarie +
                ", rimanenzeMagazzino=" + rimanenzeMagazzino +
                ", liquiditaDifferite=" + liquiditaDifferite +
                ", liquiditaImmediate=" + liquiditaImmediate +
                ", capitaleSociale=" + capitaleSociale +
                ", riservaLegale=" + riservaLegale +
                ", riservaStraordinaria=" + riservaStraordinaria +
                ", riservaPartecipazioni=" + riservaPartecipazioni +
                ", tfrConsolidato=" + tfrConsolidato +
                ", debitiBancheConsolidati=" + debitiBancheConsolidati +
                ", debitiFornitoriConsolidati=" + debitiFornitoriConsolidati +
                ", debitiTributariConsolidati=" + debitiTributariConsolidati +
                ", tfrCorrente=" + tfrCorrente +
                ", debitiBancheCorrenti=" + debitiBancheCorrenti +
                ", debitiFornitoriCorrenti=" + debitiFornitoriCorrenti +
                ", debitiTitoliAzionari=" + debitiTitoliAzionari +
                ", debitiTributariCorrenti=" + debitiTributariCorrenti +
                ", debitiAzionisti=" + debitiAzionisti +
                ", stilatura=" + stilatura +
                '}';
    }
}
