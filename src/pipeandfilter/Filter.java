// @author Varunica

package pipeandfilter;

import java.util.ArrayList;

public abstract class Filter implements Runnable {

	protected ArrayList<ArrayList<String>> allLists = new ArrayList<ArrayList<String>>();
	protected Pipe pipeUsed = new Pipe();
	
	@Override
	public void run() { 
		
	}
	
	public void addList (ArrayList<String> list){
		allLists.add(list);
	}
	
	public void setPipe (Pipe pipe){
		pipeUsed = pipe;
	}
	
}