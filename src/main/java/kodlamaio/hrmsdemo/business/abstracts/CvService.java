package kodlamaio.hrmsdemo.business.abstracts;

import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.core.utilities.results.Result;
import kodlamaio.hrmsdemo.entities.concretes.Cv;
import kodlamaio.hrmsdemo.entities.concretes.Graduate;

import java.util.List;

public interface CvService {

    DataResult<List<Cv>> getAll();
    Result add(Cv cv);
}
