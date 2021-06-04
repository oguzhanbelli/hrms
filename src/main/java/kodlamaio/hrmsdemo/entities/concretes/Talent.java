package kodlamaio.hrmsdemo.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cv_talents")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","cv"})
public class Talent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(targetEntity = Cv.class)
    @JoinColumn(name="cv_id")
    private Cv cv;
    @Column(name="talent_title")
    private String talentTitle;
    @Column(name = "created_date")
    private LocalDateTime createdDate = LocalDateTime.now();

}
