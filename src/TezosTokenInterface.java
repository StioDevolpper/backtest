
public interface TezosTokenInterface {

		public	void transfer(String mounts,String from, String too);	
		public	void mint(String address, String amounts) ;	
		public  void burn(String too , String amounts);	
		public  void approve(String from,String too, String mounts);
		public	void setPause(String setValue);	}
	
}
