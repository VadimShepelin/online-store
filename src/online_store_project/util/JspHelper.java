package online_store_project.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JspHelper {
    private static final String PATH_HELPER = "/WEB-INF/jsp/%s.jsp";

    public static String getPathToJsp(String jspName) {
        return String.format(PATH_HELPER, jspName);
    }
}
