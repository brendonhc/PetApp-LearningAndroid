package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.android.pets.data.PetContract.PetsDbEntry;

/**
 * Classe que intermedia a comunicação do app com sua base de dados local SQLite
 */
public class FeedReaderDbHelper extends SQLiteOpenHelper {

    /**
     * Versão do arquivo da base de dados
     * <p>
     *     Tem que ser modificada a cada atualização da estrutura da base de dados, como,
     * acréscimo/remoção/alteração de uma coluna.
     * </p>
     */
    private static final int DATABASE_VERSION = 1;
    /**
     * Nome da base de dados
     */
    private static final String DATABASE_NAME = "pets.db";

    /* Demais atributos estáticos para melhorar a manipulação e legibilidade do código*/

    /*TIPOS DE DADOS*/
    private static final String TEXT_TYPE = "TEXT";
    private static final String INTEGER_TYPE = "INTEGER";

    /*SEPARADORES*/
    private static final String COMMA_SEP = ",";

    /*KEYWORDS*/
    private static final String PRIMARY_KEY_KW = "PRIMARY KEY";
    private static final String AUTOINCREMENT_KW = "AUTOINCREMENT";
    private static final String NOT_NULL_KW = "NOT NULL";
    private static final String DEFAULT_KW = "DEFAULT";


    /*SQL's*/
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + PetsDbEntry.TABLE_NAME + " ("
                    + PetsDbEntry._ID + INTEGER_TYPE + PRIMARY_KEY_KW + AUTOINCREMENT_KW + COMMA_SEP
                    + PetsDbEntry.COLUMN_PET_NAME + TEXT_TYPE + COMMA_SEP
                    + PetsDbEntry.COLUMN_PET_BREED + TEXT_TYPE + NOT_NULL_KW + COMMA_SEP
                    + PetsDbEntry.COLUMN_PET_GENDER + TEXT_TYPE + NOT_NULL_KW + COMMA_SEP
                    + PetsDbEntry.COLUMN_PET_WEIGHT + INTEGER_TYPE + DEFAULT_KW + " 0" + COMMA_SEP +
            ")"
    ;

    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + PetsDbEntry.TABLE_NAME;



    /**
     * Construtor da base de dados interna do app
     * @param context
     */
    public FeedReaderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Método reescrito para criar a base de dados pela primeira vez
     * @param sqLiteDatabase Objeto que representa a base de dados, a principio, vazia
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Método "execSQL()" executa um comando sql na base de dados que NAO RETORNA VALORES,
        // neste caso, cria nosso base de dados e suas colunas
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }


    /**
     * Método que deleta a tabela e a recria
     * <p>
     *     Neste caso, é utilizado especialmente quando é feita uma alteração na estrutura da
     *     tabela, adicionando/removendo/modificando uma ou mais colunas.
     *     <p>
     *         ALTERAR O NUMERO DA VERSÃO EM "DATABASE_VERSION"
     *     </p>
     * </p>
     * @param sqLiteDatabase Objeto que representa a base de dados em questão
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }


}
