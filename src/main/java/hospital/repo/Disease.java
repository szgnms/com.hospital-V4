package hospital.repo;

import jakarta.persistence.*;

@Entity
@Table(name = "t_disease")
public class Disease {
    @Id
    @Column(name = "doctor_id")
    private int doctorId;
    @Column(name = "disease")
    private String disease;

    public Disease(int doctorId, String disease) {
        this.doctorId = doctorId;
        this.disease = disease;
    }

    public Disease(){

    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    @Override
    public String toString() {
        return
                "doctorId=" + doctorId +
                "disease=" + disease ;
    }
}
