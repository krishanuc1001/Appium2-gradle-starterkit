package com.tw.utilities;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DynamicXpathUtil {
    public static String getXPath(String xpath, String value) {
        return String.format(xpath, value);
    }

}
