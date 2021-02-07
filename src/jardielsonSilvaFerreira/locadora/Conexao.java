package jardielsonSilvaFerreira.locadora;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final Connection[] conexoes = new Connection[10];
    private static boolean conectou = false;
    private static int pos = 0;





        public static Connection getConexao () {
            if (pos == 10) {
                pos = 0;
            }
            if (!conectou) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    for (int i = 0; i < 10; i++) {
                        conexoes[i] = DriverManager.getConnection("jdbc:mysql://localhost/users?useSSL=false", "root", "root@123");
                    }
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                    System.exit(1);
                }
                conectou = true;
            }
            return conexoes[pos++];
        }

    }
