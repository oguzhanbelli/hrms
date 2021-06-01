package kodlamaio.hrmsdemo.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "candidates_cv")
public class Cv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @ManyToOne(targetEntity = Candidate.class)
    @JoinColumn(name = "candidate_id", referencedColumnName = "id", nullable = false)
    private Candidate candidate;
    @Column(name = "github_link")
    private String githubLink;
    @Column(name = "linkedin_link")
    private String linkedinLink;
    @Column(name = "description")
    private String description;
    @Column(name = "photo")
    private String photo;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private java.util.Date createdDate;
    @Column(name = "updated_date")
    private Date updatedDate;
    @Column(name = "is_active")
    private boolean isActive;
    @OneToMany(mappedBy = "cv")
    private List<Language> languages;

    @OneToMany(mappedBy = "cv")
    private List<Talent> talents;

    @OneToMany(mappedBy = "cv")
    private List<Education> educations;

    @OneToMany(mappedBy = "cv")
    private List<JobExperience> jobExperiences;

}
