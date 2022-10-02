package HomeWorks.lesson10;

import HomeWorks.lesson10.entity.Client;
import HomeWorks.lesson10.exception.WrongFieldException;
import HomeWorks.lesson10.exception.WrongSumException;
import HomeWorks.lesson10.service.TransactionService;
import HomeWorks.lesson10.util.Helper;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    //HOMEWORK 08

    public static void main(String[] args) {
        System.out.println("--- Homework 08, lesson10 ---\n");
        Scanner scanner = new Scanner(System.in);
        Helper helper = new Helper();
        Client sender = new Client();
        Client recipient = new Client();
        TransactionService transaction = new TransactionService();

        System.out.println("START MONEY TRANSACTION");
        System.out.println("=======================");

        // set sender AccountID
        System.out.println("Please, enter the account ID for the sender. \nAccount ID must contain 10 symbols:");
        do {
            sender.setClientAccountID(scanner.nextLine().strip());
            try {
                helper.checkAccountID(sender.getClientAccountID());
            } catch (WrongFieldException e) {
                System.out.println(String.format("Wrong account ID length for sender: %s \nAccount ID must contain 10 symbols. \nPlease, enter correct account ID:", sender.getClientAccountID().length()));
            }
        } while (sender.getClientAccountID().length() != 10);
        System.out.println(String.format("The sender's account ID is accepted: \"%s\"", sender.getClientAccountID()));
        System.out.println("------------------------------------");

        // set recipient AccountID
        System.out.println("Please, enter the account ID for the recipient. \nAccount ID must contain 10 symbols:");
        do {
            recipient.setClientAccountID(scanner.nextLine().strip());
            try {
                helper.checkAccountID(recipient.getClientAccountID());
            } catch (WrongFieldException e) {
                System.out.println(String.format("Wrong account ID length for recipient: %s \nAccount ID must contain 10 symbols. \nPlease, enter correct account ID:", recipient.getClientAccountID().length()));
            }
        } while (recipient.getClientAccountID().length() != 10);
        System.out.println(String.format("The recipient's account ID is accepted: \"%s\"", recipient.getClientAccountID()));
        System.out.println("---------------------------------------");

        // set sum of transaction
        System.out.println("Please, enter the transaction amount. Maximum sum - 10 000:");
        double input = 0;
        do {
            System.out.println("Please, enter amount from 0,01 to 10 000:");
            //catch wrong symbols
            try {
                input = scanner.nextDouble();

                //catch wrong amount
                try {
                    helper.checkSum(input);
                } catch (WrongSumException e) {
                    if (input < 0.01) System.out.println("The amount is less than allowed!");
                    if (input > 10_000) System.out.println("Exceeded the maximum amount!");
                    input = 0;
                }

            } catch (InputMismatchException e) {
                System.out.println("Only numbers allowed for input!");
                scanner = new Scanner(System.in);
            }

        } while (input < 0.01 || input > 10_000);

        // accept sum
        sender.setSum(input);
        System.out.println("-----------------------------------");
        System.out.println(String.format("Transaction sum \'%.2f\' accepted!", sender.getSum()));
        System.out.println("-----------------------------------");

        transaction.sendMoney(sender,recipient.getClientAccountID());
        System.out.println();
        System.out.println("====== TRANSACTION COMPLETED ======");
//        System.out.println("-----------------------------------");





    }
}
