package com.boan.crm.other.feedback.common;


public enum SuggestionReplyStatus {
	NO_REPLY( "未回复", 0 ), REPLYED( "已回复", 1 ),;

	private String name;

	private int index;

	private SuggestionReplyStatus( String name, int index )
	{
		this.name = name;
		this.index = index;
	}

	public static String getName( int index )
	{
		for( SuggestionReplyStatus c : SuggestionReplyStatus.values() )
		{
			if( c.getIndex() == index )
			{
				return c.getName();
			}
		}
		return null;
	}

	public String getName()
	{
		return name;
	}

	public void setName( String name )
	{
		this.name = name;
	}

	public int getIndex()
	{
		return index;
	}

	public void setIndex( int index )
	{
		this.index = index;
	}
}
