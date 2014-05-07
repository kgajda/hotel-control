/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.client;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * @author karol
 */
@Configuration
@EnableWebMvc
@ComponentScan("pl.hotel.control.client")
public class DispatcherConfig extends WebMvcConfigurerAdapter{
    @Bean
    public ObjectMapper mapper(){
        return new ObjectMapper();
    }
    @Bean
    public MappingJackson2HttpMessageConverter converterJson(){
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        return converter;
    }

    @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(converterJson());
        return restTemplate;
    }
    

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
//    }
//
//    @Bean
//    org.springframework.web.servlet.view.InternalResourceViewResolver internalResourceViewResolver() {
//        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
//        internalResourceViewResolver.setPrefix("/WEB-INF/views/");
//        internalResourceViewResolver.setSuffix(".jsp");
//        return internalResourceViewResolver;
//    }
//
//    @Bean
//    org.springframework.web.servlet.view.tiles3.TilesConfigurer titles() {
//        TilesConfigurer t = new TilesConfigurer();
//        t.setDefinitions("/WEB-INF/tiles/tiles-definitions.xml");
//        return t;
//    }
//
//    @Bean
//    TilesViewResolver resolver() {
//        TilesViewResolver p = new TilesViewResolver();
//        return p;
//    }
//
//    @Bean
//    org.springframework.web.servlet.view.UrlBasedViewResolver url() {
//        UrlBasedViewResolver u = new UrlBasedViewResolver();
//        u.setViewClass(org.springframework.web.servlet.view.tiles3.TilesView.class);
//        return u;
//    }

}
