/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gui
 */
public class Processador {

    private static final HashMap comandos = new HashMap();

    static {
        comandos.put("1", "view.aluno.AlunoInserir");
        comandos.put("2", "view.aluno.AlunoExcluir");
        comandos.put("3", "view.aluno.AlunoEditar");
        comandos.put("4", "view.aluno.AlunoPesquisar");

        comandos.put("5", "view.professor.ProfessorInserir");
        comandos.put("6", "view.professor.ProfessorExcluir");
        comandos.put("7", "view.professor.ProfessorEditar");
        comandos.put("8", "view.professor.ProfessorPesquisar");

        comandos.put("9", "view.proposta.PropostaInserir");
        comandos.put("10", "view.proposta.PropostaExcluir");
        comandos.put("11", "view.proposta.PropostaEditar");
        comandos.put("12", "view.proposta.PropostaPesquisar");

        comandos.put("13", "view.banca.BancaInserir");
        comandos.put("14", "view.banca.BancaExcluir");
        comandos.put("15", "view.banca.BancaEditar");
        comandos.put("16", "view.banca.BancaPesquisar");

        comandos.put("17", "view.avaliacao.AvaliacaoInserir");
        comandos.put("18", "view.avaliacao.AvaliacaoExcluir");
        comandos.put("19", "view.avaliacao.AvaliacaoEditar");
        comandos.put("20", "view.avaliacao.AvaliacaoPesquisar");

        comandos.put("00", "view.Sair");
    }

    public static void direcionar(String cmd) {
        String actionClass = (String) comandos.get(cmd);
        //Cria a instância da classe utilizando introspecção
        try {
            Class classe = Class.forName(actionClass);
            Comando comando = (Comando) classe.newInstance();
            comando.executar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Processador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException iex) {
            Logger.getLogger(Processador.class.getName()).log(Level.SEVERE, null, iex);
        } catch (IllegalAccessException iaex) {
            Logger.getLogger(Processador.class.getName()).log(Level.SEVERE, null, iaex);
        }

    }
}
