package kodlamaio.hrmsdemo.entities.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdvertisementRequestDto {
    @NotNull
    private int cityId;
    @NotNull
    private int employerId;
    @NotNull
    private int jobId;
    private int Id;

    @NotNull
    private int workingTimeId;
    @NotNull
    private int wayOfWorkingId;
    @NotBlank
    @NotNull
    private String description;
    @NotNull
    private Date endDate;
    @NotNull
    @Min(1)
    private int manyPeople;
    @NotNull
    @Min(1)
    private int maxSalary;
    @NotNull
    @Min(1)
    private int minSalary;
    private boolean active = false;

}
