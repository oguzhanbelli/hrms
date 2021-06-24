package kodlamaio.hrmsdemo.business.abstracts;

import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.entities.concretes.Favorite;
import kodlamaio.hrmsdemo.entities.concretes.Talent;
import kodlamaio.hrmsdemo.entities.dtos.TalentDto;

import java.util.List;

public interface FavoriteService {
    DataResult<List<Favorite>> getAll();
    DataResult<List<Favorite>> getAllFavoritesById(int id);
    DataResult<Favorite> add(Favorite favorite);
}
