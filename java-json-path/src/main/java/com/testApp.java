package com;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class testApp {
    public static void main(String[] args) throws IOException, JSONException {
         String path_var[] =new String [] {
//            "$.X12.TS_418.LOOP_ID_W1..LOOP_ID_W1_W2[*]LOOP_ID_W1_W2_LH1.PER-AdministrativeCommunicationsContact"
            "$.X12.TS_418..LOOP_ID_W1..LOOP_ID_W1_W2[*].PER-AdministrativeCommunicationsContact"

        };
        File file = new File("/Users/tharindu/IdeaProjects/SampleProjectForAll/417_temp_raw");
        String string = FileUtils.readFileToString(file);
        JSONObject jsonObj = new JSONObject(string);
        meth2(path_var,jsonObj);
    }
      static void meth2(String path[],JSONObject jsonObj) throws JSONException {
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

