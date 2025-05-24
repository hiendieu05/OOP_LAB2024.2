package hust.soict.hespi.aims;

import java.util.*;

import hust.soict.hespi.aims.cart.Cart;
import hust.soict.hespi.aims.media.*;
import hust.soict.hespi.aims.store.Store;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Sample media for demonstration
        store.addMedia(new DigitalVideoDisc("Avengers", "Action", "Joss Whedon", 143, 20.0f));
        store.addMedia(new Book("Harry Potter", "Fantasy", 15.0f));
        store.addMedia(new CompactDisc("Hybrid Theory", "Rock", 10.0f, "Linkin Park", 45, "Chester"));

        while (true) {
            showMainMenu();
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1 -> viewStore();
                case 2 -> updateStore();
                case 3 -> viewCart();
                case 0 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void showMainMenu() {
        System.out.println("\nAIMS MAIN MENU");
        System.out.println("------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. View current cart");
        System.out.println("0. Exit");
        System.out.print("Select an option (0-3): ");
    }

    private static void viewStore() {
        store.printStore();
        while (true) {
            showStoreMenu();
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1 -> showMediaDetails();
                case 2 -> addMediaToCart();
                case 3 -> playMedia();
                case 4 -> viewCart();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static void showStoreMenu() {
        System.out.println("\nSTORE MENU");
        System.out.println("------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.print("Choose an option (0-4): ");
    }

    private static void showMediaDetails() {
        System.out.print("Enter media title: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media != null) {
            System.out.println(media);
            boolean isPlayable = media instanceof Playable;
            showMediaDetailOptions(isPlayable);
            int option = scanner.nextInt();
            scanner.nextLine();
            if (option == 1) cart.addMedia(media);
            else if (option == 2 && isPlayable) ((Playable) media).play();
        } else {
            System.out.println("Media not found.");
        }
    }

    private static void showMediaDetailOptions(boolean isPlayable) {
        System.out.println("\nMEDIA OPTIONS");
        System.out.println("------------------------------");
        System.out.println("1. Add to cart");
        if (isPlayable) System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.print("Choose an option: ");
    }

    private static void addMediaToCart() {
        System.out.print("Enter media title to add: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media != null) cart.addMedia(media);
        else System.out.println("Media not found.");
    }

    private static void playMedia() {
        System.out.print("Enter media title to play: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media instanceof Playable playable) playable.play();
        else System.out.println("This media cannot be played.");
    }

    private static void updateStore() {
        System.out.println("1. Add media to store\n2. Remove media from store");
        int option = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        if (option == 1) {
            store.addMedia(new Book(title, "Unknown", 0));
        } else if (option == 2) {
            Media media = store.searchByTitle(title);
            if (media != null) store.removeMedia(media);
            else System.out.println("Media not found.");
        }
    }

    private static void viewCart() {
        cart.printCart();
        while (true) {
            showCartMenu();
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1 -> filterCart();
                case 2 -> sortCart();
                case 3 -> removeFromCart();
                case 4 -> playFromCart();
                case 5 -> placeOrder();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static void showCartMenu() {
        System.out.println("\nCART MENU");
        System.out.println("------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.print("Choose an option (0-5): ");
    }

    private static void filterCart() {
        System.out.println("1. Filter by ID\n2. Filter by Title");
        int option = scanner.nextInt();
        scanner.nextLine();
        if (option == 1) {
            System.out.print("Enter ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            cart.searchById(id);
        } else {
            System.out.print("Enter Title: ");
            String title = scanner.nextLine();
            cart.searchByTitle(title);
        }
    }

    private static void sortCart() {
        System.out.println("1. Sort by title\n2. Sort by cost");
        int option = scanner.nextInt();
        scanner.nextLine();
        if (option == 1 || option == 2) cart.sortByCostTitle();
    }

    private static void removeFromCart() {
        System.out.print("Enter title to remove: ");
        String title = scanner.nextLine();
        Media media = cart.searchByTitle(title);
        if (media != null) cart.removeMedia(media);
        else System.out.println("Media not found in cart.");
    }

    private static void playFromCart() {
        System.out.print("Enter title to play: ");
        String title = scanner.nextLine();
        Media media = cart.searchByTitle(title);
        if (media instanceof Playable playable) playable.play();
        else System.out.println("Cannot play this media.");
    }

    private static void placeOrder() {
        System.out.println("Order has been placed successfully!");
        cart.clear();
    }
}