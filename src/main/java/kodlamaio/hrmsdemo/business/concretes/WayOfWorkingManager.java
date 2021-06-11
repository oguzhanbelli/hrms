package kodlamaio.hrmsdemo.business.concretes;

import kodlamaio.hrmsdemo.business.abstracts.WayOfWorkingService;
import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.core.utilities.results.Result;
import kodlamaio.hrmsdemo.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsdemo.core.utilities.results.SuccessResult;
import kodlamaio.hrmsdemo.dataAccess.abstracts.WayOfWorkingDao;
import kodlamaio.hrmsdemo.entities.concretes.WayOfWorking;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WayOfWorkingManager implements WayOfWorkingService {


    private WayOfWorkingDao wayOfWorkingDao;

    public WayOfWorkingManager(WayOfWorkingDao wayOfWorkingDao) {
        this.wayOfWorkingDao = wayOfWorkingDao;
    }

    @Override
    public DataResult<List<WayOfWorking>> getAll() {
        return new SuccessDataResult<List<WayOfWorking>>(wayOfWorkingDao.findAll(),"Çalışma Türleri Listelendi");
    }

    @Override
    public DataResult<WayOfWorking> getById(int id) {


        return new SuccessDataResult<WayOfWorking>(wayOfWorkingDao.getOne(id),"Getirildi");
    }

    @Override
    public DataResult<WayOfWorking> add(WayOfWorking wayOfWorking) {
        this.wayOfWorkingDao.save(wayOfWorking);
        return new SuccessDataResult<WayOfWorking>("Ekleme Başarılı");
    }
}
