package kodlamaio.hrmsdemo.dataAccess.abstracts;

import kodlamaio.hrmsdemo.entities.concretes.Advertisement;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface AdvertisementDao extends JpaRepository<Advertisement,Integer> {
    List<Advertisement> findAllByActiveFalseOrderByCreatedDateDesc();
    List<Advertisement> findAllByActiveTrue();
    List<Advertisement> findAllByActiveTrue(Pageable pageable);
    List<Advertisement> findAllByEmployerIdAndActiveTrue(int id);
    List<Advertisement> findAllByActiveTrueOrderByEndDateDesc();
    List<Advertisement> findAllByCreatedDate(Date date);




}
