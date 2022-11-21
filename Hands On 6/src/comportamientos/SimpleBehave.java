package comportamientos;
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import java.util.*;

public class SimpleBehave extends SimpleBehaviour{
    
    public SimpleBehave(Agent a)
    {
        myAgent = a;
    }
    
    public void action()
    {
        
        //-----------------DATASET {x , y}
        
        double[][] dataSet = {  {23, 651},
                                {26, 762},
                                {30, 856},
                                {34, 1063},
                                {43, 1190},
                                {48, 1298},
                                {52, 1421},
                                {57, 1440},
                                {58, 1518}
                             };
        
        LR_Gradient_Descendent(dataSet);
    }

    public void LR_Gradient_Descendent(double[][] dataSet){
        double y_hat        = 0.0;
        double error        = 0.0;
        float n             = dataSet.length;
        double sumX         = 0.0;
        double sumY         = 0.0;
        
        double[] w_b  = {0,0};
        double learningRate = 0.00001; 
        double iterations   = 100; 

        //sumatoria de x, y
        for (int i = 0 ; i < n; i++) {
            sumX += dataSet[i][0];
            sumY += dataSet[i][1];
        }         
        
        for (int i = 0 ; i < iterations; i++) {
            w_b = descend(dataSet, learningRate, w_b);
            y_hat = w_b[0]*sumX + w_b[1];
            error = Math.pow((sumY-y_hat),2) / n;
            System.out.println("(" + i + ")"+"error= " + error + "  -  w=" + w_b[0] + "  -  b=" + w_b[1]);
        }
        
    }
    
    public double[] descend(double[][] dataSet, double learningRate, double[] wb){  
        double w            = wb[0];    
        double b            = wb[1];       
        float n             = dataSet.length;
        double d_w          = 0.0;
        double d_b          = 0.0;
        double x            = 0.0;
        double y            = 0.0;      
      
        //lossFunction = y - (m*x + c)**2
        for (int i = 0 ; i < n; i++) {
            x = dataSet[i][0];
            y = dataSet[i][1];
            
            //derivadas parciales
            d_w = -2 * x * (y - (w*x+b));
            d_b = -2 * (y - (w*x+b));
            
            //actualiza los parametros
            w = w - learningRate*(1/n)*d_w;
            b = b - learningRate*(1/n)*d_b;
        }   
        
        double[] w__b = {w,b};       
        
        return w__b;
    }
    
    public boolean done()
    {
        return true;
    }
    
}
