package com.geekster.StockManagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table

public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer stockId;

    @Column(unique = true)
    private String stockName;
    private Double stockPrice;
    private Integer stockOwnerCount;

    @Enumerated(EnumType.STRING)
    private StockType stockType; //can only be 0,1,2
    private Double stockMarketCap;
    private LocalDate stockBirthTimeStamp;

}
