package model.DAO;

import java.util.ArrayList;
import java.util.Iterator;
import model.OperacoesDAO;
import model.Professor;

/**
 *
 * @author Gui
 */
public class ProfessorDAO implements OperacoesDAO {

    private ArrayList colecao;
    private static ProfessorDAO professores = null;

    /**
     * Cria uma nova instancia de ProfessorDAO Cria a colecao de objetos
     */
    public ProfessorDAO(ArrayList colecao) {
        this.colecao = colecao;
        professores = this;
    }

    /**
     * @return a instância de ProfessorDAO
     */
    public static ProfessorDAO getInstance() {
        return professores;
    }

    /**
     * Insere uma Professor na colecao
     *
     * @param obj contem a Professor que sera inserida
     */
    public void inserir(Object obj) {
        getColecao().add(obj);
    }

    /**
     * Exclui uma Professor da colecao
     *
     * @param obj contem a profadra que sera excluida
     */
    public void excluir(Object obj) {
        getColecao().remove(obj);
    }

    /**
     * Remove o objeto antigo e acrescenta um novo objeto contendo as novas
     * informacoes
     *
     * @param newObj contem a Professor com as novas informacoes
     * @throws ClassCastException ocorre quando e feito cast para o tipo de
     * objeto incorreto
     */
    @Override
    public void editar(Object newObj) throws ClassCastException {
        Professor newprof = (Professor) newObj;
        Professor oldprof = pesquisarProfessorID(newprof.getId());
        oldprof.setProfessor(newprof);
    }

    public ArrayList pesquisar(Object key) {
        return null;
    }

    /**
     * Busca na colecao�uma determinada Professor
     *
     * @param nomeProcura contem o nome da Professor
     * @return a Professor (caso exista) ou null (caso contrario)
     */
    public Professor pesquisarProfessor(String nomeProcura) {
        Professor retValue = null;
        Iterator it = getColecao().iterator();
        while (it.hasNext()) { //verifica se h� um pr�ximo objeto
            Professor prof = (Professor) it.next();
            if (prof.getNome().equals(nomeProcura)) {
                retValue = prof;
            }
        }
        return retValue;
    }

    public String[] listaNomesprofessores() {
        String[] professores = new String[colecao.size()];
        for (int i = 0; i < colecao.size(); i++) {
            professores[i] = ((Professor) colecao.get(i)).getNome();
        }
        return professores;
    }

    public Professor pesquisarProfessorID(String nomeProcura) {
        Professor retValue = null;
        Iterator it = getColecao().iterator();
        while (it.hasNext()) { //verifica se h� um pr�ximo objeto
            Professor prof = (Professor) it.next();
            if (prof.getId().equals(nomeProcura)) {
                retValue = prof;
            }
        }
        return retValue;
    }

    public String[] listaNomesprofessoresID() {
        String[] professores = new String[colecao.size()];
        for (int i = 0; i < colecao.size(); i++) {
            professores[i] = ((Professor) colecao.get(i)).getId();
        }
        return professores;
    }

    public ArrayList getColecao() {
        return colecao;
    }
}
