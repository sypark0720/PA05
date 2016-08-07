package ds.hash;

public class HashTable {
	
	private static final int LINEAR = 0;
	private static final int QUADRATIC = 1;
	
	//hash table
	private Integer[] hashtable; // for using null
	
	//probe function
	private int pf_type;
	private int pf_c1, pf_c2, pf_c3;	
		
	public HashTable(int n) {
		this.hashtable = new Integer[n];
	}

	public void Start(String policy, int constant1, int constant2, int constant3){		
		if(policy.equals("linear")){
			this.pf_type = LINEAR;
		}else if(policy.equals("quadratic")){
			this.pf_type = QUADRATIC;
		}		
		
		this.pf_c1=constant1;
		this.pf_c2=constant2;
		this.pf_c3=constant3;		
	}
	
	public int Insert(int value) {
		int home;
		int pos = home = value%1001; //hash function
		for (int i=1; hashtable[pos]!=null; i++){
			pos = (home+p(value, i))%1001;
		}
		this.hashtable[pos] = value;	
		return value;
	}

	public int find(int value) {
		int home;
		int pos = home = value%1001;
		for (int i=1; (this.hashtable[pos]!=null)&&(this.hashtable[pos] != value); i++){
			pos=(home + p(value, i))%1001;
		}
		
		if(this.hashtable[pos]==null) return -1;
		else return pos;
	}
	
	private int p(int k, int i){
		if(this.pf_type==LINEAR){
			return pf_c1*i;
		}else{
			return pf_c1*i*i+pf_c2*i+pf_c3;
		}
	}
}
