/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.cc.lpoo_studiodanca;

import br.edu.ifsul.cc.lpoo_studiodanca.dao.PersistenciaJPA;
import br.edu.ifsul.cc.lpoo_studiodanca.dao.model.Professores;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author debor
 */
public class TestePersistenciaProfessores {

    PersistenciaJPA jpa = new PersistenciaJPA();

    public TestePersistenciaProfessores() {
    }

    @Before
    public void setUp() {
        jpa.conexaoAberta();
    }

    @After
    public void tearDown() {
        jpa.fecharConexao();
    }

    @Test
    public void testePersistenciaProfessor() throws Exception {

        Professores prof1 = new Professores();
        prof1.setNome("Daniel");
        jpa.persist(prof1);

        Professores prof2 = new Professores();
        prof2.setNome("Roberto");
        jpa.persist(prof2);

        Professores prof3 = new Professores();
        prof3.setNome("Vanessa");
        jpa.persist(prof3);
    }
}
