package fr.jaroddeveloppement.training1.repository;

import androidx.lifecycle.LiveData;

import java.util.List;

import fr.jaroddeveloppement.training1.Database.UserDAO;
import fr.jaroddeveloppement.training1.model.UserEntity;

public class UserRepository {

    private UserDAO mUserDAO;

    public UserRepository(UserDAO pUserDAO) {
        mUserDAO = pUserDAO;
    }

    public void insert (UserEntity pUserEntity) { mUserDAO.insertUser(pUserEntity);}
    public void update (UserEntity pUserEntity) {mUserDAO.updateUser(pUserEntity);}
    public void delete (UserEntity pUserEntity) {mUserDAO.deleteUser(pUserEntity);}

    public LiveData<List<UserEntity>>getAllUser(){
        return mUserDAO.getUserList();
    }
}
