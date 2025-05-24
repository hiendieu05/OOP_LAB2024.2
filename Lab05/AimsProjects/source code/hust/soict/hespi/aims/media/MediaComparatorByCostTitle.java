package hust.soict.hespi.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media o1, Media o2) {
        // Compare cost
        int cost_cmp = Double.compare(o2.getCost(), o1.getCost());
        if (cost_cmp != 0) return cost_cmp;

        // Compare title
        return o1.getTitle().compareTo(o2.getTitle());
    }
}