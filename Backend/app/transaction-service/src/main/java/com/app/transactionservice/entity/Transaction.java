package com.app.transactionservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Builder
public class Transaction {
    @Id
    private UUID id;
    private UUID accountId;
    private Integer amount;
    private String currency;
    //private String merchantCategory;
    private String country;
    private Date createdAt;

}
