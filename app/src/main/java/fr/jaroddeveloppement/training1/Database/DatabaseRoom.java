package fr.jaroddeveloppement.training1.Database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.Executors;

import fr.jaroddeveloppement.training1.model.UserEntity;


@Database(entities = {UserEntity.class}, exportSchema = false, version = 1)
public abstract class DatabaseRoom extends RoomDatabase {

    private static final String DB_Name = "DataRoom";
    private static DatabaseRoom instance;


    public static synchronized DatabaseRoom getInstance(Context pContext){
        if(instance == null){
                instance = Room.databaseBuilder(pContext.getApplicationContext(), DatabaseRoom.class, DB_Name)
                        .fallbackToDestructiveMigration()
                        .addCallback(roomCallback)
                        .build();
        }
        return instance;
    }

    public abstract UserDAO mUserDAO();

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){

        /**
         * Called when the database is created for the first time. This is called after all the
         * tables are created.
         *
         * @param db The database.
         */
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            Executors.newSingleThreadExecutor().execute(() -> {

                instance.mUserDAO().insertUser(new UserEntity("name", "firstName","age", "adress","zipCode", "country"));


            });

        }
    };
}
