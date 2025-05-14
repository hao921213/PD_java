public class Point {
    private String character;
    private boolean use = false;

    public void Set(String character) {
        this.character = character;
    }
    public void Cancel() {
    	use = false;
    }
    public String Getchar() {
        return character;
    }

    public void FirstTime() {
        use = true;
    }

    public boolean HaveUse() {
        return use;
    }

}

