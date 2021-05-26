package kodlamaio.hrmsdemo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrmsdemo.entities.concretes.Job;

public interface JobDao extends JpaRepository<Job, Integer> {
    boolean existsByJobName(String jobName);

}
