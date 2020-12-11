package typesOfElements;

public enum DropDown {
//How to get the String values from this enum class
	
	INDEX{
		@Override
		public String toString()
		{
			return "byIndex";
		}
	},
	
	VALUE{
		@Override
		public String toString()
		{
			return "byValue";
		}
	
	},
	// these will work as  inner Enum 's 
	VISIBLE_TEXT	{
		@Override
		public String toString()
		{
			return "byText";
		}
	}
			
}
	

