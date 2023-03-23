package omok.model;

import omok.model.Player;

import java.awt.*;

import javax.swing.JPanel;



/**
 * Abstraction of an Omok board, which consists of n x n intersections
 * or places where players can place their stones. The board can be
 * accessed using a pair of 0-based indices (x, y), where x and y
 * denote the column and row number, respectively. The top-left
 * intersection is represented by the indices (0, 0), and the
 * bottom-right intersection is represented by the indices (n-1, n-1).
 */
public class Board {
    MapSize size1;
    Map map1;
    final int STONE_SIZE=26;

    short[][] map;
    final short BLACK=1;
    final short WHITE=-1;
    boolean checkBNW=true;

    /** Create a new board of the default size. */
    public Board(MapSize m, Map map) {
        setBackground(Color.BLACK );
        size1=m;
        setLayout(null);
        System.out.println("board");
        this.map1=map;
    }

    private void setBackground(Color black) {
    }

    private void setLayout(Object o) {

    }

    /** Create a new board of the specified size. */
    public Board(Graphics g) {
        for(int i=1;i<=size1.getSize();i++){
            g.drawLine(size1.getCell(), i*size1.getCell(), size1.getCell()*size1.getSize(), i*size1.getCell());
            g.drawLine(i*size1.getCell(), size1.getCell(), i*size1.getCell() , size1.getCell()*size1.getSize());
        }
    }

    /** Return the size of this board. */
    public int size() {
        return size1.getSize();
    }

    /** Removes all the stones placed on the board, effectively
     * resetting the board to its original state.
     */
    public void clear() {
        new Board(size1, map1);
    }

    /** Return a boolean value indicating whether all the places
     * on the board are occupied or not.
     */
    public boolean isFull() {
        return false;
    }

    /**
     * Place a stone for the specified player at a specified
     * intersection (x, y) on the board.
     *
     * @param x 0-based column (vertical) index
     * @param y 0-based row (horizontal) index
     * @param player Player whose stone is to be placed
     */
    public void placeStone(int x, int y, Player player) {


        if(map1.getXY(y, x)==map1.getBlack()||map1.getXY(y, x)==map1.getWhite())
            return;

        System.out.println(x+" "+y);
        map1.setMap(y, x);
        map1.changeCheck();
        //Board.repaint();
    }

    /**
     * Return a boolean value indicating whether the specified
     * intersection (x, y) on the board is empty or not.
     *
     * @param x 0-based column (vertical) index
     * @param y 0-based row (horizontal) index
     */
    public boolean isEmpty(int x, int y) {
        if(x==1 & y==1){
            return isOccupied(x,y);

        }
        else {
            return true;
        }

    }

    /**
     * Is the specified place on the board occupied?
     *
     * @param x 0-based column (vertical) index
     * @param y 0-based row (horizontal) index
     */
    public boolean isOccupied(int x, int y) {
        if(x==1 & y==1){
            System.out.println("is occupied");
            return true;
        }
        else{
            System.out.println("is not occupied");
            return false;
        }
    }

