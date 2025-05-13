# 📚 Book and Author Management System

A simple web application built with Spring Boot for managing books and authors.

---

## 🎯 Project Purpose

This app provides an easy way to manage a collection of books and their authors. Users can add, view, edit, and delete both books and authors through a clean, user-friendly web interface.

---

## ✨ Features

- **Author Management**: Create, edit, view, and delete authors
- **Book Management**: Create, edit, view, and delete books
- **Relationships**: Each book is linked to an author
- **Web Interface**: Built using Thymeleaf and styled with Bootstrap

---

## 🛠 Technologies Used

- **Spring Boot** – Backend framework
- **Spring Data JDBC** – Database access layer
- **Thymeleaf** – HTML template rendering
- **H2 Database** – In-memory database for testing
- **Bootstrap** – Styling and responsive UI
- **Lombok** – Reduces Java boilerplate code

---

## 🚀 How to Run (Using IntelliJ IDEA)

1. **Open IntelliJ IDEA** and select **File > Open**, then choose the project folder (`SpringProject`).

2. Wait for Maven to finish loading the dependencies (you'll see this in the bottom bar).

3. Open the file: src/main/java/com/example/springproject/SpringProjectApplication.java

4. Right-click on the file and select:
   Run 'SpringProjectApplication.main()'

5. Once it's running, open your browser and go to:
   http://localhost:9090


---

## 🌐 Basic Usage

- **Home Page**: Displays all books
- **Add Book**: Click "Add New Book" and submit the form
- **Edit/Delete Book**: Use buttons on the book detail page
- **Authors Page**: Click "Authors" in the top menu
- **Manage Authors**: Similar features for authors (add, view, edit, delete)

---

## 🧱 Application Structure

### 🧾 Model Layer
- `Author`: Author details (name, biography)
- `Book`: Book details (title, description, year, ISBN)

### 💾 Repository Layer
- `AuthorRepository`: Accesses author data
- `BookRepository`: Accesses book data

### 🧠 Service Layer
- `AuthorService`: Business logic for authors
- `BookService`: Business logic for books

### 🌐 Controller Layer
- `HomeController`: Home page routing
- `AuthorController`: Author pages
- `BookController`: Book pages

### 🎨 View Layer
- HTML pages (Thymeleaf) in `resources/templates`
- Reusable layout for consistent look

---

## 🗃 Database Info

The project uses an **H2 in-memory database**, which resets each time you stop the app.

### H2 Console Access:
- URL: `http://localhost:9090/h2-console`
- JDBC URL: `jdbc:h2:mem:bookdb`
- Username: `sa`
- Password: `password`

---

## ✅ Notes

- Make sure port `9090` is free on your system.
- The database is automatically loaded with sample data when the app starts.

