package lv.lu.finalwork.ui;

import lv.lu.finalwork.model.Product;
import lv.lu.finalwork.system.Setup;

import java.util.List;

import static lv.lu.finalwork.system.Utilities.*;

public class Launcher {
    public static Setup setup = new Setup();
    public static Renderer renderer = new Renderer();


    public static void main(String[] args) throws Exception {

        setup.startUp();
        renderer.renderStartup();

    }

    public Setup getSetup(){
        return setup;
    }

}
