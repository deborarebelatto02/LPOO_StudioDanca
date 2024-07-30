/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.cc.lpoo_studiodanca.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author debor
 */
@Entity
public class Contrato implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataInicio;

    @Column(precision = 10, scale = 2)
    private double valorDesconto;

    @Enumerated(EnumType.STRING)
    private FormaPgto formaPagamento;

    @OneToMany(mappedBy = "contrato", cascade = CascadeType.ALL)
    private List<Pagamento> pagamentos = new ArrayList<>();

    @ManyToOne
    private Alunos aluno;

    @OneToMany(mappedBy = "contrato")
    private List<ItensContrato> itensContrato;

    @PrePersist
    protected void onCreate() {
        this.dataInicio = Calendar.getInstance();
    }

    public Contrato() {
        onCreate();
    }

    public Contrato(double valorDesconto, FormaPgto formaPagamento) {
        onCreate();
        this.valorDesconto = valorDesconto;
        this.formaPagamento = formaPagamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calendar getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Calendar dataInicio) {
        this.dataInicio = dataInicio;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public FormaPgto getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPgto formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    public void adicionarPagamento(Pagamento pagamento) {
        this.pagamentos.add(pagamento);
        pagamento.setContrato(this);
    }

    public void removerPagamento(Pagamento pagamento) {
        this.pagamentos.remove(pagamento);
        pagamento.setContrato(null);
    }

    public double calcularValorTotal() {
        double valorTotal = 0;
        for (Pagamento pagamento : pagamentos) {
            valorTotal += pagamento.getValor();
        }
        return valorTotal - valorDesconto;
    }
}
