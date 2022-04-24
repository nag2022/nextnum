package numberseries.findnextnumberinseries.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import numberseries.findnextnumberinseries.dao.CustomerDAO;
import numberseries.findnextnumberinseries.entity.Customer;
import numberseries.findnextnumberinseries.entity.nextnumDetails;
import numberseries.findnextnumberinseries.utils.MathCustomfunctions;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private MathCustomfunctions mathCustfunc;

	public static Double computeNextTerm=999.298;
	public static String nameOfSeries =null; 
	public static String formulaName =null; 
	
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
	
		customerDAO.saveCustomer(theCustomer);	
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {

		return customerDAO.getCustomer(theId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		
		customerDAO.deleteCustomer(theId);
	}

	public nextnumDetails nextNumInSeries(int a, int b, int c, int d, int e, int f,int g) throws InterruptedException {

		int []  arr = {a,b,c,d,e,f,g};
		
//		class SharedVar {
//		    private Double nextTerm;
//		    private final Object lock = new Object();
//
//		    public void newMessage(Double x) {
//		        synchronized (lock) {
//		        	nextTerm = x;
//		        }
//		    }
//
//		    public Double getMessage() {
//		        synchronized (lock) {
//		            Double temp = nextTerm;
//		            nextTerm = null;
//		            return temp;
//		        }
//		    }
//		}
		
		/*
		Thread PowerseriesCheckThread = new Thread (new Runnable() {
		
			@Override
			public void run() {
		    int flag = 0;
		    boolean inSeries = true;
			int powerValue;
			int i=(int)Math.pow(arr[0],(float)2),j=2,k=0;
			int leng = arr.length;
			
			System.out.println("PowerSeries started");
			System.out.println("Power Series->Compute next term value="+computeNextTerm);
			System.out.println("Inside Power Series-> Stopthread INITIAL value="+arr[6]);			
			
			while (k< leng) {
				powerValue = (int) Math.pow(i, j);
				if (powerValue == arr[k]) {
					i++;
					k++;
					continue;
				} else if (powerValue > arr[i - 1]) {
					flag = 1;
					inSeries = false;
					break;
				} else {
					j++;
					i = (int)Math.pow(arr[0],(float)j);
					k=0;
					inSeries = true;
				}
			}
			if (flag==0) {
				computeNextTerm = (double) Math.pow(i, j);
				arr[6]=1;
			}	
			System.out.println("At the end inside PowerSeries-> Stopthread value="+arr[6]);			
			System.out.println("At the end inside PowerSeries-> Compute next term value="+computeNextTerm);
		}	
	});   
		*/
		Thread APseriesCheckThread = new Thread(new Runnable() {
			@Override
			public void run() {
		        //SharedVar sv1 = null;
				int firstTerm=arr[0];
				int diff=arr[1]-arr[0];
				int termInd;
				boolean inSeries = true;
				
				System.out.println("Ap started");
				System.out.println("AP->Compute next term value="+computeNextTerm);
				System.out.println("Inside AP -> Stopthread INITIAL value="+arr[6]);			
				for(termInd=2;termInd<=6;termInd++) {
					int termVal=firstTerm+(termInd-1)*diff;
					if (termVal != arr[termInd-1]) {
						System.out.println("Inside AP Before break-> Stopthread value="+arr[6]);
						inSeries = false;
						break;
					}		
				}

				if (inSeries) {
					System.out.println("Calcualting ComputeNextTerm");

					computeNextTerm=(double) (firstTerm+(termInd-1)*diff);
					formulaName="(firstTerm+(termInd-1)*diff)";
					nameOfSeries="Arithmatic Progression Series";
				}
				System.out.println("At the end inside AP-> Stopthread value="+arr[6]);			
				System.out.println("At the end inside AP-> Compute next term value="+computeNextTerm);
				}  
		});
		
		Thread GPseriesCheckThread = new Thread(new Runnable() {
			@Override
			public void run() {
				int firstTerm=arr[0];
				int rdiff;
				int termInd;
				boolean inSeries = true;
				
				try {
					rdiff=arr[1]/arr[0];
				} catch (Exception e) {
					rdiff=1;
				   System.out.println(e.getMessage());
				}
				System.out.println("Gp started");
				System.out.println("GP->Compute next term value="+computeNextTerm);
				System.out.println("Inside GP -> Stopthread INITIAL value="+arr[6]);
				for(termInd=2;termInd<=6;termInd++) {
					int termVal=(int) (firstTerm*(Math.pow(rdiff, termInd-1)));
					if (termVal != arr[termInd-1]) {
						System.out.println("Inside GP Before break-> Stopthread value="+arr[6]);
						inSeries = false;
						break;
					}		
				}
				if (inSeries){
					System.out.println("Calcualting ComputeNextTerm");
					computeNextTerm=(Double)(firstTerm*(Math.pow(rdiff, termInd-1)));
					nameOfSeries="Geometric Progression Series";
					formulaName="(firstTerm*(Math.pow(rdiff, termInd-1)))";
					
				}
				System.out.println("At the end inside GP-> Stopthread value="+arr[6]);
				System.out.println("At the end inside GP-> Compute next term value="+computeNextTerm);
		     	}	
		});
		
		Thread FIBseriesCheckThread  = new Thread(new Runnable() {

			@Override
			public void run() {
				int termInd;
				boolean inSeries = true;
				System.out.println("FIB started");
				System.out.println("FIB->Compute next term value="+computeNextTerm);
				System.out.println("Inside FIB -> Stopthread INITIAL value="+arr[6]);
				for(termInd=3;termInd<=6;termInd++) {
					int termVal=arr[termInd-2]+arr[termInd-3];
					if (termVal != arr[termInd-1]) {
						System.out.println("Inside FIB Before break-> Stopthread value="+arr[6]);
						inSeries=false;
						break;
					}		
				}
				if (inSeries){
					System.out.println("Calcualting ComputeNextTerm"); 
					computeNextTerm=(double) (arr[termInd-2]+arr[termInd-3]);
					nameOfSeries="Fibonacci Series";
					formulaName="arr[termInd-2]+arr[termInd-3]";
				}
				System.out.println("At the end inside FIB-> Stopthread value="+arr[6]);
				System.out.println("At the end inside FIB-> Compute next term value="+computeNextTerm);
			}
		});
		
		
		Thread PRIMEseriesCheckThread  = new Thread(new Runnable() {

			@Override
			public void run() {
			int i,max=arr[0];
			boolean inSeries = true;
			System.out.println("PRIME started");
			System.out.println("PRIME->Compute next term value="+computeNextTerm);
			System.out.println("Inside PRIME -> Stopthread INITIAL value="+arr[6]);
			for(i=0;i<arr.length-1;i++) {
				if (checkPrime(arr[i])) {
					if (arr[i]>max)
						max=arr[i];
					continue;
				}
				else {
					inSeries=false;
					break;
				}	
			}
			if (i==arr.length-1 && inSeries) {
				int nextPrime=max+1;  // we have to take the maximum value here
				for (i=nextPrime;;i++) {
					if (checkPrime(i)){
						computeNextTerm=(double) i;
						nameOfSeries="Prime Number Series";
						formulaName="Number divisible by 1 and itself only";
						break;
					}
				}
			}
				System.out.println("At the end inside PRIMESeries-> Stopthread value="+arr[6]);
				System.out.println("At the end inside PRIMESeries-> Compute next term value="+computeNextTerm);
			}
		});

		

		//PowerseriesCheckThread.start();
		APseriesCheckThread.start();
		GPseriesCheckThread.start();
		FIBseriesCheckThread.start();
		PRIMEseriesCheckThread.start();

		//PowerseriesCheckThread.join();
		APseriesCheckThread.join();
		GPseriesCheckThread.join();
		FIBseriesCheckThread.join();
		PRIMEseriesCheckThread.join();
		
		if (computeNextTerm!=999.298) {
			//computeNextTerm=999.298;
			return(new nextnumDetails(computeNextTerm, nameOfSeries, formulaName));
		}		
		return null;

	}

	public boolean checkPrime(int num) {
		
		int bvalToCheck = (int) Math.sqrt(num);
		for(int i=2;i<=bvalToCheck;i++)
            if(num%i==0) 
                return false;
        return true;
	}
}
