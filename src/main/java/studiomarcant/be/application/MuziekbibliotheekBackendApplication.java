package studiomarcant.be.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by Win 10 on 13/11/2018.
 */
public class MuziekbibliotheekBackendApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources (MuziekbibliotheekBackendApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MuziekbibliotheekBackendApplication.class,args);
    }
}
