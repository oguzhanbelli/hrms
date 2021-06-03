package kodlamaio.hrmsdemo.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import kodlamaio.hrmsdemo.core.utilities.cloudinary.abstracts.CloudinaryService;
import kodlamaio.hrmsdemo.core.utilities.cloudinary.concretes.CloudinaryManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConf {
    @Value("${cld.access-key}")
    String accesKey;
    @Value("${cld.secret-key}")
    String secretKey;
    @Bean
    public Cloudinary cloudinaryUser(){
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "da6yblg12",
                "api_key", accesKey,
                "api_secret", secretKey));
    }

    @Bean
    public CloudinaryService cloudinaryService(){
        return new CloudinaryManager(cloudinaryUser());
    }
}
