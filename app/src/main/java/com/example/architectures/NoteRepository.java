package com.example.architectures;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteRepository {
    private NoteDao noteDao;
    private LiveData<List<Note>> allNote;

    //constructor to assign those variables
    public NoteRepository (Application application){ //Application is the context
        NoteDatabase database = NoteDatabase.getInstance(application);
        noteDao = database.noteDao();
        allNote = noteDao.getAllNotes();
    }
    //methods for all database operations are API that Repository exposes outwards
    public  void insert(Note note){
        new InsertNoteAsyncTask(noteDao).execute(note);
    }
    public  void update(Note note){
        new UpdateNoteAsyncTask(noteDao).execute(note);
    }
    public  void delete(Note note){
        new DeleteNoteAsyncTask(noteDao).execute(note);
    }
    public  void deleteAllNotes(){
        new DeleteAllNoteAsyncTask(noteDao).execute();
    }
    public LiveData<List<Note>> getAllNote() {
        return allNote;
    }
    //use AsyncTask
    private static class InsertNoteAsyncTask extends AsyncTask<Note,Void,Void>{
        private NoteDao noteDao;

        public InsertNoteAsyncTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.insert(notes[0]);
            return null;
        }
    }
    private static class UpdateNoteAsyncTask extends AsyncTask<Note,Void,Void>{
        private NoteDao noteDao;

        public UpdateNoteAsyncTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.update(notes[0]);
            return null;
        }
    }
    private static class DeleteNoteAsyncTask extends AsyncTask<Note,Void,Void>{
        private NoteDao noteDao;

        public DeleteNoteAsyncTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }
        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.delete(notes[0]);
            return null;
        }
    }
    private static class DeleteAllNoteAsyncTask extends AsyncTask<Void,Void,Void>{
        private NoteDao noteDao;

        public DeleteAllNoteAsyncTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            noteDao.deleteAllNotes();
            return null;
        }
    }
}
//one more change to NoteDatabase class to fill the recycler view with some values i.e initial values