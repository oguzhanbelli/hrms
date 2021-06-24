package kodlamaio.hrmsdemo.business.abstracts;

import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.core.utilities.results.Result;
import kodlamaio.hrmsdemo.entities.concretes.Advertisement;
import kodlamaio.hrmsdemo.entities.concretes.Cv;
import kodlamaio.hrmsdemo.entities.concretes.Graduate;
import kodlamaio.hrmsdemo.entities.dtos.CvDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CvService {

    DataResult<List<CvDto>> getAll();
    Result add(Cv cv);
    DataResult<Cv> getCv(int id);
    DataResult<Cv> updateCv(Cv cv);
    DataResult<List<Cv>> getAllCandidateId(int id);
    Result saveImage(MultipartFile file, int cvId);
}
