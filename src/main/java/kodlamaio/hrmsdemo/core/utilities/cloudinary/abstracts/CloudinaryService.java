package kodlamaio.hrmsdemo.core.utilities.cloudinary.abstracts;

import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface CloudinaryService {

    DataResult<?> save(MultipartFile file);

}
