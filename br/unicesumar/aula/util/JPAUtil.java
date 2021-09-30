/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicesumar.aula.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author suporte
 */
public class JPAUtil {
    private static EntityManagerFactory entityManagerFactory;
 
    public static EntityManager getEntityManagerFactory() {
        if (entityManagerFactory==null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("projetos");
        }
        return entityManagerFactory.createEntityManager();
    }
}
