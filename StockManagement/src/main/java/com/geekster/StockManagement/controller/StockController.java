package com.geekster.StockManagement.controller;

import com.geekster.StockManagement.model.Stock;
import com.geekster.StockManagement.model.StockType;
import com.geekster.StockManagement.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    StockService stockService;

    //get Stocks By Type
    @GetMapping("/type/{stockType}")
    public List<Stock> getStocksByType(@PathVariable StockType stockType){
        return stockService.getStocksByType(stockType);
    }

    //get Using Custom Finder
    @GetMapping("/abovePrice/price/{price}/lowerDate/{date}")
    public List<Stock> getStockAbovePriceAndLowerDate(@PathVariable Double price, @PathVariable String date){
        return stockService.getStockAbovePriceAndLowerDate(price, date);
    }

    @GetMapping("/cap/{capPercentage}")
    public List<Stock> getAllStockAboveCapPercentage(@PathVariable Double capPercentage){
        return stockService.getAllStockAboveCapPercentage(capPercentage);
    }

    @PostMapping("/")
    public String addStocks(@RequestBody List<Stock> listOfStocks){
        return stockService.insertList(listOfStocks);
    }

    @PutMapping("/marketCap/{marketCap}/id/{id}")
    public void addStocks(@PathVariable Double marketCap, @PathVariable Integer id){
        stockService.updateByMarketCap(marketCap,id);
    }

    @PutMapping("/type/id")
    public void updateStockTypeById(@RequestParam StockType stockType, @RequestParam Integer id){
        stockService.updateStockTypeById(stockType,id);
    }

}
