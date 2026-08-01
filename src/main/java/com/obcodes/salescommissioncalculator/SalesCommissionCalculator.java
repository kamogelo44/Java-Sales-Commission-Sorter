/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.obcodes.salescommissioncalculator;

/**
 *
 * @author Obakeng Phale
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

//Required Imports:
import java.text.DecimalFormat;

public class SalesCommissionCalculator {

    public static void main(String[] args) {
        //We will use this to convert the totals into a currency format
        DecimalFormat currency = new DecimalFormat("R#,##0.00");

        /*
        a. We have to create arrays for the 10 employees. 
        The first array will store their names, and the second array will store their total sales.
        */
        String[] names = {"James Boyd", "Mpho Baloyi", "Timothy Ryan", "Daniel Ramogotshi", "William Seimela", "Harold Xaba", "Miller Bentley", "Sam Sithole", "Richard Frey", "Peter Sebata"};
        double[] totalSales = {40000.00, 54321.00, 12345.60, 60444.40, 23457.80, 43222.30, 12444.00, 12444.00, 23555.00, 45666.00};
        
        //We will create a new array to hold the calculated commissions for each employee
        double[] commissions = new double[10];
        
        //We run a loop to calculate the commission for each person based on their sales
        for (int i = 0; i < 10; i++) {
            commissions[i] = CalculateCommission(totalSales[i]);
        }

        /*
        d. We call the display method to show the information in a table.
        We do this BEFORE sorting so the user can see the original order.
        */
        System.out.println("Employee Sales Commission (Before Sorting)");
        displayEmployeeInfo(names, totalSales, commissions, currency);
        displayTotals(totalSales, commissions, currency);

        /*
        f. We call the bubble sort method to sort the employees by total sales.
        After this method runs, the arrays will be rearranged in ascending order.
        */
        bubbleSort(totalSales, commissions, names);

        //We display the table again AFTER sorting so the user can see the difference
        System.out.println("\nEmployee Sales Commission (After Sorting)");
        displayEmployeeInfo(names, totalSales, commissions, currency);
        displayTotals(totalSales, commissions, currency);
    }

    /*
    e. We created this method to display the employee details in a clean table.
    It prints the names, total sales, and commissions in aligned columns.
    */
    public static void displayEmployeeInfo(String[] names, double[] totalSales, double[] commissions, DecimalFormat currency) {
        System.out.println("==================================================");
        System.out.printf("%-20s%-15s%-15s%n", "Sales Person", "Total Sales", "Commission");
        System.out.println("==================================================");
        for (int a = 0; a < 10; a++) {
            System.out.printf("%-20s%-15s%-15s%n", names[a], currency.format(totalSales[a]), currency.format(commissions[a]));
        }
        System.out.println("==================================================");
    }

    /*
    e. This method calculates the grand totals for the sales and commissions.
    It loops through the arrays, adds up the values, and prints them at the bottom of the table.
    */
    public static void displayTotals(double[] totalSales, double[] commissions, DecimalFormat currency) {
        double totalSalesAmount = 0.0;
        double totalCommission = 0.0;
        for (double sales : totalSales) {
            totalSalesAmount += sales;
        }
        for (double commission : commissions) {
            totalCommission += commission;
        }
        System.out.printf("Totals: " + currency.format(totalSalesAmount) + " " + currency.format(totalCommission));
        System.out.println();
    }

    /*
    b and c. This method calculates the commission percentage based on the total sales.
    The rules are:
    - If the total sales is less than R20,000, the commission is 3%.
    - If the total sales is between R20,000 and R50,000, the commission is 5%.
    - If the total sales is R50,000 or more, the commission is 9%.
    */
    public static double CalculateCommission(double totalSales) {
        double commission = 0.0;
        if (totalSales < 20000) {
            commission = totalSales * 0.03;
        } else if (totalSales >= 20000 && totalSales < 50000) {
            commission = totalSales * 0.05;
        } else if (totalSales >= 50000) {
            commission = totalSales * 0.09;
        }
        return commission;
    }

    /*
    f. This is the Bubble Sort algorithm implementation.
    It sorts the totalSales array in ascending order. 
    Because we want to keep the data aligned, we swap the names and commissions
    at the same time we swap the sales figures.
    */
    public static void bubbleSort(double[] totalSales, double[] commissions, String[] names) {
        int n = 10; // We are sorting 10 employees
        for (int a = 0; a < n - 1; a++) {
            for (int b = 0; b < n - a - 1; b++) {
                if (totalSales[b] > totalSales[b + 1]) {
                    // Swap totalSales
                    double tempSales = totalSales[b];
                    totalSales[b] = totalSales[b + 1];
                    totalSales[b + 1] = tempSales;

                    // Swap commissions to keep them matched with the correct person
                    double tempCommission = commissions[b];
                    commissions[b] = commissions[b + 1];
                    commissions[b + 1] = tempCommission;

                    // Swap names to keep them matched with the correct sales and commission
                    String tempName = names[b];
                    names[b] = names[b + 1];
                    names[b + 1] = tempName;
                }
            }
        }
    }
}
