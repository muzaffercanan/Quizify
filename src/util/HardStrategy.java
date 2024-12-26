
package util;

public class HardStrategy implements DifficultyStrategy {
    public int calculateScore(int baseScore) { return baseScore * 3; }
}
