package com.finboard.isa.isa.model;

import java.sql.Date;
import java.util.HashMap;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jdk.jfr.DataAmount;

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

    public Date getStilatura() {
        return stilatura;
    }

    public void setStilatura(Date stilatura) {
        this.stilatura = stilatura;
    }

    public StatoPatrimoniale() {
    }

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

    public float getImmobilizzazioniMateriali() {
        return immobilizzazioniMateriali;
    }

    public void setImmobilizzazioniMateriali(float immobilizzazioniMateriali) {
        this.immobilizzazioniMateriali = immobilizzazioniMateriali;
    }

    public float getImmobilizzazioniImmateriali() {
        return immobilizzazioniImmateriali;
    }

    public void setImmobilizzazioniImmateriali(float immobilizzazioniImmateriali) {
        this.immobilizzazioniImmateriali = immobilizzazioniImmateriali;
    }

    public float getImmobilizzazioniFinanziarie() {
        return immobilizzazioniFinanziarie;
    }

    public void setImmobilizzazioniFinanziarie(float immobilizzazioniFinanziarie) {
        this.immobilizzazioniFinanziarie = immobilizzazioniFinanziarie;
    }

    public float getRimanenzeMagazzino() {
        return rimanenzeMagazzino;
    }

    public void setRimanenzeMagazzino(float rimanenzeMagazzino) {
        this.rimanenzeMagazzino = rimanenzeMagazzino;
    }

    public float getLiquiditaDifferite() {
        return liquiditaDifferite;
    }

    public void setLiquiditaDifferite(float liquiditaDifferite) {
        this.liquiditaDifferite = liquiditaDifferite;
    }

    public float getLiquiditaImmediate() {
        return liquiditaImmediate;
    }

    public void setLiquiditaImmediate(float liquiditaImmediate) {
        this.liquiditaImmediate = liquiditaImmediate;
    }

    public float getCapitaleSociale() {
        return capitaleSociale;
    }

    public void setCapitaleSociale(float capitaleSociale) {
        this.capitaleSociale = capitaleSociale;
    }

    public float getRiservaLegale() {
        return riservaLegale;
    }

    public void setRiservaLegale(float riservaLegale) {
        this.riservaLegale = riservaLegale;
    }

    public float getRiservaStraordinaria() {
        return riservaStraordinaria;
    }

    public void setRiservaStraordinaria(float riservaStraordinaria) {
        this.riservaStraordinaria = riservaStraordinaria;
    }

    public float getRiservaPartecipazioni() {
        return riservaPartecipazioni;
    }

    public void setRiservaPartecipazioni(float riservaPartecipazioni) {
        this.riservaPartecipazioni = riservaPartecipazioni;
    }

    public float getTfrConsolidato() {
        return tfrConsolidato;
    }

    public void setTfrConsolidato(float tfrConsolidato) {
        this.tfrConsolidato = tfrConsolidato;
    }

    public float getDebitiBancheConsolidati() {
        return debitiBancheConsolidati;
    }

    public void setDebitiBancheConsolidati(float debitiBancheConsolidati) {
        this.debitiBancheConsolidati = debitiBancheConsolidati;
    }

    public float getDebitiFornitoriConsolidati() {
        return debitiFornitoriConsolidati;
    }

    public void setDebitiFornitoriConsolidati(float debitiFornitoriConsolidati) {
        this.debitiFornitoriConsolidati = debitiFornitoriConsolidati;
    }

    public float getDebitiTributariConsolidati() {
        return debitiTributariConsolidati;
    }

    public void setDebitiTributariConsolidati(float debitiTributariConsolidati) {
        this.debitiTributariConsolidati = debitiTributariConsolidati;
    }

    public float getTfrCorrente() {
        return tfrCorrente;
    }

    public void setTfrCorrente(float tfrCorrente) {
        this.tfrCorrente = tfrCorrente;
    }

    public float getDebitiBancheCorrenti() {
        return debitiBancheCorrenti;
    }

    public void setDebitiBancheCorrenti(float debitiBancheCorrenti) {
        this.debitiBancheCorrenti = debitiBancheCorrenti;
    }

    public float getDebitiFornitoriCorrenti() {
        return debitiFornitoriCorrenti;
    }

    public void setDebitiFornitoriCorrenti(float debitiFornitoriCorrenti) {
        this.debitiFornitoriCorrenti = debitiFornitoriCorrenti;
    }

    public float getDebitiTitoliAzionari() {
        return debitiTitoliAzionari;
    }

    public void setDebitiTitoliAzionari(float debitiTitoliAzionari) {
        this.debitiTitoliAzionari = debitiTitoliAzionari;
    }

    public float getDebitiTributariCorrenti() {
        return debitiTributariCorrenti;
    }

    public void setDebitiTributariCorrenti(float debitiTributariCorrenti) {
        this.debitiTributariCorrenti = debitiTributariCorrenti;
    }

    public float getDebitiAzionisti() {
        return debitiAzionisti;
    }

    public void setDebitiAzionisti(float debitiAzionisti) {
        this.debitiAzionisti = debitiAzionisti;
    }

    public float getAttivoCircolante(){
        return (this.rimanenzeMagazzino + this.liquiditaDifferite + this.liquiditaImmediate);
    }
    public float getImpieghi(){
        return (this.immobilizzazioniFinanziarie + this.immobilizzazioniMateriali + this.immobilizzazioniImmateriali);
    }
    public float getAttivo(){
        return (getImpieghi() + getAttivoCircolante());
    }

    public float getRiserve(){
        return (this.riservaLegale + this.riservaPartecipazioni + this.riservaStraordinaria);
    }
    public float getPatrimonioNetto(){
        return (this.capitaleSociale + getRiserve());
    }
    public float getPassivitaCorrenti(){
        return (this.debitiBancheCorrenti + this.debitiFornitoriCorrenti +
                this.debitiTributariCorrenti + this.tfrCorrente +
                this.debitiTitoliAzionari + this.debitiAzionisti);
    }
    public float getPassivitaConsolidate(){
        return (this.tfrConsolidato + this.debitiBancheConsolidati +
                this.debitiFornitoriConsolidati + this.debitiTributariConsolidati);
    }
    public float getPassivo(){
        return (getPatrimonioNetto() + getPassivitaConsolidate() + getPassivitaCorrenti());
    }

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
