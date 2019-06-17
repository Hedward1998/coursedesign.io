package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DButil {
  private static String className = null;
  private static String url = null;
  private static String user = null;
  private static String password = null;

  static {
    InputStream inputStream = DButil.class.getClassLoader().getResourceAsStream("db.properties");
    Properties properties = new Properties();
    try {
      properties.load(inputStream);
    } catch (IOException e) {
      e.printStackTrace();
    }
    className = properties.getProperty("className");
    url = properties.getProperty("url");
    user = properties.getProperty("user");
    password = properties.getProperty("password");

    try {
      Class.forName(className);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  public static Connection getConnection() {
    try {
      return DriverManager.getConnection(url, user, password);
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  public static void close(Connection con, Statement stmt) {
    try {
      if (stmt != null) {
        stmt.close();
      }
      if (con != null) {
        con.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void close(Connection con, Statement stmt, ResultSet res) {
    try {
      if (stmt != null) {
        stmt.close();
      }
      if (res != null) {
        res.close();
      }
      if (con != null) {
        con.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void close(Connection con, PreparedStatement psmt) {
    try {
      if (psmt != null) {
    	 psmt.close();
      }
      if (con != null) {
        con.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void close(Connection con, PreparedStatement psmt, ResultSet res) {
    try {
      if (psmt != null) {
    	 psmt.close();
      }
      if (res != null) {
        res.close();
      }
      if (con != null) {
        con.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
