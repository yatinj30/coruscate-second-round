package tasktwo;

import java.util.*;

/**
 *
 * @author yatinj
 */
public class SeatsArrangement {

    public static void main(String[] args) throws InvalidTestCaseException, InvalidSeatNumberException {
        Scanner sc = new Scanner(System.in);

        int[] seatNumber;
        int testCase = sc.nextInt();
        
        if (testCase < 1 || testCase > 105) {    //validating testCase input, if fails throw exception
            throw new InvalidTestCaseException("Allows 1 to 105.");
        } else {
            seatNumber = new int[testCase];     //creating array of required size
            
            for (int i = 0; i < testCase; i++) {  //taking inputs for number of testCase times
                seatNumber[i] = sc.nextInt();
                if (seatNumber[i] < 1 || seatNumber[i] > 108) {   //throw exception when seatNumbers are out of range
                    throw new InvalidSeatNumberException("Allows 1 to 108.");
                }
            }
        }

        for (int j = 0; j < testCase; j++) {  //run for number of testCase time.
            
            int newSeatNumber = 0;
            String newSeatType = "";
            int val = seatNumber[j] % 12;   //module by 12 gives us location of seat in form of 12 seats group.
            
            
            switch (val) {
                //12 seats group further devides in 6 and 3 seats as the arrangement
                //val=1,6,7,0 always window seat because 1 line contain 6 seat and their outer number is 1 and 6; for other line it is 7 and 12.
                //val=2,5,8,11; 2%5 is middle of 1 to 6. and 8&11 is middle of 7 to 12.
                //val=3,4,9,10 always aisle seat as per 3 seats arrangement.
                
                //here is the cases for first six seats for group of 12 seats.    
                case 1:
                    newSeatNumber = seatNumber[j] + 11;  //adding number gives it's opposite seat number.
                    newSeatType = "WS";
                    break;
                case 2:
                    newSeatNumber = seatNumber[j] + 9;
                    newSeatType = "MS";
                    break;
                case 3:
                    newSeatNumber = seatNumber[j] + 7;
                    newSeatType = "AS";
                    break;
                case 4:
                    newSeatNumber = seatNumber[j] + 5;
                    newSeatType = "AS";
                    break;
                case 5:
                    newSeatNumber = seatNumber[j] + 3;
                    newSeatType = "MS";
                    break;
                case 6:
                    newSeatNumber = seatNumber[j] + 1;
                    newSeatType = "WS";
                    break;
                //here is the cases for last six seats for group of 12 seats.    
                case 7:
                    newSeatNumber = seatNumber[j] - 1;      //removing gives it's opposite seat number.
                    newSeatType = "WS";
                    break;
                case 8:
                    newSeatNumber = seatNumber[j] - 3;
                    newSeatType = "MS";
                    break;
                case 9:
                    newSeatNumber = seatNumber[j] - 5;
                    newSeatType = "AS";
                    break;
                case 10:
                    newSeatNumber = seatNumber[j] - 7;
                    newSeatType = "AS";
                    break;
                case 11:
                    newSeatNumber = seatNumber[j] - 9;
                    newSeatType = "MS";
                    break;
                case 0:
                    newSeatNumber = seatNumber[j] - 11;
                    newSeatType = "WS";
                    break;
                default:
                    System.out.print("Something Wrong");
                    break;
            }
            System.out.print(newSeatNumber + " " + newSeatType + "\n");   //priting out the final seat number and its type.
        }
    }
}

//custom exceptions for validation
class InvalidTestCaseException extends Exception {

    InvalidTestCaseException(String s) {
        super(s);
    }
}

class InvalidSeatNumberException extends Exception {

    InvalidSeatNumberException(String s) {
        super(s);
    }
}
