package com.library.security.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
// import com.library.security.checkout;
// import com.library.security.history;
// import com.library.security.book.ShelfCurrentLoansResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository repository;

    public void save(BookRequest request) {
        var book = Book.builder()
                .id(request.getId())
                .author(request.getAuthor())
                .isbn(request.getIsbn())
                .build();
        repository.save(book);
    }

    public List<Book> findAll() {
        return repository.findAll();
    }

    // public Book checkoutBook (String userEmail, Long bookId) throws Exception {

    //     Optional<Book> book = bookRepository.findById(bookId);

    //     Checkout validateCheckout = checkoutRepository.findByUserEmailAndBookId(userEmail, bookId);

    //     if (!book.isPresent() || validateCheckout != null || book.get().getCopiesAvailable() <= 0) {
    //         throw new Exception("Book doesn't exist or already checked out by user");
    //     }

    //     book.get().setCopiesAvailable(book.get().getCopiesAvailable() - 1);
    //     bookRepository.save(book.get());

    //     Checkout checkout = new Checkout(
    //             userEmail,
    //             LocalDate.now().toString(),
    //             LocalDate.now().plusDays(7).toString(),
    //             book.get().getId()
    //     );

    //     checkoutRepository.save(checkout);

    //     return book.get();
    // }

    // public Boolean checkoutBookByUser(String userEmail, Long bookId) {
    //     Checkout validateCheckout = checkoutRepository.findByUserEmailAndBookId(userEmail, bookId);
    //     if (validateCheckout != null) {
    //         return true;
    //     } else {
    //         return false;
    //     }
    // }

    // public int currentLoansCount(String userEmail) {
    //     return checkoutRepository.findBooksByUserEmail(userEmail).size();
    // }

    // public List<ShelfCurrentLoansResponse> currentLoans(String userEmail) throws Exception {

    //     List<ShelfCurrentLoansResponse> shelfCurrentLoansResponses = new ArrayList<>();

    //     List<Checkout> checkoutList = checkoutRepository.findBooksByUserEmail(userEmail);
    //     List<Long> bookIdList = new ArrayList<>();

    //     for (Checkout i: checkoutList) {
    //         bookIdList.add(i.getBookId());
    //     }

    //     List<Book> books = bookRepository.findBooksByBookIds(bookIdList);

    //     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    //     for (Book book : books) {
    //         Optional<Checkout> checkout = checkoutList.stream()
    //                 .filter(x -> x.getBookId() == book.getId()).findFirst();

    //         if (checkout.isPresent()) {

    //             Date d1 = sdf.parse(checkout.get().getReturnDate());
    //             Date d2 = sdf.parse(LocalDate.now().toString());

    //             TimeUnit time = TimeUnit.DAYS;

    //             long difference_In_Time = time.convert(d1.getTime() - d2.getTime(),
    //                     TimeUnit.MILLISECONDS);

    //             shelfCurrentLoansResponses.add(new ShelfCurrentLoansResponse(book, (int) difference_In_Time));
    //         }
    //     }
    //     return shelfCurrentLoansResponses;
    // }

    // public void returnBook (String userEmail, Long bookId) throws Exception {

    //     Optional<Book> book = bookRepository.findById(bookId);

    //     Checkout validateCheckout = checkoutRepository.findByUserEmailAndBookId(userEmail, bookId);

    //     if (!book.isPresent() || validateCheckout == null) {
    //         throw new Exception("Book does not exist or not checked out by user");
    //     }

    //     book.get().setCopiesAvailable(book.get().getCopiesAvailable() + 1);

    //     bookRepository.save(book.get());
    //     checkoutRepository.deleteById(validateCheckout.getId());

    //     History history = new History(
    //             userEmail,
    //             validateCheckout.getCheckoutDate(),
    //             LocalDate.now().toString(),
    //             book.get().getTitle(),
    //             book.get().getAuthor(),
    //             book.get().getDescription(),
    //             book.get().getImg()
    //     );

    //     historyRepository.save(history);
    // }

    // public void renewLoan(String userEmail, Long bookId) throws Exception {

    //     Checkout validateCheckout = checkoutRepository.findByUserEmailAndBookId(userEmail, bookId);

    //     if (validateCheckout == null) {
    //         throw new Exception("Book does not exist or not checked out by user");
    //     }

    //     SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");

    //     Date d1 = sdFormat.parse(validateCheckout.getReturnDate());
    //     Date d2 = sdFormat.parse(LocalDate.now().toString());

    //     if (d1.compareTo(d2) > 0 || d1.compareTo(d2) == 0) {
    //         validateCheckout.setReturnDate(LocalDate.now().plusDays(7).toString());
    //         checkoutRepository.save(validateCheckout);
    //     }
    // }
}
