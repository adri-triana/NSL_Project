package BackPropModel;

/* Copyright 1999 University of Southern California Brain Lab */
/* email nsl@java.usc.edu */

 import nslj.src.system.*; 
 import nslj.src.cmd.*; 
 import nslj.src.lang.*; 
 import nslj.src.math.*; 
 import nslj.src.display.*; 

 public class BPForward extends NslModule /*(int inSize, int hidSize, int outSize)*/ {

    public NslDinFloat1 p ; /*(inSize)*/

    public NslDinFloat2 wh ; /*(inSize, hidSize)*/
    public NslDinFloat1 hh ; /*(hidSize)*/

    public NslDinFloat2 wo ; /*(hidSize, outSize)*/
    public NslDinFloat1 ho ; /*(outSize)*/

    public NslDoutFloat1 yh ; /*(hidSize)*/
    public NslDoutFloat1 yo ; /*(outSize)*/     

    public  void forward() {
	yh.set(NslSigmoid.eval(
 __nsltmp102=nslj.src.math.NslAdd.eval(__nsltmp102,
 __nsltmp101=nslj.src.math.NslProd.eval(__nsltmp101,p.get(),wh.get()),hh.get()))) /* rule 108 */;
	yo.set(
 __nsltmp104=nslj.src.math.NslAdd.eval(__nsltmp104,
 __nsltmp103=nslj.src.math.NslProd.eval(__nsltmp103,yh.get(),wo.get()),ho.get()));
    }

    public  void simRun() {
        forward();
    }

    public  void simTrain() {
        forward();
    }
	/* nslInitTempModule inserted by NPP */
public void nslInitTempModule() {
	/* Instantiation statements generated by NslPreProcessor */
	/* temporary variables */
	__nsltmp101 = new float[1];
	__nsltmp102 = new float[1];
	__nsltmp103 = new float[1];
	__nsltmp104 = new float[1];
	/* end of automatic instantiation statements */
	/* Intialisation statements generated by NslPreProcessor */
	/* temporary variables */
	for (int i = 0; i < __nsltmp101.length; i++) {
		__nsltmp101[i] = 0;
}
	for (int i = 0; i < __nsltmp102.length; i++) {
		__nsltmp102[i] = 0;
}
	for (int i = 0; i < __nsltmp103.length; i++) {
		__nsltmp103[i] = 0;
}
	for (int i = 0; i < __nsltmp104.length; i++) {
		__nsltmp104[i] = 0;
}
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
	private  float[] __nsltmp101;
	private  float[] __nsltmp102;
	private  float[] __nsltmp103;
	private  float[] __nsltmp104;
	/* constructor and related methods */
	/* nsl declarations */
	int inSize;
	int hidSize;
	int outSize;

	 /*GENERIC CONSTRUCTOR:   */
	 public BPForward(String nslName, NslModule nslParent,int inSize, int hidSize, int outSize) {
		super(nslName, nslParent);
		this.inSize = inSize;
		this.hidSize = hidSize;
		this.outSize = outSize;
		initSys();
		makeInst(nslName, nslParent,inSize, hidSize, outSize);
	}
	public void makeInst(String nslName, NslModule nslParent,int inSize,int hidSize,int outSize){ 
	 p=new NslDinFloat1 ("p",this,inSize); //NSLDECLS 
	 wh=new NslDinFloat2 ("wh",this,inSize,hidSize); //NSLDECLS 
	 hh=new NslDinFloat1 ("hh",this,hidSize); //NSLDECLS 
	 wo=new NslDinFloat2 ("wo",this,hidSize,outSize); //NSLDECLS 
	 ho=new NslDinFloat1 ("ho",this,outSize); //NSLDECLS 
	 yh=new NslDoutFloat1 ("yh",this,hidSize); //NSLDECLS 
	 yo=new NslDoutFloat1 ("yo",this,outSize); //NSLDECLS 
	}
	/* end of automatic declaration statements */
}
