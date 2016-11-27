package MP3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

/**
 * Created by mmcalvarez on 11/2/2016.
 */
public class Packets {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("packets.txt"));
        String str;
        LinkedList list = new LinkedList();
        String size, from, to, seq, check;
        String f1, f2, f3, f4;
        String t1, t2, t3, t4;
        int sizenum, seqnum, checknum;
        int ipf1, ipf2, ipf3, ipf4;
        int ipto1, ipto2, ipto3, ipto4;
        char[] words = new char[100];
        int j = 0;

        while ((str = br.readLine()) != null){

            size = str.substring(0, 31+1);
            sizenum = Integer.parseInt(size,2);
            from = str.substring(32, 64-1);
            f1 = from.substring(0, 8);
            f2 = from.substring(8, 15+1);
            f3 = from.substring(16, 23+1);
            f4 = from.substring(24, 32-1);

            ipf1 = Integer.parseInt(f1, 2);
            ipf2 = Integer.parseInt(f2, 2);
            ipf3 = Integer.parseInt(f3, 2);
            ipf4 = Integer.parseInt(f4, 2);

            to = str.substring(64, 96-1);
            t1 = to.substring(0, 8);
            t2 = to.substring(8, 15+1);
            t3 = to.substring(16, 23+1);
            t4 = to.substring(24, 32-1);

            ipto1 = Integer.parseInt(t1, 2);
            ipto2 = Integer.parseInt(t2, 2);
            ipto3 = Integer.parseInt(t3, 2);
            ipto4 = Integer.parseInt(t4, 2);

            seq = str.substring(96, 128);
            seqnum = Integer.parseInt(seq,2);

            int k = str.length()-1;
            check = str.substring((k-31), k);
            checknum = Integer.parseInt(check, 2);



            for(int i = 127; i < str.length(); i++){
                if(str.charAt(i) != '1' && str.charAt(i) != '0'){
                    words[j] = str.charAt(i);
                    j++;
                   // System.out.println(str.charAt(i));
                }
            }


            list.add(seqnum);
            list.add(sizenum);
            list.add(ipf1);
            list.add(ipf2);
            list.add(ipf3);
            list.add(ipf4);
            list.add(ipto1);
            list.add(ipto2);
            list.add(ipto3);
            list.add(ipto4);
            list.add(words);
            list.add(checknum);

            j = 0;

            System.out.println(words);

        }

        System.out.println(list);

br.close();
    }
}
