package model;

public class HintManager {
    private static HintManager instance;
    private boolean hintUsed;

    private HintManager() {
        this.hintUsed = false;
    }

    public static HintManager getInstance() {
        if (instance == null) {
            instance = new HintManager();
        }
        return instance;
    }

    public boolean isHintUsed() {
        return hintUsed;
    }

    public void useHint() {
        this.hintUsed = true;
    }

    public void resetHint() {
        this.hintUsed = false; // Yeni bir oyun başladığında sıfırlamak için
    }
    
}
