package kodlamaio.hrmsdemo.entities.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CvRequestDto {
    @JsonIgnore
    private int id;
    private int candidateId;
    private String linkedInLink;
    private String githubLink;
    private String photoUrl;
    private String description;
}
