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
        double[][] dataSet = {  {471784.1, 192261.83},
                                {443898.53, 191792.06},
                                {407934.54, 191050.39},
                                {383199.62, 182901.99},
                                {366168.42, 166187.94},
                                {362861.36, 156991.12},
                                {127716.82, 156122.51},
                                {323876.68, 155752.6},
                                {311613.29, 152211.77},
                                {304981.62, 149759.96},
                                {229160.95, 146121.95},
                                {249744.55, 144259.4},
                                {249839.44, 141585.52},
                                {252664.93, 134307.35},
                                {256512.92, 132602.65},
                                {261776.23, 129917.04},
                                {264346.06, 126992.93},
                                {282574.31, 125370.37},
                                {294919.57, 124266.9},
                                {0, 122776.86},
                                {298664.47, 118474.03},
                                {299737.29, 111313.02},
                                {303319.26, 110352.25},
                                {304768.73, 108733.99},
                                {140574.81, 108552.04},
                                {137962.62, 107404.34},
                                {134050.07, 105733.54},
                                {353183.81, 105008.31},
                                {118148.2, 103282.38},
                                {107138.38, 101004.64},
                                {91131.24, 99937.59},
                                {88218.23, 97483.56},
                                {46085.25, 97427.84},
                                {214634.81, 96778.92},
                                {210797.67, 96712.8},
                                {205517.64, 96479.51},
                                {201126.82, 90708.19},
                                {197029.42, 89949.14},
                                {185265.1, 81229.06},
                                {174999.3, 81005.76},
                                {172795.67, 78239.91},
                                {164470.71, 77798.83},
                                {148001.11, 71498.49},
                                {35534.17, 69758.98},
                                {28334.72, 65200.33},
                                {1903.93, 64926.08},
                                {297114.46, 49490.75},
                                {0, 42559.73},
                                {0, 35673.41},
                                {45173.06, 14681.4}
                             };
        double[] y = SLR(dataSet);

        for (int i = 0 ; i < y.length; i++) {
            System.out.printf("y: %f\n", y[i]);
        }  

    }

    public double[] SLR(double[][] dataSet){
        //-----------------DATA
        //declaracion de la data
        double promX        = 0.0;    //prom: x
        double promY        = 0.0;    //prom: y
        double sumXCuadrada = 0.0;    //sum: x^2
        double sumYCuadrada = 0.0;    //sum: y^2
        double sumY         = 0.0;
        double sumXY        = 0.0;    //sum: xy
        int n = dataSet.length;

        //generacion de la data
        for (int i = 0 ; i < n; i++) {
            promX += dataSet[i][0]; //prom: x
            promY += dataSet[i][1]; //prom: y 
            sumXCuadrada += (dataSet[i][0] * dataSet[i][0]); //sum: x^2
            sumYCuadrada += (dataSet[i][1] * dataSet[i][1]); //sum: y^2
            sumXY +=  (dataSet[i][0] * dataSet[i][1]); //sum: xy  

        }     
        sumY         = promY;
        promX        = promX/n;
        promY        = promY/n;


        //-----------------REALIZA LOS CALCULOS
        double b0;//b0
        double b1;//b1
        
        //calcula b1 
        b1 =  ( sumXY - (n*promX*promY) ) / ( sumXCuadrada - (n*(promX*promX) ) );
        //calcula b0
        b0 = ( promY - (b1 * promX) );
        
        System.out.printf("b0: %f\n", b0);
        System.out.printf("b1: %f\n", b1);
        
        //calcula y
        double[] yCalculada = new double[n];//y calculada con nuestras b
        
        for (int i = 0 ; i < n; i++) {
            yCalculada[i] = ( b0 + (b1*dataSet[i][0]) );
        }  
        
        //calcula el error
        double error;
        error = Math.sqrt( ( (sumYCuadrada) - (b0*sumY) - (b1*sumXY) ) / ( n / 2 ) );
        System.out.printf("error: %f\n", error);
        //System.out.printf("y con error: %f\n", yCalculada[0] + error);

        return yCalculada;

    }
    
    public boolean done()
    {
        return true;
    }
    
}
