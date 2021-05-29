package kodlamaio.hrmsdemo.entities.concretes;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "job_advertisements")
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties(allowSetters = false,allowGetters = true,value = {"createdDate"})

public class Advertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne()
    @JoinColumn(name = "position_id")
    private Job job;
    @ManyToOne()
    @JoinColumn(name = "city_id")
    private City city;
    @ManyToOne()
    @JoinColumn(name = "employer_id")
    private Employer employer;
    @Column(name = "description")
    private String description;
    @Column(name = "min_salary")
    private int min_salary;
    @Column(name = "max_salary")
    private int max_salary;
    @Column(name = "many_people")
    private int manyPeople;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private java.util.Date createdDate;
    @Column(name = "end_date")
    private java.sql.Date endDate;
    @Column(name = "active")
    private boolean active;
/*
// Formats output date when this DTO is passed through JSON
  @JsonFormat(pattern = "dd/MM/yyyy")
  // Allows dd/MM/yyyy date to be passed into GET request in JSON
  @DateTimeFormat(pattern = "dd/MM/yyyy")
  private Date dateOfBirth;
 */

}
