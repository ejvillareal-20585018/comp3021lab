package lab9;

/**
 * 
 * COMP 3021
 * 
This is a class that prints the maximum value of a given array of 90 elements

This is a single threaded version.

Create a multi-thread version with 3 threads:

one thread finds the max among the cells [0,29] 
another thread the max among the cells [30,59] 
another thread the max among the cells [60,89]

Compare the results of the three threads and print at console the max value.

 * 
 * @author valerio
 *
 */
public class FindMax {
	// this is an array of 90 elements
	// the max value of this array is 9999
	static int[] array = { 1, 34, 5, 6, 343, 5, 63, 5, 34, 2, 78, 2, 3, 4, 5, 234, 678, 543, 45, 67, 43, 2, 3, 4543,
			234, 3, 454, 1, 2, 3, 1, 9999, 34, 5, 6, 343, 5, 63, 5, 34, 2, 78, 2, 3, 4, 5, 234, 678, 543, 45, 67, 43, 2,
			3, 4543, 234, 3, 454, 1, 2, 3, 1, 34, 5, 6, 5, 63, 5, 34, 2, 78, 2, 3, 4, 5, 234, 678, 543, 45, 67, 43, 2,
			3, 4543, 234, 3, 454, 1, 2, 3 };

	public static void main(String[] args) {
		new FindMax().printMax();
	}

	
	public void printMax() {
		// this is a single threaded version
		
		class MyTask implements Runnable {
			private int start;
			private int end;
			private int output;

			public MyTask(int start, int end) {
				this.start = start;
				this.end = end;
			}

			public int getOutput() {
				return output;
			}

			@Override
			public void run(){
	                    output = findMax(this.start,this.end); 
			}
	    }
		
		MyTask t1 = new MyTask(0,29);
		Thread taskThread1 = new Thread(t1);
		MyTask t2 = new MyTask(30,59);
		Thread taskThread2 = new Thread(t2);
		MyTask t3 = new MyTask(60,89);
		Thread taskThread3 = new Thread(t3);
	
		taskThread1.start();
		try {
			taskThread1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		taskThread2.start();
		try {
			taskThread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		taskThread3.start();
		try {
			taskThread3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int max = Math.max(t3.getOutput(),Math.max(t2.getOutput(),t1.getOutput()));
		
		System.out.println("the max value is " + max);
	}


	/**
	 * returns the max value in the array within a give range [begin,range]
	 * 
	 * @param begin
	 * @param end
	 * @return
	 */
	private int findMax(int begin, int end) {
		// you should NOT change this function
		int max = array[begin];
		for (int i = begin + 1; i <= end; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}
}
