package hust.soict.hespi.garbage;

public class GarbageCreator {
    public static void main(String[] args) {
        // large file content
        String sampleText = "sample text for testing string concatenation performance " +
                "hsihgidfaerserewtrweteryherthrhrthrthtrhhrhtrhrthrtvwvi ";
        String largeInput = "";
        for (int i = 0; i < 5000; i++) {
            largeInput += sampleText; 		// Build large string to simulate file
        }

        // Concatenate characters using +
        long startTime = System.currentTimeMillis();
        String outputString = "";
        for (int i = 0; i < largeInput.length(); i++) {
            outputString += largeInput.charAt(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time with String: " + (endTime - startTime));
        System.out.println("Output length: " + outputString.length());
    }
}