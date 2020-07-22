/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.oficina.presenter;

import com.example.oficina.models.Func;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Cast
 */
public class FuncPresenter {

    private Long id;
    private String name;
    private Date dtNascimento;
    private String cpf;
    private String email;
    private List<OrcPresenter> orcamento;
    private String telCel;
    private String telFix;

    public FuncPresenter(Func func) {
        if (func != null) {
            this.id = func.getId();
            this.name = func.getName();
            this.dtNascimento = func.getDtNascimento();
            this.cpf = func.getCpf();
            this.email = func.getEmail();
            this.telCel = func.getTelCel();
            this.telFix = func.getTelFix();
            if (func.getOrcamento() != null) {
                this.orcamento = func.getOrcamento().stream().map(OrcPresenter::new).collect(Collectors.toList());
            }

        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getTelCel() {
        return telCel;
    }

    public String getTelFix() {
        return telFix;
    }

    public List<OrcPresenter> getOrcamento() {
        return orcamento;
    }

    public static List<FuncPresenter> listFromClients(List<Func> func) {
        return func.stream()
                .map(FuncPresenter::new)
                .collect(Collectors.toList());
    }

}
