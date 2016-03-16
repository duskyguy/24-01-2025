package com.opensourceteams.modules.common.java.io.file;

import java.io.*;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/16  下午8:31
 * 功能描述:
 */

public class FileBufferedUtil {

    public static String encoded = "UTF-8" ;

    /**
     * BufferedReader 读取流的全部内容,默认字符集为UTF-8
     * @param in
     * @return
     */
    public static  StringBuilder readerStringBuilder(InputStream in){

        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in,encoded)) ;

            String line = "";
            while ((line = reader.readLine()) != null){
                sb.append(line);

            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return sb;
    }


    /**
     * BufferedReader 读取流的全部内容,默认字符集为UTF-8
     * @param in
     * @param buffer
     * @return
     */
    public static  StringBuilder readerStringBuilderNoClose(InputStream in,char[] buffer){

        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in,encoded)) ;

            String line = reader.readLine();
            sb.append(line);

            int len = reader.read(buffer);
            sb.append(buffer,0,len);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb;
    }
}
