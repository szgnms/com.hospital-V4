package hospital.repo;

import hospital.clinics.*;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_branch")
public class Branch {
@Id
@Column(name = "doctor_id")
    private int doctorId;
@Column(name = "branch")
    private String branchName;


    public Branch() {
    }

    public Branch(int doctorId, String branchName) {
        this.doctorId = doctorId;
        this.branchName = branchName;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    @Override
    public String toString() {
        return
                "doctorId=" + doctorId +
                "branchName='" + branchName;
    }

    public static List<String> branchList = new ArrayList<>();

    public void addBranch(){
        branchList.add(new AestheticsPlasticSurgery().clinicDoctor());
        branchList.add(new AnesthesiaAndReanimation().clinicDoctor());
        branchList.add(new Dermatology().clinicDoctor());
        branchList.add(new EmergencyAndAmbulances().clinicDoctor());
        branchList.add(new EndocrinologyAndMetabolicDiseases().clinicDoctor());
        branchList.add(new EyeDiseases().clinicDoctor());
        branchList.add(new InternalMedicine().clinicDoctor());
        branchList.add(new NutritionAndDiet().clinicDoctor());
        branchList.add(new OralAndDentalDiseases().clinicDoctor());
        branchList.add(new Cardiology().clinicDoctor());



    }


}
