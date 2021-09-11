package com.example.sql;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javax.xml.transform.Result;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private ImageView idUser;

    @FXML
    private ImageView idPlay;

    @FXML
    private Label labelVali;

    @FXML
    private Button BtnThoat;

    @FXML
    private Button BtnDangNhap;


    @FXML
    private TextField idMatKhau;

    @FXML
    private TextField idTaiKhoan;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File imgPlayFile = new File("image/play-station.png");
        Image imgPlay = new Image(imgPlayFile.toURI().toString());
        idPlay.setImage(imgPlay);

        File imgUserFile = new File("image/locksmith.png");
        Image imgUser = new Image(imgUserFile.toURI().toString());
        idUser.setImage(imgUser);
    }

    public void dangnhap(ActionEvent event){
        if(idTaiKhoan.getText().isBlank() == false && idMatKhau.getText().isBlank() == false){
            valadate();
        }
        else{
            labelVali.setText("Hãy điền tài khoản hoặc mật khẩu");
        }
    }

    public void thoat(ActionEvent event){
        Stage stage = (Stage) BtnThoat.getScene().getWindow();
        stage.close();
    }

    public void valadate(){
        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectionDB = connectionNow.getConnection();

        String testLogin = "SELECT COUNT(1) FROM khachhang WHERE USER='"+idTaiKhoan.getText()+"'AND PASSWORD='"+idMatKhau.getText()+"' ;";

        try {
            Statement statement = connectionDB.createStatement();
            ResultSet result =  statement.executeQuery(testLogin);

            while (result.next()){
                if(result.getInt(1)==1){
                    labelVali.setText("Đăng nhập thành công");
                }
                else {
                    labelVali.setText("Hãy đăng nhập lai");
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
}
