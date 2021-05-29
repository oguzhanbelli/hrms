package kodlamaio.hrmsdemo.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="cities")
@JsonIgnoreProperties ({"hibernateLazyInitializer","handler","adversitement"})
public class City {

    @Id
    @Column (name="city_id")
    private int cityId;

    @Column(name="city_name")
    private String cityName;


    @JsonIgnore
    @OneToMany(mappedBy = "city")
        private List<Advertisement> advertisement;
}
