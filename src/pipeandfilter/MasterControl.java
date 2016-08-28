// @author Varunica

package pipeandfilter;

public class MasterControl {
	
	Connections connection = new Connections();
	
	public void execute() {
		connection.run();
	}
}