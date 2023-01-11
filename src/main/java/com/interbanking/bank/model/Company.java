package com.interbanking.bank.model;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "COMPANIES")
public class Company implements Serializable {

    @Id
    @Column(nullable = false, unique = true)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "This field must not be null")
    @Column(nullable = false)
    private String cuit;

    @NotNull(message = "This field must not be null")
    @Column(name = "business_name", nullable = false)
    private String businessName;

    @NotNull(message = "This field must not be null")
    @Column(name = "joining_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate joiningDate;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Transfer> transfers;
}