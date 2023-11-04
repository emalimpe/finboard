package com.finboard.isa.isa.model;

import com.finboard.isa.isa.model.funzioniDiAnalisi.SelezioneApprofondimentiSemplice;
import com.finboard.isa.isa.service.AnalisiService;
import jakarta.transaction.Transactional;

import java.sql.Date;
import java.time.Year;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Transactional
class IndiciStruttura{
    float indiceRigidita;
    float indiceImmobilizzoMateriale;
    float indiceImmobilizzoImmateriale;
    float indiceImmobilizzoFinanziario;
    float indiceDiElasticita;
    float indiceDiDisponibilitaMagazzino;
    float indiceDiLiquiditaTotale;
    float indiceDiLiquiditaImmediata;
    float indiceAutonomiaFinanziaria;
    float indiceIndebitamento;
    float indiceIndebitamentoConsolidato;
    float indiceIndebitamentoCorrente;
    float indiceIndebitamentoPermanente;
    float quozienteRigiditaImpieghi;
    float quozienteElasticitaImpieghi;
    float quozienteIndebitamento;
    float quozienteConsolidamentoPassivo;
    float quozienteEsigibilitaPassivo;

    public float getQuozienteRigiditaImpieghi() {
        return quozienteRigiditaImpieghi;
    }

    public void setQuozienteRigiditaImpieghi(float quozienteRigiditaImpieghi) {
        this.quozienteRigiditaImpieghi = quozienteRigiditaImpieghi;
    }

    public float getQuozienteElasticitaImpieghi() {
        return quozienteElasticitaImpieghi;
    }

    public void setQuozienteElasticitaImpieghi(float quozienteElasticitaImpieghi) {
        this.quozienteElasticitaImpieghi = quozienteElasticitaImpieghi;
    }

    public float getQuozienteIndebitamento() {
        return quozienteIndebitamento;
    }

    public void setQuozienteIndebitamento(float quozienteIndebitamento) {
        this.quozienteIndebitamento = quozienteIndebitamento;
    }

    public float getQuozienteConsolidamentoPassivo() {
        return quozienteConsolidamentoPassivo;
    }

    public void setQuozienteConsolidamentoPassivo(float quozienteConsolidamentoPassivo) {
        this.quozienteConsolidamentoPassivo = quozienteConsolidamentoPassivo;
    }

    public float getQuozienteEsigibilitaPassivo() {
        return quozienteEsigibilitaPassivo;
    }

    public void setQuozienteEsigibilitaPassivo(float quozienteEsigibilitaPassivo) {
        this.quozienteEsigibilitaPassivo = quozienteEsigibilitaPassivo;
    }

    public void setIndiceRigidita(float indiceRigidita) {
        this.indiceRigidita = indiceRigidita;
    }
    public void setIndiceImmobilizzoMateriale(float indiceImmobilizzoMateriale) {
        this.indiceImmobilizzoMateriale = indiceImmobilizzoMateriale;
    }

    public void setIndiceImmobilizzoImmateriale(float indiceImmobilizzoImmateriale) {
        this.indiceImmobilizzoImmateriale = indiceImmobilizzoImmateriale;
    }

    public void setIndiceImmobilizzoFinanziario(float indiceImmobilizzoFinanziario) {
        this.indiceImmobilizzoFinanziario = indiceImmobilizzoFinanziario;
    }

    public void setIndiceDiElasticita(float indiceDiElasticita) {
        this.indiceDiElasticita = indiceDiElasticita;
    }

    public void setIndiceAutonomiaFinanziaria(float indiceAutonomiaFinanziaria) {
        this.indiceAutonomiaFinanziaria = indiceAutonomiaFinanziaria;
    }

    public void setIndiceDiDisponibilitaMagazzino(float indiceDiDisponibilitaMagazzino) {
        this.indiceDiDisponibilitaMagazzino = indiceDiDisponibilitaMagazzino;
    }

    public void setIndiceDiLiquiditaImmediata(float indiceDiLiquiditaImmediata) {
        this.indiceDiLiquiditaImmediata = indiceDiLiquiditaImmediata;
    }

    public void setIndiceDiLiquiditaTotale(float indiceDiLiquiditaTotale) {
        this.indiceDiLiquiditaTotale = indiceDiLiquiditaTotale;
    }

    public void setIndiceIndebitamento(float indiceIndebitamento) {
        this.indiceIndebitamento = indiceIndebitamento;
    }

    public void setIndiceIndebitamentoConsolidato(float indiceIndebitamentoConsolidato) {
        this.indiceIndebitamentoConsolidato = indiceIndebitamentoConsolidato;
    }

