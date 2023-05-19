package com.geekster.StockManagement.service;

import com.geekster.StockManagement.model.Stock;
import com.geekster.StockManagement.model.StockType;
import com.geekster.StockManagement.repository.IStockRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StockService {

    @Autowired
    IStockRepository stockRepository;

    public List<Stock> getStocksByType(StockType stockType) {
        return stockRepository.findByStockType(stockType);
    }

    public String insertList(List<Stock> listOfStocks) {
         Iterable<Stock> list = stockRepository.saveAll(listOfStocks);
         if(list != null) return "Added list of stocks ....!!!!";
         return "Could not added...!!!";
    }

    public List<Stock> getStockAbovePriceAndLowerDate(Double price, String date) {
        LocalDate cDate = LocalDate.parse(date);
        return stockRepository.findByStockPriceGreaterThanAndStockBirthTimeStampLessThanOrderByStockNameDesc(price,cDate);
    }

    public List<Stock> getAllStockAboveCapPercentage(Double capPercentage) {
        return stockRepository.getAllStocksAboveMarketCap(capPercentage);
    }

    @Transactional
    public void updateByMarketCap(Double marketCap, Integer id) {
        stockRepository.updateMarketCapById(marketCap,id);
    }

    @Transactional
    public void updateStockTypeById(StockType stockType, Integer id) {
        String value = stockType.name();
        stockRepository.modifyStockTypeById(id,value);
    }
}
