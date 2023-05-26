package hospital;

import hospital.methods.DoctorMethods;
import hospital.methods.MainMenuMethods;
import hospital.repo.Branch;

public class Runner {

    public static void main(String[] args) {
        new Branch().addBranch();
      new MainMenuMethods().hospitalRun();
    }
}
