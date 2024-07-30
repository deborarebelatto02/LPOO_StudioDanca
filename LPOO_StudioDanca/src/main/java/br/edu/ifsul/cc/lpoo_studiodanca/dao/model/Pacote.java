/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.cc.lpoo_studiodanca.dao.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author debor
 */
@Entity
public class Pacote implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(length = 120)
    private String descricao;

    @Column(precision = 10, scale = 2)
    private double valor;

    @OneToMany(mappedBy = "pacote")
    private List<ItensContrato> itensContrato;
    
    @ManyToOne
    @JoinColumn(name = "modalidade_id")
    private Modalidade modalidade;

    // Construtores, getters e setters

    public Pacote() {
    }

    public Pacote(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Modalidade getModalidade() {
        return modalidade;
    }

    public void setModalidade(Modalidade modalidade) {
        this.modalidade = modalidade;
    }
}
