package valueObjects;

public class CreditNumber {
	private static int creditNumberCounter = 0;
    private final int creditNumber;
	
    public CreditNumber() {
	 this.creditNumber = creditNumberCounter++;
    }
	    
    public static boolean isValidAccountNumber(int number)
    {
    	return (number >= 0);
    }
    
    public int getCreditNumber() {
    	return this.creditNumber;
    }

	@Override
	public boolean equals(Object obj) {
		CreditNumber secondNumber = (CreditNumber)obj;
		return this.creditNumber == secondNumber.creditNumber;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
    

}
