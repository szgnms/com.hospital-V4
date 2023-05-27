package hospital.methods;

import hospital.repo.Doctor;
import hospital.repo.WrongInput;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static hospital.methods.HibernateConnect.*;
import static hospital.methods.MainMenuMethods.menuSecim;
import static hospital.methods.MainMenuMethods.scan;
import static hospital.repo.Branch.branchList;
import static hospital.repo.Color.*;

public class DoctorMethods implements WrongInput {
    static int doctorId;
    static String doctorName;
    static String doctorSurname;
    static String doctorBranch;

    static Doctor doctor;

    public void doctorMenu() {
        System.out.println(GREEN + "================" + CYAN + "DOCTOR MENU" + GREEN + "================\n" + RED + "Please select ->");
        System.out.println(BLUE + "1-" + WHITE + "DOCTOR REGISTRATION");
        System.out.println(BLUE + "2-" + WHITE + "DELETE DOCTOR");
        System.out.println(BLUE + "3-" + WHITE + "ALL DOCTORS");
        System.out.println(BLUE + "4-" + WHITE + "UPDATE DOCTOR");
        System.out.println(BLUE + "5-" + WHITE + "RETURN TO MAIN MENU");

        System.out.print("YOUR SELECTION : ");

        MainMenuMethods.menuSecim = MainMenuMethods.scan.next();

        switch (MainMenuMethods.menuSecim) {
            case "1" -> createDoctor();
            case "2" -> deleteDoctor();
            case "3" -> allDoctors();
            case "4" -> updateDoctor();
            case "5" -> new MainMenuMethods().hospitalRun();
            default -> wrongMethod();
        }


    }

    private void updateDoctor() {
        printDoctrList();
        System.out.println("Please select a doctor to update");
        doctorId = scan.nextInt();
        try {
            session = factory.openSession();
            tx = session.beginTransaction();
            doctor = session.get(Doctor.class, doctorId);
            tx.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(" jjjjs");
        }
        System.out.println("""
                Please select ->
                1-Name
                2-Surname
                3-Branch
                """);
        String select = scan.next();

        switch (select) {
            case "1" -> {
                try {
                    session = factory.openSession();
                    tx = session.beginTransaction();
                    System.out.println("Please enter value");
                    String value = scan.next();
                    doctor.setName(value);
                    tx.commit();
                    session.close();

                } catch (Exception e) {
                    System.out.println("s1");
                }
            }
            case "2" -> {
                try {
                    session = factory.openSession();
                    tx = session.beginTransaction();
                    System.out.println("Please enter value");
                    String value = scan.next();
                    doctor.setSurname(value);
                    tx.commit();
                    session.close();

                } catch (Exception e) {
                    System.out.println("s2");
                }
            }
            case "3" -> {
                try {
                    session = factory.openSession();
                    tx = session.beginTransaction();
                    updateDoctorBranch();
                    tx.commit();
                    session.close();
                } catch (Exception e) {
                    System.out.println("s3");
                }
            }
        }


        doctorMenu();

    }

    private void updateDoctorBranch() {
        printbranchList();
        System.out.println("Please select a branch to update");
        String branch = scan.next();
        String value = "";

        switch (branch) {
            case "1" -> value = branchList.get(0);
            case "2" -> value = branchList.get(1);
            case "3" -> value = branchList.get(2);
            case "4" -> value = branchList.get(3);
            case "5" -> value = branchList.get(4);
            case "6" -> value = branchList.get(5);
            case "7" -> value = branchList.get(6);
            case "8" -> value = branchList.get(7);
            case "9" -> value = branchList.get(8);
            case "10" -> value = branchList.get(9);
        }

        doctor.setBranch(value);


    }

    private void allDoctors() {
        printDoctrList();
        new MainMenuMethods().hospitalRun();
    }


    private void deleteDoctor() {
        printDoctrList();

        System.out.println("Please select a doctor to delete");
        doctorId = scan.nextInt();

        try {
            session = factory.openSession();
            tx = session.beginTransaction();

            doctor = findDoctorById(doctorId);

            session.get(Doctor.class, doctorId);
            session.remove(doctor);
            tx.commit();
            session.close();
        } catch (Exception e) {
            wrongMethod();
        }


        new MainMenuMethods().hospitalRun();


    }

    private void printDoctrList() {
        try {

            session = factory.openSession();
            tx = session.beginTransaction();
            List<Doctor> doctorList = session.createQuery("from Doctor").list();
            for (Doctor doctor : doctorList) {
                System.out.println(doctor);
            }

            tx.commit();
            session.close();
        } catch (Exception e) {
            System.out.println("print icin");
        }
    }

    private Doctor findDoctorById(int doctorId) {
        try {

            session = factory.openSession();
            tx = session.beginTransaction();

            List<Doctor> doctorList = session.createQuery("from Doctor").list();
            for (Doctor doctor : doctorList) {
                if (doctor.getDoctorId() == doctorId) {
                    return doctor;
                }
            }

            tx.commit();
            session.close();
        } catch (Exception e) {
            System.out.println("findDc");
        }
        return null;
    }

    private void createDoctor() {
        System.out.println("Please enter the name of the Doctor");
        doctorName = scan.next();
        System.out.println("Please enter the surname of the Doctor");
        doctorSurname = scan.next();
        printbranchList();
        System.out.println("Please select the Branch of the Doctor");
        menuSecim = scan.next();

        doctorId = Integer.parseInt(menuSecim);

        switch (menuSecim) {
            case "1" -> doctorBranch = branchList.get(0);
            case "2" -> doctorBranch = branchList.get(1);
            case "3" -> doctorBranch = branchList.get(2);
            case "4" -> doctorBranch = branchList.get(3);
            case "5" -> doctorBranch = branchList.get(4);
            case "6" -> doctorBranch = branchList.get(5);
            case "7" -> doctorBranch = branchList.get(6);
            case "8" -> doctorBranch = branchList.get(7);
            case "9" -> doctorBranch = branchList.get(8);
            case "10" -> doctorBranch = branchList.get(9);
        }

        try {
            session = factory.openSession();
            tx = session.beginTransaction();

            doctor = new Doctor(doctorId, doctorName, doctorSurname, doctorBranch);

            session.persist(doctor);
            tx.commit();
            session.close();

        } catch (Exception e) {
            System.out.println("Doctor Methods");
        }
        new MainMenuMethods().hospitalRun();

    }

    public void printbranchList() {
        System.out.println("==========DOCTOR BRANCH===============");


        for (int i = 1; i <= branchList.size(); i++) {
            System.out.println(i + " - " + branchList.get(i - 1));
        }
        System.out.println();
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
        doctorMenu();

    }
}
