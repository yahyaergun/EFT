package com.yergun.demo.util;

public class Utilities {

    public static String getPagedUrl(String url, Integer page){
        final String pageParam = "?page=";
        return (page != null && page > 1) ? url + pageParam + page : url;
    }
}
