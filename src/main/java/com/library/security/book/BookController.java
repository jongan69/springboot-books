package com.library.security.book;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService service;

    @PostMapping
    public ResponseEntity<?> save(
            @RequestBody BookRequest request
    ) {
        service.save(request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<Book>> findAllBooks() {
        return ResponseEntity.ok(service.findAll());
    }


    // @GetMapping("/secure/currentloans")
    // public List<ShelfCurrentLoansResponse> currentLoans(@RequestHeader(value = "Authorization") String token)
    //     throws Exception
    // {
    //     String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
    //     return bookService.currentLoans(userEmail);
    // }

    // @GetMapping("/secure/currentloans/count")
    // public int currentLoansCount(@RequestHeader(value = "Authorization") String token) {
    //     String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
    //     return bookService.currentLoansCount(userEmail);
    // }

    // @GetMapping("/secure/ischeckedout/byuser")
    // public Boolean checkoutBookByUser(@RequestHeader(value = "Authorization") String token,
    //                                   @RequestParam Long bookId) {
    //     String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
    //     return bookService.checkoutBookByUser(userEmail, bookId);
    // }

    // @PutMapping("/secure/checkout")
    // public Book checkoutBook (@RequestHeader(value = "Authorization") String token,
    //                           @RequestParam Long bookId) throws Exception {
    //     String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
    //     return bookService.checkoutBook(userEmail, bookId);
    // }

    // @PutMapping("/secure/return")
    // public void returnBook(@RequestHeader(value = "Authorization") String token,
    //                        @RequestParam Long bookId) throws Exception {
    //     String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
    //     bookService.returnBook(userEmail, bookId);
    // }

    // @PutMapping("/secure/renew/loan")
    // public void renewLoan(@RequestHeader(value = "Authorization") String token,
    //                       @RequestParam Long bookId) throws Exception {
    //     String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
    //     bookService.renewLoan(userEmail, bookId);
    // }
}
