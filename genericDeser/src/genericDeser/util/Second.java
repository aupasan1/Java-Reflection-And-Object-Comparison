package genericDeser.util;

/**
 * @author Abhishek Niranjan Upasani
 * @version 1.0
 * @since 2016-12-10
 * 
 */
public class Second {

	private int IntValue;
	private double DoubleValue;
	private boolean BooleanValue;
	
	public Second() {
		Logger.writeMessage("Constructor of Second class", DebugLevel.CONSTRUCTOR);
	}	

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (BooleanValue ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(DoubleValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + IntValue;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Second other = (Second) obj;
		if (BooleanValue != other.BooleanValue)
			return false;
		if (Double.doubleToLongBits(DoubleValue) != Double
				.doubleToLongBits(other.DoubleValue))
			return false;
		if (IntValue != other.IntValue)
			return false;
		return true;
	}

	/**
	 * @param IntValueIn the IntValue to set
	 */
	public void setIntValue(int IntValueIn) {
		IntValue = IntValueIn;
	}
	
	/**
	 * @param DoubleValueIn the DoubleValue to set
	 */
	public void setDoubleValue(double DoubleValueIn) {
		DoubleValue = DoubleValueIn;
	}
	
	/**
	 * @param BooleanValueIn the BooleanValue to set
	 */
	public void setBooleanValue(boolean BooleanValueIn) {
		BooleanValue = BooleanValueIn;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Second [IntValue=" + IntValue + ", DoubleValue=" + DoubleValue
				+ ", BooleanValue=" + BooleanValue + "]";
	}
}