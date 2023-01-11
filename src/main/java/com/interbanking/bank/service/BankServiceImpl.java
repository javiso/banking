package com.interbanking.bank.service;

import com.interbanking.bank.mapper.Mapper;
import com.interbanking.bank.model.Company;
import com.interbanking.bank.model.dto.CompanyDto;
import com.interbanking.bank.repository.BankRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Slf4j
@Service
@AllArgsConstructor
public class BankServiceImpl implements BankService {

    private final BankRepository bankRepository;
    @Override
    public List<Company> findCompaniesByTransferLastMonth() {
        log.info("Fetching companies whose transfer date is last month...");
        return bankRepository.findTransferLastMonth(LocalDate.now().minusMonths(1).getMonthValue());
    }

    @Override
    public List<Company> findCompaniesByLastMonth() {
        log.info("Fetching companies whose joining date is the last month..");
        return bankRepository.findCompaniesByLastMonth(LocalDate.now().minusMonths(1).getMonthValue());
    }

    @Override
    public Company joinCompany(CompanyDto companyDto) {
        var companyToSave = Mapper.toCompany(companyDto);
        companyToSave.setJoiningDate(LocalDate.now());
        log.info("Saving company: cuit: {}, businessName: {}, joiningDate: {}", companyDto.getCuit(), companyDto.getBusinessName(), companyDto.getJoiningDate());
        return bankRepository.save(companyToSave);
    }
}