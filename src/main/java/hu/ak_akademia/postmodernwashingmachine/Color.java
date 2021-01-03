package hu.ak_akademia.postmodernwashingmachine;

public enum Color {

    COLORFUL("színes"), WHITE("fehér");

 private final String color;

    Color(String color) {
        this.color = color;
    }

    public String getColor(){
        return color;
    }
}
