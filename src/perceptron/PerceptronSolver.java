package perceptron;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Orhan Demirel
 */
public class PerceptronSolver {

    double[] weights;
    double threshold;
    private int size;
    private double[][] trainData;
    private double[] inputs;
    private OperationType op;
    private double[] outputs;
    private int iters;
    private double learnRate;
    private int result;
    double weightBias;

    public int getResult() {
        return result;
    }

    public void train(double[] inputs, double threshold, double lrate, int iter, OperationType op) {
        this.inputs = inputs;
        this.threshold = threshold;
        this.size = inputs.length;
        this.weights = new double[size];
        this.iters = iter;
        this.op = op;
        this.learnRate = lrate;
        generateTrainData();
        this.outputs = generateOutputs();
        getRandomWeights();
        trainData();
        solve();
    }

    private void getRandomWeights() {
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            weights[i] = 0.5;
        }
    }

    private ArrayList<String> getBinaries(int bits, String current) {
        ArrayList<String> binaries = new ArrayList<>();
        if (current.length() == bits) {
            binaries.add(current);
            return binaries;
        }

        binaries.addAll(getBinaries(bits, "0" + current));
        binaries.addAll(getBinaries(bits, "1" + current));

        return binaries;
    }

    private double[] generateOutputs() {
        double[] output = new double[trainData.length];
        for (int i = 0; i < trainData.length; i++) {
            output[i] = getOutput(trainData[i]);
            System.out.println(Arrays.toString(trainData[i])+" "+output[i]);
        }
        return output;
    }

    private void generateTrainData() {
        trainData = getAsArray(getBinaries(inputs.length, ""));
        //System.out.println(getBinaries(inputs.length, ""));
        //show();
    }

    private void show() {
        for (int i = 0; i < trainData.length; i++) {
            for (int x = 0; x < trainData[0].length; x++) {
                System.out.print(trainData[i][x] + ",");
            }
            System.out.println("\n");
        }
    }

    private double[][] getAsArray(ArrayList<String> binaries) {
        double[][] data = new double[binaries.size()][size];
        int c = 0;
        for (String s : binaries) {
            for (int x = 0; x < s.length(); x++) {
                data[c][x] = Double.parseDouble(s.charAt(x) + "");
            }
            c++;
        }
        return data;
    }

    public double getOutput(double[] d) {
        switch (op) {
            case AND:
                return OperationsUtils.and(d);
            case OR:
                return OperationsUtils.or(d);
            case XOR:
                return OperationsUtils.xor(d);
            default:
                return OperationsUtils.and(d);
        }
    }

    private void trainData() {
        for (int i = 0; i < iters; i++) {
            //int totalError = 0;
            for (int j = 0; j < trainData.length; j++) {
                int output = multiplyWeights(trainData[j]);
                int error = (int) (outputs[j] - output);
               // totalError += error;
                for (int k = 0; k < size; k++) {
                    double delta = learnRate * trainData[j][k] * error;
                    weights[k] += delta;
                }
                weightBias+=learnRate*error;
                
            }
            //if (totalError == 0) {
            //    break;
            //}
        }
    }

    private int multiplyWeights(double[] input) {
        double sum = 0.0;
        for (int i = 0; i < input.length; i++) {
            sum += weights[i] * input[i];
        }
        sum+=weightBias;
        System.out.println(sum);
        return (sum > threshold) ? 1 : 0;
    }

    private void solve() {
        System.out.println(Arrays.toString(weights));
        result = multiplyWeights(inputs);
        System.out.println(Arrays.toString(inputs) + " " + result);
    }

}
