import java.awt.*;
import java.io.IOException;
import java.net.URI;

public class Browser {
	
	private static Browser instance = new Browser();

	public static Browser getinstance() {
		return instance;
	}

    public void browser(String url) {
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                if (desktop.isSupported(Desktop.Action.BROWSE)) {
                    desktop.browse(URI.create(url));
                }
            }
        } catch (IOException | InternalError e) {
            e.printStackTrace();
        }
    }
}