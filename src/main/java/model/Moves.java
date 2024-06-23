package model;

public record Moves(Cards card, Direction direction) {
    public int getNumber(){
        return card().number();
    }

    public Moves nextMove(){
        return new Moves(card().move(this.direction()), this.direction());
    }

    public Cards nextMoveCard() {
        return new Cards(this.card().number(),
                this.card().move(this.direction).row(),
                this.card().move(this.direction).col());
    }
}
