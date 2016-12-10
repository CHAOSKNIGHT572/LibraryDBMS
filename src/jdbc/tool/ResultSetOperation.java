package jdbc.tool;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetOperation {
	public static void display(ResultSet rs, int columnNum) {
		try {
			while(rs.next()){
				for(int i = 1; i <= columnNum; ++i){
					System.out.print(rs.getString(i) + ",");
				}
				System.out.println();
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
