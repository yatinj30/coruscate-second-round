package taskone;

import java.util.*;

/**
 *
 * @author yatinj
 */
public class ChocolatesDistribution {

    public static void main(String[] args) throws InvalidTestCaseException, InvalidChocolatesException, InvalidStudentsException {
        Scanner sc = new Scanner(System.in);

        int[] noOfChocolates;
        int[] noOfStudent;
        int testCase = sc.nextInt();
        
        if (testCase < 1 || testCase > 10) {    //validating testCase input, if fails throw exception
            throw new InvalidTestCaseException("Allows 1 to 10.");
        } else {
            noOfChocolates = new int[testCase];     //creating array of required size
            noOfStudent = new int[testCase];
            
            for (int i = 0; i < testCase; i++) {   //taking inputs for number of testCase times
                noOfChocolates[i] = sc.nextInt();
                noOfStudent[i] = sc.nextInt();
                if (noOfChocolates[i] < 1 || noOfChocolates[i] > 1000) {    //throw exception when chocolates are out of range
                    throw new InvalidChocolatesException("Allows 1 to 1000.");
                }
                if (noOfStudent[i] < 1 || noOfStudent[i] > 100) {       //throw exception when students are out of range
                    throw new InvalidStudentsException("Allows 1 to 100.");
                }
            }
        }

        for (int j = 0; j < testCase; j++) {  //run for number of testCase time.

            int minChocolateDistribution = (noOfStudent[j] * (noOfStudent[j] + 1)) / 2;      //minimum chocolate required for distribution.

            if (minChocolateDistribution > noOfChocolates[j]) {
                System.out.println(noOfChocolates[j]);     //if there isn't minimum chocolate
            } else {        //if there is more than minimum chocolate
                int leftChocolates = (noOfChocolates[j] - minChocolateDistribution) % noOfStudent[j];
                //module by students means we remove maximum chocolates that equals to number of students.
                //so we can again distribute it as last some or 0 chocolate left
                System.out.println(leftChocolates);
            }
        }

    }
}

//custom exceptions for validation
class InvalidTestCaseException extends Exception {

    InvalidTestCaseException(String s) {
        super(s);
    }
}

class InvalidChocolatesException extends Exception {

    InvalidChocolatesException(String s) {
        super(s);
    }
}

class InvalidStudentsException extends Exception {

    InvalidStudentsException(String s) {
        super(s);
    }
}
