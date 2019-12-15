/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.aluno;

import control.Comando;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.DAO.AlunoDAO;
import view.MenuPrincipal;

/**
 *
 * @author Gui
 */
public class AlunoPesquisar implements Comando {

    @Override
    public void executar() {
        AlunoDAO dao = AlunoDAO.getInstance();
        ArrayList lista = dao.getColecao();
        JOptionPane.showMessageDialog(null, lista);
        MenuPrincipal.exibir();
    }

}
