package com.finboard.isa.isa.model;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.boot.context.properties.bind.DefaultValue;


@Entity
@Transactional
@Table(name="aziende")
public class Azienda {

    @Column(columnDefinition = "varchar(50) not null ",unique = true)
    String nome;
    @Column(columnDefinition = "varchar(50) default 'defaultSettore'")
    String settore;
    String indirizzo;
    int dipendenti;
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    int codice_ateco;

    public Azienda() {
    }

    public Azienda(String nome, String indirizzo,
                   int dipendenti, Long id, int codice_ateco) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.dipendenti = dipendenti;
        this.id = id;
        this.codice_ateco = codice_ateco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public int getDipendenti() {
        return dipendenti;
    }

    public void setDipendenti(int dipendenti) {
        this.dipendenti = dipendenti;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSettore() {
        return settore;
    }

    public void setSettore(String settore) {
        this.settore = settore;
    }

    public int getCodice_ateco() {
        return codice_ateco;
    }

    public void setCodice_ateco(int codice_ateco) {
        this.codice_ateco = codice_ateco;
    }

    @Override
    public String toString() {
        return "Azienda{" +
                "nome='" + nome + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", dipendenti=" + dipendenti +
                ", id=" + id +
                ", codice_ateco=" + codice_ateco +
                '}';
    }
}
