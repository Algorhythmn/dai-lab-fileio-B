package ch.heig.dai.lab.fileio.dacc4;

public class Transformer {

    private final String newName;
    private final int numWordsPerLine;

    /**
     * Constructor
     * Initialize the Transformer with the name to replace "Chuck Norris" with 
     * and the number of words per line to use when wrapping the text.
     * @param newName the name to replace "Chuck Norris" with
     * @param numWordsPerLine the number of words per line to use when wrapping the text
     */
    public Transformer(String newName, int numWordsPerLine) {
        this.newName = newName;
        this.numWordsPerLine = numWordsPerLine;
    }

    /**
     * Replace all occurrences of "Chuck Norris" with the name given in the constructor.
     * @param source the string to transform
     * @return the transformed string
     */
    public String replaceChuck(String source) {
        return source.replaceAll("Chuck Norris", newName);
    }

    /**
     * Capitalize the first letter of each word in the string.
     * @param source the string to transform
     * @return the transformed string
     */
    public String capitalizeWords(String source) {
        // Split the source string into words
        String[] words = source.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                // Capitalize the first letter of the word and append it to the result
                result.append(Character.toUpperCase(word.charAt(0)));
                result.append(word.substring(1));
                result.append(" ");
            }
        }

        // Remove the trailing space and return the result
        return result.toString().trim();
    }


    /**
     * Wrap the text so that there are at most numWordsPerLine words per line.
     * Number the lines starting at 1.
     * @param source the string to transform
     * @return the transformed string
     */
    public String wrapAndNumberLines(String source) {
        String[] words = source.split("\\s+");
        StringBuilder result = new StringBuilder();
        result.append("1.");
        int wordCount = 0;
        int lineCount = 1;

        for (String word : words) {
            if (!word.isEmpty()) {
                if (wordCount == numWordsPerLine) {
                    // Start a new line and increment the line count
                    result.append("\n");
                    lineCount++;
                    result.append(lineCount).append(".");
                    wordCount = 0;
                }

                // Append the word and a space to the result
                result.append(" ");
                result.append(word);
                wordCount++;
            }
        }

        // Return the result
        result.append("\n");
        return result.toString();
    }
}   