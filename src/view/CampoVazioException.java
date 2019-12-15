/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Gui
 */
public class CampoVazioException extends Exception {

    /**
     * Creates a new instance of <code>CampoVazioException</code> without detail
     * message.
     */
    public CampoVazioException() {
    }

    /**
     * Constructs an instance of <code>CampoVazioException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CampoVazioException(String msg) {
        super(msg);
    }
}
