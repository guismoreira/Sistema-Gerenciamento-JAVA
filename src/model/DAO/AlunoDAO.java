package model.DAO;

import java.util.ArrayList;
import java.util.Iterator;
import model.Aluno;
import model.OperacoesDAO;

/**
 *
 * @author Gui
 */
public class AlunoDAO implements OperacoesDAO {

    private ArrayList colecao;
    private static AlunoDAO alunos = null;

    /**
     * Cria uma nova instancia de AlunoDAO Cria a colecao de objetos
     */
    public AlunoDAO(ArrayList colecao) {
        this.colecao = colecao;
        alunos = this;
    }

    /**
     * @return a instância de AlunoDAO
     */
    public static AlunoDAO getInstance() {
        return alunos;
    }

    /**
     * Insere uma Aluno na colecao
     *
     * @param obj contem a Aluno que sera inserida
     */
    public void inserir(Object obj) {
        getColecao().add(obj);
    }

    /**
     * Exclui uma Aluno da colecao
     *
     * @param obj contem a alunadra que sera excluida
     */
    public void excluir(Object obj) {
        getColecao().remove(obj);
    }

    /**
     * Remove o objeto antigo e acrescenta um novo objeto contendo as novas
     * informacoes
     *
     * @param newObj contem a Aluno com as novas informacoes
     * @throws ClassCastException ocorre quando e feito cast para o tipo de
     * objeto incorreto
     */
    @Override
    public void editar(Object newObj) throws ClassCastException {
        Aluno newAlun = (Aluno) newObj;
        Aluno oldAlun = pesquisarAlunoID(newAlun.getId());
        oldAlun.setAluno(newAlun);
    }

    public ArrayList pesquisar(Object key) {
        return null;
    }

    /**
     * Busca na colecao�uma determinada Aluno
     *
     * @param nomeProcura contem o nome da Aluno
     * @return a Aluno (caso exista) ou null (caso contrario)
     */
    public Aluno pesquisarAluno(String nomeProcura) {
        Aluno retValue = null;
        Iterator it = getColecao().iterator();
        while (it.hasNext()) { //verifica se h� um pr�ximo objeto
            Aluno alun = (Aluno) it.next();
            if (alun.getNome().equals(nomeProcura)) {
                retValue = alun;
            }
        }
        return retValue;
    }

    public String[] listaNomesalunos() {
        String[] alunos = new String[colecao.size()];
        for (int i = 0; i < colecao.size(); i++) {
            alunos[i] = ((Aluno) colecao.get(i)).getNome();
        }
        return alunos;
    }

    public Aluno pesquisarAlunoID(String nomeProcura) {
        Aluno retValue = null;
        Iterator it = getColecao().iterator();
        while (it.hasNext()) { //verifica se h� um pr�ximo objeto
            Aluno alun = (Aluno) it.next();
            if (alun.getId().equals(nomeProcura)) {
                retValue = alun;
            }
        }
        return retValue;
    }

    public String[] listaNomesalunosID() {
        String[] alunos = new String[colecao.size()];
        for (int i = 0; i < colecao.size(); i++) {
            alunos[i] = ((Aluno) colecao.get(i)).getId();
        }
        return alunos;
    }

    public ArrayList getColecao() {
        return colecao;
    }
}
