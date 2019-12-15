/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import control.GerenciadorArquivos;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.DAO.ProfessorDAO;
import model.DAO.AlunoDAO;
import model.DAO.AvaliacaoDAO;
import model.DAO.BancaDAO;
import model.DAO.PropostaDAO;
import view.CampoVazioException;
import view.MenuPrincipal;

/**
 *
 * @author Gui
 */
public class Principal {

    private static String arquivoAluno;
    private static AlunoDAO dadosAluno;
    private static String arquivoProfessor;
    private static ProfessorDAO dadosProfessor;
    private static String arquivoProposta;
    private static PropostaDAO dadosProposta;
    private static String arquivoBanca;
    private static BancaDAO dadosBanca;
    private static String arquivoAvaliacao;
    private static AvaliacaoDAO dadosAvaliacao;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList colecao = null;

        while (true) {
            try {
                arquivoAluno = leitor("Informe o nome do arquivo com os dados dos alunos"
                        + "\n DICA: q");
                if (GerenciadorArquivos.existeArquivo(arquivoAluno)) { // So cria se o arquivo nao existir
                    colecao = (ArrayList) GerenciadorArquivos.abrirArquivo(arquivoAluno);
                    dadosAluno = new AlunoDAO(colecao); // objeto contendo a colecao
                } else {
                    GerenciadorArquivos.criarArquivo(arquivoAluno);
                    dadosAluno = new AlunoDAO(new ArrayList());
                }
                break;
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possÌvel abrir o arquivo");
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (CampoVazioException cve) {
                JOptionPane.showMessageDialog(null, cve.getMessage());
            } catch (NullPointerException npe) {
                JOptionPane.showMessageDialog(null, "Fechando a aplicação");
                System.exit(0);
            }
        }

        while (true) {
            try {
                arquivoProfessor = leitor("Informe o nome do arquivo com os dados dos professores"
                        + "\n DICA: w");
                if (GerenciadorArquivos.existeArquivo(arquivoProfessor)) { // So cria se o arquivo nao existir
                    colecao = (ArrayList) GerenciadorArquivos.abrirArquivo(arquivoProfessor);
                    dadosProfessor = new ProfessorDAO(colecao); // objeto contendo a colecao
                } else {
                    GerenciadorArquivos.criarArquivo(arquivoProfessor);
                    dadosProfessor = new ProfessorDAO(new ArrayList());
                }
                break;
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possÌvel abrir o arquivo");
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (CampoVazioException cve) {
                JOptionPane.showMessageDialog(null, cve.getMessage());
            } catch (NullPointerException npe) {
                JOptionPane.showMessageDialog(null, "Fechando a aplicação");
                System.exit(0);
            }
        }

        while (true) {
            try {
                arquivoProposta = leitor("Informe o nome do arquivo com os dados das propostas"
                        + "\n DICA: e");
                if (GerenciadorArquivos.existeArquivo(arquivoProposta)) { // So cria se o arquivo nao existir
                    colecao = (ArrayList) GerenciadorArquivos.abrirArquivo(arquivoProposta);
                    dadosProposta = new PropostaDAO(colecao); // objeto contendo a colecao
                } else {
                    GerenciadorArquivos.criarArquivo(arquivoProposta);
                    dadosProposta = new PropostaDAO(new ArrayList());
                }
                break;
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possÌvel abrir o arquivo");
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (CampoVazioException cve) {
                JOptionPane.showMessageDialog(null, cve.getMessage());
            } catch (NullPointerException npe) {
                JOptionPane.showMessageDialog(null, "Fechando a aplicação");
                System.exit(0);
            }
        }

        while (true) {
            try {
                arquivoBanca = leitor("Informe o nome do arquivo com os dados da banca"
                        + "\n DICA: r");
                if (GerenciadorArquivos.existeArquivo(arquivoBanca)) { // So cria se o arquivo nao existir
                    colecao = (ArrayList) GerenciadorArquivos.abrirArquivo(arquivoBanca);
                    dadosBanca = new BancaDAO(colecao); // objeto contendo a colecao
                } else {
                    GerenciadorArquivos.criarArquivo(arquivoBanca);
                    dadosBanca = new BancaDAO(new ArrayList());
                }
                break;
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possÌvel abrir o arquivo");
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (CampoVazioException cve) {
                JOptionPane.showMessageDialog(null, cve.getMessage());
            } catch (NullPointerException npe) {
                JOptionPane.showMessageDialog(null, "Fechando a aplicação");
                System.exit(0);
            }
        }
        while (true) {
            try {
                arquivoAvaliacao = leitor("Informe o nome do arquivo com os dados da avaliacao"
                        + "\n DICA: t");
                if (GerenciadorArquivos.existeArquivo(arquivoAvaliacao)) { // So cria se o arquivo nao existir
                    colecao = (ArrayList) GerenciadorArquivos.abrirArquivo(arquivoAvaliacao);
                    dadosAvaliacao = new AvaliacaoDAO(colecao); // objeto contendo a colecao
                } else {
                    GerenciadorArquivos.criarArquivo(arquivoAvaliacao);
                    dadosAvaliacao = new AvaliacaoDAO(new ArrayList());
                }
                break;
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possÌvel abrir o arquivo");
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (CampoVazioException cve) {
                JOptionPane.showMessageDialog(null, cve.getMessage());
            } catch (NullPointerException npe) {
                JOptionPane.showMessageDialog(null, "Fechando a aplicação");
                System.exit(0);
            }
        }

        MenuPrincipal.exibir();

    }

    public static void encerrar() {
        JOptionPane.showMessageDialog(null, "Fechando a aplicação");
        try {
            GerenciadorArquivos.salvarArquivo(dadosAluno.getColecao(), arquivoAluno);
        } catch (IOException ioex) {
            JOptionPane.showMessageDialog(null, "Não foi possível salvar os dados do aluno");
            ioex.printStackTrace(); // Para ajudar a debugar
        }
        try {
            GerenciadorArquivos.salvarArquivo(dadosProfessor.getColecao(), arquivoProfessor);
        } catch (IOException ioex) {
            JOptionPane.showMessageDialog(null, "Não foi possível salvar os dados do professor");
            ioex.printStackTrace(); // Para ajudar a debugar
        }
        try {
            GerenciadorArquivos.salvarArquivo(dadosProposta.getColecao(), arquivoProposta);
        } catch (IOException ioex) {
            JOptionPane.showMessageDialog(null, "Não foi possível salvar os dados das propostas");
            ioex.printStackTrace(); // Para ajudar a debugar
        }
        try {
            GerenciadorArquivos.salvarArquivo(dadosBanca.getColecao(), arquivoBanca);
        } catch (IOException ioex) {
            JOptionPane.showMessageDialog(null, "Não foi possível salvar os dados da banca");
            ioex.printStackTrace(); // Para ajudar a debugar
        }
        try {
            GerenciadorArquivos.salvarArquivo(dadosAvaliacao.getColecao(), arquivoAvaliacao);
        } catch (IOException ioex) {
            JOptionPane.showMessageDialog(null, "Não foi possível salvar os dados da avaliacao");
            ioex.printStackTrace(); // Para ajudar a debugar
        }

        System.exit(0);
    }

    public static String leitor(String mensagem) throws CampoVazioException, NullPointerException {
        String dado = JOptionPane.showInputDialog(null, mensagem);
        if (dado.equals("")) {
            throw new CampoVazioException("Campo não preenchido");
        }
        return dado;
    }

}
