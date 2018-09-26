package myCode;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HttpTest {

    public static void main (String[] args) {
        StringBuilder sb = new StringBuilder();

        Map<String, String> map = getData();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String result = sendHttp(entry.getKey(), entry.getValue());
            String str = result.replace("\n", "").replace("\t", "").replace(" ", "");
            sb.append(entry.getKey()).append(", ").append(entry.getValue()).append(", ").append(str).append("\n");
        }

        writeData(sb.toString());
    }

    private static String sendHttp (String phone, String name) {
        final String url = "http://api.jinhuicard.com/thridpart/huahuaQB/joint_logon";
        String result = "";

        /*try {
            CloseableHttpClient client = null;
            CloseableHttpResponse response = null;

            try {
                List<BasicNameValuePair> parames = new ArrayList<>();
                parames.add(new BasicNameValuePair("channel", "H10071"));
                parames.add(new BasicNameValuePair("phone", phone));
                parames.add(new BasicNameValuePair("name", name));

                HttpPost httpPost = new HttpPost(url);
                httpPost.setEntity(new UrlEncodedFormEntity(parames, "UTF-8"));

                client = HttpClients.createDefault();
                response = client.execute(httpPost);
                HttpEntity entity = response.getEntity();
                result = EntityUtils.toString(entity);
            } finally {
                if (response != null) {
                    response.close();
                }
                if (client != null) {
                    client.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        return result;
    }

    private static Map<String, String> getData () {
        Map<String, String> rs = new HashMap<>();
        final String fileName = "D://nanshou.txt";
        File file = new File(fileName);

        BufferedReader reader = null;
        String[] vals;

        try {
            reader = new BufferedReader(new FileReader(file));

            String tempString;
            while ((tempString = reader.readLine()) != null) {
                vals = tempString.split(",");
                rs.put(vals[0].trim(), vals[1].trim());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return rs;
    }

    private static void writeData (String str) {
        final String fileName = "D://log.txt";
        BufferedWriter bw = null;
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            bw = new BufferedWriter(fw);
            bw.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
