package view.avaliacao;

import control.Comando;
import javax.swing.JOptionPane;
import model.Avaliacao;
import model.Banca;
import model.Conceito;
import model.DAO.AvaliacaoDAO;
import model.DAO.BancaDAO;
import view.CampoVazioException;
import view.MenuPrincipal;

/**
 *
 * @author gui
 */
public class AvaliacaoInserir implements Comando {

    public void executar() {

        //Essas variáveis armazenarão valores a serem informados para os objetos
        BancaDAO bdao = BancaDAO.getInstance();
        AvaliacaoDAO adao = AvaliacaoDAO.getInstance();
        Conceito conceito = null;

        String id = null;
        Banca banca = null;

        boolean ok = false;

        //Teste do id 
        do {
            try {
                id = JOptionPane.showInputDialog(null, "Informe a id da avaliacao"
                        + " (por exemplo: ava1, ava2, etc");
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

        //Teste do tcc    
        do {
            Object[] dados = bdao.listaNomesbancas();
            String nome = (String) JOptionPane.showInputDialog(
                    null,
                    "Escolha:\n",
                    "Banca",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    dados,
                    "");

            if (nome != null) {
                banca = bdao.pesquisarBanca(nome);
                ok = true;
            } else {
                ok = false;
                MenuPrincipal.exibir();
            }
        } while (!ok);

        //Teste do areaInteresse        
        do {
            Object[] dados = Conceito.values();
            conceito = (Conceito) JOptionPane.showInputDialog(
                    null,
                    "Area de interesse:\n",
                    "Escolha a area",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    dados,
                    Conceito.A);
            ok = true;

            if (conceito == null) {
                ok = false;
            }

        } while (!ok);

        Avaliacao novo = new Avaliacao(conceito, banca, id);

        adao.inserir(novo);

        MenuPrincipal.exibir();
    }
}
