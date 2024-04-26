package com.library.security.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
// import com.library.security.checkout;
// import com.library.security.history;
// import com.library.security.book.ShelfCurrentLoansResponse;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository repository;

    public void save(BookRequest request) {
        var book = Book.builder()
                .author(request.getAuthor())
                .isbn(request.getIsbn())
                .description(request.getDescription())
                .copies(request.getCopies())
                .copiesAvailable(request.getCopies())
                .category(request.getCategory())
                .img(request.getImg())
                .build();
        repository.save(book);
    }

    public List<Book> findAll() {
        return repository.findAll();
    }

    public Optional<Book> findById(int id) {
        return repository.findById(id);
    }

    // public void deleteBookById(Long id) {
    //     repository.deleteById(id);
    // }

}
