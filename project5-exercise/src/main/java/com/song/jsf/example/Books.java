package com.song.jsf.example;

import java.io.Serializable;

public class Books implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private long isbn;
	private String title;
	private String author;
	private String publisher;
	private double price;

	public Books() {}
	public Books(int id, long isbn, String title, String author, String publisher, double price) {
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getIsbn() {
		return isbn;
	}
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public Books clone() {
		return new Books(id, isbn, title, author, publisher, price);
	}

	public void restore(Books books) {
		this.id = books.getId();
		this.isbn = books.getIsbn();
		this.title = books.getTitle();
		this.author = books.getAuthor();
		this.publisher = books.getPublisher();
		this.price = books.getPrice();
		
	}
}
