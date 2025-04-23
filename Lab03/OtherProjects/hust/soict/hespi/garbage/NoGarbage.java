public class NoGarbage {
    public static void main(String[] args) {
        String sampleText = "sample text for testing string concatenation performance " +
                "hsidhgidiqwnvijwnviunvieurwiunviruwvniufvishfisfqgfywgvwvwvi ";
        String largeInput = "";
        for (int i = 0; i < 5000; i++) {
            largeInput += sampleText;
        }

        // Concatenate characters using StringBuilder
        long startTime1 = System.currentTimeMillis();
        StringBuilder output1 = new StringBuilder();
        for (int i = 0; i < largeInput.length(); i++) {
            output1.append(largeInput.charAt(i));
        }
        String result1 = output1.toString();
        long endTime1 = System.currentTimeMillis();
        System.out.println("Time with StringBuilder: " + (endTime1 - startTime1));
        System.out.println("Output length: " + result1.length());

        // Concatenate characters using StringBuffer
        long startTime2 = System.currentTimeMillis();
        StringBuffer output2 = new StringBuffer();
        for(int i = 0; i < largeInput.length(); i++) {
            output2.append(largeInput.charAt(i));
        }
        String result2 = output2.toString();
        long endTime2 = System.currentTimeMillis();
        System.out.println("\nTime with StringBuffer: " + (endTime2 - startTime2));
        System.out.println("Output length: " + result2.length());
    }
}