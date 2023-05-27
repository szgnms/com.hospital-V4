package hospital.methods;

import hospital.repo.*;
import jakarta.persistence.Query;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static hospital.methods.DoctorMethods.doctor;
import static hospital.methods.DoctorMethods.doctorId;
import static hospital.methods.HibernateConnect.*;
import static hospital.methods.MainMenuMethods.menuSecim;
import static hospital.methods.MainMenuMethods.scan;
import static hospital.repo.Color.*;
import static hospital.repo.ListDiseases.doctorBranchSelect;
import static hospital.repo.ListDiseases.doctorIdSelect;

public class PatientsMethods implements WrongInput {

    public static String patientName;
    public static String patientSurname;

    public static String patientDisease;

    public static int patientId;


    Patient patient;


    void patientMenu() {
        System.out.println(GREEN + "=================" + BLUE + "PATIENT MENU" + GREEN + "=================");
        System.out.println("""
                Please select ->
                1-Patient Registration
                2-Patient Discharged
                3-All Patients
                4-All Discharged Patients
                5-Main Menu""");
        System.out.print("Your Selection : ");
        MainMenuMethods.menuSecim = scan.next();
        switch (menuSecim) {
            case "1" -> patientRegistiration();
            case "2" -> patientDischarge();
            case "3" -> allPatients();
            case "4" -> allDischargedPatients();
            case "5" -> new MainMenuMethods().hospitalRun();
            default -> wrongMethod();
        }
    }

   
              
    public void patientRegistiration() {

        try {

            session = factory.openSession();
            tx = session.beginTransaction();

            List<Patient> patients = session.createQuery("from Patient").list();
            for (int i = 0; i < patients.size(); i++) {
                patientId = patients.get(i).getId();
            }
            tx.commit();
            session.close();

        } catch (
                Exception e) {
            System.out.println("List icin");
        }

        patientId++;

        System.out.println("Please enter the name of the Patient");
        patientName = scan.next();
        System.out.println("Please enter the surname of the Patient");
        patientSurname = scan.next();
        new ListDiseases().selectDisease();
        try {
            session = factory.openSession();
            tx = session.beginTransaction();
            List<Doctor> doctorList = session.createQuery("from Doctor", Doctor.class).list();
            for (int i = 1; i <= doctorList.size(); i++) {
                if (doctorList.get(i - 1).getBranch().contains(doctorBranchSelect)) {
                    doctorId = doctorList.get(i - 1).getDoctorId();
                    //System.out.println("\n ******** "+ doctorId);
                }
            }
            tx.commit();
            session.close();
        } catch (Exception e) {
            System.out.println("drbranchSelect");
        }

        int roomNumber = 0;
        int floorNumber = doctorId;
        switch (doctorId) {
            case 1 -> roomNumber = Rooms.firstFloorNumberRoom++;
            case 2 -> roomNumber = Rooms.secondFloorNumberRoom++;
            case 3 -> roomNumber = Rooms.thirdFloorNumberRoom++;
            case 4 -> roomNumber = Rooms.fourthFloorNumberRoom++;
            case 5 -> roomNumber = Rooms.fifthFloorNumberRoom++;
            case 6 -> roomNumber = Rooms.sixthFloorNumberRoom++;
            case 7 -> roomNumber = Rooms.seventhFloorNumberRoom++;
            case 8 -> roomNumber = Rooms.eighthFloorNumberRoom++;
            case 9 -> roomNumber = Rooms.ninthFloorNumberRoom++;
            case 10 -> roomNumber = Rooms.tenthFloorNumberRoom++;
        }
        new FloorMethods().addRoom(floorNumber, roomNumber);
        try {
            session = factory.openSession();
            tx = session.beginTransaction();

            patient = new Patient(patientId, patientName, patientSurname, patientDisease, roomNumber, doctorId);

            session.persist(patient);
            tx.commit();
            session.close();

        } catch (
                Exception e) {
            System.out.println("Patients Methods");
        }
        new MainMenuMethods().hospitalRun();
    }


    public void patientDischarge() {

        int dischargeId = 0;
        int count = 0;
        try {
            session = factory.openSession();
            tx = session.beginTransaction();

            List<Patient> patients = session.createQuery("from Patient").list();
            for (Patient p : patients) {
                System.out.println((count + 1) + " " + p);
                count++;
            }

            System.out.println("Please select id for discharge_patient : ");
            dischargeId = scan.nextInt() - 1;
            DischargedPatient dischargedPatient = new DischargedPatient();
            dischargedPatient.setId(patients.get(dischargeId).getId());
            dischargedPatient.setName(patients.get(dischargeId).getName());
            dischargedPatient.setSurname(patients.get(dischargeId).getSurname());
            dischargedPatient.setDisease(patients.get(dischargeId).getDisease());
            dischargedPatient.setRoom(patients.get(dischargeId).getRoom());
            dischargedPatient.setDoctorId(patients.get(dischargeId).getDrId());

            System.out.println(dischargedPatient);
            session.persist(dischargedPatient);
            session.remove(patients.get(dischargeId));
            tx.commit();
            session.close();

        } catch (
                Exception e) {
            System.out.println("List icin");
        }

    }


    public void allPatients() {
        try {

            session = factory.openSession();
            tx = session.beginTransaction();

            List<Patient> patients = session.createQuery("from Patient").list();
            for (Patient p : patients) {
                System.out.println(p);
            }
            tx.commit();
            session.close();

        } catch (
                Exception e) {
            System.out.println("All List icin");
        }
        patientMenu();
    }

    public void allDischargedPatients() {
        int dischargeId = 0;
        int count = 0;
        try {
            session = factory.openSession();
            tx = session.beginTransaction();

            List<DischargedPatient> patients = session.createQuery("from DischargedPatient").list();

            for (DischargedPatient p : patients) {
                System.out.println(p);
            }

            tx.commit();
            session.close();

        } catch (
                Exception e) {
            System.out.println("List icin");
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
        patientMenu();
    }

}

