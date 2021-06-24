package kodlamaio.hrmsdemo.business.concretes;

import kodlamaio.hrmsdemo.business.abstracts.AdvertisementService;
import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsdemo.dataAccess.abstracts.AdvertisementDao;
import kodlamaio.hrmsdemo.entities.concretes.Advertisement;
import kodlamaio.hrmsdemo.entities.dtos.AdvertisementDto;
import kodlamaio.hrmsdemo.entities.dtos.AdvertisementRequestDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdvertisementManager implements AdvertisementService {


    @Autowired
    private AdvertisementDao advertisementDao;
    private ModelMapper modelMapper;

    public AdvertisementManager(AdvertisementDao advertisementDao, ModelMapper modelMapper) {
        this.advertisementDao = advertisementDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public DataResult<List<AdvertisementDto>> getAllAd() {
        List<Advertisement> jobAdvertisements = advertisementDao.findAll();
      /*  List<AdvertisementDto> jobAdvertisementDtos = new ArrayList<AdvertisementDto>();
        for(Advertisement jobAdvertisement:jobAdvertisements){
            AdvertisementDto advertisementDto=modelMapper.map(jobAdvertisement,AdvertisementDto.class);
            jobAdvertisementDtos.add(advertisementDto);
        }*/
        return new SuccessDataResult<List<AdvertisementDto>>(jobAdvertisementToDto(jobAdvertisements), "Başarıyla Listelendi");
    }

    @Override
    public DataResult<AdvertisementRequestDto> addAd(AdvertisementRequestDto advertisement) {
        Advertisement jobAdvertisements = modelMapper.map(advertisement,Advertisement.class);
        advertisementDao.save(jobAdvertisements);

        return new SuccessDataResult<AdvertisementRequestDto>(advertisement, "İlan Eklendi");

    }

    @Override
    public DataResult<List<AdvertisementDto>> getActive() {
        List<Advertisement> jobAdvertisements = advertisementDao.findAllByActiveTrue();
        return new SuccessDataResult<List<AdvertisementDto>>(jobAdvertisementToDto(jobAdvertisements), "Tüm Aktif İlanlar Listelendi");
    }

    @Override
    public DataResult<List<AdvertisementDto>> getAllPassive() {
        List<Advertisement> jobAdvertisements = advertisementDao.findAllByActiveFalseOrderByCreatedDateDesc();
        return new SuccessDataResult<List<AdvertisementDto>>(jobAdvertisementToDto(jobAdvertisements), "Tüm Pasif İlanlar Listelendi");
    }

    @Override
    public DataResult<List<AdvertisementDto>> getEmpId(int id) {
        List<Advertisement> jobAdvertisements = advertisementDao.findAllByEmployerIdAndActiveTrue(id);
        return new SuccessDataResult<List<AdvertisementDto>>(jobAdvertisementToDto(jobAdvertisements), "Firmaya ait İş ilanları Listelendi");
    }

    @Override
    public DataResult<List<AdvertisementDto>> getAdDate() {
        List<Advertisement> jobAdvertisements = advertisementDao.findAllByActiveTrueOrderByEndDateDesc();
        return new SuccessDataResult<List<AdvertisementDto>>(jobAdvertisementToDto(jobAdvertisements), "Aktif İlanlar Tarihe Göre Listelendi");
    }

    @Override
    public DataResult<List<AdvertisementDto>> getAdCustomDate(Date date) {
        List<Advertisement> jobAdvertisements = advertisementDao.findAllByCreatedDate(date);
        return new SuccessDataResult<List<AdvertisementDto>>(jobAdvertisementToDto(jobAdvertisements), "İstenilen Tarihe Göre Sıralandı");
    }

    @Override
    public DataResult<Advertisement> updateActive(int id, boolean active) {
        Advertisement tempAdvertisement = advertisementDao.findById(id).orElse(null);
        tempAdvertisement.setActive(active);
        this.advertisementDao.save(tempAdvertisement);
        return new SuccessDataResult<Advertisement>(tempAdvertisement, "Güncellendi");

    }

    private List<AdvertisementDto> jobAdvertisementToDto(List<Advertisement> jobAdvertisements) {
        return jobAdvertisements.stream().map(Advertisement -> modelMapper.map(Advertisement, AdvertisementDto.class)).collect(Collectors.toList());
    }
}
