package hospital.methods;

import hospital.repo.WrongInput;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static hospital.repo.Color.*;


public class MainMenuMethods implements WrongInput {




    public static Scanner scan = new Scanner(System.in);
    public static String menuSecim;

    public void hospitalRun() {
        System.out.println(GREEN + "=".repeat(17) + CYAN + " WELCOME TO DEV3 HOSPITAL" + GREEN + "=".repeat(17));
        System.out.println(GREEN + "=".repeat(24) + CYAN + " MAIN MENU" + GREEN + "=".repeat(17)+"\n" + RED + "Please select ->");
        System.out.println(GREEN + """
                1- DOCTOR MENU
                2- PATIENT MENU
                3- QUIT
                """);
        System.out.print("YOUR SELECTION : ");
        menuSecim = scan.next();
        switch (menuSecim) {
            case "1" -> new DoctorMethods().doctorMenu();
            case "2" -> new PatientsMethods().patientMenu();
            case "3" -> System.exit(0);
            default -> wrongMethod();
        }

    }


    @Override
    public void wrongMethod() {
        System.out.println(RED + "PLEASE SELECT CORRECT \nREDIRECTING TO MENU");
        for (int i = 0; i < 5; i++) {
            System.out.print(". ");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println();

        hospitalRun();

    }
}
