
package com.mycompany.webblog;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author Elina Gorby
 */

@Configuration //für weitere Möglichkeit Pfad mit "/" schreiben. Ex: "url/first" 
public class MyConfiguration implements WebMvcConfigurer {
   
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseTrailingSlashMatch(true);
    }
}
