/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Principal;
import control.Comando;
import javax.swing.JOptionPane;

/**
 *
 * @author Gui
 */
public class Sair implements Comando {

    @Override
    public void executar() {
        JOptionPane.showMessageDialog(null, "Obrigado por testar o\nSistema de Gerenciamento de TCC\n2019 IFRS");
        Principal.encerrar();
    }

}
