package com.company;
import java.security.SecureRandom;
import java.util.Scanner;
import java.util.Random;
class Main{
    private static int n1 = 0;
    private static int n2 = 0;
    private static int mathQ = 0;

    private static String generateQuestion(int level) {
        SecureRandom random = new SecureRandom();
        boolean solvedmath = false;
        if (mathQ == 4) {
            mathQ = random.nextInt(3) + 1;
        }
        while (!solvedmath) {

            if (level == 1) {

                n1 = random.nextInt(9) + 1;
                n2 = random.nextInt(9) + 1;

            } else if (level == 2) {

                n1 = random.nextInt(99) + 1;
                n2 = random.nextInt(99) + 1;

            } else if (level == 3) {

                n1 = random.nextInt(999) + 1;
                n2 = random.nextInt(999) + 1;

            } else if (level == 4) {

                n1 = random.nextInt(9999) + 1;
                n2 = random.nextInt(9999) + 1;

            }

            solvedmath = true;



            if ((mathQ == 4) && (n1 % n2 != 0)) {

                solvedmath = false;

            }
            if ((mathQ == 3) && (n1 < n2)) {

                solvedmath = false;

            }

        }if (mathQ == 1) {

            return String.format("How much is %d + %d?", n1, n2);

        } else if (mathQ == 2) {

            return String.format("How much is %d * %d?", n1, n2);

        } else if (mathQ == 3) {

            return String.format("How much is %d - %d?", n1, n2);

        } else  {

            return String.format("How much is %d / by %d?", n1, n2);
        }
    }
    private static boolean verifyAnswer(double input) {
        if (mathQ == 1) {
            return Double.compare(input, (double) (n1 + n2)) == 0;

        } else if (mathQ == 2) {
            return Double.compare(input, (double) (n1 * n2)) == 0;

        } else if (mathQ == 3) {
            return Double.compare(input, (double) (n1 - n2)) == 0;

        } else {
            return Double.compare(input, ((double) n1 / (double) n2)) == 0;

        }
    }
    private static String rightAnswer() {

        SecureRandom random = new SecureRandom();
        int randomNum = random.nextInt(3) + 1;
        String response;
        switch (randomNum) {
            case 1:
                response = "Very good!";
                break;
            case 2:
                response = "Excellent!";
                break;
            case 3:
                response = "Nice work!";
                break;
            default:
                response = "Keep up the good work!";
                break;
        }
        return response;
    }
    private static String incorrectAnswer() {

        SecureRandom random = new SecureRandom();
        int randomNumber = random.nextInt(3) + 1;
        String response;
        switch (randomNumber) {
            case 1:
                response = "No.Please try again.";
                break;
            case 2:
                response = "Wrong. try once more.";
                break;
            case 3:
                response = "Don’t give up!";
                break;
            default:
                response = "No. Keep trying.";
                break;
        }
        return response;
    }
    private static int lvlDifficulty() {

        Scanner scnr = new Scanner(System.in);
        System.out.println("Select Difficulty Level:");
        System.out.println("Press '1' to populate Lvl: 1: ");
        System.out.println("Press '2' to populate Lvl 2: ");
        System.out.println("Press '3' to populate Lvl 3: ");
        System.out.println("Press '4' to populate Lvl 4: ");

        return scnr.nextInt();
    }
    private static int SelectProblemType() {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Select Problem Type:");
        System.out.println("Press '1' for + Addition Problems Only");
        System.out.println("Press '2' for * Multiplication Problems Only");
        System.out.println("Press '3' for - Subtration Problems Only");
        System.out.println("Press '4' for / Division Problems Only");
        System.out.println("Press '5' for Randomly Generated Problems");

        return scnr.nextInt();
    }
    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);

        int correctAnswers = 0;

        int difficultyLvl = 0;

        double input = 0.0;

        String question = "";

        boolean end = false;

        System.out.println("Choose a level of difficulty (ranging from 1 - 5):");

        while (!end) {

            difficultyLvl = lvlDifficulty();

            System.out.println();

            mathQ = SelectProblemType();
            System.out.println();
            System.out.println("Level " + difficultyLvl + ":");

            for (int i = 0; i < 10; i++) {

                question = generateQuestion(difficultyLvl);

                System.out.println("Question " + (i + 1) + ": " + question);

                input = scnr.nextDouble();

                if (verifyAnswer(input)) {

                    System.out.println(rightAnswer());
                    correctAnswers++;

                } else {

                    System.out.println(incorrectAnswer());

                }
            }

            System.out.println("Total correct answers: " + correctAnswers);
            System.out.println("Total incorrect answers: " + (10 - correctAnswers));

            if (correctAnswers <= 7) {

                System.out.println("You should ask ya teacher for some assistance");

            } else {

                System.out.println("Nice, you are ready to level-up!");
            }

            correctAnswers = 0;


            System.out.println("Enter 'YES' to Continue or 'NO' to End");


            System.out.println("Do you want to continue with a new round of questions?");
            if (scnr.next().charAt(0) == 'n') {

                end = true;
            } } }}