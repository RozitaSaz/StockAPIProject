package com.app.stock.service.mapper;

import com.app.stock.domain.Stock;
import com.app.stock.dto.StockDto;
import com.app.stock.util.DateUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;

/**
 * Created by Rozita on 10/21/21.
 */
@Service
public class StockMapper {

    @Autowired
    private ModelMapper modelMapper;

    public StockDto convertToDto(Stock stock) {
        StockDto stockDto = modelMapper.map(stock, StockDto.class);
        stockDto.setLogDate(DateUtil.convertDateToString(DateUtil.STOCK_DATE_PATTERN, stock.getDate()));
        return stockDto;
    }

    public Stock convertToEntity(StockDto stockDto) throws ParseException {
        Stock stock = modelMapper.map(stockDto, Stock.class);
        stock.setDate(DateUtil.convertStringToDate(DateUtil.STOCK_DATE_PATTERN, stockDto.getLogDate()));
        return stock;
    }
}
