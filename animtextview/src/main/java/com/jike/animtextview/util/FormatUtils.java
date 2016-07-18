package com.jike.animtextview.util;

/**
 * 参考android.text.format.Formatter类
 * Created by wancc on 2016/7/15.
 */
public class FormatUtils {

    public static final String KB ="KB";
    public static final String MB ="MB";
    public static final String GB ="GB";
    public static final String TB ="TB";
    public static final String PB ="PB";



    public static String formatFileSize(long number) {
        float result = number/ 1024;
        String suffix = KB;

        /*if (result > 999) {
            suffix = KB;
            result = result / 1024;
        }*/
        if (result > 999) {
            suffix = MB;
            result = result / 1024;
        }
        if (result > 999) {
            suffix = GB;
            result = result / 1024;
        }
        if (result > 999) {
            suffix = TB;
            result = result / 1024;
        }
        if (result > 999) {
            suffix = PB;
            result = result / 1024;
        }
        String value;
        if (result < 1) {
            value = String.format("%.2f", result);
        } else if (result < 10) {
            value = String.format("%.2f", result);
        } else if (result < 100) {
            value = String.format("%.1f", result);
        } else {
            value = String.format("%.0f", result);
        }
        return value+suffix;
    }
}
