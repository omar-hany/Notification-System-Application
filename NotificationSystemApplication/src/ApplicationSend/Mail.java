package com.example.demo.ApplicationSend;

import com.example.demo.Databases.IDatabase;
import com.example.demo.Templates.NotificationTemplate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class Mail implements Isend{
    private static LinkedList<NotificationTemplate> MailQueue=new LinkedList<NotificationTemplate>();
    @Override
    public Boolean Send(NotificationTemplate notification,String sender,String receiver) throws SQLException {
        MailQueue.add(notification);
        Connection connection = DB.connectToDatabase();
        Statement stmt = connection.createStatement();
        String sql = "INSERT INTO mail values("+notification.toString()+",\""+receiver+"\",\""+sender+"\","+true+')';
        int res = stmt.executeUpdate(sql);
        return true;
    }
}
