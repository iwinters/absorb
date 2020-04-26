package org.pocketworkstation.pckeyboard;

import android.util.Log;


import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.net.URLEncoder;

public class Http {
    private static final String BASE_URL = "https://translation.googleapis.com/language/translate/v2?";
    private static final String KEY = "-----BEGIN PRIVATE KEY-----\\nMIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDhnFZqIlpX9XER\\naz1/oY78+CK/DgENJTZJA3eWnySEi+hRV9zYWHGp3NyiPJw5eBvkkMrXrleDUc7J\\nRa6API1kdZzyek0e+aHR8QLi878MWGrzln/vJJoqDKK4h2XQdOpmZvUnGicb+9Ke\\nSN9YI5wwGzYvwG0TR2ptHGcig70D89qLoLXn4NqXSNia34wcYe9WP37aMkvr0vt/\\ntYI9IBNgEGtnXHa1b1ksNZZRbP4Qf7p8x/KdfEBL1WtuBxQTpHXf3q2VNTQY4oOZ\\nDzu1x05ecOEvxhLVUQAXiDuUPNs4MFQRMVjpEQOxKB91WzhVRY9nu1gMDkTa78QO\\n7NWif3fbAgMBAAECggEAZs/RW317MTFDDP6TYHnVyPclEm7F0OE/20cOtN+iCxsc\\nzBDfreGkLpXdH7vCL7hJ8b+ACIjFDa12sCcmjf7KKlkkpCVSxsZY1Wzg9V7BldUn\\nLAlOFMNX08i9UJ03KydUeET7/A1BfFGmWgZ4bViRASUtbNZifpIhcEasw0BInyci\\nw+ZSyjgVGz6/jX4A/i0etvaqTO9TQYl1mp7yugt5yz4bJKxM69MCICNiHrR+YTEI\\ncNjq4Bj1Xv75Vj21A5OXew2189E9CoRZZhNn35678qEuDZzXEnKRxLCRaZ6ZIAAa\\niGkvSF+14zpDrhl36+U1AF6z3JJBxnWalPHE4/vZHQKBgQD0VfWyn4NcCeQWcDGG\\nbR5M63pUGrA8OeWHdBpg+qVl6CdQk08vVF3+yqYBGB+tQ+ijqe5n1drR1NiIlUp5\\nWmTB3N3uxljnNfARjGA4ksbXolJcKe9u73lUOz1HsP6ALMc5EDALvoHE1cuQqgnG\\nMmGORLrCVV4xGzwe2+oPrki/lwKBgQDsYYmcf5Bt4+n3JHb6j6wH5/HWIqXips7h\\ngqZyKhHCt0c3FS9VaPrpoHo/9srwOUxMpHk02QYs+y/rZ1hD8wElXQ1LWs9iR4mi\\njsvOJD5pTu9u8H7jtk55X/k+6ipJfAZBcIjjTwqBWCOwcIZWdZBvVsULGgDm0FT9\\nwyaNn1jSXQKBgQDn+/Wb8ve1m26EH2HmUBRE1A8Ba5WImS/ku8eP7Gq9pv4s8rBs\\nL55PG/khcNYinCd1vRIuZE2ujHhKtfRP5BNmPV46JviiDgQxpSZ2kGVatzObbfV3\\nTsfTwasdNl9tMxa0hzoW7HopeRQd9lPxakRV38uyV3tnBITAh+xjlwZbYQKBgC9x\\nvE8fA3wq/LDQLtlHsP29Pjr+pVECrg9xS7sqWno8kxypMeDwuzvdK+xeuojQ11Gi\\nyXkj/itVF18mVP7+bUJ0lNCFH47YUPXBt4Jen/A/Gauota86zjFqY/qOwYISVKcZ\\n0T/eg3tGl5M4Yp5D5oOSZOY/h+LL+eMdIkXWr9s5AoGBANced7eRaatF3XJSuYGr\\nGIKyeQY9bNcJdaCUAHlaQkWf03DDM3zg8+gmxQdSshMz4WemQFCx6HC1GzzUKJay\\n6KzX/yY9T0S7Yw0d34p8e9PKBxEsfJj51wp1JNh9G5ioCUGPcwSVxXMb0cuC+dxb\\nngzBqGqYO6I4vV/vFk35pWdV\\n-----END PRIVATE KEY-----\\n";


    private static AsyncHttpClient client = new AsyncHttpClient();


    public static void post(String transText,String sourceLang, String destLang, AsyncHttpResponseHandler responseHandler) {
        client.get(getAbsoluteUrl(transText, sourceLang, destLang), responseHandler);
    }

    private static String makeKeyChunk(String key) {
        return "key=" + KEY;
    }

    private static String makeTransChunk(String transText) {
        String encodedText = URLEncoder.encode(transText);
        return "&amp;q=" + encodedText;
    }

    private static String langSource(String langSource) {
        return "&amp;source=" + langSource;
    }

    private static String langDest(String langDest) {
        return "&amp;target=" + langDest;

    }

    private static String getAbsoluteUrl(String transText, String sourceLang, String destLang) {
        String apiUrl = BASE_URL + makeKeyChunk(KEY) + makeTransChunk(transText) + langSource(sourceLang) + langDest(destLang);
        return apiUrl;
    }
}