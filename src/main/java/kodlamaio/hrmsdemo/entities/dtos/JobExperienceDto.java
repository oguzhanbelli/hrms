package kodlamaio.hrmsdemo.entities.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobExperienceDto {
    @JsonIgnore
    private int id;
    private int cvId;
    private String workPlaceName;
    @JsonIgnore
    private LocalDateTime createdDate = LocalDateTime.now();
    private Date startedDate;
    private Date endedDate;
    private int jobId;
}
