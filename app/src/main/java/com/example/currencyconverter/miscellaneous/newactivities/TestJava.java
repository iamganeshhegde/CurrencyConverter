package com.example.currencyconverter.miscellaneous.newactivities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TestJava {

//    Calendar calendar = Calendar.getInstance();
//    int count = 0;
//for(int i=1901;i<2000;i++){
//        for(int j=1;i<12;j++){
//            calendar.set(Calendar.YEAR, i);
//            calendar.set(Calendar.MONTH,j);
//            calendar.set(Calendar.DATE,1);
//            if(calendar.get(Calendar.DAY_OF_WEEK) == (Calendar.SUNDAY)){
//                count++;
//            }
//        }
//    }


//    public void AAA(){
//        Scanner sc=new Scanner(System.in);
//        int n=sc.nextInt();
//        if (isCircularPrime(n)) System.out.println("Circular Prime");
//        else System.out.println("Not a Circular Prime");
//    }
//    private static booleanisPrime(int n)
//    {
//        for(int i=2;i<=n/2;i++) if(n%i==0) return false;
//        return true;
//    }
//    private static booleanisCircularPrime(int N)
//    {
//        int count = 0, temp = N;
//        while (temp>0)
//        {
//            count++;
//            temp /= 10;
//        }
//        int num = N;
//        while (isPrime(num))
//        {
//            int rem = num % 10;
//            int div = num / 10;
//            num = (int)((Math.pow(10, count - 1)) * rem)+ div;
//            if (num == N) return true;
//        }
//        return false;
//    }


    static int maxTickets(List<Integer> tickets) {

        Integer answer = 1;
        Integer numberOfelemnets = tickets.get(0);
        Integer max =0;

        List<Integer> answerArray = new ArrayList<Integer>();


        answerArray = tickets.subList(1, tickets.size());

        Collections.sort(answerArray);
        Integer current = answerArray.get(0);


        for(int i = 1; i < answerArray.size(); i++) {

            if(answerArray.get(i).equals(current) || answerArray.get(i) ==  current+1) {

                answer = answer+1;

            }else if(answerArray.get(i) > current+1) {
                answer = 1;
            }

            if(max < answer) {
                max = answer;
            }

            current = answerArray.get(i);

        }

        return max;




    }





}
