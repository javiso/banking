package com.interbanking.bank.service;

import com.interbanking.bank.model.Company;
import com.interbanking.bank.model.dto.CompanyDto;

import java.util.List;

public interface BankService {
    List<Company> findCompaniesByTransferLastMonth();

    List<Company> findCompaniesByLastMonth();

    Company joinCompany(final CompanyDto company);
}