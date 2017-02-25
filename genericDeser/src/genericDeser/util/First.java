package genericDeser.util;

/**
 * @author Abhishek Niranjan Upasani
 * @version 1.0
 * @since 2016-12-10
 * 
 */
public class First {

	private int IntValue;
	private float FloatValue;
	private short ShortValue;
	private String StringValue;
	
	public First() {
		Logger.writeMessage("Constructor of First class", DebugLevel.CONSTRUCTOR);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(FloatValue);
		result = prime * result + IntValue;
		result = prime * result + ShortValue;
		result = prime * result
				+ ((StringValue == null) ? 0 : StringValue.hashCode());
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
		First other = (First) obj;
		if (Float.floatToIntBits(FloatValue) != Float
				.floatToIntBits(other.FloatValue))
			return false;
		if (IntValue != other.IntValue)
			return false;
		if (ShortValue != other.ShortValue)
			return false;
		if (StringValue == null) {
			if (other.StringValue != null)
				return false;
		} else if (!StringValue.equals(other.StringValue))
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
	 * @param FloatValueIn the FloatValue to set
	 */
	public void setFloatValue(float FloatValueIn) {
		FloatValue = FloatValueIn;
	}
	
	/**
	 * @param ShortValueIn the ShortValue to set
	 */
	public void setShortValue(short ShortValueIn) {
		ShortValue = ShortValueIn;
	}
	
	/**
	 * @param StringValueIn the StringValue to set
	 */
	public void setStringValue(String StringValueIn) {
		StringValue = StringValueIn;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "First [IntValue=" + IntValue + ", FloatValue=" + FloatValue
				+ ", ShortValue=" + ShortValue + ", StringValue=" + StringValue
				+ "]";
	}
}