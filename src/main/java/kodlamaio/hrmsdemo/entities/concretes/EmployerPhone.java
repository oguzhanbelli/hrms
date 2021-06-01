package kodlamaio.hrmsdemo.entities.concretes;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="employer_phones")
public class EmployerPhone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private int id;

    @ManyToOne()
    @JoinColumn(name = "employer_id")
    private Employer employerphone;
    private String phoneNumber;

}
