package BackPropModel;
/* Copyright 1999 University of Southern California Brain Lab */
/* email nsl@java.usc.edu */

 import nslj.src.system.*; 
 import nslj.src.cmd.*; 
 import nslj.src.lang.*; 
 import nslj.src.math.*; 
 import nslj.src.display.*; 

 public class BPError extends NslModule /*(int outSize)*/ 
{
    public NslDinFloat1 yo ; /*(outSize)*/      
    public NslDinFloat1 t ; /*(outSize)*/  
    
    public NslDoutFloat1 err ; /*(outSize)*/      

    private NslFloat0 epsilon ; /*()*/      
    public  NslFloat0 tss ; /*()*/
        
    public  void initTrain() {
        tss.set(0.0);
    }

    public  void simTrain() {
        err.set(
 __nsltmp101=nslj.src.math.NslSub.eval(__nsltmp101,yo.get(),t.get()));
        tss.set(
 nslj.src.math.NslAdd.eval(tss.get(),NslSum.eval(
 __nsltmp102=nslj.src.math.NslElemMult.eval(__nsltmp102,err.get(),err.get()))));
    }

    public  void endTrain() {
        if (
 nslj.src.math.NslLes.eval(tss.get(),epsilon.get())) {
            System.out.println("Convergence");
	    /* verbatim NSLJ */
            system.getScheduler().breakCycles();
	    system.continueCmd();
	     /* verbatim off */
        }
    }
	/* nslInitTempModule inserted by NPP */
public void nslInitTempModule() {
	/* Instantiation statements generated by NslPreProcessor */
	/* temporary variables */
	__nsltmp101 = new float[1];
	__nsltmp102 = new float[1];
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
	for (int i = 0; i < __nsltmp101.length; i++) {
		__nsltmp101[i] = 0;
}
	for (int i = 0; i < __nsltmp102.length; i++) {
		__nsltmp102[i] = 0;
}
	/* end of automatic intialisation statements */
}

	/* Declaration statements generated by NslPreProcessor */
	/* makeinst() declared variables */
	/* temporary variables */
	private  float[] __nsltmp101;
	private  float[] __nsltmp102;
	/* constructor and related methods */
	/* nsl declarations */
	int outSize;

	 /*GENERIC CONSTRUCTOR:   */
	 public BPError(String nslName, NslModule nslParent,int outSize) {
		super(nslName, nslParent);
		this.outSize = outSize;
		initSys();
		makeInst(nslName, nslParent,outSize);
	}
	public void makeInst(String nslName, NslModule nslParent,int outSize){ 
	 yo=new NslDinFloat1 ("yo",this,outSize); //NSLDECLS 
	 t=new NslDinFloat1 ("t",this,outSize); //NSLDECLS 
	 err=new NslDoutFloat1 ("err",this,outSize); //NSLDECLS 
	 epsilon=new NslFloat0 ("epsilon",this); //NSLDECLS 
	 tss=new NslFloat0 ("tss",this); //NSLDECLS 
	}
	/* end of automatic declaration statements */
}
