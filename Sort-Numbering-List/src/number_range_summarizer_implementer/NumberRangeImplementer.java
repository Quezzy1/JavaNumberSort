package number_range_summarizer_implementer;

import number_range_summarizer.NumberRangeSummarizer;
import java.util.*;
//import java.util.function.BiConsumer;
//import java.util.function.BinaryOperator;
//import java.util.function.Function;
//import java.util.function.Supplier;
//import java.util.stream.Collector.Characteristics;
import java.util.stream.Collectors;
//import org.springframework.stereotype.Component;

/**
 * 
 */
/**
 * @author Siphokazi.Nene
 *
 */

//@Component
public class NumberRangeImplementer implements NumberRangeSummarizer {

    private int indexIncrement = 0;
    private boolean isSequential;
    private int currentNumber = 0;
    private int nextNumber = 0;

    @Override
    public final Collection<Integer> collect(String input) {
        return Arrays.stream(input.split("[,]"))
                .filter(val -> val.matches("-?[0-9]*$"))
//        		.filter(number -> Integer.parseInt(number instanceof Integer)
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public final String summarizeCollection(Collection<Integer> input) {

        ArrayList<Integer> list = new ArrayList<>(input);
        String str = list.get(0).toString();
        if(hasBreaks(list) == false) {
        	return list.get(0).toString() + "-" + list.get(list.size()-1).toString();
        }
        
        return summarize(list, indexIncrement, str);
    }
    private String summarize(ArrayList<Integer> list, int i, String str){
        currentNumber = (list.get(i) + 1);
        nextNumber = list.get(i + 1);
        if(currentNumber == nextNumber){
            i++;
            isSequential = true;
        }
        else if(isSequential) {
            str += "-" + list.get(i);
            i++;
            str += ("," + list.get(i));
            isSequential = false;
        }
        else {
            isSequential = false;
            i++;
            str += "," + list.get(i);
        }
        return (i <= list.size() - 2 ? summarize(list, i, str) : str) ;
    }
    public boolean hasBreaks(ArrayList<Integer> list) {
    	for(int i=0;i<list.size()-1;i++) {
    		currentNumber = (list.get(i) + 1);
            nextNumber = list.get(i + 1);
    		if(currentNumber == nextNumber) {
    			if(nextNumber == list.get(list.size() - 1)) {
    				return false;
    			}else {
    				continue;
    			}
    		}
    	}
    	return true;
    	
    }
    
}