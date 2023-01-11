package com.interbanking.bank.mapper;

import com.interbanking.bank.model.Company;
import com.interbanking.bank.model.dto.CompanyDto;

public class Mapper {
    public static CompanyDto toCompanyDto(Company company) {
        return CompanyDto.builder().cuit(company.getCuit()).businessName(company.getBusinessName()).joiningDate(company.getJoiningDate()).build();
    }

    public static Company toCompany(CompanyDto companyDto) {
        return Company.builder().businessName(companyDto.getBusinessName()).cuit(companyDto.getCuit()).build();
    }
}
