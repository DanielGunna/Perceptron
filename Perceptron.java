/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptron;

import javax.swing.JOptionPane;

/**
 *
 * @author 940437
 */
public class Perceptron {
    private static final int AND_OPERATION  = 0 ;
    private static final int OR_OPERATION  =  1 ;
    private static final int XOR_OPERATION  = 2 ;
    
    public static int readInt(String msg) {
        try {
            return Integer.parseInt(JOptionPane.showInputDialog(null, msg));
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int learnfactor = readInt("Insira  o fato de aprendizagem :");
        int iterations =  readInt("Insira  o  numero de iterações  :");
        int operation =   readInt("Insira  o  codigo da operação (0- AND, 1-OR, 2-XOR):");
        
        int[][] tesInput = 
        {
            {1,0,0},
            {1,1,0},
            {1,1,1},
            {0,0,0},
            {0,0,1},
            {0,1,0},
            {0,1,1},
        };
        
        

    }

}
