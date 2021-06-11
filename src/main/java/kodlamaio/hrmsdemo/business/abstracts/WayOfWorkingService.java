package kodlamaio.hrmsdemo.business.abstracts;

import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.core.utilities.results.Result;
import kodlamaio.hrmsdemo.entities.concretes.Job;
import kodlamaio.hrmsdemo.entities.concretes.WayOfWorking;

import java.util.List;
import java.util.Optional;

public interface WayOfWorkingService {
    DataResult<List<WayOfWorking>> getAll();

    DataResult<WayOfWorking> getById(int id);
    DataResult<WayOfWorking> add(WayOfWorking wayOfWorking);
}
