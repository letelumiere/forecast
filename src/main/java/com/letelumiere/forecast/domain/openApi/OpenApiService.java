package com.letelumiere.forecast.domain.openApi;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.util.MultiValueMapAdapter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.letelumiere.forecast.domain.openApi.model.ShortApiReqeust;
import com.letelumiere.forecast.domain.openApi.model.ShortApiResponse;

//단기예보
    //요청주소 http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst
    //서비스URL http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0
    
    //초단기예보
    //요청주소 http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtFcst
    //서비스URL http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0
    
    //중기 육상
    //요청주소 http://apis.data.go.kr/1360000/MidFcstInfoService/getMidFcst
    //서비스URL http://apis.data.go.kr/1360000/MidFcstInfoService

    //중기해상
    //요청주소 http://apis.data.go.kr/1360000/MidFcstInfoService/getMidSeaFcst
    //서비스URL /MidFcstInfoService

    @Service
    public class OpenApiService { //외부 API를 조회해서, DB에 저장하는 Service
        //properties에 등록은 나중에

        @Autowired HttpHeaders httpHeaders;
        @Autowired RestTemplate restTemplate;

        String baseUrl = "http://apis.data.go.kr/1360000";

        String villageServiceUrl = "/VilageFcstInfoService_2.0";
        String MidFcstInfoService = "/MidFcstInfoService";

        String getVilageFcst = "/getVilageFcst"; 
        String getUltraSrtFcst = "/getUltraSrtFcst";

        String getMidFcstUrl = "/getMidFcst";
        String getMidSeaFcstUrl = "/getMidSeaFcst";

        //@GetMapping("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst") <- 외부 API 
        //해당 정보를 조회한다 
        //외부 API를 조회한다

        public ShortApiResponse getShortInfo(ShortApiReqeust request){

            var uri = UriComponentsBuilder.fromHttpUrl(baseUrl+villageServiceUrl+getVilageFcst)
                .queryParam("ServiceKey", request.getServiceKey())
                .queryParam("pageNo", request.getPageNo())
                .queryParam("dataType", request.getDataType())
                .queryParam("base_date", request.getBase_date())
                .queryParam("base_time", request.getBase_time())
                .queryParam("nx",request.getNx())
                .queryParam("ny",request.getNy())
                .build()
                .toUriString();

            restTemplate.setMessageConverters(gson);
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                //httpHeaders.add("Authorization", AUTHORIZATION);
            httpHeaders.add("Content-Type","application/json; charset=UTF-8");
            RequestEntity<Void> requestEntity = RequestEntity.get(uri).headers(httpHeaders).build();
            ResponseEntity<ShortApiResponse> response = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, ShortApiResponse.class);


            System.out.println(response.getBody());
            return response.getBody();  
        }

    }

    /*
     * public class ApiShortRequest {
    private String ServiceKey; // 공공데이터포털에서 받은 인증키
    private int pageNo; //페이지번호
    private int numOfRows; //한 페이지 결과 수
    private String dataType; // 요청자료형식(XML/JSON) Default: XML
    private int base_date; //20210628 ‘21년 6월 28일 발표
    private int base_time; // 0600 06시 발표(정시단위)
    private int nx; //55 예보지점의 X 좌표값
    private int ny;	// 127 예보지점의 Y 좌표값
}
     * 
     * 
     * 
     */


    /*

    private String ServiceKey; // 공공데이터포털에서 받은 인증키
    private int pageNo; //페이지번호
    private int numOfRows; //한 페이지 결과 수
    private String dataType; // 요청자료형식(XML/JSON) Default: XML
    private int base_date; //20210628 ‘21년 6월 28일 발표
    private int base_time; // 0600 06시 발표(정시단위)
    private int nx; //55 예보지점의 X 좌표값
    private int ny;	// 127 예보지점의 Y 좌표값

    
public class ApiExplorer {
    public static void main(String[] args) throws IOException {
//        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/MidFcstInfoService/getMidSeaFcst"); /*URL*/
//        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=서비스키"); /*Service Key*/
//        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
//        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
//        urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("XML", "UTF-8")); /*요청자료형식(XML/JSON)Default: XML*/
//        urlBuilder.append("&" + URLEncoder.encode("regId","UTF-8") + "=" + URLEncoder.encode("12A20000", "UTF-8")); /*12A20000 서해중부, 12B10000 남해서부등.. 하단 참고자료 참조*/
//        urlBuilder.append("&" + URLEncoder.encode("tmFc","UTF-8") + "=" + URLEncoder.encode("201404080600", "UTF-8")); /*-일 2회(06:00,18:00)회 생성 되며 발표시각을 입력- YYYYMMDD0600(1800) 최근 24시간 자료만 제공*/
//        URL url = new URL(urlBuilder.toString());
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        conn.setRequestMethod("GET");
//        conn.setRequestProperty("Content-type", "application/json");
//        System.out.println("Response code: " + conn.getResponseCode());
//        BufferedReader rd;
//        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
//            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//        } else {
//            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
//        }
//        StringBuilder sb = new StringBuilder();
//        String line;
//        while ((line = rd.readLine()) != null) {
//            sb.append(line);
//        }
//        rd.close();
//        conn.disconnect();
//        System.out.println(sb.toString());
//    }
//}
//    public class TestServiceImpl {
//        @Service("FifaonService")
//        implements FifaonService {
//        private static final String AUTHORIZATION = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhY2NvdW50X2lkIjoiMTMyNjIwNzg1OCIsImF1dGhfaWQiOiIyIiwidG9rZW5fdHlwZSI6IkFjY2Vzc1Rva2VuIiwic2VydmljZV9pZCI6IjQzMDAxMTQ4MSIsIlgtQXBwLVJhdGUtTGltaXQiOiI1MDA6MTAiLCJuYmYiOjE2MDg5NzU0MTgsImV4cCI6MTYyNDUyNzQxOCwiaWF0IjoxNjA4OTc1NDE4fQ.xBWhSNzSc_nkrXTJdTYSmsk8enfADOvoppRhfaCtYQw";
//        private RestTemplate restTemplate;
//        private JsonParser jParser;
//        
//        @Autowired
//        public void FifaonService(RestTemplate restTemplate) {
//            this.restTemplate = restTemplate;
//        }
//        
//        @Override
//        public Users SearchUserByNickname(String nickname) {
//            String base_url = "https://api.nexon.co.kr/fifaonline4/v1.0/users?";
//            
//            URI uriBuilder = UriComponentsBuilder.fromHttpUrl(base_url)
//                    .queryParam("nickname", nickname)
//                    .build("usersInfo");
//            
//            HttpHeaders httpheaders = new HttpHeaders();
//            httpheaders.add("Authorization", AUTHORIZATION);
//            httpheaders.add("Content-Type","application/json; charset=UTF-8");
//            
////            RequestEntity<Void> requestEntity = RequestEntity.get(uriBuilder).headers(httpheaders).build();
////            ResponseEntity<Users> response = restTemplate.exchange(uriBuilder, HttpMethod.GET, requestEntity, Users.class);
////            
////            Users users = response.getBody();
//            
//            return users;
//        }
//    
//        *///
//}
