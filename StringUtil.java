import java.util.List;

public class StringUtil {

    public static String joinWithComma(List<String> items) {
        if (items == null || items.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            String cleaned = items.get(i).replaceAll("\\r?\\n", "");
            sb.append(cleaned);
            if (i < items.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }
}