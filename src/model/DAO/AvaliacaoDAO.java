package model.DAO;

import java.util.ArrayList;
import java.util.Iterator;
import model.Avaliacao;
import model.OperacoesDAO;

/**
 *
 * @author Gui
 */
public class AvaliacaoDAO implements OperacoesDAO {

    private ArrayList colecao;
    private static AvaliacaoDAO avaliacoes = null;

    /**
     * Cria uma nova instancia de AvaliacaoDAO Cria a colecao de objetos
     */
    public AvaliacaoDAO(ArrayList colecao) {
        this.colecao = colecao;
        avaliacoes = this;
    }

    /**
     * @return a instância de AvaliacaoDAO
     */
    public static AvaliacaoDAO getInstance() {
        return avaliacoes;
    }

    /**
     * Insere uma Avaliacao na colecao
     *
     * @param obj contem a Avaliacao que sera inserida
     */
    public void inserir(Object obj) {
        getColecao().add(obj);
    }

    /**
     * Exclui uma Avaliacao da colecao
     *
     * @param obj contem a ban que sera excluida
     */
    public void excluir(Object obj) {
        getColecao().remove(obj);
    }

    /**
     * Remove o objeto antigo e acrescenta um novo objeto contendo as novas
     * informacoes
     *
     * @param newObj contem a Avaliacao com as novas informacoes
     * @throws ClassCastException ocorre quando e feito cast para o tipo de
     * objeto incorreto
     */
    @Override
    public void editar(Object newObj) throws ClassCastException {
        Avaliacao newAva = (Avaliacao) newObj;
        Avaliacao oldAva = pesquisarAvaliacaoID(newAva.getId());
        oldAva.setAvaliacao(newAva);
    }

    public ArrayList pesquisar(Object key) {
        return null;
    }

    /**
     * Busca na colecao�uma determinada Avaliacao
     *
     * @param nomeProcura contem o nome da Avaliacao
     * @return a Avaliacao (caso exista) ou null (caso contrario)
     */
    public Avaliacao pesquisarAvaliacao(String nomeProcura) {
        Avaliacao retValue = null;
        Iterator it = getColecao().iterator();
        while (it.hasNext()) { //verifica se h� um pr�ximo objeto
            Avaliacao ava = (Avaliacao) it.next();
            if (ava.getId().equals(nomeProcura)) {
                retValue = ava;
            }
        }
        return retValue;
    }

    public String[] listaNomesAvaliacoes() {
        String[] avaliacoes = new String[colecao.size()];
        for (int i = 0; i < colecao.size(); i++) {
            avaliacoes[i] = ((Avaliacao) colecao.get(i)).getId();
        }
        return avaliacoes;
    }

    public Avaliacao pesquisarAvaliacaoID(String nomeProcura) {
        Avaliacao retValue = null;
        Iterator it = getColecao().iterator();
        while (it.hasNext()) { //verifica se h� um pr�ximo objeto
            Avaliacao ava = (Avaliacao) it.next();
            if (ava.getId().equals(nomeProcura)) {
                retValue = ava;
            }
        }
        return retValue;
    }

    public String[] listaNomesAvaliacoesID() {
        String[] avaliacoes = new String[colecao.size()];
        for (int i = 0; i < colecao.size(); i++) {
            avaliacoes[i] = ((Avaliacao) colecao.get(i)).getId();
        }
        return avaliacoes;
    }

    public ArrayList getColecao() {
        return colecao;
    }
}
