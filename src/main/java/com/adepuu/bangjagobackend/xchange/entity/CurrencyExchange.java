package com.adepuu.bangjagobackend.xchange.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "currency_exchange")
public class CurrencyExchange {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "currency_exchange_id_gen")
    @SequenceGenerator(name = "currency_exchange_id_gen", sequenceName = "currency_exchange_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 10)
    @NotNull
    @Column(name = "base_currency", nullable = false, length = 10)
    private String baseCurrency;

    @Size(max = 10)
    @NotNull
    @Column(name = "target_currency", nullable = false, length = 10)
    private String targetCurrency;

    @NotNull
    @Column(name = "average_rate", nullable = false)
    private Double averageRate;

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "deleted_at")
    private Instant deletedAt;

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @PreUpdate
    public void preUpdate() {
        updatedAt = Instant.now();
    }

    @PrePersist
    public void prePersist() {
        createdAt = Instant.now();
        updatedAt = Instant.now();
    }

    @PreRemove
    public void preRemove() {
        deletedAt = Instant.now();
    }
}