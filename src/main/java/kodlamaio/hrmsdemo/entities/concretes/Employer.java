package kodlamaio.hrmsdemo.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    @NotNull(message = "Şirket isim Alanı Boş olamaz")
    @Column(name = "company_name")
    private String companyName;

    @NotBlank(message = "Web Adresi Alanı Boş olamaz")
    @NotNull(message = "Web Adresi Alanı Boş olamaz")
    @Column(name = "web_address")
    private String webAddress;

    @Column(name = "verify")
    private boolean verify=false;


    @OneToMany(mappedBy = "employerphone")
    private List<EmployerPhone> employerPhones;

    @JsonIgnore
    @OneToMany(mappedBy = "employer")
    private List<Advertisement> jobAdvertisements;
}
