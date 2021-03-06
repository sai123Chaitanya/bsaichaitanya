package deckcard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StandardDeck implements Deck {

	private List<Card> entireDeck;

	public StandardDeck(List<Card> existingList) {
		this.entireDeck = existingList;
	}

	public StandardDeck() {
		this.entireDeck = new ArrayList<Card>();
		for (Card.Suit s : Card.Suit.values()) {

			for (Card.Rank r : Card.Rank.values()) {
				this.entireDeck.add(new PlayingCard(r, s));
			}
		}

	}

	@Override
	public List<Card> getCards() {
		return entireDeck;

	}

	@Override
	public Deck deckFactory() {

		return new StandardDeck(new ArrayList<Card>());
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return entireDeck.size();
	}

	public void addcard(Card card) {
		entireDeck.add(card);

	}

	@Override
	public void addCards(List<Card> cards) {
		entireDeck.addAll(cards);

	}

	@Override
	public void addDeck(Deck deck) {
		List<Card> listToAdd = deck.getCards();
		entireDeck.addAll(listToAdd);

	}

	@Override
	public void shuffle() {
		Collections.shuffle(entireDeck);

	}

	@Override
	public void sort() {
		Collections.sort(entireDeck);

	}

	@Override
	public void sort(Comparator<Card> c) {
		Collections.sort(entireDeck,c);

	}

	@Override
	public String deckToString()
	{
		
		return this.entireDeck.stream().map(Card::toString).collect(Collectors.joining("\n"));
	}


	@Override
	public Map<Integer, Deck> deal(int players, int numberOfCards) throws IllegalArgumentException {
		int cardsDealt = players * numberOfCards;
		int sizeOfDeck = entireDeck.size();
		if (cardsDealt > sizeOfDeck) {
			throw new IllegalArgumentException("Number of Players( " + players + ") times number of cards to be dealt("
					+ numberOfCards + ") is greater than number of cards in deck (" + sizeOfDeck + ").");
		}

	

	
	
	Map<Integer, List<Card>> dealtDeck = entireDeck.stream().collect(Collectors.groupingBy(card -> {

		int cardIndex = entireDeck.indexOf(card);
		if (cardIndex >= cardsDealt) return (players + 1);
		else return (cardIndex % players) + 1;
	}));
	
	
	Map<Integer, Deck> mapToReturn = new HashMap<>();
	
	for(int i=1;i<=(players+1);i++)
	{
		Deck currentDeck = deckFactory();
		currentDeck.addCards(dealtDeck.get(i));
		mapToReturn.put(i, currentDeck);
	}
	
	return mapToReturn;
	}

	@Override
	public void addcard() {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		
		StandardDeck MyDeck = new StandardDeck();
		System.out.println("Creating deck:");
		MyDeck.sort();
		System.out.println("SortedDeck");
		System.out.println(MyDeck.deckToString());
		MyDeck.shuffle();
		MyDeck.sort(new SortByRankThenSuit());
		System.out.println("sorted by rank then by suit");
		System.out.println(MyDeck.deckToString());
		MyDeck.shuffle();
		MyDeck.sort(Comparator.comparing(Card::getRank).thenComparing(Comparator.comparing(Card::getSuit)));
		System.out.println("Sorted by rank reversed, then by suit" + "with static and default methods");
		System.out.println(MyDeck.deckToString());
		
	}
	
	
}

