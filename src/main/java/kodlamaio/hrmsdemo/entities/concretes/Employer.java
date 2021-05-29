package kodlamaio.hrmsdemo.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "employers")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties ({"hibernateLazyInitializer","handler","jobAdvertisements"})
public class Employer extends User {
    @NotBlank(message = "Şirket isim Alanı Boş olamaz")
    @Column(name = "company_name")
    private String companyName;
    @NotBlank(message = "Şifre Alanı Boş olamaz")

    @Column(name = "web_address")
    private String webAddress;

    @JsonIgnore
    @OneToMany(mappedBy = "employer")
    private List<Advertisement> jobAdvertisements;
}
