package com.interbanking.bank.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TRANSFERS")
public class Transfer implements Serializable {
    @Id
    @Column(nullable = false, unique = true)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "This field must not be null")
    @DecimalMin(value = "0.0", message = "The value must be greater than 0")
    @Column(nullable = false)
    private BigDecimal cost;

    @NotNull(message = "This field must not be null")
    @Column(name = "debit_account", nullable = false)
    private String debitAccount;

    @NotNull(message = "This field must not be null")
    @Column(name = "credit_account", nullable = false)
    private String creditAccount;

    @NotNull(message = "This field must not be null")
    @Column(name = "transfer_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate transferDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;
}