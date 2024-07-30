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
import br.edu.ifsul.cc.lpoo_studiodanca.dao.model.Modalidade;
import br.edu.ifsul.cc.lpoo_studiodanca.dao.model.Pacote;

/**
 *
 * @author debor
 */
public class TestePersistenciaPacoteModalidade {

    PersistenciaJPA jpa = new PersistenciaJPA();
    
    public TestePersistenciaPacoteModalidade(){
        
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
    public void testePersistenciaPacoteModalidade() throws Exception {
        // Criar uma modalidade
        Modalidade modalidade = new Modalidade();
        modalidade.setDescricao("Dança de salão");

        // Criar um pacote associado à modalidade
        Pacote pacote = new Pacote();
        pacote.setDescricao("Pacote básico de dança de salão");
        pacote.setValor(100.00); // Valor fictício
        pacote.setModalidade(modalidade);

        // Persistir o pacote e a modalidade
        jpa.persist(modalidade);
        jpa.persist(pacote);

        // Buscar o pacote persistido
        Pacote persistidoPacote = (Pacote) jpa.find(Pacote.class, pacote.getId());

        // Verificar se o pacote persistido possui a modalidade correta
        Assert.assertEquals(modalidade.getDescricao(), persistidoPacote.getModalidade().getDescricao());
    }
}
