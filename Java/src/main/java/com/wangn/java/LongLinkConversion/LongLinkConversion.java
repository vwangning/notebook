package com.wangn.java.LongLinkConversion;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class LongLinkConversion {


    private static Map<String, String> linkMap = new HashMap<>();
    /*
    * 长短链接转化 用md532实现
     */
    public static void main(String[] args) throws NoSuchAlgorithmException {

        // 创建一个 HashMap 来存储长链接和短链接的映射

        String longLink = "https://jsonll.blog.csdn.net/article/details/134492033?spm=1001.2101.3001.6650.5&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7ERate-5-134492033-blog-135154750.235%5Ev43%5Epc_blog_bottom_relevance_base6&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7ERate-5-134492033-blog-135154750.235%5Ev43%5Epc_blog_bottom_relevance_base6&utm_relevant_index=10";
        // 生成短链接
        String shortLink = MD5Utils.MD532(longLink);
        System.out.println("短链接: " + shortLink);

        // 将长链接和短链接存储到映射中
        storeLink(shortLink, longLink);

        // 根据短链接获取长链接
        String retrievedLongLink = getLongLink(shortLink);
        System.out.println("根据短链接获取的长链接: " + retrievedLongLink);

    }
    // 存储短链接和长链接的映射
    private static void storeLink(String shortLink, String longLink) {
        linkMap.put(shortLink, longLink);
    }

    // 根据短链接获取长链接
    private static String getLongLink(String shortLink) {
        return linkMap.get(shortLink);
    }
}