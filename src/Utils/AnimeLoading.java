package Utils;

public class AnimeLoading implements Runnable{

    private static String lastLine = "";
    private static boolean interrupt = false;

    public static void print(String line) {
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

    private static byte anim;

    public static void animate() throws InterruptedException {
   
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
    

	@Override
	public void run() {
		// TODO Auto-generated method stub
		 while(!interrupt) {		 
			 try {
				animate();
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
	}
	
	
	 public void stop() {
		 interrupt = true;
		 System.out.print("\r" + "          ");
	   }
    
	
}
