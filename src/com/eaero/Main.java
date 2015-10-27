package com.eaero;

import com.eaero.views.MainView;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
       MainView main = new MainView();
       main.setVisible(true);
    }
    
}
