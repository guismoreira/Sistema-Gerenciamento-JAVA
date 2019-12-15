/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.Processador;
import javax.swing.JOptionPane;

/**
 *
 * @author Gui
 */
public class MenuPrincipal {

    public static void exibir() {
        //Teste do menu        
        boolean ok = true;
        do {
            try {
                String opcao = leitor("Olá, seja bem-vindo(a) ao Sistema de Gerenciamento de TCC:"
                        + "\n\nAluno"
                        + "\n1 - INSERIR    |   2-EXCLUIR    |   3-EDITAR    |   4-PESQUISAR "
                        + "\n-----------------------------------------------------------------------------------"
                        + "\nProfessor"
                        + "\n5 - INSERIR    |   6-EXCLUIR    |   7-EDITAR    |   8-PESQUISAR "
                        + "\n-----------------------------------------------------------------------------------"
                        + "\nProposta"
                        + "\n9 - INSERIR    |   10-EXCLUIR    |   11-EDITAR    |   12-PESQUISAR "
                        + "\n-----------------------------------------------------------------------------------"
                        + "\nBanca"
                        + "\n13 - INSERIR    |   14-EXCLUIR    |   15 - EDITAR    |   16-PESQUISAR "
                        + "\n-----------------------------------------------------------------------------------"
                        + "\nAvaliacao"
                        + "\n17 - INSERIR    |   18-EXCLUIR    |   19 - EDITAR    |   20-PESQUISAR "
                        + "\n-----------------------------------------------------------------------------------"
                        + "\n00 - Sair");
                Processador.direcionar(opcao);
                ok = true;
            } catch (CampoVazioException cve) {
                JOptionPane.showMessageDialog(null, cve);
                ok = false;
            } catch (NullPointerException npe) {
                int n = JOptionPane.showConfirmDialog(
                        null, "Fechar a aplicação?",
                        "ok",
                        JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION) {
                    new Sair().executar();
                    ok = false;
                } else if (n == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(null, "ok, de volta ao menu principal");
                    ok = true;
                }
            }
        } while (ok);
    }

    public static String leitor(String mensagem) throws CampoVazioException, NullPointerException {
        String dado = JOptionPane.showInputDialog(null, mensagem);
        if (dado.equals("")) {
            throw new CampoVazioException("Campo não preenchido");
        }
        return dado;
    }

}
