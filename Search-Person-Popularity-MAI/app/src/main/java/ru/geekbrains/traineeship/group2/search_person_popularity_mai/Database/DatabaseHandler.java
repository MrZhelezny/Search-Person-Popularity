package ru.geekbrains.traineeship.group2.search_person_popularity_mai.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.List;

/**
 * Created by skubatko on 27/10/17.
 */

public class DatabaseHandler extends SQLiteOpenHelper implements IDatabaseHandler {

    /**
     * Имя файла базы данных
     */
    private static final String DATABASE_NAME = "searchPersonPopularity.db";

    /**
     * Версия базы данных. При изменении схемы увеличить на единицу
     */
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_PERSONS = "persons";
    private static final String TABLE_KEYWORDS = "keywords";
    private static final String TABLE_SITES = "sites";

    private static final String KEY_ID = "_id";

    private static final String TABLE_PERSONS_FIELD_NAME = "name";

    private static final String TABLE_KEYWORDS_FIELD_NAME = "name";
    private static final String TABLE_KEYWORDS_FIELD_PERSON_ID = "person_id";

    private static final String TABLE_SITES_FIELD_NAME = "name";

    /**
     * Конструктор {@link DatabaseHandler}.
     *
     * @param context Контекст приложения
     */
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Вызывается при создании базы данных
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

//      SQL запрос для создания таблицы Persons:
//      CREATE TABLE persons (
//          _id     INTEGER     PRIMARY KEY AUTOINCREMENT,
//          name    TEXT        NOT NULL
//      );
        String CREATE_PERSONS_TABLE = "CREATE TABLE " + TABLE_PERSONS + " (" +
                KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TABLE_PERSONS_FIELD_NAME + " TEXT NOT NULL" +
                ");";

//      SQL запрос для таблицы Keywords:
//      CREATE TABLE keywords (
//          _id         INTEGER     PRIMARY KEY AUTOINCREMENT,
//          name        TEXT        NOT NULL,
//          person_id   INTEGER     NOT NULL,
//          FOREIGN KEY(person_id) REFERENCES persons(_id)
//      );
        String CREATE_KEYWORDS_TABLE = "CREATE TABLE " + TABLE_KEYWORDS + " (" +
                KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TABLE_KEYWORDS_FIELD_NAME + " TEXT NOT NULL, " +
                TABLE_KEYWORDS_FIELD_PERSON_ID + " INTEGER NOT NULL, " +
                "FOREIGN KEY(" + TABLE_KEYWORDS_FIELD_PERSON_ID + ") REFERENCES " + TABLE_PERSONS + "(" + KEY_ID + ")" +
                ");";

//      SQL запрос для таблицы Sites:
//      CREATE TABLE sites (
//          _id     INTEGER     PRIMARY KEY AUTOINCREMENT,
//          name    TEXT        NOT NULL
//      );
        String CREATE_SITES_TABLE = "CREATE TABLE " + TABLE_SITES + " (" +
                KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TABLE_SITES_FIELD_NAME + " TEXT NOT NULL" +
                ");";

        db.execSQL(CREATE_PERSONS_TABLE);
        db.execSQL(CREATE_KEYWORDS_TABLE);
        db.execSQL(CREATE_SITES_TABLE);
        Log.d("onCreate", "Таблицы базы данных созданы");
    }

    /**
     * Вызывается при обновлении схемы базы данных
     * Увеличение версии схемы
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PERSONS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_KEYWORDS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SITES);

        onCreate(db);
    }

    /**
     * Вызывается при обновлении схемы базы данных
     * Уменьшение версии схемы
     */
    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PERSONS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_KEYWORDS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SITES);
        Log.d("onDowngrade", "Таблицы базы данных удалены");

        onCreate(db);
    }

    public void showDatabaseInfo() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                TABLE_PERSONS,                              // таблица
                new String[]{TABLE_PERSONS_FIELD_NAME},    // столбцы
                null,                                       // столбцы для условия WHERE
                null,                                       // значения для условия WHERE
                null,                                       // Don't group the rows
                null,                                       // Don't filter by row groups
                null                                        // порядок сортировки
        );

        try {
            Log.d("DB", "Table: " + TABLE_PERSONS + " содержит: " + cursor.getCount() + " записей");

        } finally {
            // Всегда закрываем курсор после чтения
            cursor.close();
        }

    }

    @Override
    public void AddPerson(Person person) {

    }

    @Override
    public Person getPerson(int id) {
        return null;
    }

    @Override
    public List getAllPersons() {
        return null;
    }

    @Override
    public int getPersonsCount() {
        return 0;
    }

    @Override
    public int updatePerson(Person person) {
        return 0;
    }

    @Override
    public void deletePerson(Person person) {

    }

    @Override
    public void deleteAllPersons() {

    }

    @Override
    public void AddKeyword(Keyword keyword) {

    }

    @Override
    public Keyword getKeyword(int id) {
        return null;
    }

    @Override
    public List getAllKeywords() {
        return null;
    }

    @Override
    public int getKeywordsCount() {
        return 0;
    }

    @Override
    public int updateKeyword(Keyword keyword) {
        return 0;
    }

    @Override
    public void deleteKeyword(Keyword keyword) {

    }

    @Override
    public void deleteAllKeywords() {

    }

    @Override
    public void AddSite(Site site) {

    }

    @Override
    public Site getSite(int id) {
        return null;
    }

    @Override
    public List getAllSites() {
        return null;
    }

    @Override
    public int getSitesCount() {
        return 0;
    }

    @Override
    public int updateSite(Site site) {
        return 0;
    }

    @Override
    public void deleteSite(Site site) {

    }

    @Override
    public void deleteAllSites() {

    }
}
