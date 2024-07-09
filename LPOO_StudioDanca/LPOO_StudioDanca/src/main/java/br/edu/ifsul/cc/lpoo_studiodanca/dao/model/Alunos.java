/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.cc.lpoo_studiodanca.dao.model;

import java.util.Calendar;
import javax.persistence.Entity;

/**
 *
 * @author debor
 */
@Entity
public class Alunos extends Pessoas{
    private Calendar dataInicio;
    private int dataPgto;

    public Calendar getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Calendar dataInicio) {
        this.dataInicio = dataInicio;
    }

    public int getDataPgto() {
        return dataPgto;
    }

    public void setDataPgto(int dataPgto) {
        this.dataPgto = dataPgto;
    }
    
    
}
