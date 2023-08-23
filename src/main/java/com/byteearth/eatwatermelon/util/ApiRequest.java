package com.byteearth.eatwatermelon.util;

import cn.hutool.http.HttpStatus;
import com.alibaba.fastjson.JSON;
import com.byteearth.eatwatermelon.model.entity.JsonRootBean;
import com.byteearth.eatwatermelon.model.entity.Replies;
import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

//@Slf4j
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
        // 设置目标点赞视频id
        String oid = "956733745";
        // 设置目标点赞数,-1不限制,其他设置低于该点赞数的不拉取
        int likecount = -1;
        String url = "https://api.bilibili.com/x/v2/reply/main?jsonp=jsonp&type=1&oid=" + oid + "&mode=3&plat=1&next=1";

        List<Replies> replyList = Lists.newArrayList();
        int count = 0;
        while (true) {
            String response = request(url);
            JsonRootBean json = JSON.parseObject(response, JsonRootBean.class);
            replyList.addAll(json.getData().getReplies());
            if (CollectionUtils.isEmpty(json.getData().getReplies())) {
                break;
            }
//            log.info("{}",++count);
            System.out.println(++count);
        }
        System.out.println(replyList.size());
//        for (Replies repliesObj : replyList) {
//            System.out.println("用户名称:" + repliesObj.getMember().getUname() + ",回复内容：" + repliesObj.getContent().getMessage()
//                    + "\n点赞数:" + repliesObj.getLike() + ",评论数:" + repliesObj.getRcount()
//                    + ",评论时间:" + DateUtils.format(new Date(Long.parseLong(repliesObj.getCtime() + "000")), DateUtils.DATE_TIME_CHINESE));
//        }
    }
}
