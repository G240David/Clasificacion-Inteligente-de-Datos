package Agents;
import jade.core.Agent;
import Behaviours.SimpleBehave;

public class MultipleLinearRegression extends Agent{
    public void setup()
    {
       addBehaviour(new SimpleBehave(this));
    }   
}





