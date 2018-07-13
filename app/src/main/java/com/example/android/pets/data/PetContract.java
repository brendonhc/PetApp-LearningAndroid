package com.example.android.pets.data;

import android.provider.BaseColumns;

/**
 *  Classe de contratos definidos para o aplicativo
 *
 *  <p>
 *  A Classe conta com classes atributos e métodos estáticos e globais (static final) para auxiliar
 *  o a codificação e legibilidade do código em sua completude
 *  </p>
 */
public final class PetContract {

    /**
     * Constantes para os campos da tabela "pets" da base de dados
     */
    public static final class PetsDbEntry implements BaseColumns {
        public static final String TABLE_NAME = "pets_table";

        public static final String _ID = "_id";
        public static final String COLUMN_PET_NAME = "name";
        public static final String COLUMN_PET_BREED = "breed";
        public static final String COLUMN_PET_GENDER = "gender";
        public static final String COLUMN_PET_WEIGHT = "weight";

        public static final int GENDRR_MALE = 1;
        public static final int GENDER_FEMALE = 2;
        public static final int GENDER_UNKNOW = 0;
    }

}
