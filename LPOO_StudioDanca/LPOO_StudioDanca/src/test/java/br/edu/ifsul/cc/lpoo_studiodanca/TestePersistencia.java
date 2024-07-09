/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.cc.lpoo_studiodanca;

import org.junit.Test;
import br.edu.ifsul.cc.lpoo_studiodanca.dao.PersistenciaJPA;

/**
 *
 * @author debor
 */
public class TestePersistencia {
    
    @Test
    public void TestConexao(){
        PersistenciaJPA jpa = new PersistenciaJPA();

        if (jpa.conexaoAberta()) {
            System.out.println("Conexao realizada com sucesso");
        } else {
            System.out.println("Falha ao conectar ao Banco");
        }
    }
}
