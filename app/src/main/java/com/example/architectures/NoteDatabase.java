package com.example.architectures;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

//connect all different part and create instance of the database

@Database(entities = {Note.class,},version = 1)
public abstract class NoteDatabase extends RoomDatabase {
    //create our variable

    private static NoteDatabase instance; //we create this method we have to turn class into singleton
    public abstract NoteDao noteDao(); //use method to access our Dau //room subclasses
    public static synchronized NoteDatabase getInstance(Context context){ //singleton, only one thread can access the instance
        if (instance == null){
            //instance = Room.databaseBuilder(context.getApplicationContext(),NoteDatabase.class,"note_database").fallbackToDestructiveMigration().build();
            instance = Room.databaseBuilder(context.getApplicationContext(),NoteDatabase.class,"note_database").fallbackToDestructiveMigration().addCallback(roomCallback).build();

        }
        return instance;
        //next repository class, an abstraction layer between data source and rest of the app eg SQLITE AND SERVERS,provides clean API to rest of the app, the view model calls API from it
    }

    //populate initial values thus start with some values
    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        //ctrl+o
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) { //on create is the first time the app is opened
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute(); //execute in  on create then attach to database thus when instance is created it will execute onCreate and populate our table
        }
    };
    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void,Void>{
        private NoteDao noteDao;

        private PopulateDbAsyncTask(NoteDatabase db){
            noteDao = db.noteDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            noteDao.insert(new Note("Title1","Description1",1));
            noteDao.insert(new Note("Title2","Description2",2));
            noteDao.insert(new Note("Title3","Description3",3));
            return null;
        }
    }
}
//next view model
