package main;

import java.util.*;
import books.Book;
import members.Members;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();

        Members member = new Members(name, phone);

        List<Book> library = new ArrayList<>();
        library.add(new Book("1984", "George Orwell"));
        library.add(new Book("The Alchemist", "Paulo Coelho"));
        library.add(new Book("Dune", "Frank Herbert"));

        while (true) {
            System.out.println("\n1. Borrow Book");
            System.out.println("2. Return Book");
            System.out.println("3. View Borrowed Books");
            System.out.println("4. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    if (library.isEmpty()) {
                        System.out.println("No books available to borrow.");
                        break;
                    }
                    System.out.println("Available Books:");
                    for (int i = 0; i < library.size(); i++) {
                        System.out.println((i + 1) + ". " + library.get(i).getTitle() + " by " + library.get(i).getAuthorName());
                    }
                    System.out.print("Enter book number to borrow: ");
                    int bookChoice = sc.nextInt();
                    sc.nextLine();
                    if (bookChoice > 0 && bookChoice <= library.size()) {
                        member.borrowBooks(library.get(bookChoice - 1));
                        System.out.println("Book borrowed successfully.");
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;

                case 2:
                    if (member.getBorrowedBooks().isEmpty()) {
                        System.out.println("No books to return.");
                        break;
                    }
                    System.out.println("Your Borrowed Books:");
                    for (int i = 0; i < member.getBorrowedBooks().size(); i++) {
                        System.out.println((i + 1) + ". " + member.getBorrowedBooks().get(i).getTitle());
                    }
                    System.out.print("Enter book number to return: ");
                    int returnChoice = sc.nextInt();
                    sc.nextLine();
                    if (returnChoice > 0 && returnChoice <= member.getBorrowedBooks().size()) {
                        Book returned = member.getBorrowedBooks().remove(returnChoice - 1);
                        System.out.println("Returned " + returned.getTitle());
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;

                case 3:
                    if (member.getBorrowedBooks().isEmpty()) {
                        System.out.println("No borrowed books.");
                    } else {
                        System.out.println("Borrowed Books:");
                        for (Book b : member.getBorrowedBooks()) {
                            System.out.println(b.getTitle() + " by " + b.getAuthorName());
                        }
                    }
                    break;

                case 4:
                    System.out.println("Goodbye, " + member.getUsername() + "!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}
