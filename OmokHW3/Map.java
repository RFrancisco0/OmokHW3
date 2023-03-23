package omok.model;

public class Map {
    short[][] map;
    final short BLACK = 1;
    final short WHITE = -1;
    boolean checkBNW = true;

    MapSize ms;

    public Map(MapSize ms) {
        this.ms = ms;
        map = new short[ms.getSize()][];
        for (int i = 0; i < map.length; i++)
            map[i] = new short[ms.getSize()];

        System.out.println("map");
    }

    public short getBlack() {
        return BLACK;
    }

    public short getWhite() {
        return WHITE;
    }

    public short getXY(int y, int x) {
        return map[y][x];
    }

    public boolean getCheck() {
        return checkBNW;
    }

    public void changeCheck() {
        if (checkBNW)
            checkBNW = false;
        else
            checkBNW = true;
    }

    public void setMap(int y, int x) {
        if (checkBNW)
            map[y][x] = BLACK;
        else
            map[y][x] = WHITE;
    }
}
