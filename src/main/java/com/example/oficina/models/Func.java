/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.oficina.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author Cast
 */
@Entity
public class Func implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date dtNascimento;
    private String cpf;
    private String email;
    private String telCel;
    private String telFix;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "orcamento_id", referencedColumnName = "id", nullable = false)
    private List<Orcamento> orcamento;

    public Func(String name, String cpf, Date dtNascimento, String email, String telFix, String telCel) {
        this.name = name;
        this.dtNascimento = dtNascimento;
        this.cpf = cpf;
        this.email = email;
        this.telCel = telCel;
        this.telFix = telFix;
    }

    public Func(String name, Date dtNascimento, String cpf, String email, String telCel, String telFix, List<Orcamento> orcamento) {
        this.name = name;
        this.dtNascimento = dtNascimento;
        this.cpf = cpf;
        this.email = email;
        this.orcamento = orcamento;
        this.telCel = telCel;
        this.telFix = telFix;
    }

    public Func() {
        //default
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Orcamento> getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(List<Orcamento> orcamento) {
        this.orcamento = orcamento;
    }

    public String getTelCel() {
        return telCel;
    }

    public void setTelCel(String telCel) {
        this.telCel = telCel;
    }

    public String getTelFix() {
        return telFix;
    }

    public void setTelFix(String telFix) {
        this.telFix = telFix;
    }

}
