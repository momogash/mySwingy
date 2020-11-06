package Controller;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class Db_Connection {
	private static Connection con; //used to establish connection
	private static boolean hasData = false; //used to connect and check if table exits, set to true
	HeroMaker hero = new HeroMaker();
	HeroMaker heromaker = HeroMaker.getHero();
	
	
	
	public Db_Connection() {}
	
	public ResultSet displayusers() throws ClassNotFoundException, SQLException {
		if (con == null)
			getConnection();
		
		Statement state = con.createStatement();
		ResultSet res = state.executeQuery("SELECT name, type FROM user");
		return res;
		
	}
	
	
	
	public void getConnection() throws ClassNotFoundException, SQLException{
		//File file = new File(Swingy.db);
		Class.forName("org.sqlite.JDBC");
		con = DriverManager.getConnection("jdbc:sqlite:Swingy");
		System.out.println("Connected to sqllite DB");
		initialize();
	}
	private void initialize() throws SQLException {
		if (!hasData)
			hasData = true;
		
		Statement state = con.createStatement();
		ResultSet res = state.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='users' ");
		if (!res.next()) {
			System.out.println("building user with prepopulated values");
		//build table
		Statement state2 = con.createStatement();
		state2.execute("CREATE TABLE users(id integer,"
				+ "name varchar(60)," + "type varchar(60)," + "attack integer," +  "experience integer," + "defence integer," + "hp integer," +
				"level integer," + "xp integer," + "x integer," + "y integer," +
				"primary key(id));");
		System.out.println("Table created");
		}
		
		
	}
	
	public void insert(HeroMaker hero) throws ClassNotFoundException, SQLException {
		if (con == null)
			getConnection();
		PreparedStatement prep = con.prepareStatement("INSERT INTO users (name, type, attack, experience, defence, hp, level, xp, y, x) values(?,?,?,?,?,?,?,?,?,?);");
		prep.setString(1, hero.getHeroName());
		prep.setString(2, hero.getHeroType());
		prep.setInt(3, hero.getHeroAttack());
		prep.setInt(4, hero.getexperience());
		prep.setInt(5, hero.getHeroDefense());
		prep.setInt(6, hero.getHeroHitPoints());
		prep.setInt(7, hero.getHeroLevel());
		prep.setInt(8, hero.getHeroXp());
		prep.setInt(9, hero.getx());
		prep.setInt(10, hero.gety());
		prep.execute();
		System.out.println("inserted hero - " + hero.getHeroName());
		prep.close();
		
	} 
	
	public void update(HeroMaker hero) throws ClassNotFoundException, SQLException {
		if (con == null)
			getConnection();
		//update data
		PreparedStatement prep = con.prepareStatement("UPDATE users SET name = ?, type = ?, attack = ?, experience = ?, defense = ?, hitpoints = ?," +
				" level = ?, xp = ?, x = ?, y = ?, WHERE id = "+hero.getHeroid()+";"); //check mp updateinfo playerstats
		prep.setString(2, hero.getHeroName());
		prep.setString(3, hero.getHeroType());
		prep.setInt(4, hero.getHeroAttack());
		prep.setInt(5, hero.getexperience());
		prep.setInt(6, hero.getHeroDefense());
		prep.setInt(7, hero.getHeroHitPoints());
		prep.setInt(8, hero.getHeroLevel());
		prep.setInt(9, hero.getHeroXp());
		prep.setInt(10, hero.getx());
		prep.setInt(11, hero.gety());
		prep.execute();
		System.out.println("updated hero");
		prep.close();;
		
	} 
	
	//in order to continue game
	
	public ArrayList<String> getUsers() throws ClassNotFoundException, SQLException {
		
		ArrayList<String> result = new ArrayList<String>();
		if (con == null)
			getConnection();
		
		Statement state = con.createStatement();
		ResultSet res = state.executeQuery("SELECT * FROM users");
		
		while(res.next()) {
			result.add(res.getString("name"));
			result.add(res.getString("type"));
			result.add(res.getString("attack"));
			result.add(res.getString("experience"));
			result.add(res.getString("defence"));
			result.add(res.getString("hp"));
			result.add(res.getString("level"));
			result.add(res.getString("xp"));
			result.add(res.getString("x"));
			result.add(res.getString("y"));
			result.add(res.getString("id"));
			
		}
		return result;
		//getUsers is of type arrayList as it reuturns an arraylist.
		//should iterate through the array with a for loop to get the results	
		
	}
	
	public ResultSet lastInsert() throws ClassNotFoundException, SQLException {
		if (con == null)
			getConnection();
		
		PreparedStatement prep = con.prepareStatement("SELECT * FROM users order by `id` desc limit 1;");
		
		return prep.executeQuery();
		}
	
	public void updateCoordinates() throws ClassNotFoundException, SQLException {
		if (con == null)
			getConnection();
		ResultSet lastInfo = lastInsert();
		int idNo = lastInfo.getInt("id");
		System.out.println(idNo );

		//update data
		PreparedStatement prep = con.prepareStatement("UPDATE users SET x = ?, y = ?, WHERE id = "+idNo+";"); //check mp updateinfo playerstats
		
		prep.setInt(10, hero.getx());
		prep.setInt(11, hero.gety());
		prep.execute();
		System.out.println("updated hero");
		System.out.println(hero.gety());
		System.out.println(heromaker.getx());
		prep.close();
		
		
	}
	

}
