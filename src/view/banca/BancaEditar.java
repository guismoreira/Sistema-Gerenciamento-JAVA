package view.banca;

import control.Comando;
import javax.swing.JOptionPane;

import model.Banca;
import model.DAO.AlunoDAO;
import model.DAO.BancaDAO;
import model.DAO.ProfessorDAO;
import model.DAO.PropostaDAO;
import model.Professor;
import model.Proposta;
import view.CampoVazioException;
import view.MenuPrincipal;

/**
 *
 * @author gui
 */
public class BancaEditar implements Comando {

    public void executar() {

        //Essas variáveis armazenarão valores a serem informados para os objetos
        BancaDAO bdao = BancaDAO.getInstance();
        AlunoDAO adao = AlunoDAO.getInstance();
        ProfessorDAO prdao = ProfessorDAO.getInstance();
        PropostaDAO pdao = PropostaDAO.getInstance();

        Proposta proposta = null;
        Professor avaliador1 = null;
        Professor avaliador2 = null;
        String id = null;

        boolean ok = false;

        //Teste do id 
        do {
            try {
                id = JOptionPane.showInputDialog(null, "Informe a id da banca, "
                        + " que será editada");
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

        //Teste do avaliador 1    
        do {
            Object[] avaliadores1 = prdao.listaNomesprofessores();
            String nome = (String) JOptionPane.showInputDialog(
                    null,
                    "Escolha:\n",
                    "Avaliador",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    avaliadores1,
                    "");

            if (nome != null) {
                avaliador1 = prdao.pesquisarProfessor(nome);
                ok = true;
            } else {
                ok = false;
            }
        } while (!ok);

        //Teste do avakiador 2 
        do {
            Object[] avaliadores2 = prdao.listaNomesprofessores();
            String nome = (String) JOptionPane.showInputDialog(
                    null,
                    "Escolha:\n",
                    "Avaliador 2",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    avaliadores2,
                    "");

            if (nome != null) {
                avaliador2 = prdao.pesquisarProfessor(nome);
                ok = true;
            } else {
                ok = false;
            }
        } while (!ok);

        //Teste de escolha de proposta do tcc    
        do {
            Object[] propostas = pdao.listaNomespropostas();
            String nome = (String) JOptionPane.showInputDialog(
                    null,
                    "Escolha:\n",
                    "Titulo",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    propostas,
                    "");

            if (nome != null) {
                proposta = pdao.pesquisarProposta(nome);
                ok = true;
            } else {
                ok = false;
            }
        } while (!ok);

        Banca novo = new Banca(avaliador1, avaliador2, proposta, id);

        bdao.editar(novo);

        MenuPrincipal.exibir();
    }

}
