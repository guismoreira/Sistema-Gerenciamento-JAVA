package model.DAO;

import java.util.ArrayList;
import java.util.Iterator;
import model.OperacoesDAO;
import model.Banca;

/**
 *
 * @author Gui
 */
public class BancaDAO implements OperacoesDAO {

    private ArrayList colecao;
    private static BancaDAO bancas = null;

    /**
     * Cria uma nova instancia de BancaDAO Cria a colecao de objetos
     */
    public BancaDAO(ArrayList colecao) {
        this.colecao = colecao;
        bancas = this;
    }

    /**
     * @return a instância de BancaDAO
     */
    public static BancaDAO getInstance() {
        return bancas;
    }

    /**
     * Insere uma Banca na colecao
     *
     * @param obj contem a Banca que sera inserida
     */
    public void inserir(Object obj) {
        getColecao().add(obj);
    }

    /**
     * Exclui uma Banca da colecao
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
     * @param newObj contem a Banca com as novas informacoes
     * @throws ClassCastException ocorre quando e feito cast para o tipo de
     * objeto incorreto
     */
    @Override
    public void editar(Object newObj) throws ClassCastException {
        Banca newban = (Banca) newObj;
        Banca oldban = pesquisarBancaID(newban.getId());
        oldban.setBanca(newban);
    }

    public ArrayList pesquisar(Object key) {
        return null;
    }

    /**
     * Busca na colecao�uma determinada Banca
     *
     * @param nomeProcura contem o nome da Banca
     * @return a Banca (caso exista) ou null (caso contrario)
     */
    public Banca pesquisarBanca(String nomeProcura) {
        Banca retValue = null;
        Iterator it = getColecao().iterator();
        while (it.hasNext()) { //verifica se h� um pr�ximo objeto
            Banca ban = (Banca) it.next();
            if (ban.getId().equals(nomeProcura)) {
                retValue = ban;
            }
        }
        return retValue;
    }

    public String[] listaNomesbancas() {
        String[] bancas = new String[colecao.size()];
        for (int i = 0; i < colecao.size(); i++) {
            bancas[i] = ((Banca) colecao.get(i)).getId();
        }
        return bancas;
    }

    public Banca pesquisarBancaID(String nomeProcura) {
        Banca retValue = null;
        Iterator it = getColecao().iterator();
        while (it.hasNext()) { //verifica se h� um pr�ximo objeto
            Banca ban = (Banca) it.next();
            if (ban.getId().equals(nomeProcura)) {
                retValue = ban;
            }
        }
        return retValue;
    }

    public String[] listaNomesbancasID() {
        String[] bancas = new String[colecao.size()];
        for (int i = 0; i < colecao.size(); i++) {
            bancas[i] = ((Banca) colecao.get(i)).getId();
        }
        return bancas;
    }

    public ArrayList getColecao() {
        return colecao;
    }
}
