package com.grbarbosa.libraryapi.service;

import com.grbarbosa.libraryapi.api.dto.LoanFilterDTO;
import com.grbarbosa.libraryapi.model.entity.Book;
import com.grbarbosa.libraryapi.model.entity.Loan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface LoanService {

    Loan save( Loan loan );

    Optional<Loan> getById(Long id);

    Loan update(Loan loan);

    Page<Loan> find(LoanFilterDTO filterDTO, Pageable pageable);

    Page<Loan> getLoansByBook( Book book, Pageable pageable);

    List<Loan> getAllLateLoans();

}
