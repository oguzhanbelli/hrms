package kodlamaio.hrmsdemo.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cv_education")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","cv"})
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

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

    @Column(name = "created_date")
    private LocalDateTime createdDate = LocalDateTime.now();

}
