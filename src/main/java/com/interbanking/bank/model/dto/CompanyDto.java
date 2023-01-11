package com.interbanking.bank.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class CompanyDto {

    private String cuit;
    private String businessName;
    private LocalDate joiningDate;
}