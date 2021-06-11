package kodlamaio.hrmsdemo.business.abstracts;

import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.entities.concretes.Candidate;
import kodlamaio.hrmsdemo.entities.concretes.City;
import kodlamaio.hrmsdemo.entities.concretes.WayOfWorking;

import java.util.List;

public interface CityService {
    DataResult<List<City>> getAll();

    DataResult<City> getById(int id);
    DataResult<City> add(City city);
}
