package ngo.sapne.intents.sapne;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

/**
 * Created by Shiva on 27/02/2018.
 */

public class Admin_fragment_support extends Activity {
    Intent data;
    Uri selectedImage = data.getData();
    String[] filePathColumn = { MediaStore.Images.Media.DATA };

    public Cursor method() {
        Cursor cursor = getContentResolver().query(selectedImage,
                filePathColumn, null, null, null);
        cursor.moveToFirst();
        return cursor;
    }
}
