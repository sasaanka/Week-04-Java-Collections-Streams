import java.util.*;
import java.util.stream.*;

public class BookRecommendation {
    static class Book {
        final private String title;
        final private String author;
        final private String genre;
        final private double rating;
        public Book(String title, String author, String genre, double rating) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.rating = rating;
        }
        public String getTitle() { return title; }
        public String getAuthor() { return author; }
        public String getGenre() { return genre; }
        public double getRating() { return rating; }
    }
    static class BookRecommendationSystem {
        final private String title;
        final private double rating;
        public BookRecommendationSystem(String title, double rating) {
            this.title = title;
            this.rating = rating;
        }
        public double getRating() {
            return rating;
        }
        @Override
        public String toString() {
            return title + " - Rating: " + rating;
        }
    }

    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
            new Book("Dune", "Frank Herbert", "Science Fiction", 4.8),
            new Book("Neuromancer", "William Gibson", "Science Fiction", 4.3),
            new Book("Foundation", "Isaac Asimov", "Science Fiction", 4.5),
            new Book("Red Mars", "Kim Stanley Robinson", "Science Fiction", 4.0),
            new Book("The Left Hand of Darkness", "Ursula K. Le Guin", "Science Fiction", 4.3),
            new Book("Brave New World", "Aldous Huxley", "Dystopian", 4.1),
            new Book("1984", "George Orwell", "Dystopian", 4.6)
        );

        List<Book> filtered = books.stream()
            .filter(b -> b.getGenre().equals("Science Fiction") && b.getRating() > 4.0)
            .collect(Collectors.toList());

        List<BookRecommendationSystem> recommendations = filtered.stream()
            .map(b -> new BookRecommendationSystem(b.getTitle(), b.getRating()))
            .collect(Collectors.toList());

        List<BookRecommendationSystem> sorted = recommendations.stream()
            .sorted(Comparator.comparingDouble(BookRecommendationSystem::getRating).reversed())
            .collect(Collectors.toList());

        int pageSize = 5;
        int total = Math.min(10, sorted.size());
        int totalPages = (int) Math.ceil(total / (double) pageSize);

        for (int page = 1; page <= totalPages; page++) {
            System.out.println("\nPage " + page + ":");
            sorted.stream()
                .skip((page - 1) * pageSize)
                .limit(pageSize)
                .forEach(System.out::println);
        }
    }
}
