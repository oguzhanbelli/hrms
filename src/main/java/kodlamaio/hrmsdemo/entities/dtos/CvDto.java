package kodlamaio.hrmsdemo.entities.dtos;

import kodlamaio.hrmsdemo.entities.concretes.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

 @Data
 @AllArgsConstructor
 @NoArgsConstructor
public class CvDto {


    private int id;
    private String candidateId;
    private String githubLink;
    private String linkedinLink;
    private String description;
    private String photo;
    private LocalDateTime createdDate;
    private Date updatedDate;
    private List<Language> languages;
    private List<Talent> talents;
    private List<Education> educations;
    private List<JobExperience> jobExperiences;
}
