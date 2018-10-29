package ru.unn.agile.MortgageCalculator.Model;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
public class MortgageCalculatorTest {

    final private double epsilon = 0.1;
    final private int isNotCorrectNum = -1;

    @Test
    public void checkThatFullCostOfApartmentCorrectInitialized() {
        MortgageCalculator myMortgageCalculator = new MortgageCalculator();

        myMortgageCalculator.setFullCostOfApartment(100000.12);

        assertEquals(100000.12, myMortgageCalculator.getFullCostOfApartment(), epsilon);
    }

    @Test
    public void checkIfFullCostOfApartmentIsZero() {
        MortgageCalculator myMortgageCalculator = new MortgageCalculator();

        myMortgageCalculator.setFullCostOfApartment(0);

        assertEquals(isNotCorrectNum, myMortgageCalculator.getFullCostOfApartment(), epsilon);
    }

    @Test
    public void checkIfFullCostOfApartmentIsNegative() {
        MortgageCalculator myMortgageCalculator = new MortgageCalculator();

        myMortgageCalculator.setFullCostOfApartment(-300);

        assertEquals(isNotCorrectNum, myMortgageCalculator.getFullCostOfApartment(), epsilon);
    }

    @Test
    public void checkInitialPaymentCorrectInitialized() {
        MortgageCalculator myMortgageCalculator = new MortgageCalculator();

        myMortgageCalculator.setFullCostOfApartment(51000);
        myMortgageCalculator.setInitialPayment(50000.50);

        assertEquals(50000.50,myMortgageCalculator.getInitialPayment(), epsilon);
    }

    @Test
    public void checkThatInitialPaymentIsZero() {
        MortgageCalculator myMortgageCalculator = new MortgageCalculator();

        myMortgageCalculator.setInitialPayment(0);

        assertEquals(0, myMortgageCalculator.getInitialPayment(), epsilon);
    }

    @Test
    public void checkInitialPaymentIsNegative() {
        MortgageCalculator myMortgageCalculator = new MortgageCalculator();

        myMortgageCalculator.setInitialPayment(-10000);

        assertEquals(isNotCorrectNum, myMortgageCalculator.getInitialPayment(), epsilon);
    }

    @Test
    public void checkInitialPaymentIsMoreThenFullCost() {
        MortgageCalculator myMortgageCalculator = new MortgageCalculator();

        myMortgageCalculator.setFullCostOfApartment(100000);
        myMortgageCalculator.setInitialPayment(100001);

        assertEquals(isNotCorrectNum,myMortgageCalculator.getInitialPayment(),epsilon);
    }

    @Test
    public void checkDateOfMortgageInMonths() {
        MortgageCalculator myMortgageCalculator = new MortgageCalculator();

        myMortgageCalculator.setDateOfMortgage(10);

        assertEquals(10, myMortgageCalculator.getDateOfMortgage());
    }

    @Test
    public void checkDateOfMortgageInMonthsIsNegative() {
        MortgageCalculator myMortgageCalculator = new MortgageCalculator();

        myMortgageCalculator.setDateOfMortgage(-2);

        assertEquals(isNotCorrectNum, myMortgageCalculator.getDateOfMortgage());
    }

    @Test
    public void checkDateOfMortgageInMonthsIsZero() {
        MortgageCalculator myMortgageCalculator = new MortgageCalculator();

        myMortgageCalculator.setDateOfMortgage(0);

        assertEquals(isNotCorrectNum, myMortgageCalculator.getDateOfMortgage());
    }

    @Test
    public void checkInterestRate() {
        MortgageCalculator myMortgageCalculator = new MortgageCalculator();

        myMortgageCalculator.setInterestRate(50.0);

        assertEquals(50.0, myMortgageCalculator.getInterestRate(),epsilon);
    }

    @Test
    public void checkInterestRateIsNegative() {
        MortgageCalculator myMortgageCalculator = new MortgageCalculator();

        myMortgageCalculator.setInterestRate(-50.0);

        assertEquals(isNotCorrectNum, myMortgageCalculator.getInterestRate(), epsilon);
    }

    @Test
    public void checkPrincipalDebtInOneMonth() {
        MortgageCalculator myMortgageCalculator = new MortgageCalculator();

        myMortgageCalculator.setFullCostOfApartment(1000);
        myMortgageCalculator.setInitialPayment(0);
        myMortgageCalculator.setDateOfMortgage(12);

        assertEquals(83.3,myMortgageCalculator.getPrincipalDebt(),epsilon);
    }

