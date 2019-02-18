package com;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class testApp {
    public static void main(String[] args) throws IOException, JSONException {

        File file = new File("/Users/tharindu/IdeaProjects/SampleProjectForAll/java-json-path/src/main/resources/418.json");
        String string = FileUtils.readFileToString(file);
//        System.out.println(string);
        JSONObject ediJSON = new JSONObject(string);
        Configuration conf = Configuration.builder() .build();
        Object value=null;
        try {
            value = JsonPath.using(conf).parse(ediJSON.toString()).read("$.X12.TS_418.BAX-BeginningSegmentForAdvanceConsistAndTransportationAutomaticEquipmentId..BAX01-StandardPointLocationCode");
            System.out.println(value);
        }catch (Exception ex){

        }


        if(value instanceof net.minidev.json.JSONArray) {
            net.minidev.json.JSONArray  array= (net.minidev.json.JSONArray) value;
             for (int i=0;i<array.size();i++){
                 java.util.LinkedHashMap  map= (LinkedHashMap) ((LinkedHashMap) array.get(i)).get("W3-ConsigneeInformation");

                 System.out.println(map!=null? map.get("W303-AbbreviatedCustomerName") :null);

            }
        }
        else if(value instanceof java.util.LinkedHashMap) {
            java.util.LinkedHashMap  map= (LinkedHashMap) ((LinkedHashMap) value).get("W3-ConsigneeInformation");
            System.out.println(map!=null? map.get("W303-AbbreviatedCustomerName") :null);
        }




//        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        String json = "{ \"color\"  :  { \"a\": { \"bb\":\"bb\"} }  ,  \"type\"  :  \"BMW\"   }";
//
//        Javamapper javamapper = objectMapper.readValue(json, Javamapper.class);
//        String dtoAsString = objectMapper.writeValueAsString(javamapper);
//        System.out.println(javamapper);
//        System.out.println(dtoAsString);


        // meth2(path_var,jsonObj);
    }
      static void meth2(String path[],JSONObject jsonObj) throws JSONException {
          System.out.println(jsonObj.toString());
         Configuration conf2 = Configuration.defaultConfiguration().addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL);
        for (String aPath : path) {
            List<Map<String, Object>> jsonArray = JsonPath.using(conf2).parse( jsonObj.toString()).read(aPath);
            getAndValidateRoadMark(jsonArray);
            for (Object name : jsonArray) {
                //getAndValidateRoadMark(name);
            }
        }
        }
      static void getAndValidateRoadMark(Object str){
            System.out.println(str);
        }
    }

