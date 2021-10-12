package spil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Field {

    private int fieldPrice;
    private String fieldName;
    private String fieldText;

    public int getFieldPrice() {
        return fieldPrice;
    }

    public void setFieldPrice(int fieldPrice) {
        this.fieldPrice = fieldPrice;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldText() {
        return fieldText;
    }

    public void setFieldText(String fieldText) {
        this.fieldText = fieldText;
    }

    public Field(int fieldPrice, String fieldName, String fieldText) {
        this.fieldPrice = fieldPrice;
        this.fieldName = fieldName;
        this.fieldText = fieldText;
    }

    private List<Field> fields;

    public void setUpFields() {
        Field[] localFields = new Field[]{
                new Field(FieldConstants.Tower, FieldConstants.TowerName, FieldConstants.TowerText),
                new Field(FieldConstants.Crater, FieldConstants.CraterName, FieldConstants.CraterText),
                new Field(FieldConstants.PalaceGates, FieldConstants.PalaceGatesName, FieldConstants.PalaceGatesText),
                new Field(FieldConstants.ColdDesert, FieldConstants.ColdDesertName, FieldConstants.ColdDesertText),
                new Field(FieldConstants.WalledCity, FieldConstants.WalledCityName, FieldConstants.WalledCityText),
                new Field(FieldConstants.Monastary, FieldConstants.MonastaryName, FieldConstants.MonastaryText),
                new Field(FieldConstants.BlackCave, FieldConstants.BlackCaveName, FieldConstants.BlackCaveText),
                new Field(FieldConstants.HutsInTheMountain, FieldConstants.HutsInTheMountainName, FieldConstants.HutsInTheMountainText),
                new Field(FieldConstants.TheWerewall, FieldConstants.TheWerewallName, FieldConstants.TheWerewallText),
                new Field(FieldConstants.ThePit, FieldConstants.ThePitName, FieldConstants.ThePitText),
                new Field(FieldConstants.GoldMine, FieldConstants.GoldMineName, FieldConstants.GoldMineText)
        };
/*
        this.fields.add(
                new Field(FieldConstants.Tower, FieldConstants.TowerName, FieldConstants.TowerText)
        );
        this.fields.add(
                new Field(FieldConstants.Tower, FieldConstants.TowerName, FieldConstants.TowerText)
        );

 */

        Collections.addAll(this.fields, localFields);

    }


}
