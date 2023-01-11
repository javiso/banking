
package com.interbanking.bank.controller;

import com.interbanking.bank.mapper.Mapper;
import com.interbanking.bank.model.dto.CompanyDto;
import com.interbanking.bank.service.BankService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("v1/bank")
@AllArgsConstructor
public class BankController {

    private final BankService bankService;

    @GetMapping("/transfer")
    public ResponseEntity<List<CompanyDto>> findCompaniesByTransferLastMonth() {
        return ResponseEntity.ok(bankService.findCompaniesByTransferLastMonth().stream().map(Mapper::toCompanyDto).toList());
    }

    @GetMapping("/company")
    public ResponseEntity<List<CompanyDto>> findCompaniesByLastMonth() {
        return ResponseEntity.ok(bankService.findCompaniesByLastMonth().stream().map(Mapper::toCompanyDto).toList());
    }

    @PostMapping("/joining")
    public ResponseEntity<CompanyDto> joinCompany(@Valid @RequestBody final CompanyDto company) {
        return ResponseEntity.ok(Mapper.toCompanyDto(bankService.joinCompany(company)));
    }
}