    public void setIndiceIndebitamentoCorrente(float indiceIndebitamentoCorrente) {
        this.indiceIndebitamentoCorrente = indiceIndebitamentoCorrente;
    }

    public void setIndiceIndebitamentoPermanente(float indiceIndebitamentoPermanente) {
        this.indiceIndebitamentoPermanente = indiceIndebitamentoPermanente;
    }

    public float getIndiceRigidita() {
        return indiceRigidita;
    }

    public float getIndiceImmobilizzoMateriale() {
        return indiceImmobilizzoMateriale;
    }

    public float getIndiceImmobilizzoImmateriale() {
        return indiceImmobilizzoImmateriale;
    }

    public float getIndiceImmobilizzoFinanziario() {
        return indiceImmobilizzoFinanziario;
    }

    public float getIndiceDiElasticita() {
        return indiceDiElasticita;
    }

    public float getIndiceDiDisponibilitaMagazzino() {
        return indiceDiDisponibilitaMagazzino;
    }

    public float getIndiceDiLiquiditaTotale() {
        return indiceDiLiquiditaTotale;
    }

    public float getIndiceDiLiquiditaImmediata() {
        return indiceDiLiquiditaImmediata;
    }

    public float getIndiceAutonomiaFinanziaria() {
        return indiceAutonomiaFinanziaria;
    }

    public float getIndiceIndebitamento() {
        return indiceIndebitamento;
    }

    public float getIndiceIndebitamentoConsolidato() {
        return indiceIndebitamentoConsolidato;
    }

    public float getIndiceIndebitamentoCorrente() {
        return indiceIndebitamentoCorrente;
    }

    public float getIndiceIndebitamentoPermanente() {
        return indiceIndebitamentoPermanente;
    }

    public HashMap<String,Float> dizionarioValori(){
        HashMap<String,Float> toRet = new HashMap<>();
        toRet.put("indiceAutonomiaFinanziaria",this.getIndiceAutonomiaFinanziaria());
        toRet.put("indiceDiDisponibilitaMagazzino",this.getIndiceDiDisponibilitaMagazzino());
        toRet.put("indiceDiElasticita",this.getIndiceDiElasticita());
        toRet.put("indiceDiLiquiditaImmediata",this.getIndiceDiLiquiditaImmediata());
        toRet.put("indiceDiLiquiditaTotale",this.getIndiceDiLiquiditaTotale());
        toRet.put("indiceDiImmobilizzazioneFinanziaria",this.getIndiceImmobilizzoFinanziario());
        toRet.put("indiceDiIndebitamento",this.getIndiceIndebitamento());
        toRet.put("indiceDiImmobilizzazioneImmateriale",this.getIndiceImmobilizzoImmateriale());
        toRet.put("indiceDiRigidita",this.getIndiceRigidita());
        toRet.put("indiceDiIndebitamentoCorrente",this.getIndiceIndebitamentoCorrente());
        toRet.put("indiceDiImmobilizzazioneMateriale",this.getIndiceImmobilizzoMateriale());
        toRet.put("indiceDiIndebitamentoPermanente",this.getIndiceIndebitamentoPermanente());
        toRet.put("indiceDiIndebitamentoConsolidato",this.getIndiceIndebitamentoConsolidato());
        toRet.put("quozienteDiRigiditaDegliImpieghi",this.getQuozienteRigiditaImpieghi());
        toRet.put("quozienteDiIndebitamento",this.getQuozienteIndebitamento());
        toRet.put("quozienteDiConsolidamentoDelPassivo",this.getQuozienteConsolidamentoPassivo());
        toRet.put("quozienteDiElasticitaDegliImpieghi",this.getQuozienteElasticitaImpieghi());
        toRet.put("quozienteDiEsigibilitaDelPassivo",this.getQuozienteEsigibilitaPassivo());

        return toRet;
    }
}

@Transactional
class SoliditaPatrimoniale{
    float quozienteStrutturaPrimario;
    float quozienteStrutturaSecondario;
    float margineStrutturaPrimario;
    float margineStrutturaSecondario;

    public float getQuozienteStrutturaPrimario() {
        return quozienteStrutturaPrimario;
    }

    public void setQuozienteStrutturaPrimario(float quozienteStrutturaPrimario) {
        this.quozienteStrutturaPrimario = quozienteStrutturaPrimario;
    }

    public float getQuozienteStrutturaSecondario() {
        return quozienteStrutturaSecondario;
    }

