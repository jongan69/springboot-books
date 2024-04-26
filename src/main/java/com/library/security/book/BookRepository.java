package com.library.security.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    Page<Book> findByTitleContaining(@RequestParam("title") String title, Pageable pageable);

    Page<Book> findByCategory(@RequestParam("category") String category, Pageable pageable);

    @Query("select o from Book o where id in :book_ids")
    List<Book> findBooksByBookIds (@Param("book_ids") List<Book> bookId);

    @Modifying
    @Query("delete from Book b where b.id in :book_ids")
    void deleteBooksByIds(@Param("book_ids") Long id);
}
