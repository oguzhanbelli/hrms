package kodlamaio.hrmsdemo.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "way_of_workings")
public class WayOfWorking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="typeofwork_title")
    private String wayOfWorkingTitle;

    @JsonIgnore
    @OneToMany(mappedBy = "wayOfWorking")
    private List<Advertisement> advertisement;
}
