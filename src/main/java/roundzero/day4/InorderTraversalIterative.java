package roundzero.day4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Gaurav on 01/10/17.
 */
public class InorderTraversalIterative {


    public static void main(String args[]) throws Exception {
        System.out.println("Hello World! eneter nodes seprated by space");
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] splittedInput = line.split(" ");
        BinaryTree binaryTree = new BinaryTree();
        for (int i = 0; i < splittedInput.length; i++) {
            int data = Integer.parseInt(splittedInput[i]);
            binaryTree.insert(data);
        }
        binaryTree.printPreOrder();
        System.out.println(" ");
        binaryTree.printInOrder();
        System.out.println(" ");
        binaryTree.printPostOrder();
        System.out.println(" ");
        binaryTree.recursiveInOrder();
        System.out.println("iterativePreOrder ");
        binaryTree.iterativePreOrder();

    }


}
