package com.clp.entity;

import java.util.ArrayList;
import java.util.List;

import com.clp.data.DataStorage;
import com.clp.repository.Repository;
import com.clp.services.TextService;

public class PublicGroup extends Group {
	private String groupCode;
//	private String groupName;
	private TextService textService = new TextService();

	public PublicGroup() {
		super();
		this.groupCode = textService.generateCode();
	}

	public String getGroupCode() {
		return groupCode;
	}

	public boolean joinByCode(User user, String code) {
		int idUser = user.getId();
		User foundUser = getUserById(idUser);
		System.out.println(foundUser);
		System.out.println(idUser + " ");
		if (foundUser == null) {
			System.out.println(groupCode);
			if (code.equals(groupCode)) {
				addUser(user);
				return true;
			}
		}
		return false;
	}

	public void leaveGroup(User user) {
		int id = user.getId();
		deleteUser(id);
	}
	

//	@Override
//	public List<User> getUsers() {
//		Repository<User> userRepository = storage.getUsers();
//		List<User> users = userRepository.getAll();
//		return users;
//	}

//
//	@Override
//	public boolean deleteUser(int id) {
//		// TODO Auto-generated method stub
//		return super.deleteUser(id);
//	}
//

//	@Override
//	public User getUserById(int id) {
//		// TODO Auto-generated method stub
//		return super.getUserById(id);
//	}

//	public User findUserByName(String userName) {
//		Repository<User> userRepository = storage.getUsers();
//		User attemptedUser = userRepository.getFirst(user -> user.getUserName().equals(userName));
//		if (attemptedUser == null) {
//			return null;
//		}
//		return attemptedUser;
//	}
}
