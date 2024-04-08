package fpoly.huyndph40487.qlda_bantrsua.base;

import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import fpoly.huyndph40487.qlda_bantrsua.MainActivity;

public class NavHelper {
    MainActivity activity;
    NavController navController;

    public NavHelper(MainActivity activity, int navId) {
        this.activity = activity;
        NavHostFragment navHostFragment = (NavHostFragment) activity.getSupportFragmentManager().findFragmentById(navId);
        if (navHostFragment != null) {
            navController = navHostFragment.getNavController();
        }
    }

    public void navigate(int layoutId) {
        navController.navigate(layoutId);
    }
}
