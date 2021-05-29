package kodlamaio.hrmsdemo.entities.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdvertisementRequestDto {
    private int cityId;
    private int employerId;
    private int jobId;
    private int Id;
    private String description;
    private Date endDate;
    private int manyPeople;
    private int max_salary;
    private int min_salary;
    private boolean active;

}
