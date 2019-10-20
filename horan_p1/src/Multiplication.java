import java.util.Scanner;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

public class Multiplication {
    static void questionGen(int type, double firstInt, double secondInt)
    {
        switch (type)
        {
            case 1:
                System.out.println("How much is " + (int) firstInt + " plus " + (int) secondInt + "?");
                break;
            case 2:
                System.out.println("How much is " + (int) firstInt + " times " + (int) secondInt + "?");
                break;
            case 3:
                System.out.println("How much is " + (int) secondInt + " minus " + (int) firstInt + "?");
                break;
            case 4:
                if (secondInt == 0)
                    secondInt++;
                System.out.println("How much is " + (int) firstInt + " divided by " + (int) secondInt + "?");
                break;
        }
    }

    static void responseGen(int ind)  throws NoSuchProviderException, NoSuchAlgorithmException
    {
        SecureRandom secureRandomGenerator = SecureRandom.getInstance("SHA1PRNG", "SUN");
        int respond = secureRandomGenerator.nextInt(3) + 1;
        if(ind == 0)
        {
            switch (respond){
                case 1:
                    System.out.println("Very Good!");
                    break;
                case 2:
                    System.out.println("Excellent!");
                    break;
                case 3:
                    System.out.println("Nice work!");
                    break;
                case 4:
                    System.out.println("Keep up the good work!");
                    break;
            }
        }

        if(ind == 1)
        {
            switch (respond){
                case 1:
                    System.out.println("No. Please try again.");
                    break;
                case 2:
                    System.out.println("Wrong. Try once more.");
                    break;
                case 3:
                    System.out.println("Don't give up!");
                    break;
                case 4:
                    System.out.println("No. Keep trying.");
                    break;
            }
        }
    }

    static float difficultyDet(int difficult) throws NoSuchProviderException, NoSuchAlgorithmException
    {
        SecureRandom secureRandomGenerator = SecureRandom.getInstance("SHA1PRNG", "SUN");
        float randomInt = 0;
        switch (difficult)
        {
            case 1:
                randomInt = secureRandomGenerator.nextInt(10);
                break;
            case 2:
                randomInt = secureRandomGenerator.nextInt(90) + 10;
                break;
            case 3:
                randomInt = secureRandomGenerator.nextInt(900) + 100;
                break;
            case 4:
                randomInt = secureRandomGenerator.nextInt(9000) + 1000;
                break;
        }
        return randomInt;
    }

    static double typeDet(int difficulty, int type) throws NoSuchProviderException, NoSuchAlgorithmException
    {
        SecureRandom secureRandomGenerator = SecureRandom.getInstance("SHA1PRNG", "SUN");
        float product, sum, quotient, difference, firstInt, secondInt;
        int  random;
        random = secureRandomGenerator.nextInt(4)+1;
        firstInt = difficultyDet(difficulty);
        secondInt = difficultyDet(difficulty);

        if(type == 5)
        {
            questionGen(random, firstInt, secondInt);
        }
        else
            questionGen(type, firstInt,secondInt);

        switch (type)
        {
            case 1:
                sum = firstInt + secondInt;
                return sum;
            case 2:
                product = firstInt * secondInt;
                return product;
            case 3:
                difference = secondInt - firstInt;
                return difference;
            case 4:
                if(secondInt == 0)
                    secondInt++;
                quotient = firstInt / secondInt;
                return quotient;
            case 5:
                switch (random)
                {
                    case 1:
                        sum = firstInt + secondInt;
                        return sum;
                    case 2:
                        product = firstInt * secondInt;
                        return product;
                    case 3:
                        difference = secondInt - firstInt;
                        return difference;
                    case 4:
                        if(secondInt == 0)
                            secondInt++;
                        quotient = firstInt / secondInt;
                        return quotient;
                }
        }

        return 0;
    }

    public static void main(String[] args) throws NoSuchProviderException, NoSuchAlgorithmException
    {
        Scanner input = new Scanner(System.in);
        SecureRandom secureRandomGenerator = SecureRandom.getInstance("SHA1PRNG", "SUN");


        int i = 0, difficulty, type, numCorrect = 0, numWrong = 0;
        double grade, answer, response;
        char stu = 'y';
        while(stu == 'y')
        {
            difficulty = -1;
            type = -1;

            while (difficulty > 4 || difficulty < 1)
            {
                System.out.println("Enter a difficulty 1, 2, 3, or 4: ");
                difficulty = input.nextInt();
                if (difficulty > 4 || difficulty < 1)
                    System.out.println("Invalid Input!");
            }
            while (type > 5 || type < 1)
            {
                System.out.println("Enter a type 1, 2, 3, 4, or 5: ");
                type = input.nextInt();
                if (type > 5 || type < 1)
                    System.out.println("Invalid Input!");
            }


            while (i < 10)
            {
                answer = typeDet(difficulty, type);
                System.out.println("Enter Answer: ");
                response = input.nextFloat();

                if (response == answer) {
                    numCorrect++;
                    responseGen(0);

                } else {
                    numWrong++;
                    responseGen(1);
                }
                //System.out.println("Correct Answer: " + answer);
                i++;
            }

            System.out.println("Number of questions answered correctly: " + numCorrect);
            System.out.println("Number of questions answered incorrectly: " + numWrong);

            grade = (float) numCorrect / 10;

            System.out.println("\nYour grade: " + Math.round(grade * 100 * 100.0) / 100.0 + "%.");

            if (grade < .75)
            {
                System.out.println("Please ask you teacher for extra help.\n");
            }
            else {
                System.out.println("Congratulations, you are ready to go to the next level\n");
            }

            i = 0;
            numCorrect = 0;
            numWrong = 0;

            do {
                System.out.println("Would you like to start a new session? (y or n) : ");
                stu = input.next().charAt(0);
                if (stu != 'y' && stu != 'n') {
                    System.out.println("Invalid Input!");
                }
            } while (stu != 'y' && stu != 'n');
        }
    }
}