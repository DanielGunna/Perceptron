# Perceptron Algorithm implementation in Java

Implementation of  Perceptron Algorithm to solve a simple classification problem and show  the algorithm limitations, using  the  logical operations AND, OR and XOR. 
A simple user interface, that loads a file, was implemented to help the user handle the inputs  which  Perceptron algorithm uses.

# Using  implementaion of Perceptron Algorithm Logic
```java
\\An array with multiple inputs to be solved
 
 double[] input  = {0, 0,0,0,0,0,0,0,0};
 
 PerceptronSolver p = new PerceptronSolver();
 
 \\ The method that train the Perceptron Algorithm and evaluate the results 
 \\The params are : input, threshold, learn rate, number of iterations and operation 
 p.train(vet, 0.0, 0.3f, 500,OperationType.OR);
 
 \\Get the result 
 p.getResult();
```
## The possible operations are:
These operations are defined in  an enum contained on  the [OperationType.java](https://github.com/DanielGunna/Perceptron/blob/master/src/perceptron/OperationType.java) file.
```java
 p.train(vet, 0.0, 0.3f, 500,OperationType.AND);
 p.train(vet, 0.0, 0.3f, 500,OperationType.OR);
 p.train(vet, 0.0, 0.3f, 500,OperationType.XOR);
```
