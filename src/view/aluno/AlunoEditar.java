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
import view.CampoVazioException;
import view.MenuPrincipal;

/**
 *
 * @author Gui
 */
public class AlunoEditar implements Comando {

    /**
     *
     */
    @Override
    public void executar() {
        String nome = null;
        String numMat = null;
        String email = null;
        String telefone = null;
        String id = null;

        boolean ok = false;

        AlunoDAO ddao = AlunoDAO.getInstance();

        do {
            try {
                id = JOptionPane.showInputDialog(null, "Informe a id do aluno que será editado, "
                        + "você pode ver o id em pesquisar (opção 4 do menu principal)");
                if (id.equals("")) {
                    //throw pra ser pego pelo catch:
                    throw new CampoVazioException("Você não digitou nada!");
                }
                ok = true;
            } catch (CampoVazioException cve) {
                JOptionPane.showMessageDialog(null, cve.getMessage());
                ok = false;
            }
        } while (!ok);

        do {
            try {
                nome = JOptionPane.showInputDialog(null, "Informe o nome do aluno");
                if (nome.equals("")) {
                    //throw pra ser pego pelo catch:
                    throw new CampoVazioException("Você não digitou nada!");
                }
                ok = true;
            } catch (CampoVazioException cve) {
                JOptionPane.showMessageDialog(null, cve.getMessage());
                ok = false;
            }
        } while (!ok);

        //Teste do numMat        
        do {
            try {
                numMat = JOptionPane.showInputDialog(null, "Informe numero de matricula");
                if (numMat.equals("")) {
                    //throw pra ser pego pelo catch:
                    throw new CampoVazioException("Você não digitou nada!");
                }
                ok = true;
            } catch (CampoVazioException cve) {
                JOptionPane.showMessageDialog(null, cve.getMessage());
                ok = false;
            }
        } while (!ok);

        //Teste do email        
        do {
            try {
                email = JOptionPane.showInputDialog(null, "Informe email");
                if (email.equals("")) {
                    //throw pra ser pego pelo catch:
                    throw new CampoVazioException("Você não digitou nada!");
                }
                ok = true;
            } catch (CampoVazioException cve) {
                JOptionPane.showMessageDialog(null, cve.getMessage());
                ok = false;
            }
        } while (!ok);

        //Teste do telefone        
        do {
            try {
                telefone = JOptionPane.showInputDialog(null, "Informe telefone");
                if (telefone.equals("")) {
                    //throw pra ser pego pelo catch:
                    throw new CampoVazioException("Você não digitou nada!");
                }
                ok = true;
            } catch (CampoVazioException cve) {
                JOptionPane.showMessageDialog(null, cve.getMessage());
                ok = false;
            }
        } while (!ok);

        Aluno newAluno = new Aluno(nome, numMat, email, telefone, id);
        ddao.editar(newAluno);
        MenuPrincipal.exibir();
    }

}
