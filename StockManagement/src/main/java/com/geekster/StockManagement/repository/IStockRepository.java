package com.geekster.StockManagement.repository;

import com.geekster.StockManagement.model.Stock;
import com.geekster.StockManagement.model.StockType;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IStockRepository extends CrudRepository<Stock, Integer> {

    public List<Stock> findByStockType(StockType stockType);

    public List<Stock> findByStockPriceGreaterThanAndStockBirthTimeStampLessThanOrderByStockNameDesc(Double price, LocalDate date);

    //Custom queries : Native
    @Query(value = "Select * From Stock Where STOCK_MARKET_CAP >:capPercentage", nativeQuery = true)
    public List<Stock> getAllStocksAboveMarketCap(Double capPercentage);

    @Modifying
    @Query(value = "Update Stock set STOCK_MARKET_CAP = :capPercentage where STOCK_ID  = :id", nativeQuery = true)
    public void updateMarketCapById(Double capPercentage, Integer id);

    @Modifying
    @Query(value = "Update Stock set STOCK_TYPE = :myType where STOCK_ID  = :id", nativeQuery = true)
    public void modifyStockTypeById(Integer id, String myType);


}
