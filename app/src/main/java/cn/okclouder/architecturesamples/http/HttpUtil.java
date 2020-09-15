package cn.okclouder.architecturesamples.http;

import android.util.Log;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author caoshen
 * @date 2020/9/14
 */
public class HttpUtil {

    public String get(String uid) {
        return "{\n" +
                "  \"name\": \"zhangsan\",\n" +
                "  \"age\": 18\n" +
                "}";
    }

}
