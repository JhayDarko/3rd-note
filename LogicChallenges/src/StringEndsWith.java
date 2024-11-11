public class StringEndsWith {

    public static boolean endsWith(String text, String suffix) {
        if (suffix.length() > text.length()) {
            return false;
        }
        text = text.substring(text.length() - suffix.length());
        return text.equals(suffix);
    }

    public static void main(String[] args) {
        System.out.println("abc - bc: " + endsWith("abc", "bc"));
        System.out.println("abc - d: " + endsWith("abc", "d"));
    }
}
