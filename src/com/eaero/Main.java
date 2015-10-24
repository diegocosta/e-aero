package com.eaero;

import com.eaero.views.MainView;
import java.sql.SQLException;
import javax.swing.ImageIcon;

public class Main {

    public static void main(String[] args) throws SQLException {
       MainView main = new MainView();
       main.setTitle("AeroApp");
       main.setIconImage(new ImageIcon(Main.class.getResource("views/images/icon_black.png")).getImage());
       main.setResizable(false);
       main.setLocation(300, 100);
       main.setSize(800, 600);
       main.show();
    }
    
}
