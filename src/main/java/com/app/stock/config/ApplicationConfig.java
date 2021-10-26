package com.app.stock.config;

import com.app.stock.domain.Stock;
import com.app.stock.dto.StockDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

/**
 * Created by Rozita on 10/21/21.
 */
@Configuration
public class ApplicationConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<StockDto, Stock>() {
            @Override
            protected void configure() {
                skip(destination.getDate());
            }
        });
        return modelMapper;
    }
}