    @Test
    public void checkPrincipalDebtInOneMonthWithInitialPayment() {
        MortgageCalculator myMortgageCalculator = new MortgageCalculator();

        myMortgageCalculator.setFullCostOfApartment(1000);
        myMortgageCalculator.setInitialPayment(100);
        myMortgageCalculator.setDateOfMortgage(12);

        assertEquals(75,myMortgageCalculator.getPrincipalDebt(),epsilon);
    }

    @Test
    public void checkInterestCharges() {
        MortgageCalculator myMortgageCalculator = new MortgageCalculator();

        myMortgageCalculator.setFullCostOfApartment(1000);
        myMortgageCalculator.setInterestRate(20);

        assertEquals(16.67,myMortgageCalculator.
                getAccruedInterest(myMortgageCalculator.getFullCostOfApartment()), epsilon);
    }

    @Test
    public void checkFullPriceInFirstMonthOfDate() {
        MortgageCalculator myMortgageCalculator = new MortgageCalculator();

        myMortgageCalculator.setFullCostOfApartment(1000);
        myMortgageCalculator.setInterestRate(20);

        assertEquals(100.0,myMortgageCalculator.
                getFullPrice(myMortgageCalculator.getFullCostOfApartment()),epsilon);
    }

    @Test
    public void checkPrincipalDebtIsCorrect() {
        MortgageCalculator myMortgageCalculator = new MortgageCalculator();

        myMortgageCalculator.setFullCostOfApartment(500.02);
        myMortgageCalculator.setDateOfMortgage(myMortgageCalculator.getDateOfMortgage()-6);
        myMortgageCalculator.setInterestRate(20);

        assertEquals(83.33,myMortgageCalculator.getPrincipalDebt(), epsilon);
    }

    @Test
    public void checkAccruedInterestIsCorrectInMiddleOfDate() {
        MortgageCalculator myMortgageCalculator = new MortgageCalculator();
        myMortgageCalculator.setFullCostOfApartment(500.02);
        myMortgageCalculator.setDateOfMortgage(myMortgageCalculator.getDateOfMortgage()-6);
        myMortgageCalculator.setInterestRate(20);

        assertEquals(8.33,myMortgageCalculator.
                getAccruedInterest(myMortgageCalculator.getFullCostOfApartment()),epsilon);
    }

    @Test
    public void checkAccruedInterestIsCorrectInLastMonth() {
        MortgageCalculator myMortgageCalculator = new MortgageCalculator();

        myMortgageCalculator.setFullCostOfApartment(83.37);
        myMortgageCalculator.setDateOfMortgage(myMortgageCalculator.getDateOfMortgage()-11);
        myMortgageCalculator.setInterestRate(20);

        assertEquals(1.39,myMortgageCalculator.
                getAccruedInterest(myMortgageCalculator.getFullCostOfApartment()),epsilon);
    }

    @Test
    public void checkAccruedInterestInTableView() {
        double[] expectedPayments = {16.67,15.28,13.89,12.50,11.11,9.72,8.33,6.94,5.56,4.17,2.78,1.39};
        double[] actualInterest;
        MortgageCalculator myMortgageCalculator = new MortgageCalculator();

        myMortgageCalculator.setFullCostOfApartment(1000);
        myMortgageCalculator.setDateOfMortgage(12);
        myMortgageCalculator.setInterestRate(20);
        myMortgageCalculator.setAccruedInterestInTableView();
        actualInterest = myMortgageCalculator.getAccruedInterestInTableView();

       assertArrayEquals(expectedPayments,actualInterest,epsilon);
    }

    @Test
    public void checkFullPriceInTableView() {
        double[] expectedPayments = {100,98.61,97.22,95.83,94.44,93.05,91.66,90.27,88.89,87.50,86.11,84.72};
        double[] actualPayments;
        MortgageCalculator myMortgageCalculator = new MortgageCalculator();

        myMortgageCalculator.setFullCostOfApartment(1000);
        myMortgageCalculator.setDateOfMortgage(12);
        myMortgageCalculator.setInterestRate(20);
        actualPayments = myMortgageCalculator.getFullPriceInTableView();

        assertArrayEquals(expectedPayments,actualPayments,epsilon);
    }
}
