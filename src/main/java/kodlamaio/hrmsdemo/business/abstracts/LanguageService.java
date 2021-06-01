package kodlamaio.hrmsdemo.business.abstracts;

import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.core.utilities.results.Result;
import kodlamaio.hrmsdemo.entities.concretes.Language;
import kodlamaio.hrmsdemo.entities.concretes.Talent;

import java.util.List;

public interface LanguageService {
    DataResult<List<Language>> getAll();

    Result add(Language language);
}
