//package com.example.irelandcontrollerex;
//
//import org.apache.http.params.HttpConnectionParams;
//import org.apache.http.params.HttpParams;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.io.UnsupportedEncodingException;
//
//public class DataForm {
//    public String sendHttpWithMsg(String url) {
//        JSONObject jObj = new JSONObject();
//        try {
//            jObj.put("name", "hong");
//            jObj.put("phone", "000-0000");
//        } catch (JSONException e1) {
//            e1.printStackTrace();
//        }
//
//        try {
//            // JSON을 String 형변환하여 httpEntity에 넣어줍니다.
//            StringEntity se;
//            se = new StringEntity(jObj.toString());
//            HttpEntity he=se;
//            post.setEntity(he);
//        } catch (UnsupportedEncodingException e1) {
//            e1.printStackTrace();
//        }
//        //httpPost 를 서버로 보내고 응답을 받습니다.
//        HttpResponse response = client.execute(post);
//        //출처: https://wowan.tistory.com/63 [DevWarehouse:티스토리]
//    }
//}
