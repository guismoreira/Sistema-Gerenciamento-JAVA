/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.proposta;

import control.Comando;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.DAO.PropostaDAO;
import view.MenuPrincipal;

/**
 *
 * @author Gui
 */
public class PropostaPesquisar implements Comando {

    @Override
    public void executar() {
        PropostaDAO dao = PropostaDAO.getInstance();
        ArrayList lista = dao.getColecao();
        JOptionPane.showMessageDialog(null, lista);
        MenuPrincipal.exibir();
    }

}
