package imo;

import scala.util.parsing.combinator.testing.Str;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class writeToDataCSV {
    
    public static void main(String[] args){
        try {
            PrintStream out = new PrintStream(new FileOutputStream("/home/erdem/IdeaProjects/FlinkBulkMongo/src/main/resources/data2.csv",true));
            for (int i=0; i<100000; i++) {
                out.println("1,Apple,Keyboard,2019/11/21,5,31.15,\"Discount:Urgent\"\n" +
                        "2,LinkedIn,Headset,2019/11/25,5,36.9,\"Urgent:Pickup\"\n" +
                        "3,Facebook,Keyboard,2019/11/24,5,49.89,\"\"\n" +
                        "4,Google,Webcam,2019/11/07,4,34.21,Discount\n" +
                        "5,LinkedIn,Webcam,2019/11/21,3,48.69,Pickup\n" +
                        "6,Google,Mouse,2019/11/23,5,40.58,\"\"\n" +
                        "7,LinkedIn,Webcam,2019/11/20,4,37.19,\"\"\n" +
                        "8,Google,Mouse,2019/11/13,1,46.79,\"Urgent:Discount:Pickup\"\n" +
                        "9,Google,Webcam,2019/11/10,4,27.48,\"Discount:Urgent\"\n" +
                        "10,LinkedIn,Headset,2019/11/09,2,26.91,\"Urgent:Discount:Pickup\"\n" +
                        "11,Facebook,Headset,2019/11/26,5,45.84,\"Urgent:Pickup\"\n" +
                        "12,Google,Headset,2019/11/05,2,41.17,\"Discount:Urgent\"\n" +
                        "13,Facebook,Keyboard,2019/11/10,3,31.32,\"Urgent:Pickup\"\n" +
                        "14,Apple,Mouse,2019/11/09,4,40.27,Discount\n" +
                        "15,Apple,Mouse,2019/11/25,5,38.89,\"\"\n" +
                        "16,Facebook,Keyboard,2019/11/09,1,26.37,\"Urgent:Pickup\"\n" +
                        "17,Apple,Headset,2019/11/09,4,29.98,\"Discount:Urgent\"\n" +
                        "18,LinkedIn,Webcam,2019/11/06,3,40.59,Discount\n" +
                        "19,LinkedIn,Webcam,2019/11/06,2,43.92,Pickup\n" +
                        "20,LinkedIn,Mouse,2019/11/25,4,36.77,\"Urgent:Pickup\"\n" +
                        "21,Google,Headset,2019/11/26,3,46.61,Discount\n" +
                        "22,Facebook,Keyboard,2019/11/19,5,37.72,Discount\n" +
                        "23,Facebook,Webcam,2019/11/13,2,28.71,Urgent\n" +
                        "24,Facebook,Headset,2019/11/01,1,36.0,\"Discount:Urgent\"\n" +
                        "25,Apple,Webcam,2019/11/03,3,44.95,\"Urgent:Discount:Pickup\"\n" +
                        "26,LinkedIn,Mouse,2019/11/21,4,31.82,\"Discount:Pickup\"\n" +
                        "27,LinkedIn,Mouse,2019/11/01,5,26.25,\"Discount:Pickup\"\n" +
                        "28,LinkedIn,Webcam,2019/11/05,1,38.04,Discount\n" +
                        "29,LinkedIn,Mouse,2019/11/23,1,42.16,\"Urgent:Pickup\"\n" +
                        "30,Facebook,Webcam,2019/11/16,3,31.38,\"Urgent:Pickup\"\n" +
                        "31,Google,Keyboard,2019/11/06,4,29.04,\"\"\n" +
                        "32,Apple,Mouse,2019/11/11,1,46.43,Urgent\n" +
                        "33,Apple,Headset,2019/11/17,5,49.99,\"Urgent:Discount:Pickup\"\n" +
                        "34,Facebook,Webcam,2019/11/05,5,42.49,\"Urgent:Discount:Pickup\"\n" +
                        "35,Google,Mouse,2019/11/17,2,49.33,Pickup\n" +
                        "36,LinkedIn,Keyboard,2019/11/22,2,47.45,\"Discount:Urgent\"\n" +
                        "37,LinkedIn,Mouse,2019/11/11,4,48.35,\"Discount:Urgent\"\n" +
                        "38,Facebook,Keyboard,2019/11/13,5,30.74,\"Discount:Urgent\"\n" +
                        "39,Facebook,Keyboard,2019/11/16,5,49.04,Discount\n" +
                        "40,Google,Keyboard,2019/11/01,5,44.11,\"Urgent:Pickup\"\n" +
                        "41,LinkedIn,Mouse,2019/11/09,1,28.94,\"Discount:Pickup\"\n" +
                        "42,LinkedIn,Webcam,2019/11/24,3,31.85,\"Discount:Pickup\"\n" +
                        "43,Apple,Mouse,2019/11/25,2,38.88,Discount\n" +
                        "44,LinkedIn,Webcam,2019/11/08,3,42.47,Pickup\n" +
                        "45,Apple,Webcam,2019/11/01,2,44.95,Pickup\n" +
                        "46,Google,Keyboard,2019/11/01,2,49.51,Pickup\n" +
                        "47,Google,Headset,2019/11/18,4,46.7,\"Discount:Urgent\"\n" +
                        "48,Facebook,Mouse,2019/11/12,2,48.81,Discount\n" +
                        "49,Apple,Headset,2019/11/09,3,30.63,\"Discount:Pickup\"\n" +
                        "50,Facebook,Mouse,2019/11/02,5,33.13,Urgent\n" +
                        "51,Google,Mouse,2019/11/27,4,32.8,Urgent\n" +
                        "52,Google,Keyboard,2019/11/26,2,41.01,\"\"\n" +
                        "53,LinkedIn,Headset,2019/11/21,4,32.81,\"Discount:Pickup\"\n" +
                        "54,LinkedIn,Headset,2019/11/16,4,49.46,\"Urgent:Pickup\"\n" +
                        "55,Google,Webcam,2019/11/25,3,33.87,\"Urgent:Discount:Pickup\"\n" +
                        "56,LinkedIn,Headset,2019/11/10,2,39.69,\"Urgent:Discount:Pickup\"\n" +
                        "57,Google,Mouse,2019/11/21,5,32.0,Pickup\n" +
                        "58,Apple,Keyboard,2019/11/24,4,38.1,\"Urgent:Pickup\"\n" +
                        "59,Apple,Webcam,2019/11/02,3,45.0,\"Discount:Pickup\"\n" +
                        "60,LinkedIn,Headset,2019/11/08,4,42.51,\"\"\n" +
                        "61,Apple,Webcam,2019/11/24,3,42.66,\"\"\n" +
                        "62,Google,Keyboard,2019/11/18,1,46.95,Discount\n" +
                        "63,LinkedIn,Mouse,2019/11/25,5,40.74,\"Urgent:Pickup\"\n" +
                        "64,Apple,Keyboard,2019/11/04,4,44.23,\"Discount:Urgent\"\n" +
                        "65,Facebook,Keyboard,2019/11/07,3,49.55,\"Discount:Pickup\"\n" +
                        "66,LinkedIn,Headset,2019/11/14,5,25.78,\"Discount:Urgent\"\n" +
                        "67,Facebook,Mouse,2019/11/26,3,27.36,\"Urgent:Discount:Pickup\"\n" +
                        "68,LinkedIn,Webcam,2019/11/17,1,48.54,\"Urgent:Pickup\"\n" +
                        "69,Google,Keyboard,2019/11/28,2,31.5,Urgent\n" +
                        "70,Google,Headset,2019/11/01,3,49.14,\"Discount:Pickup\"\n" +
                        "71,Google,Mouse,2019/11/29,2,25.35,\"Urgent:Pickup\"\n" +
                        "72,Apple,Mouse,2019/11/13,1,48.8,\"Urgent:Discount:Pickup\"\n" +
                        "73,Facebook,Headset,2019/11/24,3,49.67,Urgent\n" +
                        "74,Facebook,Mouse,2019/11/12,4,35.35,\"Urgent:Discount:Pickup\"\n" +
                        "75,Google,Mouse,2019/11/04,1,28.35,\"\"\n" +
                        "76,LinkedIn,Mouse,2019/11/26,5,28.0,Urgent\n" +
                        "77,Apple,Headset,2019/11/17,4,42.89,\"Urgent:Pickup\"\n" +
                        "78,Apple,Keyboard,2019/11/02,1,38.41,\"Urgent:Discount:Pickup\"\n" +
                        "79,Facebook,Mouse,2019/11/08,3,47.06,\"Discount:Pickup\"\n" +
                        "80,Facebook,Mouse,2019/11/05,5,37.22,\"Urgent:Pickup\"\n" +
                        "81,LinkedIn,Keyboard,2019/11/13,5,32.93,\"\"\n" +
                        "82,Apple,Webcam,2019/11/02,4,27.36,Pickup\n" +
                        "83,Facebook,Keyboard,2019/11/21,1,44.05,Pickup\n" +
                        "84,Facebook,Headset,2019/11/21,4,46.74,\"Urgent:Discount:Pickup\"\n" +
                        "85,Google,Webcam,2019/11/04,2,36.25,\"Discount:Pickup\"\n" +
                        "86,LinkedIn,Webcam,2019/11/27,5,40.45,Discount\n" +
                        "87,Google,Mouse,2019/11/27,4,40.95,\"Discount:Pickup\"\n" +
                        "88,Apple,Webcam,2019/11/22,5,47.84,Urgent\n" +
                        "89,Google,Headset,2019/11/17,3,29.93,\"Urgent:Discount:Pickup\"\n" +
                        "90,LinkedIn,Headset,2019/11/21,2,44.28,\"\"\n" +
                        "91,Google,Keyboard,2019/11/28,3,25.09,\"Urgent:Pickup\"\n" +
                        "92,Facebook,Headset,2019/11/11,5,31.09,\"\"\n" +
                        "93,Apple,Headset,2019/11/08,4,32.17,\"\"\n" +
                        "94,LinkedIn,Webcam,2019/11/21,4,47.5,\"Discount:Pickup\"\n" +
                        "95,Google,Mouse,2019/11/13,1,48.62,Urgent\n" +
                        "96,Facebook,Mouse,2019/11/09,2,43.94,\"Discount:Pickup\"\n" +
                        "97,Apple,Webcam,2019/11/01,2,47.78,Discount\n" +
                        "98,Google,Mouse,2019/11/22,5,42.07,Urgent\n" +
                        "99,Apple,Webcam,2019/11/13,5,48.84,\"Discount:Pickup\"\n" +
                        "100,Google,Webcam,2019/11/10,5,39.34,\"Urgent:Pickup\"");
            }
            out.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
