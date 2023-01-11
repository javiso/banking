package com.interbanking.bank.repository;

import com.interbanking.bank.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BankRepository extends JpaRepository<Company, Long> {
    @Query(value = "SELECT c.* FROM COMPANIES c INNER JOIN TRANSFERS t ON c.id = t.company_id WHERE EXTRACT(MONTH FROM t.transfer_date) = :lastMonth GROUP BY c.id", nativeQuery = true)
    List<Company> findTransferLastMonth(@Param("lastMonth") int lastMonth);

    @Query(value = "SELECT c.* FROM COMPANIES c WHERE EXTRACT(MONTH FROM c.joining_date) = :lastMonth", nativeQuery = true)
    List<Company> findCompaniesByLastMonth(@Param("lastMonth") int lastMonth);
}