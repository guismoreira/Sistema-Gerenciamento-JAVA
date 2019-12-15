/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.proposta;

import control.Comando;
import javax.swing.JOptionPane;
import model.DAO.PropostaDAO;
import model.Proposta;
import view.MenuPrincipal;

/**
 *
 * @author Gui
 */
public class PropostaExcluir implements Comando {

    @Override
    public void executar() {
        boolean ok = false;

        PropostaDAO ddao = PropostaDAO.getInstance();
        do {
            Object[] propostas = ddao.listaNomespropostas();
            String nome = (String) JOptionPane.showInputDialog(
                    null,
                    "Escolha qual proposta deseja excluir:\n",
                    "Proposta",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    propostas,
                    "");

            if (nome != null) {
                Proposta proposta = ddao.pesquisarProposta(nome);
                ddao.excluir(proposta);
                ok = true;
            } else {
                ok = false;

                MenuPrincipal.exibir();
            }
        } while (!ok);
    }

}
