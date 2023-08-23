package com.byteearth.eatwatermelon.util;

import cn.hutool.http.HttpStatus;
import com.alibaba.fastjson.JSON;
import com.byteearth.eatwatermelon.model.entity.JsonRootBean;
import com.byteearth.eatwatermelon.model.entity.Replies;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class ApiRequest {

    public static String request(String url) throws IOException {
        URL urlObject = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();
        connection.setRequestMethod(RequestMethod.GET.toString());
        connection.setRequestProperty("Accept", "application/json");

        int responseCode = connection.getResponseCode();
        if (responseCode != HttpStatus.HTTP_OK) {
            throw new IOException(connection.getResponseMessage());
        }

        InputStream inputStream = connection.getInputStream();
        Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        StringBuilder response = new StringBuilder();
        int c;
        while ((c = reader.read()) != -1) {
            response.append((char) c);
        }

        return response.toString();
    }

    public static void main(String[] args) throws IOException {
        String url = "https://api.bilibili.com/x/v2/reply/main?jsonp=jsonp&type=1&oid=956733745&mode=3&plat=1&next=1";
        String response = request(url);
        JsonRootBean json = JSON.parseObject(response, JsonRootBean.class);
        for (Replies repliesObj : json.getData().getReplies()) {
            System.out.println("用户名称:" + repliesObj.getMember().getUname() + ",回复内容：" + repliesObj.getContent().getMessage()
                    + "\n点赞数:" + repliesObj.getLike() + ",评论数:" + repliesObj.getRcount()
                    + ",评论时间:" + DateUtils.format(new Date(Long.parseLong(repliesObj.getCtime() + "000")), DateUtils.DATE_TIME_CHINESE));
        }
    }
}
