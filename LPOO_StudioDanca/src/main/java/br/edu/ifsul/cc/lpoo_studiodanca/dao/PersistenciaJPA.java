/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.cc.lpoo_studiodanca.dao;

import br.edu.ifsul.cc.lpoo_studiodanca.dao.model.Modalidade;
import java.awt.List;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author debor
 */
public class PersistenciaJPA implements InterfacePersistencia {

    EntityManager entity;
    EntityManagerFactory factory;

    public PersistenciaJPA() {
        factory = Persistence.createEntityManagerFactory("pu_studiodanca");
        entity = factory.createEntityManager();
    }

    @Override
    public Boolean conexaoAberta() {
        return entity.isOpen();
    }

    @Override
    public void fecharConexao() {
        entity.close();
    }

    @Override
    public Object find(Class c, Object id) throws Exception {
        return entity.find(c, id);
    }

    @Override
    public void persist(Object o) throws Exception {
        entity.getTransaction().begin();
        entity.persist(o);
        entity.getTransaction().commit();
    }

    @Override
    public void remover(Object o) throws Exception {
        entity.getTransaction().begin();
        entity.remove(o);
        entity.getTransaction().commit();
    }

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("EstudioDancaPU");

    public void persist(Modalidade modalidade) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(modalidade);
        em.getTransaction().commit();
        em.close();
    }
    
    public void update(Modalidade modalidade) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(modalidade);
        em.getTransaction().commit();
        em.close();
    }
    
    public void remove(Modalidade modalidade) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    modalidade = em.merge(modalidade);
    em.remove(modalidade);
    em.getTransaction().commit();
    em.close();
}

    public ArrayList<Modalidade> getModalidades() {
        EntityManager em = emf.createEntityManager();
        ArrayList<Modalidade> modalidades = (ArrayList<Modalidade>) em.createQuery("SELECT m FROM Modalidade m", Modalidade.class).getResultList();
        em.close();
        return modalidades;
    }

    public Modalidade getModalidadeByDescricao(String descricao) {
        EntityManager em = emf.createEntityManager();
        Modalidade modalidade = em.createQuery("SELECT m FROM Modalidade m WHERE m.descricao = :descricao", Modalidade.class)
                .setParameter("descricao", descricao)
                .getSingleResult();
        em.close();
        return modalidade;
    }

    
}
