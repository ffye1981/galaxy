package com.thoughtworks.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: galaxy
 * @description: 文件读写工具类
 * @author: ffye
 * @create: 2019-12-05 09:12
 */
public class FileUtil {
    public static void readInputs(){
        File file = new File("src/main/resources/inputs.txt");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine())!= null){
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 从文件地址获取文件内容
     * @param url
     * @return
     */
    public static List<String> readInputs(String url) {
        List<String> lines = null;
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File(url));
            lines =  readInputs(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return lines;
    }

    /**
     * 从流中获取文本内容
     * @param inputStream
     * @return
     */
    public static List<String> readInputs(InputStream inputStream){
        List<String> lines = new ArrayList<String>();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader br = null;
        try {
            br = new BufferedReader(inputStreamReader);
            String line;
            while ((line = br.readLine())!= null){
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return lines;
    }
}
