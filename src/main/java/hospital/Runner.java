package hospital;

import hospital.methods.DoctorMethods;
import hospital.methods.MainMenuMethods;
import hospital.repo.Branch;
import hospital.repo.Rooms;

public class Runner {

    public static void main(String[] args) {
        new Branch().addBranch();
        new Rooms().addFloor();
        new MainMenuMethods().hospitalRun();

    }
}
