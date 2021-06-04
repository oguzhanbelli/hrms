package kodlamaio.hrmsdemo.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationDto {


    private int id;
    private int cvId;
    private String schoolName;
    private int graduateId;
    private String schoolDepartment;
    private Date startedDate;
    private Date endedDate;
    private LocalDateTime createdDate;
}
