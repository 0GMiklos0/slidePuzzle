package model;

import java.util.HashSet;
import java.util.Set;

public class slidingPuzzle {
    private Cards[] cards;

    private Tile[][] tiles;

    public boolean isLegalMove(Moves move){
        int[] theMove = {move.card().move(move.direction()).row(),  move.card().move(move.direction()).col()};
        return tiles[theMove[0]][theMove[1]].equals(Tile.REACHABLE);
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
}
