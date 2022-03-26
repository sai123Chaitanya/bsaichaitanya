package deckcard;

public class PlayingCard implements Card{
	
	private Card.Rank rank;
	private Card.Suit suit;
	
	
	public PlayingCard(Card.Rank rank , Card.Suit suit)
	{
		
		this.rank = rank;
		this.suit = suit;
		
	}

	@Override
	public int compareTo(Card o) {
		return this.hashCode()-o.hashCode();
	}

	@Override
	public Suit getSuit() {
		// TODO Auto-generated method stub
		return suit;
	}

	@Override
	public Rank getRank() {
		// TODO Auto-generated method stub
		return rank;
	}
	
	public boolean equals(Object obj)
	{
		
		if(obj instanceof Card)
		{
			if (((Card) obj).getRank()==this.rank && ((Card) obj).getSuit()==this.suit) {
				return true;
				
			} else {
				return false;

			}
		}
		else {
			return false;
			
		}
		
	}
	
	
	public int hashCode()
	{
		return((suit.value()-1)*13)+rank.value();
	}
	
	
	public String toString()
	{
		
		return this.rank.text() + "of" + this.suit.text();
	}
	
	
	public static void main(String[] args) {
		
		new PlayingCard(Rank.ACE, Suit.DIAMONDS);
		new PlayingCard(Rank.KING, Suit.SPADES);
	}
	
		
	}

