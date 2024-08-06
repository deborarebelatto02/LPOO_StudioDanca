/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.cc.lpoo_studiodanca.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author debor
 */
@Entity
@Table(name = "tb_professor")
public class Professores extends Pessoas implements Serializable {

    public Professores() {
        holerites = new ArrayList<>();
    }

    private String nome;

    @Override
    public String toString() {
        return nome; 
    }

    @Column(name = "professor_data_admissao")
    private Calendar dataAdmissao;

    @OneToMany(mappedBy = "professor")
    private List<FolhaPagamento> holerites = new ArrayList<>();

    @OneToMany(mappedBy = "professor")
    private List<Modalidade> modalidades = new ArrayList<>();

    public Calendar getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Calendar dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public List<FolhaPagamento> getHolerites() {
        return holerites;
    }

    public void addFolhaPagamentoMes(FolhaPagamento f) {
        holerites.add(f);
    }

    public List<Modalidade> getModalidades() {
        return modalidades;
    }

    public void addModalidade(Modalidade m) {
        modalidades.add(m);
        m.setProfessor(this);
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    

}
