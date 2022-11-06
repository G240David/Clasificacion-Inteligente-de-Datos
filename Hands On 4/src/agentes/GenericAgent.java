
package agentes;
import jade.core.Agent;
import comportamientos.SimpleBehave;


public class GenericAgent extends Agent{

    public void setup()
    {
       addBehaviour(new SimpleBehave(this));
    }
    
}
