package ngo.sapne.intents.sapne.events;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.InfiniteScrollAdapter;

import java.lang.ref.WeakReference;

import ngo.sapne.intents.sapne.R;

public class DiscreteScrollViewOptions {

    private static DiscreteScrollViewOptions instance;

    public static void init(Context context) {
        instance = new DiscreteScrollViewOptions();
    }

    public static void smoothScrollToUserSelectedPosition(final DiscreteScrollView scrollView, View anchor) {
        PopupMenu popupMenu = new PopupMenu(scrollView.getContext(), anchor);
        Menu menu = popupMenu.getMenu();
        final RecyclerView.Adapter adapter = scrollView.getAdapter();
        int itemCount = (adapter instanceof InfiniteScrollAdapter) ?
                ((InfiniteScrollAdapter) adapter).getRealItemCount() :
                adapter.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            menu.add(String.valueOf(i + 1));
        }
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int destination = Integer.parseInt(String.valueOf(item.getTitle())) - 1;
                if (adapter instanceof InfiniteScrollAdapter) {
                    destination = ((InfiniteScrollAdapter) adapter).getClosestPosition(destination);
                }
                scrollView.smoothScrollToPosition(destination);
                return true;
            }
        });
        popupMenu.show();
    }

    private static SharedPreferences defaultPrefs() {
        return PreferenceManager.getDefaultSharedPreferences(App.getInstance());
    }
}