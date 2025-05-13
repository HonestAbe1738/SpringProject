package com.example.springproject.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.springproject.model.Author;
import com.example.springproject.model.Book;
import com.example.springproject.service.AuthorService;
import com.example.springproject.service.BookService;

import jakarta.annotation.PostConstruct;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private AuthorService authorService;
    
    @Autowired
    private BookService bookService;
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @PostConstruct
    public void initDatabase() {
        // Check if tables exist, if not create them
        try {
            List<String> tables = jdbcTemplate.queryForList(
                "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA='PUBLIC'",
                String.class
            );
            
            if (!tables.contains("AUTHORS")) {
                jdbcTemplate.execute(
                    "CREATE TABLE AUTHORS (" +
                    "ID BIGINT AUTO_INCREMENT PRIMARY KEY, " +
                    "NAME VARCHAR(255) NOT NULL, " +
                    "BIOGRAPHY TEXT)"
                );
            }
            
            if (!tables.contains("BOOKS")) {
                jdbcTemplate.execute(
                    "CREATE TABLE BOOKS (" +
                    "ID BIGINT AUTO_INCREMENT PRIMARY KEY, " +
                    "TITLE VARCHAR(255) NOT NULL, " +
                    "DESCRIPTION TEXT, " +
                    "PUBLICATION_YEAR INT, " +
                    "ISBN VARCHAR(20), " +
                    "AUTHOR_ID BIGINT NOT NULL, " +
                    "FOREIGN KEY (AUTHOR_ID) REFERENCES AUTHORS(ID))"
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void run(String... args) throws Exception {
        // Create some authors

        Author author1 = Author.builder()
                .name("George Orwell")
                .biography("English novelist, essayist, journalist and critic. His work is marked by lucid prose, awareness of social injustice, opposition to totalitarianism, and outspoken support of democratic socialism.")
                .build();

        Author author2 = Author.builder()
                .name("Jane Austen")
                .biography("An English novelist known primarily for her six major novels, which interpret, critique and comment upon the British landed gentry at the end of the 18th century.")
                .build();

        Author author3 = Author.builder()
                .name("Gabriel García Márquez")
                .biography("A Colombian novelist, short-story writer, screenwriter and journalist, known affectionately as Gabo or Gabito throughout Latin America. He is considered one of the most significant authors of the 20th century and one of the best in the Spanish language.")
                .build();

        Author author4 = Author.builder()
                .name("Haruki Murakami")
                .biography("A Japanese writer. His books and stories have been bestsellers in Japan and internationally, with his work being translated into 50 languages and selling millions of copies worldwide.")
                .build();
        
        Author author5 = Author.builder()
                .name("J.K. Rowling")
                .biography("British author, best known for the Harry Potter series.")
                .build();

        // Save authors
        author1 = authorService.save(author1);
        author2 = authorService.save(author2);
        author3 = authorService.save(author3);
        author4 = authorService.save(author4);
        author5 = authorService.save(author5);
        
        // Create some books
        Book book1 = Book.builder()
                .title("Nineteen Eighty-Four")
                .description("A dystopian novel by English novelist George Orwell.")
                .publicationYear(1949)
                .isbn("9780451524935")
                .authorId(author1.getId())
                .build();

        Book book2 = Book.builder()
                .title("Pride and Prejudice")
                .description("An 1813 novel of manners by Jane Austen.")
                .publicationYear(1813)
                .isbn("9780141439518")
                .authorId(author2.getId())
                .build();
        
        Book book3 = Book.builder()
                .title("One Hundred Years of Solitude")
                .description("A landmark 1967 novel by Colombian author Gabriel García Márquez.")
                .publicationYear(1967)
                .isbn("9780061120084")
                .authorId(author3.getId())
                .build();
        
        Book book4 = Book.builder()
                .title("Norwegian Wood")
                .description("A 1987 novel by Japanese author Haruki Murakami.")
                .publicationYear(1987)
                .isbn("9780375704024")
                .authorId(author4.getId())
                .build();
        
        Book book5 = Book.builder()
                .title("Harry Potter and the Philosopher's Stone")
                .description("The first book in the Harry Potter series.")
                .publicationYear(1997)
                .isbn("9780747532743")
                .authorId(author5.getId())

                .build();
        // Save books
        bookService.save(book1);
        bookService.save(book2);
        bookService.save(book3);
        bookService.save(book4);
        bookService.save(book5);
    }
}