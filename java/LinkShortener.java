import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class LinkShortener {

    private static final String BASE_URL = "http://short.link/";
    private static final int SHORT_URL_LENGTH = 6;

    private Map<String, String> urlMap;
    private Random random;

    public LinkShortener() {
        this.urlMap = new HashMap<>();
        this.random = new Random();
    }

    public String shortenUrl(String originalUrl) {
        String shortKey = generateShortKey();
        String shortUrl = BASE_URL + shortKey;
        urlMap.put(shortKey, originalUrl);
        return shortUrl;
    }

    public String redirect(String shortUrl) {
        String shortKey = shortUrl.replace(BASE_URL, "");
        return urlMap.getOrDefault(shortKey, "URL not found");
    }

    private String generateShortKey() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SHORT_URL_LENGTH; i++) {
            char randomChar = (char) (random.nextInt(26) + 'a');
            sb.append(randomChar);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkShortener linkShortener = new LinkShortener();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Shorten URL");
            System.out.println("2. Redirect URL");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter the URL to shorten: ");
                    String originalUrl = scanner.nextLine();
                    String shortUrl = linkShortener.shortenUrl(originalUrl);
                    System.out.println("Shortened URL: " + shortUrl);
                    break;
                case 2:
                    System.out.print("Enter the shortened URL: ");
                    String inputUrl = scanner.nextLine();
                    String redirectedUrl = linkShortener.redirect(inputUrl);
                    System.out.println("Redirecting to: " + redirectedUrl);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
