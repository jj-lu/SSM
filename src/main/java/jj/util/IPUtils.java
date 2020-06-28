package jj.util;

import javax.servlet.http.HttpServletRequest;

public class IPUtils {

    private static final String ERRORIP = "127.0.0.1";

    public static String getIP(HttpServletRequest request){
        String IP = request.getHeader("X-Real-IP");

        if (IP == null){
            IP = request.getHeader("x-forwarded-for");
        }

        if (IP == null){
            IP = request.getRemoteAddr();
            if ("0:0:0:0:0:0:0:1".equals(IP)) {
                IP = ERRORIP;
            }
        }
        return IP;
    }
}
