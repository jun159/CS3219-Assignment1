// @author Varunica

package pipeandfilter;

import java.util.ArrayList;


public class Pipeline implements Runnable {
	
	ArrayList<Filter> filters = new ArrayList<Filter>();
	Pipe thisPipe = new Pipe();
	Filter filter;
	
	public Pipeline() {
		
	}


	public void addFilter(Filter filter) {
		filters.add(filter);
	}
	
	public void setPipeline() {
		int size = filters.size();
		for(int i=0; i<size; i++){
			filters.get(i).setPipe(thisPipe);
		}
		
	}
	
	@Override
	public void run() {
		int size = filters.size();
		for(int i=0; i<size; i++){
			filters.get(i).run();
		}
	}
}