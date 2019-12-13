package user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserServiceDAO {

	private static List<User> users=new ArrayList<User>();
	private static int userCount=3;
	
	static {
		users.add(new User(1, "Devdyuti", new Date()));
		users.add(new User(2, "Jitender", new Date()));
		users.add(new User(3, "Sudhir", new Date()));
	}
	
	public List<User> findAll(){
		return users;
	}
	public User saveUser(User user) {
		if(user.getId()==null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	public User findOne(int id) {
		for(User user: users) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
	}
	public User deleteById(int id) {
		Iterator<User> itr=users.iterator();
		while (itr.hasNext()) {
			User user=itr.next();
			if(user.getId()==id) {
				itr.remove();
				return user;
			}
		}
		return null;
	}
}
