/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.banca;

import control.Comando;
import javax.swing.JOptionPane;
import model.Banca;
import model.DAO.BancaDAO;
import view.MenuPrincipal;

/**
 *
 * @author Gui
 */
public class BancaExcluir implements Comando {

    @Override
    public void executar() {
        boolean ok = false;

        BancaDAO ddao = BancaDAO.getInstance();
        do {
            Object[] bancas = ddao.listaNomesbancas();
            String nome = (String) JOptionPane.showInputDialog(
                    null,
                    "Escolha qual banca deseja excluir:\n",
                    "Banca",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    bancas,
                    "");

            if (nome != null) {
                Banca banca = ddao.pesquisarBanca(nome);
                ddao.excluir(banca);
                ok = true;
            } else {
                ok = false;

                MenuPrincipal.exibir();
            }
        } while (!ok);
    }

}
