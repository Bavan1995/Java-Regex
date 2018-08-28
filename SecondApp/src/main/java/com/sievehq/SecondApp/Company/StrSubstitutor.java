package com.sievehq.SecondApp.Company;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StrSubstitutor extends Object{
    private static final String str = "Between {{freelancer}} and {{client}} dated {{date}}.";
    private static final Map <String,String> hashmap = new HashMap<>();
    public static void main(String args[]){
        StrSubstitutor substitutor = new StrSubstitutor();
        hashmap.put("freelancer","Arun");
        hashmap.put("client","Sanjay");
        hashmap.put("date","01/11/2018");
        substitutor.replaceValues(str,hashmap);
    }

    public static String replaceValues(final String template,final Map<String, String> values){

        final StringBuffer sb = new StringBuffer();
        final Pattern pattern =
                Pattern.compile("\\{\\{(.*?)\\}\\}",Pattern.DOTALL);
        final Matcher matcher = pattern.matcher(template);
        while(matcher.find()){
            final String key = matcher.group(1);
            final String replacement = values.get(key);
            //System.out.println(replacement);
            if(replacement == null){
                System.out.println(replacement);
                throw new IllegalArgumentException(
                        "Template contains unmapped key: "
                                + key);
            }
            matcher.appendReplacement(sb, replacement);
        }
        matcher.appendTail(sb);
        System.out.println(sb.toString());
        return sb.toString();
    }
}