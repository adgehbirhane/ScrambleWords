// it is not working on my divice.
// import com.formdev.flatlaf.FlatLightLaf;
import frames.Home;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        try {
            // UIManager.setLookAndFeel(new FlatLightLaf());
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        new Home();
    }
}
