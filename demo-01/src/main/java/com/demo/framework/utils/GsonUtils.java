package com.demo.framework.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Gson Tools
 * 
 * Gson 谷歌的JSON处理工具， 好处是不用担心缺失的属性. 如： 我们的映射对象有A、B、C三个属性,
 * 如果JSON字符串缺失了某一个，转换时候不会报错(这样就可以差别不大的映射对象共用), Jackson会报错。
 * 
 */
public class GsonUtils {
    private static final Gson gson = new GsonBuilder().disableHtmlEscaping().create();

    /**
     * <pre>
     * JSON字符串转换为List数组, 提供两种方式(主要解决调用的容易程度)
     *     1. TypeToken<List<T>> token 参数转换
     *     2. Class<T> cls 方式转换
     * 
     * @param json
     * @return List<T>
     * 
     * <pre>
     */
    public static <T> List<T> convertList(String json, TypeToken<List<T>> token) {
        if (StringUtils.isBlank(json)) {
            return new ArrayList<T>();
        }
        return gson.fromJson(json, token.getType());
    }

    /**
     * <pre>
     * JSON字符串转换为List数组, 提供两种方式(主要解决调用的容易程度)
     *     1. TypeToken<List<T>> token 参数转换
     *     2. Class<T> cls 方式转换
     * 
     * @param json
     * @param cls
     * @return List<T>
     * </pre>
     */
    public static <T> List<T> convertList(String json, Class<T> cls) {
        if (StringUtils.isBlank(json)) {
            return new ArrayList<T>();
        }
        Type type = new TypeToken<List<JsonObject>>() {
        }.getType();
        List<JsonObject> jsonObjs = gson.fromJson(json, type);
        List<T> listOfT = new ArrayList<>();
        for (JsonObject jsonObj : jsonObjs) {
            listOfT.add(convertObj(jsonObj.toString(), cls));
        }
        return listOfT;
    }

    /**
     * <pre>
     * Json格式转换, 由JSON字符串转化到制定类型T
     * 
     * @param json
     * @param cls
     * @return T
     * 
     * <pre>
     */
    public static <T> T convertObj(String json, Class<T> cls) {
        if (StringUtils.isBlank(json)) {
            return null;
        }
        return gson.fromJson(json, cls);
    }

    /**
     * <pre>
     * java对象转化JSON
     * 
     * @return String
     * 
     * <pre>
     */
    public static String toJson(Object obj) {
        if (obj == null) {
            return "";
        }
        return gson.toJson(obj);
    }

    public static String getJsonObjectAsString(JsonObject jsonObject, String name) {
        if (jsonObject == null || StringUtils.isBlank(name)) {
            return null;
        }
        JsonElement jsonElement = jsonObject.get(name);
        return (jsonElement == null) ? null : jsonElement.getAsString();
    }

    public static JsonObject getJsonObjectChild(JsonObject jsonObject, String name) {
        if (jsonObject == null || StringUtils.isBlank(name)) {
            return null;
        }
        JsonElement jsonElement = jsonObject.get(name);
        return (jsonElement == null) ? null : jsonElement.getAsJsonObject();
    }

    public static boolean getJsonObjectAsBoolean(JsonObject jsonObject, String name) {
        if (jsonObject == null || StringUtils.isBlank(name)) {
            return false;
        }
        JsonElement jsonElement = jsonObject.get(name);
        return (jsonElement == null) ? false : jsonElement.getAsBoolean();
    }
}
