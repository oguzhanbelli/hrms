package kodlamaio.hrmsdemo.entities.concretes;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
//@transient password repeat;
@Entity
@Data
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")

    private int id;
    @Email(message = "Lütfen Geçerli Bir Mail Giriniz")
    @NotBlank(message = "Mail Alanı Boş olamaz")
    @Column(name="email_address")
    private String emailAdress;

    @NotBlank(message = "Şifre Alanı Boş olamaz")
    @Column(name="password")
    private String password;
    //@OnetoMany(mappedBy = "categories"),
    //private List<Product> products;
    //ManytoOne
    //private Category category
    //OnetoOne birebir

    
}
