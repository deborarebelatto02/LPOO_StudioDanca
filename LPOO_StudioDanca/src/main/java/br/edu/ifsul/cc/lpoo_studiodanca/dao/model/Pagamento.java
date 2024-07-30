/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.cc.lpoo_studiodanca.dao.model;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.*;

/**
 *
 * @author debor
 */
@Entity
public class Pagamento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Temporal(TemporalType.DATE)
    private Calendar dataVcto;

    @Column(precision = 10, scale = 2)
    private double valor;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataPgto;

    @Column(precision = 10, scale = 2)
    private double valorPgto;

    @ManyToOne
    @JoinColumn(name = "contrato_id")
    private Contrato contrato;

    // Construtores, getters e setters

    public Pagamento() {
    }

    public Pagamento(Calendar dataVcto, double valor) {
        this.dataVcto = dataVcto;
        this.valor = valor;
    }
    
    public void GerarPagamento(int mesRef) {
        this.dataVcto = Calendar.getInstance();
        this.dataVcto.set(Calendar.MONTH, mesRef);
        this.valor = 500.00;    
        this.dataPgto = Calendar.getInstance();
        this.valorPgto = this.valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calendar getDataVcto() {
        return dataVcto;
    }

    public void setDataVcto(Calendar dataVcto) {
        this.dataVcto = dataVcto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Calendar getDataPgto() {
        return dataPgto;
    }

    public void setDataPgto(Calendar dataPgto) {
        this.dataPgto = dataPgto;
    }

    public double getValorPgto() {
        return valorPgto;
    }

    public void setValorPgto(double valorPgto) {
        this.valorPgto = valorPgto;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public void gerarPagamento(int mesRef) {
        // Verifica se o pagamento já foi realizado para o mês de referência
        if (dataPgto != null && dataPgto.get(Calendar.MONTH) == mesRef) {
            System.out.println("Pagamento já realizado para o mês de referência.");
            return;
        }

        // Calcula o mês de vencimento do pagamento
        Calendar dataVencimento = (Calendar) dataVcto.clone();
        dataVencimento.add(Calendar.MONTH, mesRef);

        // Verifica se o pagamento já foi vencido para o mês de referência
        if (dataVencimento.before(Calendar.getInstance())) {
            System.out.println("Pagamento vencido para o mês de referência.");
            return;
        }

        // Cria um novo pagamento com base no mês de referência
        Pagamento novoPagamento = new Pagamento();
        novoPagamento.setDataVcto(dataVencimento);
        novoPagamento.setValor(this.valor);
        novoPagamento.setContrato(this.contrato);

        // Realiza o pagamento
        this.contrato.adicionarPagamento(novoPagamento);
        System.out.println("Novo pagamento gerado com sucesso para o mês de referência.");
    }
}
