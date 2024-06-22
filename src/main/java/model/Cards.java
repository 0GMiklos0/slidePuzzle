package model;

public record Cards(int number, int row, int col) {
    public Cards move(Direction direction) {
        return new Cards(this.number(), this.row() + direction.getRow(), this.col() + direction.getCol());
    }
}
