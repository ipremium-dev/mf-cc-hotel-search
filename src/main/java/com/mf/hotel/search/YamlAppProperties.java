package com.mf.hotel.search;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "yaml")
@PropertySource(value = "classpath:application.yml", factory = YamlPropertySourceFactory.class)
public class YamlAppProperties {

    private String searchApi;

}
