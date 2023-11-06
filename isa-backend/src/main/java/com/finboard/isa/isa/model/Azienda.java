package com.finboard.isa.isa.model;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.boot.context.properties.bind.DefaultValue;


/**
 * Class Azienda, entity "aziende" for relation creation into the database
 * author emanuele malimpensa
 * version 0.1
 * */

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

    /**
     *params null, empty constructor for database relation creation with hybernate
     *return class Azienda instance*/
    public Azienda() {
    }

    /**
     * Constructor method for instance creation
     *params String nome, String indirizzo, int dipendenti, int codice_ateco
     *return class Azienda instance*/
    public Azienda(String nome, String indirizzo,
                   int dipendenti, Long id, int codice_ateco) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.dipendenti = dipendenti;
        this.id = id;
        this.codice_ateco = codice_ateco;
    }
    /**
     * return the azienda's name
     *params null
     *return String nome of azienda instance*/
    public String getNome() {
        return nome;
    }
    /**
     * set the azienda's name
     *params String nome
     *return void*/
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * return the azienda's address
     *params null
     *return String azienda's address*/
    public String getIndirizzo() {
        return indirizzo;
    }

    /**
     * set azienda's address
     *params String indirizzo
     *return void*/
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    /**
     * return the number of employees in the azienda
     *params null
     *return int #dipendenti*/
    public int getDipendenti() {
        return dipendenti;
    }

    /**
     * set the number of dipendenti
     *params int dipendenti
     *return void*/
    public void setDipendenti(int dipendenti) {
        this.dipendenti = dipendenti;
    }

    /**
     * return the id of the azienda
     *params null
     *return Long id*/
    public Long getId() {
        return id;
    }

    /**
     * set the id of the azienda instance
     *params Long id
     *return void*/
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * return the sector of the firm
     *params null
     *return String settore*/
    public String getSettore() {
        return settore;
    }

    /**
     * set the sector of the Azienda instance
     *params String settore
     *return void*/
    public void setSettore(String settore) {
        this.settore = settore;
    }

    /**
     * return the codice_ateco of the Azienda instance
     *params null
     *return int codice_ateco*/
    public int getCodice_ateco() {
        return codice_ateco;
    }

    /**
     * set the codice_ateco
     *params int codice_ateco
     *return void*/
    public void setCodice_ateco(int codice_ateco) {
        this.codice_ateco = codice_ateco;
    }

    /**
     * toString method override
     *params null
     *return String toString instance stamp*/

    @Override
    public String toString() {
        return "Azienda{" +
                "nome='" + nome + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", dipendenti=" + dipendenti +
                ", id=" + id +
                ", codice_ateco=" + codice_ateco +
                ", settore=" + settore +
                '}';
    }
}
