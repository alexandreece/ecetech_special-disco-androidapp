package SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 16/01/2017.
 *
 * http://www.androidhive.info/2011/11/android-sqlite-database-tutorial/
 *
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1; //Database Version
    private static final String DATABASE_NAME = "LAMapp.db"; //Database Name

    //★★★★★★★★★★★★★★★★★★★★★★★★★★★★

    //EQUIPES
    private static final String TABLE_EQUIPES = "Equipes"; //Nom Table
    private static final String KEY_ID_EQUIPE = "idEquipe"; //Colonnes
    private static final String KEY_NOM_EQUIPE = "nomEquipe";
    private static final String KEY_NBJOUEURS_EQUIPE = "nbJoueurs";

    //JOUEURS
    private static final String TABLE_JOUEURS = "Joueurs"; //Nom Table
    private static final String KEY_ID_JOUEUR = "idJoueur"; //Colonnes
    private static final String KEY_NOM_JOUEUR = "nomJoueur";

    //JOUEURS_HAS_EQUIPES
    private static final String TABLE_JOUEURS_HAS_EQUIPES = "Joueurs_has_Equipes"; //Nom Table

    //PREVIOUSWORDS
    private static final String TABLE_PREVIOUSWORDS = "PreviousWords"; //Nom Table
    private static final String KEY_ID_PREVIOUSWORDS = "idPreviousWords"; //Colonnes
    private static final String KEY_PREVIOUSWORD = "previousWord";

    //SCORES
    private static final String TABLE_SCORES = "Scores"; //Nom Table
    private static final String KEY_ID_SCORE = "idScore"; //Colonnes
    private static final String KEY_SCORE = "score";
    private static final String KEY_DATEJEU_SCORE = "dateJeu";
    private static final String KEY_NIVEAUJEU_SCORE = "niveauJeu";

    //WORDSLIST
    private static final String TABLE_WORDSLIST = "WordsList"; //Nom Table
    private static final String KEY_ID_WORD = "idWord"; //Colonnes
    private static final String KEY_CATEGORY = "category";
    private static final String KEY_WORD = "word";


    //★★★★★★★★★★★★★★★★★★★★★★★★★★★★
    //CONSTRUCTEUR
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    //★★★★★★★★★★★★★★★★★★★★★★★★★★★★

    //CREATION DES TABLES
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_EQUIPES = "CREATE TABLE " + TABLE_EQUIPES + " ("
                + KEY_ID_EQUIPE + " INTEGER PRIMARY KEY," + KEY_NOM_EQUIPE + " TEXT,"
                + KEY_NBJOUEURS_EQUIPE + " INTEGER)";
        String CREATE_TABLE_JOUEURS = "CREATE TABLE " + TABLE_JOUEURS + " ("
                + KEY_ID_JOUEUR + " INTEGER PRIMARY KEY," + KEY_NOM_JOUEUR + " TEXT)";
        String CREATE_TABLE_JOUEURS_HAS_EQUIPES = "CREATE TABLE " + TABLE_JOUEURS_HAS_EQUIPES + " ("
                + KEY_ID_JOUEUR + " INTEGER," + KEY_ID_EQUIPE + " INTEGER)";
        String CREATE_TABLE_PREVIOUSWORDS = "CREATE TABLE " + TABLE_PREVIOUSWORDS + " ("
                + KEY_ID_PREVIOUSWORDS + " INTEGER PRIMARY KEY," + KEY_PREVIOUSWORD + " TEXT)";
        String CREATE_TABLE_SCORES = "CREATE TABLE " + TABLE_SCORES + " ("
                + KEY_ID_SCORE + " INTEGER PRIMARY KEY," + KEY_SCORE + " INTEGER,"
                + KEY_DATEJEU_SCORE + " TEXT," + KEY_NIVEAUJEU_SCORE + " INTEGER,"
                + KEY_ID_EQUIPE + " INTEGER)";
        String CREATE_TABLE_WORDSLIST = "CREATE TABLE " + TABLE_WORDSLIST + " ("
                + KEY_ID_WORD + " INTEGER PRIMARY KEY,"
                + KEY_CATEGORY + " TEXT," + KEY_WORD + " TEXT)";

        db.execSQL(CREATE_TABLE_EQUIPES);
        db.execSQL(CREATE_TABLE_JOUEURS);
        db.execSQL(CREATE_TABLE_JOUEURS_HAS_EQUIPES);
        db.execSQL(CREATE_TABLE_PREVIOUSWORDS);
        db.execSQL(CREATE_TABLE_SCORES);
        db.execSQL(CREATE_TABLE_WORDSLIST);
    }

    //MISE À JOUR DE LA BASE

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EQUIPES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_JOUEURS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_JOUEURS_HAS_EQUIPES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PREVIOUSWORDS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SCORES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WORDSLIST);

        onCreate(db);
    }

    //★★★★★★★★★★★★★★★★★★★★★★★★★★★★
    //CRUD

    //CREATE
    void addEquipe(Equipe equipe){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NOM_EQUIPE, equipe.getNomEquipe());
        values.put(KEY_NBJOUEURS_EQUIPE, equipe.getNbJoueurs());

        db.insert(TABLE_EQUIPES, null, values);
        db.close();
    }

    void addJoueur(Joueur joueur){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NOM_JOUEUR, joueur.getNomJoueur());

        db.insert(TABLE_JOUEURS, null, values);
        db.close();
    }

    public void addPreviousWord(PreviousWord word){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_PREVIOUSWORD, word.getPreviousWord());

        db.insert(TABLE_PREVIOUSWORDS, null, values);
        db.close();
    }

    void addScore(Score score){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_SCORE,score.getScore());
        values.put(KEY_DATEJEU_SCORE,score.getDateJeu());
        values.put(KEY_NIVEAUJEU_SCORE,score.getNiveauJeu());
        values.put(KEY_ID_EQUIPE, score.getEquipes_idEquipe());

        db.insert(TABLE_SCORES, null, values);
        db.close();
    }

    void addWord(Word word){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_CATEGORY,word.getCategory());
        values.put(KEY_WORD,word.getWord());

        db.insert(TABLE_WORDSLIST, null, values);
        db.close();
    }

    //READ SINGLE
    Equipe getEquipe(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_EQUIPES, new String[] { KEY_ID_EQUIPE, KEY_NOM_EQUIPE, KEY_NBJOUEURS_EQUIPE }, KEY_ID_EQUIPE + "=?", new String[]{ String.valueOf(id)},null,null,null,null);
        if (cursor!=null)
            cursor.moveToFirst();

        Equipe equipe = new Equipe(Integer.parseInt(cursor.getString(0)),cursor.getString(1), Integer.parseInt(cursor.getString(2)));
        return equipe;
    }

    Joueur getJoueur(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_JOUEURS, new String[] { KEY_ID_JOUEUR, KEY_NOM_JOUEUR }, KEY_ID_JOUEUR + "=?", new String[]{ String.valueOf(id)},null,null,null,null);
        if (cursor!=null)
            cursor.moveToFirst();

        Joueur joueur = new Joueur(Integer.parseInt(cursor.getString(0)),cursor.getString(1));
        return joueur;
    }

    PreviousWord getPreviousWord(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_PREVIOUSWORDS, new String[] { KEY_ID_PREVIOUSWORDS, KEY_PREVIOUSWORD }, KEY_ID_PREVIOUSWORDS + "=?", new String[]{String.valueOf(id)},null,null,null,null);
        if (cursor!=null)
            cursor.moveToFirst();

        PreviousWord previousWord = new PreviousWord(Integer.parseInt(cursor.getString(0)),cursor.getString(1));
        return previousWord;
    }

    Score getScore(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_SCORES, new String[] { KEY_ID_SCORE, KEY_SCORE, KEY_DATEJEU_SCORE, KEY_NIVEAUJEU_SCORE, KEY_ID_EQUIPE }, KEY_ID_SCORE + "=?", new String[]{ String.valueOf(id)},null,null,null,null);
        if (cursor!=null)
            cursor.moveToFirst();

        Score score = new Score(Integer.parseInt(cursor.getString(0)),Integer.parseInt(cursor.getString(1)),cursor.getString(2),Integer.parseInt(cursor.getString(3)),Integer.parseInt(cursor.getString(4)));
        return score;
    }

    Word getWord(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_WORDSLIST, new String[] {  KEY_ID_WORD, KEY_CATEGORY, KEY_WORD }, KEY_ID_WORD + "=?", new String[]{ String.valueOf(id)},null,null,null,null);
        if (cursor!=null)
            cursor.moveToFirst();

        Word word = new Word(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2));
        return word;
    }

    //READ ALL
    public List<Equipe> getAllEquipes() {
        List<Equipe> equipes = new ArrayList<Equipe>();
        String selectQuery = "SELECT * FROM " + TABLE_EQUIPES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);

        if (cursor.moveToFirst()){
            do {
                Equipe equipe = new Equipe();
                equipe.setIdEquipe(Integer.parseInt(cursor.getString(0)));
                equipe.setNomEquipe(cursor.getString(1));
                equipe.setNbJoueurs(Integer.parseInt(cursor.getString(2)));

                equipes.add(equipe);
            }while (cursor.moveToNext());
        }
        return equipes;
    }

    public List<Joueur> getAllJoueurs() {
        List<Joueur> joueurs = new ArrayList<Joueur>();
        String selectQuery = "SELECT * FROM " + TABLE_JOUEURS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);

        if (cursor.moveToFirst()){
            do {
                Joueur joueur = new Joueur();
                joueur.setIdJoueur(Integer.parseInt(cursor.getString(0)));
                joueur.setNomJoueur(cursor.getString(1));

                joueurs.add(joueur);
            }while (cursor.moveToNext());
        }
        return joueurs;
    }

    public List<PreviousWord> getAllPreviousWords() {
        List<PreviousWord> previousWordList = new ArrayList<PreviousWord>();
        String selectQuery = "SELECT * FROM " + TABLE_PREVIOUSWORDS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);

        if (cursor.moveToFirst()){
            do {
                PreviousWord word = new PreviousWord();
                word.setIdPreviousWord(Integer.parseInt(cursor.getString(0)));
                word.setPreviousWord(cursor.getString(1));

                previousWordList.add(word);
            }while (cursor.moveToNext());
        }
        return previousWordList;
    }

    public List<Score> getAllScores() {
        List<Score> scores = new ArrayList<Score>();
        String selectQuery = "SELECT * FROM " + TABLE_SCORES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);

        if (cursor.moveToFirst()){
            do {
                Score score = new Score();
                score.setIdScore(Integer.parseInt(cursor.getString(0)));
                score.setScore(Integer.parseInt(cursor.getString(1)));
                score.setDateJeu(cursor.getString(2));
                score.setNiveauJeu(Integer.parseInt(cursor.getString(3)));
                score.setEquipes_idEquipe(Integer.parseInt(cursor.getString(4)));

                scores.add(score);
            }while (cursor.moveToNext());
        }
        return scores;
    }

    public List<Word> getWordsList() {
        List<Word> wordList = new ArrayList<Word>();
        String selectQuery = "SELECT * FROM " + TABLE_WORDSLIST;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);

        if (cursor.moveToFirst()){
            do {
                Word word = new Word();
                word.setIdWord(Integer.parseInt(cursor.getString(0)));
                word.setCategory(cursor.getString(1));
                word.setWord(cursor.getString(2));

                wordList.add(word);
            }while (cursor.moveToNext());
        }
        return wordList;
    }
}