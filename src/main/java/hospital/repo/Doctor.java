package hospital.repo;

import jakarta.persistence.*;

@Entity
@Table(name = "t_doctors")
public class Doctor {
    @Id
    @Column(name = "doctor_id")
    private int doctorId;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "branch")
    private String branch;


    Doctor(){

    }

    public Doctor(int doctorId, String name, String surname, String branch) {
        this.doctorId = doctorId;
        this.name = name;
        this.surname = surname;
        this.branch = branch;
    }

    @Override
    public String toString() {
        return
                "doctorId=" + doctorId +
                        "name= " + name +
                        "surname= " + surname +
                        "branch='" + branch
                ;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}
