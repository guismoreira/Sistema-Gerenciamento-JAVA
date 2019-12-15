/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Gui
 */
public class GerenciadorArquivos {

    public static boolean existeArquivo(String nomearq) {
        File file = new File(nomearq);
        return (file.exists());
    }

    public static void criarArquivo(String nomearq) throws IOException {
        if (!existeArquivo(nomearq)) {
            File file = new File(nomearq);
            file.createNewFile();
        }
    }

    public static void excluirArquivo(String nomearq) throws IOException {
        if (existeArquivo(nomearq)) {
            File file = new File(nomearq);
            file.delete();
        }
    }

    public static Object abrirArquivo(String nomearq) throws IOException, ClassNotFoundException {
        Object obj = null;
        File f = new File(nomearq);
        if (f.exists()) {
            FileInputStream in = new FileInputStream(f);
            ObjectInputStream sin = new ObjectInputStream(in);
            obj = sin.readObject();
            in.close();
        } else {
            System.out.println("\nO arquivo não existe");
        }
        return obj;
    }

    public static void salvarArquivo(Object obj, String nomearq) throws IOException {
        File f = new File(nomearq);
        FileOutputStream out = new FileOutputStream(f);
        ObjectOutputStream sout = new ObjectOutputStream(out);
        sout.writeObject(obj);
        out.close();
    }
}
