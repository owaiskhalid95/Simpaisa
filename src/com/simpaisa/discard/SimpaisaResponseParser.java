package com.simpaisa.discard;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class SimpaisaResponseParser {

    private Response response;

    public SimpaisaResponseParser(Response post) {
        this.response = post;

    }

    public void body() {
        String response_data = response.asString();
        System.out.println("this is response body " + response_data);
    }

    public void response_time() {
        long response_time = response.getTime();
        System.out.println("this is response time " + response_time);
    }

    public void status_code() {
        int code = response.getStatusCode();
        System.out.println("this is status code: " + code);
    }

    public void content_type() {
        String content_type = response.getContentType();
        System.out.println("this is content type: " + content_type);
    }

    public void misc() {
        String response_data = response.asString();

        System.out.println("this is response body " + response_data);
        String referenceId = response_data.split(",")[0].split(":")[0];
        System.out.println(referenceId);
        String referenceId1 = response_data.split(",")[0].split(":")[1];
        System.out.println(referenceId1);
        String referenceId2 = response_data.split(",")[1].split(":")[0];
        System.out.println(referenceId2);
        String referenceId3 = response_data.split(",")[1].split(":")[1];
        System.out.println(referenceId3);
        String referenceId4 = response_data.split(",")[5].split(":")[0];
        System.out.println(referenceId4);
        String referenceId5 = response_data.split(",")[5].split(":")[1];
        System.out.println(referenceId5);


    }

    public Map<String, String> misc1() {
        String response_data = response.asString()
                                .replaceAll("}", "")
                                .replaceAll("\\{", "")
                                .replaceAll("\"", "");


        String[] values = response_data.split(":");



        Map<String, String> myMap = new HashMap<String, String>();

        String[] pairs = response_data.split(",");
        for (int i = 0; i < pairs.length; i++) {
            String pair = pairs[i];
            String[] keyValue = pair.split(":");
            myMap.put(keyValue[0], (keyValue[1]));

        }

        return myMap;

    }


    public static void response(Response result) {

        String response_data = result.asString();
        System.out.println("this is response body " + response_data);

        long response_time = result.getTime();
        System.out.println("this is response time " + response_time);

        int code = result.getStatusCode();
        System.out.println("this is status code: " + code);

        String content_type = result.getContentType();
        System.out.println("this is content type: " + content_type);

    }
}
