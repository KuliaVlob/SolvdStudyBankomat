import menu.MainMenu;
import org.apache.log4j.Logger;

public class Executor {

    final static Logger LOGGER = Logger.getLogger((Executor.class));

        public static void main(String[] args) {

            MainMenu mainMenu = new MainMenu();
            mainMenu.getInputData();

        }
}
