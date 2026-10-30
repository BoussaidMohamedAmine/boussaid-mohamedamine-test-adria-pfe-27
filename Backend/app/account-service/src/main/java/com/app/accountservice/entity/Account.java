package com.app.accountservice.entity;

import com.app.accountservice.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data @NoArgsConstructor
@AllArgsConstructor @Builder
public class Account {

    @Id
    private UUID id;
    private String customerReference;
    private String currency;
    private Double balance;
    @Enumerated(EnumType.STRING)
    private Status status;
}
