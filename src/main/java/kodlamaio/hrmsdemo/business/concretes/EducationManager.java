package kodlamaio.hrmsdemo.business.concretes;

import kodlamaio.hrmsdemo.business.abstracts.EducationService;
import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.core.utilities.results.Result;
import kodlamaio.hrmsdemo.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsdemo.core.utilities.results.SuccessResult;
import kodlamaio.hrmsdemo.dataAccess.abstracts.EducationDao;
import kodlamaio.hrmsdemo.entities.concretes.Advertisement;
import kodlamaio.hrmsdemo.entities.concretes.Education;
import kodlamaio.hrmsdemo.entities.concretes.Graduate;
import kodlamaio.hrmsdemo.entities.dtos.AdvertisementDto;
import kodlamaio.hrmsdemo.entities.dtos.AdvertisementRequestDto;
import kodlamaio.hrmsdemo.entities.dtos.EducationDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EducationManager implements EducationService {



    private EducationDao educationDao;
    private ModelMapper modelMapper;
    @Autowired
    public EducationManager(EducationDao educationDao,ModelMapper modelMapper) {
        this.educationDao = educationDao;
        this.modelMapper = modelMapper;
    }
    @Override
    public DataResult<List<EducationDto>> getAll() {
        List<Education> educations = educationDao.findAll();
        return new SuccessDataResult<List<EducationDto>>(educationToDto(educations),"Data Listelendi");
    }

    @Override
    public DataResult<EducationDto> add(EducationDto educationDto) {
        Education educations = modelMapper.map(educationDto,Education.class);
        educationDao.save(educations);

        return new SuccessDataResult<EducationDto>(educationDto, "Okul Eklendi");

    }
    private List<EducationDto> educationToDto(List<Education> educations) {
        return educations.stream().map(Education -> modelMapper.map(Education, EducationDto.class)).collect(Collectors.toList());
    }
}
