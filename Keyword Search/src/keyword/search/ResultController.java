/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyword.search;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author nayem
 */
public class ResultController implements Initializable {
    public static ObservableList<String> getSaveList() {
        return save;
    }
    public static ObservableList<String> getkeywordList() {
        return keywordList;
    }
    public static void getSaveList(ObservableList<String> Asave) {
        save=Asave;
    }
    public static void getkeyList(ObservableList<String> key) {
        keywordList=key;
    }
    private static ObservableList<String>save;
    private static ObservableList<String>keywordList;

    public static void getsize(int siz) {
        size=siz;
    }
    private static int size;
    @FXML
    private ListView<String> matchedList;
    @FXML
    private ListView<String> unmatchedList;
    @FXML
    private Label totalKey;
    @FXML
    private Label match;
    @FXML
    private Label notmatchd;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       matchedList.setItems(save);
       unmatchedList.setItems(keywordList);
       
       totalKey.setText(size+"");
       match.setText(save.size()+"");
       notmatchd.setText(keywordList.size()+"");
    }    
    
}
