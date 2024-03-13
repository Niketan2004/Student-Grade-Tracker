public class Animation {
     public static void Animations(int delay, int rotation) {
          String[] frames = { "\\", "|", "/", "-" };
          // int delay = 100; // milliseconds
          for (int i = 0; i < 6; i++) {
               for (String frame : frames) {
                    System.out.print("\r" + frame + " LOADING...PLEASE WAIT!.... ");
                    try {
                         Thread.sleep(delay);
                    } catch (InterruptedException e) {
                         e.printStackTrace();
                    }
               }
          }
          ;
          System.out.println();
     }
}