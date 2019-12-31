package io.iotmp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2019/12/30 21:36
 * @Version 1.0
 **/
@ComponentScan
@Configuration
public class WebConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/pic/**").addResourceLocations("file:///"+System.getProperty("user.dir") +"\\target\\classes\\static\\pic\\");
    }
}
