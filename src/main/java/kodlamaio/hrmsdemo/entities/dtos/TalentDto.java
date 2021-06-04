package kodlamaio.hrmsdemo.entities.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TalentDto {
    @JsonIgnore
    private int id;
    private int cvId;
    @NotBlank(message = "Yetenek Başlığı Boş bırakılamaz")
    private String talentTitle;
    @JsonIgnore
    private LocalDateTime createdDate = LocalDateTime.now();
}
