package com.david.converter.core;

import java.util.HashMap;
import java.util.Map;

/**
 * @author David
 *
 */
public class MappingHandler implements IMapper{
	
	//Single instance here
	private static volatile MappingHandler instance;
	
	public static MappingHandler getInstance() {
		if (instance == null) {
			synchronized(MappingHandler.class) {
				if(instance == null) {
					instance = new MappingHandler();
				}
			}
		}
		return instance;
	}
	
	
	Map<String,String> phoneNumberMap = new HashMap<String, String>();
	
	StringBuilder builder;
	
	private MappingHandler() {
		//Store the phone number mapping
		phoneNumberMap.put("2","abc");
	    phoneNumberMap.put("3","def");
	    phoneNumberMap.put("4","ghi");
	    phoneNumberMap.put("5","jkl");
	    phoneNumberMap.put("6","mno");
	    phoneNumberMap.put("7","pqrs");
	    phoneNumberMap.put("8","tuv");
	    phoneNumberMap.put("9","wxyz");
	}
	

	public String map(String target) {
		 builder = new StringBuilder();
        if(target.length()!=0) {
        	if (target.contains("0") || target.contains("1")) {
        		target = target.replace("0", "");
        		target = target.replace("1", "");
			}
        	recursive("",target);
        }
        return builder.toString();
    }
    
    /**
     * @param previous 
     * @param next 
     */
    public void recursive(String previous,String next){
    	if (next.length() == 0) {
    		builder.append(previous + " ");
		} else {
			//digit to be mapped to the alphabet 
			String key = next.substring(0,1);
            String value = phoneNumberMap.get(key);
            
            //recursively call itself to generate the mapping
            for(int i = 0;i < value.length(); i++){
            	String s = previous + value.substring(i,i+1);
                recursive(s,next.substring(1));
            }
		}     
    }
}
