package kodlamaio.hrmsdemo.business.concretes;

import kodlamaio.hrmsdemo.business.abstracts.EducationService;
import kodlamaio.hrmsdemo.core.utilities.dtoConverter.abstracts.DtoConverterService;
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
import kodlamaio.hrmsdemo.entities.dtos.CvDto;
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
    private DtoConverterService dtoConverterService;
    @Autowired
    public EducationManager(EducationDao educationDao,ModelMapper modelMapper,DtoConverterService dtoConverterService) {
        this.educationDao = educationDao;
        this.modelMapper = modelMapper;
        this.dtoConverterService = dtoConverterService;
    }
    @Override
    public DataResult<List<EducationDto>> getAll() {
        return new SuccessDataResult<List<EducationDto>>(dtoConverterService.dtoConverter(educationDao.findAll(),EducationDto.class), "Data Listelendi");
    }

    @Override
    public DataResult<EducationDto> add(EducationDto educationDto) {


        this.educationDao.save((Education) dtoConverterService.dtoClassConverter(educationDto, Education.class));
        return new SuccessDataResult<EducationDto>(educationDto, "Okul Eklendi");

    }
 /*   private List<EducationDto> educationToDto(List<Education> educations) {
        return educations.stream().map(Education -> modelMapper.map(Education, EducationDto.class)).collect(Collectors.toList());
    }*/
}
