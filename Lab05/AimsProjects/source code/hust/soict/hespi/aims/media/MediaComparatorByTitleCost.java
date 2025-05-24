package hust.soict.hespi.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media o1, Media o2) {
        // Compare title
        int title_cmp = o1.getTitle().compareTo(o2.getTitle());
        if (title_cmp != 0) return title_cmp;

        // Compare cost
        return Double.compare(o2.getCost(), o1.getCost());
    }
}