    /**
     * Rreturn a boolean value indicating whether the specified
     * intersection (x, y) on the board is occupied by the given
     * player or not.
     *
     * @param x 0-based column (vertical) index
     * @param y 0-based row (horizontal) index
     */
    public boolean isOccupiedBy(int x, int y, Player player) {
        if(isOccupied(x,y) == true){
            System.out.println("the player is " + player);
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Return the player who occupies the specified intersection (x, y)
     * on the board. If the place is empty, this method returns null.
     *
     * @param x 0-based column (vertical) index
     * @param y 0-based row (horizontal) index
     */
    public Player playerAt(int x, int y) {
        if(map1.getXY(y, x)==map1.getBlack()){
            System.out.println("Black");

        } else if (map1.getXY(y, x)==map1.getWhite()) {
            System.out.println("White");
        }
        else {
            return null;
        }
        return null;
    }

    /**
     * Return a boolean value indicating whether the given player
     * has a winning row on the board. A winning row is a consecutive
     * sequence of five or more stones placed by the same player in
     * a horizontal, vertical, or diagonal direction.
     */
    public boolean isWonBy(int x,int y) {
        if(winCheckL(x, y)||winCheckLD(x, y)||winCheckLU(x, y)||winCheckR(x, y)
                ||winCheckRD(x, y)||winCheckRU(x, y)||winCheckUp(x, y)||winCheckDown(x, y)
                ||winCheckOneDown(x, y)||winCheckOneL(x, y)||winCheckOneLD(x, y)||winCheckOneLU(x, y)
                ||winCheckOneR(x, y)||winCheckOneRD(x, y)||winCheckOneUp(x, y)||winCheckOneRU(x, y)
                ||winCheckCenterLU(x, y)||winCheckCenterRL(x, y)||winCheckCenterRU(x, y)||winCheckCenterUD(x, y))
            return true;
        else
            return false;
    }

    public boolean winCheckUp(int x,int y) {
        for(int i=y;i<y+5;i++){
            if(map[y][x]!=map[i][x])
                return false;
        }

        return true;
    }
    //down
    public boolean winCheckDown(int x,int y) {
        for(int i=y;i>y-5;i--){
            if(map[y][x]!=map[i][x])
                return false;
        }

        return true;
    }
    //upper right diagonal
    public boolean winCheckRU(int x,int y) {
        for(int i=y, z=x;i>y-5;i--,z++){
            if(map[y][x]!=map[i][z])
                return false;
        }

        return true;
    }

    //upper left diagonal
    public boolean winCheckLU(int x,int y) {
        for(int i=y, z=x;i>y-5;i--,z--){
            if(map[y][x]!=map[i][z])
                return false;
        }

        return true;
    }

    //right
    public boolean winCheckR(int x,int y) {
        for(int z=x;z<x+5;z++){
            if(map[y][x]!=map[y][z])
                return false;
        }

        return true;
    }

    //left
    public boolean winCheckL(int x,int y) {
        for(int z=x;z>x-5;z--){
            if(map[y][x]!=map[y][z])
                return false;
        }

        return true;
    }

    //diagonal lower right
    public boolean winCheckRD(int x,int y) {
        for(int i=y, z=x;i<y+5;i++,z++){
            if(map[y][x]!=map[i][z]||i>19||z>19||i<0||z<0)
                return false;
        }

        return true;
    }

    //diagonal lower left
    public boolean winCheckLD(int x,int y) {
        for(int i=y, z=x;i<y+5;i++,z--){
            if(map[y][x]!=map[i][z])
                return false;
        }

        return true;
    }
    //one space up
    public boolean winCheckOneUp(int x,int y) {
        for(int i=y-1;i<y+4;i++){
            if(map[y][x]!=map[i][x])
                return false;
        }

        return true;
    }
    //one space down
    public boolean winCheckOneDown(int x,int y) {
        for(int i=y+1;i>y-4;i--){
            if(map[y][x]!=map[i][x])
                return false;
        }

        return true;
    }
    //diagonal upper right
    public boolean winCheckOneRU(int x,int y) {
        for(int i=y+1, z=x-1;i>y-4;i--,z++){
            if(map[y][x]!=map[i][z])
                return false;
        }

        return true;
    }

    //diagonal upper left
    public boolean winCheckOneLU(int x,int y) {
        for(int i=y+1, z=x+1;i>y-4;i--,z--){
            if(map[y][x]!=map[i][z])
                return false;
        }

        return true;
    }

    //one space to the right
    public boolean winCheckOneR(int x,int y) {
        for(int z=x-1;z<x+4;z++){
            if(map[y][x]!=map[y][z])
                return false;
        }

        return true;
    }

    //one space left
    public boolean winCheckOneL(int x,int y) {
        for(int z=x+1;z>x-4;z--){
            if(map[y][x]!=map[y][z])
                return false;
        }

        return true;
    }

    //Diagonal down one space to the right
    public boolean winCheckOneRD(int x,int y) {
        for(int i=y-1, z=x-1;i<y+4;i++,z++){
            if(map[y][x]!=map[i][z]||i>19||z>19||i<0||z<0)
                return false;
        }

        return true;
    }

    //Diagonal one space lower left
    public boolean winCheckOneLD(int x,int y) {
        for(int i=y-1, z=x+1;i<y+4;i++,z--){
            if(map[y][x]!=map[i][z])
                return false;
        }

        return true;
    }
    //center up down
    public boolean winCheckCenterUD(int x,int y) {
        for(int i=y-2;i<y+3;i++){
            if(map[y][x]!=map[i][x])
                return false;
        }

        return true;
    }
    //center right left
    public boolean winCheckCenterRL(int x,int y) {
        for(int z=x-2;z<x+3;z++){
            if(map[y][x]!=map[y][z])
                return false;
        }

        return true;
    }
    //center light diagonal
    public boolean winCheckCenterRU(int x,int y) {
        for(int i=y+2, z=x-2;i>y-3;i--,z++){
            if(map[y][x]!=map[i][z])
                return false;
        }

        return true;
    }
    //center left diagonal
    public boolean winCheckCenterLU(int x,int y) {
        for(int i=y+2, z=x+2;i>y-4;i--,z--){
            if(map[y][x]!=map[i][z])
                return false;
        }

        return true;
    }

    /** Return the winning row. For those who are not familiar with
     * the Iterable interface, you may return an object of
     * List<Place>. */
    /*public Iterable<Place> winningRow(int x, int y) {

        int xx = x;
        System.out.println(isWonBy();
        return null;
    }*/

    /**
     * An intersection on an Omok board identified by its 0-based column
     * index (x) and row index (y). The indices determine the position
     * of a place on the board, with (0, 0) denoting the top-left
     * corner and (n-1, n-1) denoting the bottom-right corner,
     * where n is the size of the board.
     */
    public static class Place {
        /** 0-based column index of this place. */
        public final int x;

        /** 0-based row index of this place. */
        public final int y;

        /** Create a new place of the given indices.
         *
         * @param x 0-based column (vertical) index
         * @param y 0-based row (horizontal) index
         */
        public Place(int x, int y) {
            this.x = x;
            this.y = y;
        }

        // other methods if needed ...




    }
}

