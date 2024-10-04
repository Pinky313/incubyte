package org.example;

import java.util.Arrays;
import java.util.stream.Stream;

public class Basics {
    public int compare(int n1, int n2) {
        if (n1 > n2) return 1;
        return -1;
    }

    public int add(String s) throws NegativeNumberException {
        String t="";
        String[] newStr = new String[]{};
        if (s == null || s.length()==0) {
            return 0;
        } else {
            if (s.startsWith("//")) {
                String newS = s.replace("//", "");
                t = String.valueOf(newS.charAt(0));
                if (newS.toString().contains(("\n"))) {
                    String seplaced = newS.replace("\n", t);
                    seplaced = seplaced.replace(' ','0');
                    newStr = new String[]{seplaced};
                    newStr = seplaced.split(t);
                    return sum(newStr);
                }
            }
            else{
                if (s.contains("\n")) {
                   String temp = s.replace('\n',',');
                    newStr = new String[]{temp};
                newStr = temp.split(",");
                    return sum(newStr);
                } else {
                newStr = s.split(",");
                    return sum(newStr);
            }

            }
           }
        return 0;
    }

     int sum(String[] arr) throws NegativeNumberException{
        int total = 0;
        int elements[] = Stream.of(arr).filter(str -> !str.isEmpty()).mapToInt(Integer::parseInt).toArray();
        int elementInClip[];
         elementInClip = Arrays.stream(elements).filter(s -> s < 0).toArray();
         Arrays.stream(elementInClip).forEach(System.out::println);
         for (int i = 0; i < elements.length; i++) {
             if(elements[i]<0){
                        throw new NegativeNumberException("Negative number is present");
                }
                 total += elements[i];
         }
         return total;
    }


}

