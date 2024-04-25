package com.library.security.book;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BookRequest {

    private Integer id;
    private String author;
    private String isbn;
    private String title;
    private String description;
    private int copies;
    private String category;
    private String img;
}
