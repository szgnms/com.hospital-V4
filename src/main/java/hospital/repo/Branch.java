package hospital.repo;

import jakarta.persistence.*;

@Entity
@Table(name = "t_branch")
public class Branch {
@Id
@Column(name = "doctor_id")
    private int doctorId;
@Column(name = "brach")
    private String branchName;








}
