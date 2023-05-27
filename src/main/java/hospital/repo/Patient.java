package hospital.repo;

import jakarta.persistence.*;


@Entity
@Table(name = "t_patients")
public class Patient {
    @Id
    @Column(name = "patient_id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "disease")
    private String disease;
    @Column(name = "room")
    private int room;

    @Column(name = "dr_id")
    private int drId;


    public Patient() {
    }

    public Patient(int id, String name, String surname, String disease, int room, int drId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.disease = disease;
        this.room = room;
        this.drId = drId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getDrId() {
        return drId;
    }

    public void setDrId(int drId) {
        this.drId = drId;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                        " name=" + name +
                        " surname=" + surname +
                        " disease=" + disease +
                        " room=" + room +
                        "dr id=" + drId;

    }
}
