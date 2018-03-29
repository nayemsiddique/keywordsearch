/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyword.search;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 *
 * @author nayem
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private TextArea pasteTextField;
    String paste;
    String keyword;
    private ObservableList<String>pasteList;
    private ObservableList<String>keywordList;
    private ObservableList<String>save;
    private ObservableList<String>not;
    @FXML
    private TextArea pasteKeyWordField;
    private int siz;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pasteList=FXCollections.observableArrayList();
        keywordList=FXCollections.observableArrayList();
        save=FXCollections.observableArrayList();
        not=FXCollections.observableArrayList();
    }    

    @FXML
    @SuppressWarnings("empty-statement")
    private void handleNextAction(ActionEvent event) {
        try {
            paste=pasteTextField.getText().toLowerCase();
            //String p=paste.toLowerCase();
            
            keyword=pasteKeyWordField.getText().toLowerCase();
            String arr[]=paste.split(" ");
            
            pasteList.addAll(Arrays.asList(arr));
            
            arr=keyword.split(" ");
            keywordList.addAll(Arrays.asList(arr));
           // siz=keywordList.size();
            /** same as
             * for(String ss : arr){
             *
             *         pasteList.add(ss);
             * }
             **/
            //System.out.println(keywordList.size());
            for(int i=0;i<pasteList.size();i++){
                //pasteList.get(i).toLowerCase();
                if(pasteList.get(i).contains("/")||pasteList.get(i).contains(".")||
                        pasteList.get(i).contains(",")||pasteList.get(i).contains("*")||
                        pasteList.get(i).contains("!")||pasteList.get(i).contains("@")||
                        pasteList.get(i).contains("#")||pasteList.get(i).contains("%")||
                        pasteList.get(i).contains("^")||pasteList.get(i).contains("&")||
                        pasteList.get(i).contains("(")||pasteList.get(i).contains(")")||
                        pasteList.get(i).contains("-")||pasteList.get(i).contains("_")||
                        pasteList.get(i).contains("=")||pasteList.get(i).contains("+")||
                        pasteList.get(i).contains(";")||pasteList.get(i).contains(":")||
                        pasteList.get(i).contains("'")||pasteList.get(i).contains("?")){
                    String rem=pasteList.get(i);
                    pasteList.remove(i);
                    pasteList.add(rem.substring(0, rem.length()-1));
                }
                //System.out.println(pasteList.get(i));
            }
            
            for(int i=0;i<keywordList.size();i++){
                //String toLowerCase = keywordList.get(i).toLowerCase();
                //keywordList.remove(i);
                //keywordList.add(toLowerCase);
                
                if(keywordList.get(i).contains("/")||keywordList.get(i).contains(".")||
                        keywordList.get(i).contains(",")||keywordList.get(i).contains("*")||
                        keywordList.get(i).contains("!")||keywordList.get(i).contains("@")||
                        keywordList.get(i).contains("#")||keywordList.get(i).contains("%")||
                        keywordList.get(i).contains("^")||keywordList.get(i).contains("&")||
                        keywordList.get(i).contains("(")||keywordList.get(i).contains(")")||
                        keywordList.get(i).contains("-")||keywordList.get(i).contains("_")||
                        keywordList.get(i).contains("=")||keywordList.get(i).contains("+")||
                        keywordList.get(i).contains(";")||keywordList.get(i).contains(":")||
                        keywordList.get(i).contains("'")||keywordList.get(i).contains("?")){
                    String rem=keywordList.get(i);
                    //System.out.println("yes");
                    //keywordList.get(i).replace(keywordList.get(i), keywordList.get(i).substring(0,(keywordList.get(i).length()-1) ));
                    keywordList.remove(i);
                    keywordList.add(rem.substring(0, rem.length()-1));
                }
                //System.out.println(keywordList.get(i));
            }
            for(int i=0;i<keywordList.size();i++){
                for(int j=0;j<pasteList.size();j++){
                    if(keywordList.get(i).equals(pasteList.get(j))){
                        
                        String p=pasteList.get(j);
                        save.add(p);
                        break;
                    }
                }
            }
            for(int i=0;i<save.size();i++){
                for(int j=0;j<keywordList.size();j++){
                    if(save.get(i).equals(keywordList.get(j))){
                        //System.out.println("yes");
                        ;
                    }
                    else{
                        keywordList.remove(save.get(i));
                        break;
                    }
                }
            }
            if(keywordList.size()>0){
                for(int i=0;i<keywordList.size();i++){
                    for(int j=0;j<save.size();j++){
                        if(keywordList.get(i).equals(save.get(j))){
                           keywordList.remove(save.get(j));
                           
                        }
                    }
                }
            }
            ResultController.getSaveList(save);
            ResultController.getkeyList(keywordList);
            ResultController.getsize(siz);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("result.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = KeywordSearch.getMainStage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Result");
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
