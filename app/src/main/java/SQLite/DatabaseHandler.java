package SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by alex on 16/01/2017.
 *
 * http://www.androidhive.info/2011/11/android-sqlite-database-tutorial/
 *
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1; //Database Version
    private static final String DATABASE_NAME = "LAMapp"; //Database Name

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

    
}