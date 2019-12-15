/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Gui
 */
public interface OperacoesDAO {

    public void inserir(Object obj);

    public void excluir(Object obj);

    public void editar(Object newObj);

    public ArrayList pesquisar(Object key);
}
