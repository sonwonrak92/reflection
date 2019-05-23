package com.team4.webservice.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.team4.webservice.dto.UserDto;

@RestController
public class ApiRestController {
	
	public String callNaverLoginApi(@RequestBody UserDto dto) {
		return "";
	}

	 @GetMapping("/get/{apiName}/{imgPath}")
	 public String callClovarFaceReferenceApi( @PathVariable String apiName, @PathVariable String imgPath) {
		 
		    StringBuffer reqStr = new StringBuffer();
		    String apiURL = null;
		    String clientId = "m4WFYhvnPWkxvFuWj2D0";//애플리케이션 클라이언트 아이디값";
	        String clientSecret = "34UW8ZIIZJ";//애플리케이션 클라이언트 시크릿값";
	        
	        if( apiName.equals("celebApi") ) {
	        	apiURL = "https://openapi.naver.com/v1/vision/celebrity"; // 유명인 얼굴 인식
	        } else if (  apiName.equals("faceApi") ) {
	        	apiURL = "https://openapi.naver.com/v1/vision/face"; // 얼굴 감지
	        }	        
	        
	        try {
	            String paramName = "image"; // 파라미터명은 image로 지정
	            String imgFile = "C:\\app\\"+imgPath+"";
	            File uploadFile = new File(imgFile);
	            URL url = new URL(apiURL);
	            HttpURLConnection con = (HttpURLConnection)url.openConnection();
	            con.setUseCaches(false);
	            con.setDoOutput(true);
	            con.setDoInput(true);
	            // multipart request
	            String boundary = "---" + System.currentTimeMillis() + "---";
	            con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
	            con.setRequestProperty("X-Naver-Client-Id", clientId);
	            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
	            OutputStream outputStream = con.getOutputStream();
	            PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"), true);
	            String LINE_FEED = "\r\n";
	            // file 추가
	            String fileName = uploadFile.getName();
	            writer.append("--" + boundary).append(LINE_FEED);
	            writer.append("Content-Disposition: form-data; name=\"" + paramName + "\"; filename=\"" + fileName + "\"").append(LINE_FEED);
	            writer.append("Content-Type: "  + URLConnection.guessContentTypeFromName(fileName)).append(LINE_FEED);
	            writer.append(LINE_FEED);
	            writer.flush();
	            FileInputStream inputStream = new FileInputStream(uploadFile);
	            byte[] buffer = new byte[4096];
	            int bytesRead = -1;
	            while ((bytesRead = inputStream.read(buffer)) != -1) {
	                outputStream.write(buffer, 0, bytesRead);
	            }
	            outputStream.flush();
	            inputStream.close();
	            writer.append(LINE_FEED).flush();
	            writer.append("--" + boundary + "--").append(LINE_FEED);
	            writer.close();
	            BufferedReader br = null;
	            int responseCode = con.getResponseCode();
	            if(responseCode==200) { // 정상 호출
	                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	            } else {  // 에러 발생
	                System.out.println("error!!!!!!! responseCode= " + responseCode);
	                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	            }
	            String inputLine;
	            if(br != null) {
	            	StringBuffer response = new StringBuffer();
	                while ((inputLine = br.readLine()) != null) {
	                    response.append(inputLine);
	                    reqStr = response;
	                    System.out.println(response.toString());
	                }
	                br.close();
	            } 
	            
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	        return reqStr.toString();
	 }
	 

}
