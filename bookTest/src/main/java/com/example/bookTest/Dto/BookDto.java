package com.example.bookTest.Dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookDto {
	private int bookId;
	private String bookTitle;
	private String bookAuthor;
	private int bookCost;
	private int bookPage;
	private String publisher;
}
