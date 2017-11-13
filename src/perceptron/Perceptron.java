package perceptron;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package perceptron;
import java.io.BufferedReader;
import java.io.File;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import static perceptron.OperationType.AND;
import static perceptron.OperationType.OR;
import static perceptron.OperationType.XOR;

/**
 *
 * @author 940437
 */
public class Perceptron {

    private static final int AND_OPERATION = 0;
    private static final int OR_OPERATION = 1;
    private static final int XOR_OPERATION = 2;
    private static final int MAX_VALUES = 6;
    private static OperationType selectedOp;
    private static ArrayList<double[]> input;

    private static int[] expected;

    public static int readInt(String msg) {
        try {
            return Integer.parseInt(JOptionPane.showInputDialog(null, msg));
        } catch (Exception e) {
            return 0;
        }
    }

    public static String openFile() {
        JFileChooser chooser = new JFileChooser();
        chooser.addChoosableFileFilter(new FileNameExtensionFilter("Arquivos de Texto", ".txt"));
        int returned = chooser.showOpenDialog(null);
        if (returned == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile().getAbsolutePath();
        } else {
            return null;
        }
    }

    public static void readInput() {
        input = new ArrayList<>();
        String file = openFile();
        if (file == null) {
            return;
        }
        File trainFile = new File(file);
        try {
            readFromFile(trainFile);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void readFromFile(File trainFile) throws Exception {
        BufferedReader fileReader = new BufferedReader(new FileReader(trainFile));
        Scanner in = new Scanner(trainFile);
        String line = "";
        while ((line = fileReader.readLine()) != null) {
            line += ",1";
            String[] values = line.split(",");
            //System.out.println(line);
            input.add(getAsIntArray(values));
        }
        fileReader.close();
        in.close();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        readInput();
        selectedOp = getOpTime(readInt("Insira  o  codigo da operação (0- AND, 1-OR, 2-XOR):"));
        float lf = (float) readDouble("Insira o fator de aprendizagem");
        int iterations = readInt("Insira o número de iterações");
        for(double[] i : input){
             PerceptronSolver p =  new PerceptronSolver();
             p.train(i, 0.5, lf, iterations, selectedOp);
             double result = p.getOutput(i);
             System.out.println(
                     "==========================================="
                     + "\n\nOPERATION:"+selectedOp.name()+
                     "\nINPUT : "+Arrays.toString(i)+
                     "\nRESULT: "+p.getResult()+
                     "\nCORRECT RESULT : "+ result +
                     "\nSTATUS :"+ (result == p.getResult() ? "[CORRECT]" : "[WRONG]")) ;
        }
//        double[] vet = {0, 0,0,0,0,0,0,0,0};
//        PerceptronSolver p = new PerceptronSolver();
//        p.train(vet, 0.0, 0.3f, 500,OR);

    }

    private static double[] getAsIntArray(String[] values) {
        double[] v = new double[values.length];
        for (int x = 0; x < values.length; x++) {
            v[x] = Integer.parseInt(values[x]);
        }
        return v;
    }

    private static OperationType getOpTime(int readInt) {
        switch (readInt) {
            case 0:
                return AND;
            case 1:
                return OR;
            case 2:
                return XOR;
            default:
                return AND;

        }
    }

    private static double readDouble(String msg) {
        try {
            return Double.parseDouble(JOptionPane.showInputDialog(null, msg));
        } catch (Exception e) {
            return 0;
        }
    }

}
