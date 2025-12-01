package ua.opnu;

public class BookData implements Comparable<BookData> {

    private String title;
    private String author;
    private int reviews;
    private double total;

    public BookData(String title, String author, int reviews, double total) {
        this.title = title;
        this.author = author;
        this.reviews = reviews;
        this.total = total;
    }

    public double getRating() {
        if (reviews == 0) return 0.0;
        return total / reviews;
    }

    @Override
    public int compareTo(BookData other) {
        double myRating = this.getRating();
        double otherRating = other.getRating();
        int ratingResult = Double.compare(otherRating, myRating);
        if (ratingResult != 0) {
            return ratingResult;
        }
        int titleResult = this.title.compareTo(other.title);
        if (titleResult != 0) {
            return titleResult;
        }
        return this.author.compareTo(other.author);
    }

    @Override
    public String toString() {
        return String.format("Book{title='%s', author='%s', rating=%.2f}", title, author, getRating());
    }
}
