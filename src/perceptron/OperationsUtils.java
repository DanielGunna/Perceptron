/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptron;

/**
 *
 * @author felipesilva
 */
public class OperationsUtils {

    public static int and(double[] input) {
        boolean r = true;
        for (int i = 0; i < input.length ; i++) {
            r = r && input[i] != 0;
        }
        return r ? 1 : 0;
    }

    public static int or(double[] input) {
        boolean r = false;
        for (int i = 0; i < input.length; i++) {
            r = r || input[i] != 0;
        }
        return r ? 1 : 0;
    }

    public static int xor(double[] input) {
        boolean r = true;
        for (int i = 0; i < input.length; i++) {
            r = r ^ input[i] != 0;
        }
        return r ? 1 : 0;
    }
}