    public void setQuozienteStrutturaSecondario(float quozienteStrutturaSecondario) {
        this.quozienteStrutturaSecondario = quozienteStrutturaSecondario;
    }

    public float getMargineStrutturaPrimario() {
        return margineStrutturaPrimario;
    }

    public void setMargineStrutturaPrimario(float margineStrutturaPrimario) {
        this.margineStrutturaPrimario = margineStrutturaPrimario;
    }

    public float getMargineStrutturaSecondario() {
        return margineStrutturaSecondario;
    }

    public void setMargineStrutturaSecondario(float margineStrutturaSecondario) {
        this.margineStrutturaSecondario = margineStrutturaSecondario;
    }

    public HashMap<String,Float> dizionarioValori(){
        HashMap<String,Float> toRet = new HashMap<>();
        toRet.put("margineDiStrutturaPrimario",this.getMargineStrutturaPrimario());
        toRet.put("margineDiStrutturaSecondario",this.getMargineStrutturaSecondario());
        toRet.put("quozienteDiStrutturaPrimario",this.getQuozienteStrutturaPrimario());
        toRet.put("quozienteDiStrutturaSecondario",this.getQuozienteStrutturaSecondario());

        return toRet;
    }
}

@Transactional
class Tesoreria{
    float margineDisponibilita;
    float margineTesoreria;
    float quozienteDisponibilita;
    float capitaleCircolanteNetto;
    float quozienteTesoreria;

    public float getMargineDisponibilita() {
        return margineDisponibilita;
    }

    public void setMargineDisponibilita(float margineDisponibilita) {
        this.margineDisponibilita = margineDisponibilita;
    }

    public float getMargineTesoreria() {
        return margineTesoreria;
    }

    public void setMargineTesoreria(float margineTesoreria) {
        this.margineTesoreria = margineTesoreria;
    }

    public float getQuozienteDisponibilita() {
        return quozienteDisponibilita;
    }

    public void setQuozienteDisponibilita(float quozienteDisponibilita) {
        this.quozienteDisponibilita = quozienteDisponibilita;
    }

    public float getCapitaleCircolanteNetto() {
        return capitaleCircolanteNetto;
    }

    public void setCapitaleCircolanteNetto(float capitaleCircolanteNetto) {
        this.capitaleCircolanteNetto = capitaleCircolanteNetto;
    }

    public float getQuozienteTesoreria() {
        return quozienteTesoreria;
    }

    public void setQuozienteTesoreria(float quozienteTesoreria) {
        this.quozienteTesoreria = quozienteTesoreria;
    }

    public HashMap<String,Float> dizionarioValori(){
        HashMap<String,Float> toRet = new HashMap<>();
        toRet.put("margineTesoreria",this.getMargineTesoreria());
        toRet.put("quozienteTesoreria",this.getQuozienteTesoreria());
        toRet.put("capitaleCircolanteNetto",this.getCapitaleCircolanteNetto());
        toRet.put("quozienteDiDisponibilita",this.getQuozienteDisponibilita());
        toRet.put("margineDisponibilita",this.getMargineDisponibilita());
        return toRet;
    }
}

@Transactional
class RitorniAndRotazioni{
    float indiceRotazioneMagazzino;
    float indiceRotazioneCapitaleCircolante;
    float indiceRotazioneCapitaleInvestito;
    float ros;
    float roe;
    float roi;
    float molSuFatturato;
    float rod;

    public float getIndiceRotazioneMagazzino() {
        return indiceRotazioneMagazzino;
    }

    public void setIndiceRotazioneMagazzino(float indiceRotazioneMagazzino) {
        this.indiceRotazioneMagazzino = indiceRotazioneMagazzino;
    }

    public float getIndiceRotazioneCapitaleCircolante() {
        return indiceRotazioneCapitaleCircolante;
    }

    public void setIndiceRotazioneCapitaleCircolante(float indiceRotazioneCapitaleCircolante) {
        this.indiceRotazioneCapitaleCircolante = indiceRotazioneCapitaleCircolante;
    }

    public float getIndiceRotazioneCapitaleInvestito() {
        return indiceRotazioneCapitaleInvestito;
    }

    public void setIndiceRotazioneCapitaleInvestito(float indiceRotazioneCapitaleInvestito) {
        this.indiceRotazioneCapitaleInvestito = indiceRotazioneCapitaleInvestito;
    }

    public float getRos() {
        return ros;
    }

    public void setRos(float ros) {
        this.ros = ros;
    }

    public float getRoe() {
        return roe;
    }

    public void setRoe(float roe) {
        this.roe = roe;
    }

