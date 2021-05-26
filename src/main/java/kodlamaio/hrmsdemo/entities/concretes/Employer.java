package kodlamaio.hrmsdemo.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "employers")
@NoArgsConstructor
@AllArgsConstructor

public class Employer extends User {
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "web_address")
    private String webAddress;

}
