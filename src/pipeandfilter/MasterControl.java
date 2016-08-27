// @author Varunica

package pipeandfilter;

public class MasterControl {
	
	//Pipeline pipeline = new Pipeline();
	Connections connection = new Connections();
	
	public void execute() {
		//pipeline.run();
		connection.run();
	}
}