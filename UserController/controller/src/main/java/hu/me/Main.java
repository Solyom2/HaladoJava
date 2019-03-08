package hu.me;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        String action;

        do{
            System.out.println("1. Registration  2. Exit");
            action = scanner.next();

            if(action.equals("1")) {
                String userName, password;
                System.out.println("Username: ");
                userName = scanner.next();
                System.out.println("Password: ");
                password = scanner.next();

                Controller controller = new Controller();
                Registration registration = new Registration();
                Validator validator = new Validator();

                NoSpaceChecker noSpaceChecker = new NoSpaceChecker();
                LengthChecker lengthChecker = new LengthChecker();

                ArrayList<DataChecker> checkers = new ArrayList<>();
                checkers.add(noSpaceChecker);
                checkers.add(lengthChecker);

                User user = new User(userName, password);
                controller.register(user, checkers, registration, validator);
            }

            else if(action.equals("2")) {
                running = false;
            }

        }while (running);

    }

}
