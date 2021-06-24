package kodlamaio.hrmsdemo.business.abstracts;

import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.entities.concretes.Advertisement;
import kodlamaio.hrmsdemo.entities.dtos.AdvertisementDto;
import kodlamaio.hrmsdemo.entities.dtos.AdvertisementRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.xml.crypto.Data;
import java.sql.Date;
import java.util.List;

public interface AdvertisementService {
    DataResult<List<AdvertisementDto>> getAllAd();
    DataResult<AdvertisementRequestDto> addAd (AdvertisementRequestDto advertisement);

    DataResult<List<AdvertisementDto>> getActive();
    DataResult<List<AdvertisementDto>> getAllPassive();
    DataResult<List<AdvertisementDto>> getEmpId(int id);
    DataResult<List<AdvertisementDto>> getAdDate();
    DataResult<List<AdvertisementDto>> getAdCustomDate(Date date);
    DataResult<List<AdvertisementDto>> findAll(int pageNo, int pageSize);
    DataResult<Advertisement> updateActive(int id, boolean active);
}
