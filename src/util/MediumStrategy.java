package util;

public class MediumStrategy implements DifficultyStrategy {
    public int calculateScore(int baseScore) {
        return baseScore * 2;
    }
}
