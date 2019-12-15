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
public class AlunoInserir implements Comando {

    public void executar() {

        //Essas variáveis armazenarão valores a serem informados para os objetos
        String nome = null;
        String numMat = null;
        String email = null;
        String telefone = null;
        String id = null;

        AlunoDAO dao = AlunoDAO.getInstance();

        boolean ok = false;

        //Teste do id 
        do {
            try {
                id = JOptionPane.showInputDialog(null, "Informe a id do aluno, "
                        + "por exemplo, al1, al2, al3, etc");
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

        //Teste do nome    
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
                numMat = JOptionPane.showInputDialog(null, "Informe "
                        + "numero de matricula");
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

        Aluno novo = new Aluno(nome, numMat, email, telefone, id);
        dao.inserir(novo);

        MenuPrincipal.exibir();
    }
}
