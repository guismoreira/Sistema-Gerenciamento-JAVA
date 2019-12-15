/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.aluno;

import control.Comando;
import javax.swing.JOptionPane;
import model.Aluno;
import model.DAO.AlunoDAO;
import view.MenuPrincipal;

/**
 *
 * @author Gui
 */
public class AlunoExcluir implements Comando {

    @Override
    public void executar() {
        boolean ok = false;

        AlunoDAO ddao = AlunoDAO.getInstance();
        do {
            Object[] alunos = ddao.listaNomesalunos();
            String nome = (String) JOptionPane.showInputDialog(
                    null,
                    "Escolha qual aluno deseja excluir:\n",
                    "Aluno",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    alunos,
                    "");

            if (nome != null) {
                Aluno aluno = ddao.pesquisarAluno(nome);
                ddao.excluir(aluno);
                ok = true;
            } else {
                ok = false;

                MenuPrincipal.exibir();
            }
        } while (!ok);
    }

}
