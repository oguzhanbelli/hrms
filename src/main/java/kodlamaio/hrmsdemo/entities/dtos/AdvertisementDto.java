package kodlamaio.hrmsdemo.entities.dtos;

import kodlamaio.hrmsdemo.entities.concretes.Advertisement;
import kodlamaio.hrmsdemo.entities.concretes.Employer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdvertisementDto {
    private int id;
    private String employerCompanyName;//Employer Dto
    private String description;
    private String jobName;
    private String workingTimeTitle;
    private String wayOfWorkingTitle;
    private String manyPeople;
    private LocalDateTime createdDate = LocalDateTime.now();
    private String cityName;
    private java.sql.Date endDate;
    private boolean active;





}
