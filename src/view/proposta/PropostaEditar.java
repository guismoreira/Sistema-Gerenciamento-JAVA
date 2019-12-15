package view.proposta;

import control.Comando;
import javax.swing.JOptionPane;
import model.Aluno;
import model.DAO.AlunoDAO;
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
public class PropostaEditar implements Comando {

    public void executar() {

        //Essas variáveis armazenarão valores a serem informados para os objetos
        AlunoDAO adao = AlunoDAO.getInstance();
        ProfessorDAO prdao = ProfessorDAO.getInstance();
        PropostaDAO pdao = PropostaDAO.getInstance();

        Aluno autor = null;
        Professor orientador = null;
        String id = null;
        String titulo = null;

        boolean ok = false;

        //Teste do id 
        do {
            try {
                id = JOptionPane.showInputDialog(null, "Informe a id da proposta, "
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

        //Teste do autor    
        do {
            Object[] autores = adao.listaNomesalunos();
            String nome = (String) JOptionPane.showInputDialog(
                    null,
                    "Escolha:\n",
                    "Autor",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    autores,
                    "");

            if (nome != null) {
                autor = adao.pesquisarAluno(nome);
                ok = true;
            } else {
                ok = false;
            }
        } while (!ok);

        //Teste do orientador    
        do {
            Object[] orientadores = prdao.listaNomesprofessores();
            String nome = (String) JOptionPane.showInputDialog(
                    null,
                    "Escolha:\n",
                    "Orientador",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    orientadores,
                    "");

            if (nome != null) {
                orientador = prdao.pesquisarProfessor(nome);
                ok = true;
            } else {
                ok = false;
            }
        } while (!ok);

        //Teste do titulo 
        do {
            try {
                titulo = JOptionPane.showInputDialog(null, "Informe o titulo do tcc");
                if (titulo.equals("")) {
                    //throw pra ser pego pelo catch:
                    throw new CampoVazioException("Você não digitou nada!");
                }
                ok = true;
            } catch (CampoVazioException cve) {
                JOptionPane.showMessageDialog(null, cve.getMessage());
                ok = false;
            }
        } while (!ok);

        Proposta novo = new Proposta(autor, orientador, id, titulo);
        pdao.editar(novo);

        MenuPrincipal.exibir();
    }
}
