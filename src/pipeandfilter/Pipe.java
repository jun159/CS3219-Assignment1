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
	

	/*
	private Queue<ArrayList<String>> buffer = new LinkedList<ArrayList<String>>();
	private boolean isOpenForWriting = true;
	private boolean hasReadLastObject = false;
	
	
	
	public synchronized boolean put(ArrayList<String> obj) {
	    if (!isOpenForWriting) {
         throw new RuntimeException(new IOException("pipe is closed; cannot write to it"));
         
	       } else if (obj == null) {
	           throw new IllegalArgumentException("cannot put null in pipe; null is reserved for pipe-empty sentinel value");
	       }

	    boolean wasAdded = buffer.add(obj);
	    notify();
	    //System.out.println("added to pipe: " + (obj==null?"<null>":obj.toString()));
	    return wasAdded;
	}

	    
	 
	 public synchronized ArrayList<String> nextOrNullIfEmptied() throws InterruptedException {
		 if (hasReadLastObject) {
			 throw new NoSuchElementException("pipe is closed and empty; will never contain any further values");
	     }
	       
	     while (buffer.isEmpty()) {
	         wait(); // pipe empty - wait
	     }

	     ArrayList<String> obj = buffer.remove();
	     if (obj == null) { // will be null if it's the last element
	          hasReadLastObject = true;
	      }
     return obj;
     }

	  
	  public synchronized void closeForWriting() {
		  isOpenForWriting = false;
	      buffer.add(null);
	      notify();
	   }
	  */


