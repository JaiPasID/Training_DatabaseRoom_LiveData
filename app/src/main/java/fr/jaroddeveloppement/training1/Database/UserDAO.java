package fr.jaroddeveloppement.training1.Database;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import fr.jaroddeveloppement.training1.model.UserEntity;

import java.util.List;



@Dao
public interface UserDAO {

    @Query ("SELECT * FROM data_user")
    LiveData<List<UserEntity>> getUserList();

    @Query("DELETE FROM data_user")
    void deleteAllUser();


    @Insert
    void insertUser(UserEntity pUserEntity);

    @Update
    void updateUser(UserEntity pUserEntity);

    @Delete
    void deleteUser (UserEntity pUserEntity);
}
