/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.professor;

import control.Comando;
import javax.swing.JOptionPane;
import model.Professor;
import model.DAO.ProfessorDAO;
import view.MenuPrincipal;

/**
 *
 * @author Gui
 */
public class ProfessorExcluir implements Comando {

    @Override
    public void executar() {
        boolean ok = false;

        ProfessorDAO ddao = ProfessorDAO.getInstance();
        do {
            Object[] Professores = ddao.listaNomesprofessores();
            String nome = (String) JOptionPane.showInputDialog(
                    null,
                    "Escolha qual Professor deseja excluir:\n",
                    "Professor",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    Professores,
                    "");

            if (nome != null) {
                Professor professor = ddao.pesquisarProfessor(nome);
                ddao.excluir(professor);
                ok = true;
            } else {
                ok = false;
                MenuPrincipal.exibir();
            }
        } while (!ok);
    }

}
