/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.professor;

import control.Comando;
import javax.swing.JOptionPane;
import model.AreaInteresse;
import model.Professor;
import model.DAO.ProfessorDAO;
import view.CampoVazioException;
import view.MenuPrincipal;

/**
 *
 * @author Gui
 */
public class ProfessorInserir implements Comando {

    public void executar() {

        //Essas variáveis armazenarão valores a serem informados para os objetos
        String nome = null;
        String email = null;
        AreaInteresse areaInteresse = null;
        String sugestaoProj = null;
        String id = null;

        ProfessorDAO dao = ProfessorDAO.getInstance();

        boolean ok = false;

        //Teste do id 
        do {
            try {
                id = JOptionPane.showInputDialog(null, "Informe a id do professor"
                        + ", por exemplo: pr1, pr2, pr3, etc");
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
                nome = JOptionPane.showInputDialog(null, "Informe o nome do professor");
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

        //Teste do areaInteresse        
        do {
            Object[] dados = AreaInteresse.values();
            areaInteresse = (AreaInteresse) JOptionPane.showInputDialog(
                    null,
                    "Area de interesse:\n",
                    "Escolha a area",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    dados,
                    AreaInteresse.UX);
            ok = true;

            if (areaInteresse == null) {
                ok = false;
            }

        } while (!ok);

        //Teste do sugestaoProj        
        do {
            try {
                sugestaoProj = JOptionPane.showInputDialog(null, "Informe a sugestao de projeto");
                if (sugestaoProj.equals("")) {
                    //throw pra ser pego pelo catch:
                    throw new CampoVazioException("Você não digitou nada!");
                }
                ok = true;
            } catch (CampoVazioException cve) {
                JOptionPane.showMessageDialog(null, cve.getMessage());
                ok = false;
            }
        } while (!ok);

        //
        Professor novo = new Professor(nome, email, areaInteresse, sugestaoProj, id);
        dao.inserir(novo);

        MenuPrincipal.exibir();
    }
}
