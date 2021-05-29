package kodlamaio.hrmsdemo.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidates")
public class Candidate extends User {


    @NotBlank(message = "İsim Alanı Boş olamaz")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Soyisim Alanı Boş olamaz")
    @Column(name = "last_name")
    private String lastName;
    @NotBlank(message = "Tc Alanı Boş olamaz")
    @Column(name = "identification_number")
    private String identificationNumber;
    @NotBlank(message = "Doğum Tarihi Alanı Boş olamaz")
    @Column(name = "birth_date")
    private Date birthDate;
}
