/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.cc.lpoo_studiodanca;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import br.edu.ifsul.cc.lpoo_studiodanca.dao.PersistenciaJPA;
import br.edu.ifsul.cc.lpoo_studiodanca.dao.model.Contrato;
import br.edu.ifsul.cc.lpoo_studiodanca.dao.model.FormaPgto;
import br.edu.ifsul.cc.lpoo_studiodanca.dao.model.Pagamento;

/**
 *
 * @author debor
 */
public class TestePersistenciaContratoPagamento {

    PersistenciaJPA jpa = new PersistenciaJPA();

    public TestePersistenciaContratoPagamento() {

    }

    @Before
    public void setUp() {
        jpa = new PersistenciaJPA();
        jpa.conexaoAberta();
    }

    @After
    public void tearDown() {
        jpa.fecharConexao();
    }

    @Test
    public void testePersistenciaContratoPagamento() throws Exception {
        // Criar um contrato
        Contrato contrato = new Contrato();
        contrato.setValorDesconto(20.00); // Valor fictício
        contrato.setFormaPagamento(FormaPgto.DINHEIRO); // Forma de pagamento fictícia

        // Criar um pagamento associado ao contrato
        Pagamento pagamento = new Pagamento();
        pagamento.setValor(100.00); // Valor fictício
        pagamento.setContrato(contrato);

        // Persistir o contrato e o pagamento
        jpa.persist(contrato);
        jpa.persist(pagamento);

        // Buscar o contrato persistido
        Contrato persistidoContrato = (Contrato) jpa.find(Contrato.class, contrato.getId());

        // Verificar se o contrato persistido possui o pagamento associado
        Assert.assertEquals(contrato.getFormaPagamento(), persistidoContrato.getFormaPagamento());
    }

}
