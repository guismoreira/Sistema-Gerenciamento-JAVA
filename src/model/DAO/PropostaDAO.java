package model.DAO;

import java.util.ArrayList;
import java.util.Iterator;
import model.OperacoesDAO;
import model.Proposta;

/**
 *
 * @author Gui
 */
public class PropostaDAO implements OperacoesDAO {

    private ArrayList colecao;
    private static PropostaDAO propostas = null;

    /**
     * Cria uma nova instancia de PropostaDAO Cria a colecao de objetos
     */
    public PropostaDAO(ArrayList colecao) {
        this.colecao = colecao;
        propostas = this;
    }

    /**
     * @return a instância de PropostaDAO
     */
    public static PropostaDAO getInstance() {
        return propostas;
    }

    /**
     * Insere uma Proposta na colecao
     *
     * @param obj contem a Proposta que sera inserida
     */
    public void inserir(Object obj) {
        getColecao().add(obj);
    }

    /**
     * Exclui uma Proposta da colecao
     *
     * @param obj contem a propadra que sera excluida
     */
    public void excluir(Object obj) {
        getColecao().remove(obj);
    }

    /**
     * Remove o objeto antigo e acrescenta um novo objeto contendo as novas
     * informacoes
     *
     * @param newObj contem a Proposta com as novas informacoes
     * @throws ClassCastException ocorre quando e feito cast para o tipo de
     * objeto incorreto
     */
    @Override
    public void editar(Object newObj) throws ClassCastException {
        Proposta newProp = (Proposta) newObj;
        Proposta oldProp = pesquisarPropostaID(newProp.getId());
        oldProp.setProposta(newProp);
    }

    public ArrayList pesquisar(Object key) {
        return null;
    }

    /**
     * Busca na colecao�uma determinada Proposta
     *
     * @param nomeProcura contem o nome da Proposta
     * @return a Proposta (caso exista) ou null (caso contrario)
     */
    public Proposta pesquisarProposta(String nomeProcura) {
        Proposta retValue = null;
        Iterator it = getColecao().iterator();
        while (it.hasNext()) { //verifica se h� um pr�ximo objeto
            Proposta prop = (Proposta) it.next();
            if (prop.getTitulo().equals(nomeProcura)) {
                retValue = prop;
            }
        }
        return retValue;
    }

    public String[] listaNomespropostas() {
        String[] propostas = new String[colecao.size()];
        for (int i = 0; i < colecao.size(); i++) {
            propostas[i] = ((Proposta) colecao.get(i)).getTitulo();
        }
        return propostas;
    }

    public Proposta pesquisarPropostaID(String nomeProcura) {
        Proposta retValue = null;
        Iterator it = getColecao().iterator();
        while (it.hasNext()) { //verifica se h� um pr�ximo objeto
            Proposta prop = (Proposta) it.next();
            if (prop.getId().equals(nomeProcura)) {
                retValue = prop;
            }
        }
        return retValue;
    }

    public String[] listaNomespropostasID() {
        String[] propostas = new String[colecao.size()];
        for (int i = 0; i < colecao.size(); i++) {
            propostas[i] = ((Proposta) colecao.get(i)).getId();
        }
        return propostas;
    }

    public ArrayList getColecao() {
        return colecao;
    }
}
