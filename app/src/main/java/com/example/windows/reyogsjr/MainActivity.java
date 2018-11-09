package com.example.windows.reyogsjr;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.example.windows.reyogsjr.Bottom.HomeFragment;
import com.example.windows.reyogsjr.Bottom.MusikFragment;
import com.example.windows.reyogsjr.Bottom.TokohFragment;
import com.example.windows.reyogsjr.Bottom.VideoFragment;
import com.example.windows.reyogsjr.Web.Facebook;
import com.example.windows.reyogsjr.Web.Instagram;
import com.example.windows.reyogsjr.Web.Twitter;
import com.example.windows.reyogsjr.Web.Youtube;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity {

    private BottomBar bottomBar;

    private Drawer.Result navigationDrawerLeft;
    private AccountHeader.Result headerNavigationLeft;

    private ShareActionProvider mShareActionProvider;

    private AlertDialog.Builder alertDialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alertDialogBuilder = new AlertDialog.Builder(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //==========================================================================================
        headerNavigationLeft = new  AccountHeader()
                .withActivity(this)
                .withCompactStyle(false)
                .withSavedInstance(savedInstanceState)
                .withHeaderBackground(R.color.colorPrimary)
                .addProfiles(
                        new ProfileDrawerItem()
                                .withName("Reyog Singo Joyo Rekso")
                                .withEmail("singojoyorekso@gmail.com")
                                .withIcon(getResources()
                                        .getDrawable(R.drawable.logo))
                )
                .build();

        navigationDrawerLeft = new Drawer()
                .withActivity(this)
                .withToolbar(toolbar)
                .withDisplayBelowToolbar(false)
                .withActionBarDrawerToggleAnimated(true)
                .withDrawerGravity(Gravity.LEFT)
                .withSavedInstance(savedInstanceState)
                .withAccountHeader(headerNavigationLeft)
                .withSelectedItem(0)
                .build();

        navigationDrawerLeft
                .addItem(new PrimaryDrawerItem()
                .withName("Instagram")
                .withIcon(getResources().getDrawable(R.drawable.ic_image_black_24dp)));
        navigationDrawerLeft
                .addItem(new PrimaryDrawerItem()
                        .withName("Youtube")
                        .withIcon(getResources().getDrawable(R.drawable.ic_ondemand_video_black_24dp)));
        navigationDrawerLeft
                .addItem(new PrimaryDrawerItem()
                        .withName("Twitter")
                        .withIcon(getResources().getDrawable(R.drawable.ic_public_black_24dp)));
        navigationDrawerLeft
                .addItem(new PrimaryDrawerItem()
                        .withName("Facebook")
                        .withIcon(getResources().getDrawable(R.drawable.ic_share_black_24dp)));

        navigationDrawerLeft.setOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id, IDrawerItem drawerItem) {
                Intent intent = null;
                switch (position) {
                    case 1:
                        intent = new Intent(MainActivity.this, Youtube.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this, Twitter.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(MainActivity.this, Facebook.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(MainActivity.this, Instagram.class);
                        startActivity(intent);
                        break;
                    default:
                        Log.d("Test","Default");
                        break;
                }
            }
        });

        //==========================================================================================

        bottomBar = (BottomBar)findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {

            Fragment fragment = null;
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.tab_home ){
                    fragment = new HomeFragment();
                }else if (tabId == R.id.tab_tokoh){
                    fragment = new TokohFragment();
                }else if (tabId == R.id.tab_musik){
                    fragment = new MusikFragment();
                }else if (tabId == R.id.tab_video){
                    fragment = new VideoFragment();
                }
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content, fragment)
                        .commit();
            }
        });
    }

    //==========================================================================================

//    @Override
//    public void onBackPressed(){
//        alertDialogBuilder.setTitle("Tutup Aplikasi");
//        alertDialogBuilder
//                .setMessage("Apakah Anda yakin menutup Aplikasi")
//                .setCancelable(false)
//                .setPositiveButton("YA", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                   //YA
//                   dialog.cancel();
//                    }
//                })
//                .setNegativeButton("TIDAK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        //Tidak
//                        dialog.cancel();
//                    }
//                }).create().show();
//    }

    //==========================================================================================

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()){
            case R.id.mShare:
            Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=com.baaghidevelopers.proxy.vpn");
                startActivity(Intent.createChooser(intent,"Share Via"));
                break;
        }
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            Intent intent = new Intent(MainActivity.this, TentangActivity.class);
//            startActivity(intent);
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
        return false;
    }
}
