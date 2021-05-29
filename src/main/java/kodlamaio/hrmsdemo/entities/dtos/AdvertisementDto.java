package kodlamaio.hrmsdemo.entities.dtos;

import kodlamaio.hrmsdemo.entities.concretes.Advertisement;
import kodlamaio.hrmsdemo.entities.concretes.Employer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdvertisementDto {
    private int id;
    private String employerCompanyName;//Employer Dto
    private String description;
    private String jobName;
    private String manyPeople;
    private Date createdDate;
    private String cityName;
    private java.sql.Date endDate;





}
