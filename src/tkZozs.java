import milfont.com.tezosj.model.TezosWallet;


public class tkZozs implements TezosTokenInterface{

	public TezosWallet getTezosWallet() throws Exception {

		TezosWallet 	twalletUser = new TezosWallet(
				"edskS7s8JDAh74muB3rkPkWZKvxYz9VeQSB1QLgMNw1HpYNk9g1cbDuMWcwpm1JzXfhMYbpbeLk4eyHxiFoKqn1k5NqM1AVfAK", 
				"edpktirtvUD2T8MyZYKLfAFNVYrtTtFhUJCAr1uWsKXBHjnHvyT68N", 
				"tz1MwakuLuEmR9X96uT9rfQyc62S3BnZNvi6", 
				"TMmyPVbeo1");	
		return twalletUser;  
	}

	public TezosWallet getAdminTezosWallet() throws Exception {

		TezosWallet   adminWallet = new TezosWallet(
				"edskRzEQvFcQgjHTY7g2UwpdYJsjgPt6immnpchfJkrgi4etkUf1ha2wwrm2MZbEc4iQx1TQzkNdZ3BnKni32VTUgRiAZ6CdQ1", 
				"edpkuGGd43wor9b8Fhmi1AJzMYrikmWzxiVACYn1hJoN3Ep3KH4FoV", 
				"tz1SwVJ35TEp6GoxbK9cyscybSV4Q3mCBCw6", 
				"Di607MIv5Q");
		return adminWallet;  
	}


	public   void  transfer(String amount,String from, String too)
	{     
		try {	 		
			getTezosWallet().setProvider("https://eb7195f3.ngrok.io");

			//Calls the transfer function  .
			System.out.println(" transfer transaction please wait a minute ...! ");	       		 
			JSONObject jsonObject = getTezosWallet().callContractEntryPoint(getTezosWallet().getPublicKeyHash(), "KT1B6Cy7PfxzydZ4k373sdNJprkka6QiGe3J",new BigDecimal(0), new BigDecimal(10), "", "", "transfer", new String[]{amount,from ,too}); 

			// Waits for the transaction to be included
			String opHash = (String) jsonObject.get("result");
			Boolean opHashIncluded = getTezosWallet().waitForResult(opHash, 3);
			System.out.println(opHashIncluded + " " + opHash);   

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}


	public void mint(String address, String amounts) 
	{
		try {

			getAdminTezosWallet().setProvider("https://eb7195f3.ngrok.io");
			System.out.println("mint transaction please wait a minute;..");
			// Calls the contract  mint transaction .
			JSONObject jsonObject = getAdminTezosWallet().callContractEntryPoint(getAdminTezosWallet().getPublicKeyHash(), "KT1B6Cy7PfxzydZ4k373sdNJprkka6QiGe3J",new BigDecimal(0), new BigDecimal(10), "", "", "mint", new String[]{address,amounts});

			// Waits for the transaction to be included, so that we may call the contract once more.
			String opHash = (String) jsonObject.get("result");
			Boolean opHashIncluded = getAdminTezosWallet().waitForResult(opHash, 3);
			System.out.println(opHashIncluded + " " + opHash);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}


	public void burn(String too , String amounts)
	{     
		try {

			getAdminTezosWallet().setProvider("https://eb7195f3.ngrok.io");

			//Call contract Burn Transactions 
			System.out.println(" Burn transaction  please wait a minute ...");
			JSONObject jsonObjectBurn = getAdminTezosWallet().callContractEntryPoint(getAdminTezosWallet().getPublicKeyHash(), "KT1B6Cy7PfxzydZ4k373sdNJprkka6QiGe3J", new BigDecimal(0), new BigDecimal(10),"", "", "burn", new String[]{too ,amounts});
			// Waits for the transaction to be included, so that we may call the contract once more.
			String opHashBurn = (String) jsonObjectBurn.get("result");
			Boolean opHashIncludedBurn = getAdminTezosWallet().waitForResult(opHashBurn, 3);
			System.out.println(opHashIncludedBurn + " " + opHashBurn);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	   
	}


	public void approve(String from,String too, String amounts)
	{
		try {

			getTezosWallet().setProvider("https://eb7195f3.ngrok.io");
			//Call contract Approve Transactions 
			System.out.println(" Approve transaction  please wait a minute ... ");	       
			JSONObject jsonObjectApprove = getTezosWallet().callContractEntryPoint(getTezosWallet().getPublicKeyHash(), "KT1B6Cy7PfxzydZ4k373sdNJprkka6QiGe3J",new BigDecimal(0), new BigDecimal(10), "", "", "approve", new String[]{amounts,from,too});

			// Waits for the transaction to be included
			String opHashApprove = (String) jsonObjectApprove.get("result");
			Boolean opHashIncludedApprove = getTezosWallet().waitForResult(opHashApprove, 3);
			System.out.println(opHashIncludedApprove + " " + opHashApprove);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void setPause(String setValue)
	{
		try {

			getAdminTezosWallet().setProvider("https://eb7195f3.ngrok.io");
			//Call contract setAdministrator
			System.out.println("setAdministrator ( please wait a minute)...");
			JSONObject jsonObject = getAdminTezosWallet().callContractEntryPoint(getAdminTezosWallet().getPublicKeyHash(), "KT1B6Cy7PfxzydZ4k373sdNJprkka6QiGe3J", new BigDecimal(0), new BigDecimal(10), "", "", "setPause", new String[]{setValue});
			// Waits for the transaction to be included, so that we may call the contract once more.
			String opHash = (String) jsonObject.get("result");
			Boolean opHashIncluded = getAdminTezosWallet().waitForResult(opHash, 3);
			System.out.println(opHashIncluded + " " + opHash);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}





	

}