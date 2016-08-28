// @author Varunica
package pipeandfilter;

import java.util.ArrayList;

public class Pipe {
	
	private Filter filter;
	ArrayList<ArrayList<String>> allLists = new ArrayList<ArrayList<String>>();
	
	public Pipe(){
    	
    }
	
	public void setNextFilter(Filter filter){
		this.filter = filter;
	}
	
	public void addList (ArrayList<String> list){
		allLists.add(list);
	}

	public void run(){
		filter.run();
	}
	
}