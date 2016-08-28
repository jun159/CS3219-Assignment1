// @author Varunica

package pipeandfilter;

public class Connections {
	
	static Pipeline pipeline = new Pipeline();
	
	public void run(){
		
		pipeline.addFilter(new Input());
		pipeline.addFilter(new CircularShift());
		pipeline.addFilter(new Alphabetizer());
		pipeline.addFilter(new Sink());
		
		pipeline.setPipeline();
	}

}
