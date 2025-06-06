-- Drop tables if they exist to avoid conflicts
DROP TABLE IF EXISTS BOOKS;
DROP TABLE IF EXISTS AUTHORS;

-- Create authors table
CREATE TABLE AUTHORS (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(255) NOT NULL,
    BIOGRAPHY TEXT
);

-- Create books table with foreign key to authors
CREATE TABLE BOOKS (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    TITLE VARCHAR(255) NOT NULL,
    DESCRIPTION TEXT,
    PUBLICATION_YEAR INT,
    ISBN VARCHAR(20),
    AUTHOR_ID BIGINT NOT NULL,
    FOREIGN KEY (AUTHOR_ID) REFERENCES AUTHORS(ID)
);