package ngo.sapne.intents.sapne;

/**
 * Created by Pankaj on 17-01-2018.
 */

public class RegularCampItem {

    private int imageCamp;
    private int txtCamp;

    public RegularCampItem(int imageCamp, int txtCamp) {
        this.imageCamp = imageCamp;
        this.txtCamp = txtCamp;
    }

    public int getImageCamp() {
        return imageCamp;
    }

    public void setImageCamp(int imageCamp) {
        this.imageCamp = imageCamp;
    }

    public int getTxtCamp() {
        return txtCamp;
    }

    public void setTxtCamp(int txtCamp) {
        this.txtCamp = txtCamp;
    }
}
