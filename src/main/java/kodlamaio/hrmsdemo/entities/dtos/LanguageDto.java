package kodlamaio.hrmsdemo.entities.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LanguageDto {

    @JsonIgnore
    private int id;
    private int cvId;
    @NotBlank(message = "Dil İsmi Boş Bırakılamaz ")
    private String languageName;
    @Min(value = 1, message = "min 1")
    @Max(value = 5, message = "max 5")
    private short languageLevel;
    private LocalDateTime createdDate;
}