    public float getRoi() {
        return roi;
    }

    public void setRoi(float roi) {
        this.roi = roi;
    }

    public float getMolSuFatturato() {
        return molSuFatturato;
    }

    public void setMolSuFatturato(float molSuFatturato) {
        this.molSuFatturato = molSuFatturato;
    }

    public float getRod() {
        return rod;
    }

    public void setRod(float rod) {
        this.rod = rod;
    }

    public HashMap<String,Float> dizionarioValori(){
        HashMap<String,Float> toRet = new HashMap<>();
        toRet.put("rod",this.getRod());
        toRet.put("roe",this.getRoe());
        toRet.put("roi",this.getRoi());
        toRet.put("ros",this.getRos());
        toRet.put("indiceDiRotazioneDelMagazzino",this.getIndiceRotazioneMagazzino());
        toRet.put("molSulFatturato",this.getMolSuFatturato());
        toRet.put("indiceDiRotazioneDelCapitaleCircolante",this.getIndiceRotazioneCapitaleCircolante());
        toRet.put("indiceDiRotazioneDelCapitaleInvestito",this.getIndiceRotazioneCapitaleInvestito());

        return toRet;
    }
}

@Transactional
public class Analisi {

    StatoPatrimoniale sp;
    ContoEconomico ce;
    Azienda azienda;
    IndiciStruttura is = new IndiciStruttura();
    SoliditaPatrimoniale solidita = new SoliditaPatrimoniale();
    Tesoreria tesoreria = new Tesoreria();
    RitorniAndRotazioni rar = new RitorniAndRotazioni();
    Date stilatura;
    SelezioneApprofondimentiSemplice sas = new SelezioneApprofondimentiSemplice();

    public Analisi(StatoPatrimoniale sp, ContoEconomico ce){
        this.sp = sp;
        this.ce = ce;
    }

    public Date getStilatura() {
        return stilatura;
    }

    public void setStilatura(Date stilatura) {
        this.stilatura = stilatura;
    }

    public Analisi(Azienda azienda){
        this.azienda = azienda;
    }

    public void setSp(StatoPatrimoniale sp) {
        this.sp = sp;
        if(this.stilatura == null) {
            setStilatura(sp.getStilatura());
        }
        if(this.ce != null){
            setStruttura();
            setRaR();
            setSolidita();
            setTesoreria();
        }
    }

    public void setCe(ContoEconomico ce) {
        this.ce = ce;
        if(this.stilatura == null) {
            setStilatura(ce.getStilatura());
        }
        if(this.sp != null){
            setStruttura();
            setRaR();
            setSolidita();
            setTesoreria();
        }
    }

    public void setAzienda(Azienda azienda) {this.azienda = azienda;}

    public void setStruttura(){

        this.is.setIndiceRigidita( (this.sp.getImmobilizzazioniFinanziarie() +
                                    this.sp.getImmobilizzazioniImmateriali() +
                                    this.sp.getImmobilizzazioniMateriali())  / (this.sp.getCapitaleSociale() + this.sp.getRiserve()));
        this.is.setIndiceImmobilizzoMateriale(this.sp.immobilizzazioniMateriali/this.sp.getAttivo());
        this.is.setIndiceImmobilizzoImmateriale(this.sp.immobilizzazioniImmateriali/this.sp.getAttivo());
        this.is.setIndiceImmobilizzoFinanziario(this.sp.immobilizzazioniFinanziarie/this.sp.getAttivo());
        this.is.setIndiceDiElasticita(this.sp.getAttivoCircolante()/this.sp.getAttivo());
        this.is.setIndiceDiDisponibilitaMagazzino(this.sp.rimanenzeMagazzino/this.sp.getAttivo());
        this.is.setIndiceDiLiquiditaTotale((this.sp.getLiquiditaDifferite()+this.sp.getLiquiditaImmediate())/this.sp.getAttivo());
        this.is.setIndiceDiLiquiditaImmediata(this.sp.getLiquiditaImmediate()/this.sp.getAttivo());
        this.is.setIndiceAutonomiaFinanziaria(this.sp.getPatrimonioNetto()/this.sp.getAttivo());
        this.is.setIndiceIndebitamento((this.sp.getPassivo()-this.sp.getPatrimonioNetto())/this.sp.getAttivo());
        this.is.setIndiceIndebitamentoConsolidato(this.sp.getPassivitaConsolidate()/this.sp.getAttivo());
        this.is.setIndiceIndebitamentoCorrente(this.sp.getPassivitaCorrenti()/this.sp.getAttivo());
        this.is.setIndiceIndebitamentoPermanente((this.sp.getPassivo()-this.sp.getPassivitaCorrenti()) / this.sp.getAttivo());
        this.is.setQuozienteRigiditaImpieghi(this.sp.getImpieghi()/this.sp.getAttivoCircolante());
        this.is.setQuozienteElasticitaImpieghi(this.sp.getAttivoCircolante()/this.sp.getImpieghi());
        this.is.setQuozienteIndebitamento((this.sp.getPassivitaCorrenti()+this.sp.getPassivitaConsolidate())/this.sp.getPatrimonioNetto());
        this.is.setQuozienteConsolidamentoPassivo(this.sp.getPassivitaConsolidate()/this.sp.getPassivitaCorrenti());
        this.is.setQuozienteEsigibilitaPassivo(this.sp.getPassivitaCorrenti()/this.sp.getPassivitaConsolidate());
    }

