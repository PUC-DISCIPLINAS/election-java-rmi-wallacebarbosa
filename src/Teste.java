import Utils.StringUtils;

public class Teste {


    private String lastLine = "";

    public void print(String line) {
        //clear the last line if longer
        if (lastLine.length() > line.length()) {
            String temp = "";
            for (int i = 0; i < lastLine.length(); i++) {
                temp += " ";
            }
            if (temp.length() > 1)
                System.out.print("\r" + temp);
        }
        System.out.print("\r" + line);
        lastLine = line;
    }

    private byte anim;

    public void animate() {
        switch (anim) {
            case 1:
                print("[ \\ ]");
                break;
            case 2:
                print("[ | ]");
                break;
            case 3:
                print("[ / ]");
                break;
            default:
                anim = 0;
                print("[ - ]");
        }
        anim++;
    }

    public static void main(String[] args) throws InterruptedException {
        Teste consoleHelper = new Teste();
        for (int i = 0; i < 20; i++) {
            consoleHelper.animate();
            //simulate a piece of task
            Thread.sleep(400);
        }
    }
	

}
