import java.util.ArrayList;

class Book {
    protected String title;
    protected String author;
    protected double price;
    
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    
    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }
}

class Fiction extends Book {
    public Fiction(String title, String author, double price) {
        super(title, author, price);
    }
    
    @Override
    public void displayDetails() {
        System.out.println("Fiction Book Details:");
        super.displayDetails();
    }
}

class NonFiction extends Book {
    public NonFiction(String title, String author, double price) {
        super(title, author, price);
    }
    
    @Override
    public void displayDetails() {
        System.out.println("Non-Fiction Book Details:");
        super.displayDetails();
    }
}

class Library {
    private ArrayList<Book> books;
    
    public Library() {
        books = new ArrayList<>();
    }
    
    public void addBook(Book book) {
        books.add(book);
    }
    
    public void displayAllBooks() {
        for (Book book : books) {
            book.displayDetails();
            System.out.println("---------------------------");
        }
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        System.out.println("Library Management System by Pushkar[22bcs17250]");
        System.out.println();
        
        Library library = new Library();
        
        library.addBook(new Fiction("1984", "George Orwell", 400));
        library.addBook(new Fiction("Brave New World", "Aldous Huxley", 450));
        library.addBook(new Fiction("The Great Gatsby", "F. Scott Fitzgerald", 350));
        
        library.addBook(new NonFiction("The Selfish Gene", "Richard Dawkins", 650));
        library.addBook(new NonFiction("Sapiens", "Yuval Noah Harari", 700));
        library.addBook(new NonFiction("Educated", "Tara Westover", 550));
        
        library.displayAllBooks();
    }
}
