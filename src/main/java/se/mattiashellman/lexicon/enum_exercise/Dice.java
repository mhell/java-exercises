package se.mattiashellman.lexicon.enum_exercise;

enum Dice {
    D6(6),
    D10(10),
    D20(20),
    D100(100);

    private final int maxValue;

    Dice(int maxValue) {
        this.maxValue = maxValue;
    }

    public int roll() {
        return (int)Math.round(Math.random() * maxValue);
    }
}