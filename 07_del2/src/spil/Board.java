package spil;

import java.util.Arrays;
import java.util.List;

public class Board {
    private List<Field> fields;

    //Field Objects that includes ID, Money Count, Field name and Field flavor text
    private static final List<Field> startupFields = Arrays.asList(
            new Field(FieldConstants.TOWER_ID, FieldConstants.TOWER_AMOUNT, FieldConstants.TOWER_NAME, FieldConstants.TOWER_TEXT),
            new Field(FieldConstants.CRATER_ID, FieldConstants.CRATER_AMOUNT, FieldConstants.CRATER_NAME, FieldConstants.CRATER_TEXT),
            new Field(FieldConstants.PALACE_GATES_ID, FieldConstants.PALACE_GATES_AMOUNT, FieldConstants.PALACE_GATES_NAME, FieldConstants.PALACE_GATES_TEXT),
            new Field(FieldConstants.COLD_DESERT_ID, FieldConstants.COLD_DESERT_AMOUNT, FieldConstants.COLD_DESERT_NAME, FieldConstants.COLD_DESERT_TEXT),
            new Field(FieldConstants.WALLED_CITY_ID, FieldConstants.WALLED_CITY_AMOUNT, FieldConstants.WALLED_CITY_NAME, FieldConstants.WALLED_CITY_TEXT),
            new Field(FieldConstants.MONASTARY_ID, FieldConstants.MONASTARY_AMOUNT, FieldConstants.MONASTARY_NAME, FieldConstants.MONASTARY_TEXT),
            new Field(FieldConstants.BLACK_CAVE_ID, FieldConstants.BLACK_CAVE_AMOUNT, FieldConstants.BLACK_CAVE_NAME, FieldConstants.BLACK_CAVE_TEXT),
            new Field(FieldConstants.HUTS_IN_THE_MOUNTAIN_ID, FieldConstants.HUTS_IN_THE_MOUNTAIN_AMOUNT, FieldConstants.HUTS_IN_THE_MOUNTAIN_NAME, FieldConstants.HUTS_IN_THE_MOUNTAIN_TEXT),
            new Field(FieldConstants.THE_WEREWALL_ID, FieldConstants.THE_WEREWALL_AMOUNT, FieldConstants.THE_WEREWALL_NAME, FieldConstants.THE_WEREWALL_TEXT),
            new Field(FieldConstants.THE_PIT_ID, FieldConstants.THE_PIT_AMOUNT, FieldConstants.THE_PIT_NAME, FieldConstants.THE_PIT_TEXT),
            new Field(FieldConstants.GOLD_MINE_ID, FieldConstants.GOLD_MINE_AMOUNT, FieldConstants.GOLD_MINE_NAME, FieldConstants.GOLD_MINE_TEXT)
    );

    //Gets the chosen field value from the list
    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    // Constructor for Field that creates objects
    public Board(List<Field> fields) {
        this.fields = fields;
    }

    // Constructor for Field that creates objects
    public Board() {
        this.fields = startupFields;
    }
}
