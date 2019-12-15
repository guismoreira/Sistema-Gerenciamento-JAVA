/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.avaliacao;

import control.Comando;
import javax.swing.JOptionPane;
import model.Avaliacao;
import model.DAO.AvaliacaoDAO;
import view.MenuPrincipal;

/**
 *
 * @author Gui
 */
public class AvaliacaoExcluir implements Comando {

    @Override
    public void executar() {
        boolean ok = false;

        AvaliacaoDAO ddao = AvaliacaoDAO.getInstance();
        do {
            Object[] avaliacoes = ddao.listaNomesAvaliacoes();
            String nome = (String) JOptionPane.showInputDialog(
                    null,
                    "Escolha qual Avaliacao deseja excluir:\n",
                    "Avaliacao",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    avaliacoes,
                    "");

            if (nome != null) {
                Avaliacao avaliacao = ddao.pesquisarAvaliacao(nome);
                ddao.excluir(avaliacao);
                ok = true;
            } else {
                ok = false;

                MenuPrincipal.exibir();
            }
        } while (!ok);
    }

}
