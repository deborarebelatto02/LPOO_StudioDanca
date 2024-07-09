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

/**
 *
 * @author debor
 */
public class TestePersistenciaObjetos {
    
    PersistenciaJPA jpa = new PersistenciaJPA();
    
    public TestePersistenciaObjetos(){
        
    }
    
    @Before // o que fazer antes da persistencia
    public void setUp() {
        jpa.conexaoAberta();
    }
    
    @After
    public void tearDown() {
        jpa.fecharConexao();
    }
    
    @Test
    public void testePersistenciaModalidade() throws Exception {
        // criar meu obj Modalidade
        Modalidade m = new Modalidade();
        m.setDescricao("Dança de salão");
        
        // persistir objeto
        jpa.persist(m);
        
        // buscar o objeto persistido
        Modalidade persistidoModalidade = (Modalidade)jpa.find(Modalidade.class, m.getId());
        
        // verificar se objeto persistido é igual ao criado
        Assert.assertEquals(m.getDescricao(), persistidoModalidade.getDescricao());
    }
}
