package model;

public class Dimensions {
    private int Height;
    private int Length;
    private int Width;

    public Dimensions(int height, int length, int width) {
        this.Height = height;
        this.Length = length;
        this.Width = width;
    }


    @Override
    public String toString() {
        return "Model.Dimensions{" +
                "Height=" + Height +
                ", Length=" + Length +
                ", Width=" + Width +
                '}';
    }

    public int getHeight() {
        return Height;
    }

    public int getLength() {
        return Length;
    }

    public int getWidth() {
        return Width;
    }
}
