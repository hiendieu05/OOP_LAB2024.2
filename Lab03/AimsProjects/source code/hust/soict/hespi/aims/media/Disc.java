package hust.soict.hespi.aims.media;

public class Disc extends Media {
    private String director;
    private int length;

    // Constructor
    public Disc(String title) {
        super(title);
    }

    public Disc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public Disc(String title, String category, String director, float cost) {
        super(title, category, cost);
        this.director = director;
    }

    public Disc(String title, String category, String director, int length, float cost) {
        super(title, category, cost);
        this.director = director;
        this.length = length;
    }

    // Getter
    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    @Override
    public int compareTo(Media other) {
        if (other instanceof Disc) {
            Disc otherDVD = (Disc) other;
            int title_cmp = this.getTitle().compareTo(otherDVD.getTitle());
            if (title_cmp != 0) return title_cmp; // Compare title
            else {
                // Compare by decreasing length
                int length_cmp = Integer.compare(otherDVD.getLength(), this.getLength());
                if (length_cmp != 0) return length_cmp;
                else return Double.compare(this.getCost(), otherDVD.getCost()); // Compare cost
            }
        } else return super.compareTo(other);
        // if the media object isn't Disc -> default method in Media class
    }
}