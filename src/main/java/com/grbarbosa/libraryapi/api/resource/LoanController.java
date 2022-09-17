package com.grbarbosa.libraryapi.api.resource;

import com.grbarbosa.libraryapi.api.dto.BookDTO;
import com.grbarbosa.libraryapi.api.dto.LoanDTO;
import com.grbarbosa.libraryapi.api.dto.LoanFilterDTO;
import com.grbarbosa.libraryapi.api.dto.ReturnedLoanDTO;
import com.grbarbosa.libraryapi.model.entity.Book;
import com.grbarbosa.libraryapi.model.entity.Loan;
import com.grbarbosa.libraryapi.service.BookService;
import com.grbarbosa.libraryapi.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/loans")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService service;
    private final BookService bookService;
    private final ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(@RequestBody LoanDTO dto) {
        Book book = bookService
                .getBookByIsbn(dto.getIsbn())
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.BAD_REQUEST, "Book not found for passed isbn"));
        Loan entity = Loan.builder()
                .book(book)
                .customer(dto.getCustomer())
                .loanDate(LocalDate.now())
                .build();

        entity = service.save(entity);
        return entity.getId();
    }

    @PatchMapping("{id}")
    public void returnBook(
            @PathVariable Long id,
            @RequestBody ReturnedLoanDTO dto) {
        Loan loan = service.getById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        loan.setReturned(dto.getReturned());
        service.update(loan);
    }

    @GetMapping
    public Page<LoanDTO> find(LoanFilterDTO dto, Pageable pageRequest) {
        Page<Loan> result = service.find(dto, pageRequest);
        List<LoanDTO> loans = result
                .getContent()
                .stream()
                .map(entity -> {

                    Book book = entity.getBook();
                    BookDTO bookDTO = modelMapper.map(book, BookDTO.class);
                    LoanDTO loanDTO = modelMapper.map(entity, LoanDTO.class);
                    loanDTO.setBook(bookDTO);
                    return loanDTO;

                }).collect(Collectors.toList());
        return new PageImpl<LoanDTO>(loans, pageRequest, result.getTotalElements());
    }
}