    public void setSolidita(){

        this.solidita.setMargineStrutturaPrimario(this.sp.getPatrimonioNetto() - this.sp.getImpieghi());
        this.solidita.setMargineStrutturaSecondario((this.sp.getPatrimonioNetto()+this.sp.getPassivitaConsolidate())-this.sp.getImpieghi());
        this.solidita.setQuozienteStrutturaPrimario(this.sp.getImpieghi()/this.sp.getAttivoCircolante());
        this.solidita.setQuozienteStrutturaSecondario((this.sp.getPatrimonioNetto()+this.sp.getPassivitaConsolidate())/this.sp.getImpieghi());

    }

    public void setTesoreria(){

        this.tesoreria.setMargineDisponibilita(this.sp.getAttivoCircolante()-this.sp.getPassivitaCorrenti());
        this.tesoreria.setMargineTesoreria((this.sp.getLiquiditaImmediate()+this.sp.getLiquiditaDifferite())/this.sp.getImpieghi());
        this.tesoreria.setQuozienteDisponibilita(this.sp.getAttivoCircolante()/this.sp.getPassivitaCorrenti());
        this.tesoreria.setCapitaleCircolanteNetto(this.sp.getAttivoCircolante()-this.sp.getPassivitaConsolidate());
        this.tesoreria.setQuozienteTesoreria((this.sp.liquiditaImmediate + this.sp.liquiditaDifferite)/this.sp.getPassivitaCorrenti());

    }

    public void setRaR(){
        this.rar.setIndiceRotazioneMagazzino(this.ce.getValoreProduzione()/(1+this.sp.getRimanenzeMagazzino()));
        this.rar.setIndiceRotazioneCapitaleCircolante(this.ce.getValoreProduzione()/(1+this.sp.getAttivoCircolante()));
        this.rar.setIndiceRotazioneCapitaleInvestito(this.ce.getValoreProduzione()/(1+this.sp.getAttivo()));
        this.rar.setRod(this.ce.getSaldoAreaFinanziaria()/(1+this.sp.getPassivitaCorrenti()+this.sp.getPassivitaConsolidate()));
        this.rar.setRoe(this.ce.getRedditoNetto()/(1+this.sp.getPatrimonioNetto()));
        this.rar.setRoi(this.ce.getRedditoOperativo()/(1+this.sp.getAttivo()));
        this.rar.setRos(this.ce.getRedditoAnteImposte()/(this.ce.getValoreProduzione()+1));
        this.rar.setMolSuFatturato(this.ce.getMargineOperativoLordo()/(1+this.ce.getValoreProduzione()));
    }

    /*public StatoPatrimoniale getSp() {
        return sp;
    }*/

    /*public ContoEconomico getCe() {
        return ce;
    }*/

    public Azienda getAzienda() {
        return azienda;
    }

    public HashMap<String, HashMap<String, Float>> getAnalisi(){
        HashMap<String,HashMap<String,Float>> toRet = new HashMap<>();
        toRet.put("statoPatrimoniale",this.sp.dizionarioValori());
        toRet.put("contoEconomico",this.ce.dizionarioValori());
        toRet.put("struttura",this.is.dizionarioValori());
        toRet.put("rigiditaRotazioni",this.rar.dizionarioValori());
        toRet.put("solidita",this.solidita.dizionarioValori());
        toRet.put("tesoreria",this.tesoreria.dizionarioValori());
        toRet.put("APPROFONDIMENTI",this.sas.selezione(toRet));
        return toRet;
    }

    @Override
    public String toString() {
        return "Analisi{" +
                "sp=" + sp +
                ", ce=" + ce +
                ", azienda=" + azienda +
                '}';
    }
}
