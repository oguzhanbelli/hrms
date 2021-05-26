package kodlamaio.hrmsdemo.dataAccess.abstracts;

import kodlamaio.hrmsdemo.entities.concretes.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateDao extends JpaRepository<Candidate, Integer> {

    List<Candidate> findAllByEmailAdress(String email);

    boolean existsByIdentificationNumber(String Tc);

}
