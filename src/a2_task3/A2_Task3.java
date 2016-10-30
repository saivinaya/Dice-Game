/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a2_task3;

import java.util.*;
/**
 * Take the input from the user for number of times the dice needs to be rolled and output the graph showing the sum of dies, 
 * main method is used to take the input from user, 
 * generateDiceRoll() is for generating the dice roll for given number of times by the user,
 * printGraph() prints the actual graph required
 * @author VinayaSaiD
 */
public class A2_Task3 {
    public static int[] resultsSum = {0,0,0,0,0,0,0,0,0,0,0,0,0};
    public static int numberOfRolls=0;
    
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        System.out.print("Enter the number of rolls for the two dice: ");
        // Take the number of rolls from the user
        numberOfRolls = input.nextInt();
        // go to generateDiceRoll method
        generateDiceRoll();
    }
    public static void generateDiceRoll()
        {
        int firstDice=0;
        int secondDice=0;
        int sum=0;

        for (int i=0;i<numberOfRolls;i++)
        {
            Random rn = new Random();
            // Generating random  number from 1 to 6 for each dice
            firstDice = 1 + rn.nextInt((6-1) + 1); // Random number between 1 and 6 Both included
            secondDice = 1 + rn.nextInt((6-1) + 1);// Random number between 1 and 6 Both included
            sum = firstDice+secondDice;
            // maintaning a record of the sum for each roll in an array by couting them
            resultsSum[sum] = resultsSum[sum] + 1;
        }
        // go to printGraph method
        printGraph();
        }
      
    public static void printGraph()
    {
        double sumTotal = 0;
        for (int j : resultsSum){
            sumTotal += j;
            }
        System.out.format("Number of rolls is %d \n",numberOfRolls);
        //This for loop is to print the percentage of each Sum
        for (int k=2;k<=12;k++) {
            System.out.format("Percentage of Sum of two dies being %d : %.2f \n",k, (resultsSum[k]/sumTotal*100));
        }
        System.out.println();
        // This is to print the bar graph for the sum of values
        for (int k=2;k<=12;k++)
        {   String stringOutput = "";
            double percentage = resultsSum[k]/sumTotal*100;
            // one * for 1 percentage
            for (int i =1;i<=percentage; i++)
            {
                stringOutput = stringOutput + "*";
            }
            System.out.format("Sum of two dies being %2d : %s\n",k,stringOutput);
        }
            
     }
}
