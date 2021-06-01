package kodlamaio.hrmsdemo.entities.concretes;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cv_education")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(targetEntity = Cv.class)
    @JoinColumn(name="cv_id")
    private Cv cv;

    @ManyToOne(targetEntity = Graduate.class)
    @JoinColumn(name = "graduate_id", referencedColumnName = "id", nullable = false)
    private Graduate graduate;

    @NotBlank(message = "Okul İsmi Boş Geçilemez")
    @Column(name = "school_name")
    private String schoolName;
    @NotBlank(message = "Bölüm İsmi Boş Geçilemez")
    @Column(name = "school_department")
    private String schoolDepartment;

    @Column(name = "started_date")
    private Date startedDate;

    @Column(name = "ended_date")
    private Date endedDate;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_date")
    private java.util.Date createdDate;

}
