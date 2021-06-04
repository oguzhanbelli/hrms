package kodlamaio.hrmsdemo.entities.dtos;

import kodlamaio.hrmsdemo.entities.concretes.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

public class CvDto {


    private int id;
    private int candidateId;
    private String githubLink;
    private String linkedinLink;
    private String description;
    private String photo;
    private LocalDateTime createdDate;
    private Date updatedDate;
    private List<Language> languagesId;
    private List<Talent> talentsId;
    private List<Education> educationsId;
    private List<JobExperience> jobExperiencesId;
}
