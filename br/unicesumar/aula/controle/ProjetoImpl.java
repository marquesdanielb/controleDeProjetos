/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicesumar.aula.controle;

import br.unicesumar.aula.exceptions.DadoConsultadoException;
import br.unicesumar.aula.modelo.Projeto;
 
import java.util.HashSet;
import java.util.*;
import java.util.Set;
import java.util.stream.*;

/**
 *
 * @author suporte
 */
public class ProjetoImpl extends Projeto implements ProjetoDAO {
    //Collection que irá armazenar todos os projetos
    private static Set<Projeto> projetos = new HashSet<>();

    @Override
    public void adicionar(Projeto projeto) {
        projetos.add(projeto);
    }
 
    @Override
    public List<Projeto> listar() {
        List<Projeto> listandoProjeto = new ArrayList<>(projetos);
        return listandoProjeto;
    }
 
    @Override
    public Projeto consultarPorNome(String nome) throws DadoConsultadoException {
        for(Projeto projeto: projetos){
            if(projeto.getNome().equalsIgnoreCase(nome)){
                return projeto;
            }
        }
        throw new DadoConsultadoException("Projeto não encontrado");
    }
 
    @Override
    public Projeto alterar(String nome, Projeto projeto) throws DadoConsultadoException {
        Projeto projetoEncontrado = consultarPorNome(nome);
        projetoEncontrado.substituir(projeto);
        return projetoEncontrado;
    }
 
    @Override
    public void excluir(Projeto projeto) throws DadoConsultadoException, UnsupportedOperationException {
        if(projetos.contains(projeto)){
            projetos.remove(projeto);
        }else{
        throw new DadoConsultadoException("Esse projeto não foi encontrado");
        }
    }
 
    @Override
    public void excluir(String nome) throws DadoConsultadoException, UnsupportedOperationException {
        Projeto projeto = consultarPorNome(nome);
        excluir(projeto);
    }
}

