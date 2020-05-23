package ngo.sapne.intents.sapne;

import java.util.ArrayList;


public class SectionModel {
    private String sectionLabel;
    private ArrayList<String> itemArrayList;
    private ArrayList<String> itemArrayList1;
    private ArrayList<Integer> itemArrayList2;
    private ArrayList<Integer> itemArrayList3;



    public SectionModel(String sectionLabel, ArrayList<String> itemArrayList, ArrayList<String> itemArrayList1, ArrayList<Integer> itemArrayList2, ArrayList<Integer> itemArrayList3) {
        this.sectionLabel = sectionLabel;
        this.itemArrayList = itemArrayList;
        this.itemArrayList1 = itemArrayList1;
        this.itemArrayList2 = itemArrayList2;
        this.itemArrayList3 = itemArrayList3;
    }

    public String getSectionLabel() {
        return sectionLabel;
    }

    public ArrayList<String> getItemArrayList() {
        return itemArrayList;
    }
    public ArrayList<String> getItemArrayList1() {
        return itemArrayList1;
    }
    public ArrayList<Integer> getItemArrayList2() {
        return itemArrayList2;
    }
    public ArrayList<Integer> getItemArrayList3() {
        return itemArrayList3;
    }
}
