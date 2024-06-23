package model;

import java.util.*;

public class slidingPuzzle implements State<Moves> {
    private Cards[] cards;

    private int[][] tiles;
    public slidingPuzzle(){
        cards = new Cards[]{
                new Cards(1,1,9),
                new Cards(2,1,1),
                new Cards(3,1,2),
                new Cards(4,1,3),
                new Cards(5,1,4),
                new Cards(6,1,5),
                new Cards(7,1,6),
                new Cards(8,1,7),
                new Cards(9,1,8),
        };
        tiles = new int[][]{
                {-1,-1,-1,0,-1,0,-1,0,-1}, {0,0,0,0,0,0,0,0}
        };
    }

    public Cards[] cardOrder(){
        return (Cards[]) Arrays.stream(cards).sorted(Comparator.comparingInt(c -> c.row() + c.col())).toArray();
    }

    public void makeMove(Moves move){
        cards[move.getNumber()-1] = move.nextMoveCard();
    }
    public boolean isLegalMove(Moves move){
        int[] theMove = {move.nextMove().card().row(), move.nextMove().card().col()};
        return tiles[theMove[0]][theMove[1]]==0 && Arrays.stream(cards).noneMatch(card -> (card.row() == theMove[0] && card.col() == theMove[1]));
    }

    public Set<Moves> getLegalMoves(){
        HashSet<Moves> legalMoves = new HashSet();
        for (int i = 0; i < cards.length; i++){
            for (var direction : Direction.values()){
                var move = new Moves(cards[i], direction);
                if(isLegalMove(move)) legalMoves.add(move);
            }
        }
        return legalMoves;
    }

    public boolean isSolved(){
        for (int i = 0; i < cardOrder().length; i++){
            if(!(cardOrder()[i].number() == i+1)) return false;
        }
        return true;
    }
}
