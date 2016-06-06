package com.ws.test;

import org.junit.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * RestTemplate 是Spring3.0新增的模板类，在客户端程序中可使用该类调用Web服务端的服务
 * 它支持REST风格的URL
 * Created by alvin on 2016/6/6.
 */
public class UserControllerTest {
    @Test
    public void testHandle41(){
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String,String> form = new LinkedMultiValueMap<String, String>();
        form.add("username", "tom");
        form.add("password","123456");

        restTemplate.postForLocation("http://localhost:8080/spring-mvc/user/handle41.html",form);
    }

    @Test
    public void testHandle42() throws IOException{
        RestTemplate restTemplate = new RestTemplate();
        byte[] response = restTemplate.postForObject("http://localhost:8080/spring-mvc/user/handle42/{itemId}.html",null,byte[].class,"123456789");
        Resource outFile = new FileSystemResource("d:/ideaworkspace/image_copy.jpg");
        FileCopyUtils.copy(response,outFile.getFile());
    }
}
