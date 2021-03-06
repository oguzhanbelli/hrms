package kodlamaio.hrmsdemo.business.concretes;

import kodlamaio.hrmsdemo.business.abstracts.CvService;
import kodlamaio.hrmsdemo.core.utilities.cloudinary.abstracts.CloudinaryService;
import kodlamaio.hrmsdemo.core.utilities.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrmsdemo.core.utilities.helpers.CvHelper;
import kodlamaio.hrmsdemo.core.utilities.helpers.CvHelperService;
import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.core.utilities.results.Result;
import kodlamaio.hrmsdemo.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsdemo.core.utilities.results.SuccessResult;
import kodlamaio.hrmsdemo.dataAccess.abstracts.CvDao;
import kodlamaio.hrmsdemo.entities.concretes.Advertisement;
import kodlamaio.hrmsdemo.entities.concretes.Cv;
import kodlamaio.hrmsdemo.entities.concretes.Education;
import kodlamaio.hrmsdemo.entities.concretes.Graduate;
import kodlamaio.hrmsdemo.entities.dtos.CvDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Service
public class CvManager implements CvService {


    private CvDao cvDao;
    private CvHelperService cvHelperService;
    private CloudinaryService cloudinaryService;
    private DtoConverterService dtoConverterService;


    @Autowired
    public CvManager(CvDao cvDao, CvHelperService cvHelperService, CloudinaryService cloudinaryService, DtoConverterService dtoConverterService) {
        this.cvDao = cvDao;
        this.cvHelperService = cvHelperService;
        this.cloudinaryService = cloudinaryService;
        this.dtoConverterService = dtoConverterService;
    }

    @Override
    public DataResult<List<CvDto>> getAll() {

        return new SuccessDataResult<List<CvDto>>(dtoConverterService.dtoConverter(cvDao.findAll(), CvDto.class), "Data Listelendi");
    }

    @Override
    public Result add(Cv cv) {
        cvDao.save(cv);
        this.cvHelperService.setAllCvId(cv.getEducations(), cv.getLanguages(), cv.getTalents(), cv.getJobExperiences(), cv);
        return new SuccessResult("Kay??t Ba??ar??l??");
    }

    @Override
    public DataResult<Cv> getCv(int id) {
        return new SuccessDataResult<Cv>(cvDao.getOne(id), "Cv Getirildi");
    }

    @Override
    public DataResult<Cv> updateCv(Cv cv) {

        this.cvHelperService.setAllCvId(cv.getEducations(), cv.getLanguages(), cv.getTalents(), cv.getJobExperiences(), cv);

        this.cvDao.save(cv);

        return new SuccessDataResult<Cv>(cv, "G??ncellendi");

    }

    @Override
    public DataResult<List<Cv>> getAllCandidateId(int id) {
        return new SuccessDataResult<List<Cv>>(cvDao.findAllByCandidate_Id(id));
    }

    @Override
    public Result saveImage(MultipartFile file, int cvId) {
        Map<String, String> uploader = (Map<String, String>) cloudinaryService.save(file).getData();
        String imageUrl = uploader.get("url");
        Cv cva = cvDao.findById(cvId).orElse(null);
        assert cva != null;
        cva.setPhoto(imageUrl);
        cvDao.save(cva);
        return new SuccessResult("Kay??t Ba??ar??l??");
    }
}
