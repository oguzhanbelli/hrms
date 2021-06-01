package kodlamaio.hrmsdemo.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cv_languages")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne(targetEntity = Cv.class)
    @JoinColumn(name="cv_id")
    private Cv cv;
    @NotBlank(message = "Dil  adı boş geçilemez")
    @Column(name="language_name")
    private String languageName;
    @NotBlank(message = "İş yeri adı boş geçilemez")
    @Column(name="language_level")
    private char language_level;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_date")
    private Date createdDate;
}
