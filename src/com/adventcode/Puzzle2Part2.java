package com.adventcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;

public class Puzzle2Part2 {


    public static final int MIN_NUMBER_OF_DIGITS_THAT_CAN_REPEAT = 2;

    public static void main(String[] args) {
        List<String> productCodeRanges = Arrays.stream(PRODUCT_CODE_LIST.split(",")).toList();
        Long sumOfAllInvalidCodes = 0l;
        //        productCodeRanges.forEach(System.out::println);
        for (String productCodeRange : productCodeRanges) {
            String[] productCodeRangeSplit = productCodeRange.split("-");
            long endExclusive = Long.parseLong(productCodeRangeSplit[1]);
            long startInclusive = Long.parseLong(productCodeRangeSplit[0]);
            sumOfAllInvalidCodes += LongStream.rangeClosed(startInclusive, endExclusive)
                                                 .mapToObj(String::valueOf)
                    .filter(productCode -> {


//
                        boolean even = productCode.length() % 2 == 0;
                        if(even){

                            String productCodeFirstHalf = productCode.substring(0, productCode.length() / 2);
                            String productCodeSecondHalf = productCode.substring(productCode.length() / 2);


                            if(productCodeFirstHalf.equals(productCodeSecondHalf)){
                                System.out.println(productCode + "  Match  ");
                                return true;
                            }


                            for(int i = 2; i <  productCode.length(); i++) {
                                String productCodeAux = productCode.substring(0, i);
                                int length = productCode.replace(productCodeAux, "").length();

                                if(length == 0){
                                    System.out.println(productCode + "  -  " + productCodeAux + "  -  " + length + "  -  " + productCode.replace(productCodeAux, ""));
                                    return true;
                                }
                                return false;
                            }
                            return false;

                        }else{
//                            System.out.println("I dont know");
                            for(int i = 1; i <  productCode.length(); i++) {
                                String productCodeAux = productCode.substring(0, i);
                                int length = productCode.replace(productCodeAux, "").length();

                                if(length == 0){
                                System.out.println(productCode + "  -  " + productCodeAux + "  -  " + length + "  -  " + productCode.replace(productCodeAux, ""));
                                    return true;
                                }
                                continue;
                            }
                        }
//
//
                        return false;
                    })
                                                 .mapToLong(Long::valueOf)
                                                 .sum();




        }
        System.out.println(sumOfAllInvalidCodes);
    }


    private static final String PRODUCT_CODE_LIST =
//            "989989-989990";
//            "11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124";
            "492410748-492568208,246-390,49-90,16-33,142410-276301,54304-107961,12792-24543,3434259704-3434457648,848156-886303,152-223,1303-1870,8400386-8519049,89742532-89811632,535853-567216,6608885-6724046,1985013826-1985207678,585591-731454,1-13,12067202-12233567,6533-10235,6259999-6321337,908315-972306,831-1296,406-824,769293-785465,3862-5652,26439-45395,95-136,747698990-747770821,984992-1022864,34-47,360832-469125,277865-333851,2281-3344,2841977-2953689,29330524-29523460";
}