package MaxSelectorModel;
//
// MaxSelectorModel 
//
//////////////////////////////////////////////////////////////////////
/**
 *MaxSelector - A class representing the Didday Model or Maximum Selector Model.
 *The neuron (element) with the greatest strength will propogate to the output
 *of the model blocking out the signal by other neurons.
 *@see            MaxSelector.nslm
 *@version        3.0.k 99/4/30
 *@author         HBP
 *#var private w1 weight constant used in u membrane potential calculation. <p>
 *#var private w2 weight constant used in u membrane potential calculation.<p>
 *#var private h1 is a constant that must be 0 <= h1, and is use d in u membrane potential calculation.<p>
 * #var private h2 is a constant that must be 0<=h2<1 , and is use d in v membrane potential calculation.<p>
 * #var  private k is a threshold constant used in the step function when calculating u firing rate.<p>
 * #var private s1 is the source array of type NslDouble1  <p>
 * #var private u_pot holds the membrane potentials for the first layer of type NslDouble1  <p>
 * #var private u holds the firing rates for the first layer of type NslDouble1  <p>
 * #var private v_pot holds the membrane potentials for the second layer of type NslDouble0 <p>
 * #var private v holds the firing rates for the second layer of type NslDouble0 <p>
*/

/* MaxSelectorModel is the name of the model */
/* MaxSelectorModel does not contain any outside ports, but does inherit NslModule */

 import nslj.main.*;
 import nslj.src.system.*; 
 import nslj.src.cmd.*; 
 import nslj.src.lang.*; 
 import nslj.src.math.*; 
 import nslj.src.display.*; 
import xmlUtility.xmlParser;


public class MaxSelectorModel/*()*/  extends NslModel/*()*/ {
 
	static private final  int size = 10;

	private MaxSelectorStimulus stimulus ; /*(size)*/
	private MaxSelector maxselector ; /*(size)*/  //change later
	private MaxSelectorOutput output ; /*(size)*/  

	public  void initSys() {
		//system.setRunEndTime(10.0);
		//system.nslSetRunDelta(0.01);
                
                xmlParser parseSys = new xmlParser();
                parseSys.setSystemVar();
                
	}
	public  void makeConn() {
                nslConnect(stimulus.s_out, maxselector.in);
		nslConnect(stimulus.s_out, output.s_out);
		nslConnect(maxselector.out, output.uf); 

	}

	/* nslInitTempModule inserted by NPP */
public void nslInitTempModule() {
	/* Instantiation statements generated by NslPreProcessor */
	/* temporary variables */
	/* end of automatic instantiation statements */
	/* Intialisation statements generated by NslPreProcessor */
	/* temporary variables */
	/* end of automatic intialisation statements */
}

	/* nslInitTempRun inserted by NPP */
public void nslInitTempRun() {
	/* Intialisation statements generated by NslPreProcessor */
	/* temporary variables */
	/* end of automatic intialisation statements */
}

	/* nslInitTempTrain inserted by NPP */
public void nslInitTempTrain() {
	/* Initialisation statements generated by NslPreProcessor */
	/* temporary variables */
	/* end of automatic intialisation statements */
}

	/* Declaration statements generated by NslPreProcessor */
	/* makeinst() declared variables */
	/* temporary variables */
	/* constructor and related methods */
	/* EMPTY CONSTRUCTOR Called only for the top level module */
	 public MaxSelectorModel() {
		super("maxSelectorModel",(NslModel)null);
		if (NslMain.TopLoaded) { System.err.println(
		 "ERROR construction without (name,parent)");
		 System.exit(1);} 
		 NslMain.TopLoaded=true; 
		initSys();
		makeInst("maxSelectorModel",null);
	}
	/* nsl declarations */

	 /*GENERIC CONSTRUCTOR:   */
	 public MaxSelectorModel(String nslName, NslModule nslParent) {
		super(nslName, nslParent);
		initSys();
		makeInst(nslName, nslParent);
	}
	public void makeInst(String nslName, NslModule nslParent){ 
	 stimulus=new MaxSelectorStimulus ("stimulus",this,size); //NSLDECLS 
	 maxselector=new MaxSelector ("maxselector",this,size); //NSLDECLS 
	 output=new MaxSelectorOutput ("output",this,size); //NSLDECLS 
	}
	/* end of automatic declaration statements */
}
