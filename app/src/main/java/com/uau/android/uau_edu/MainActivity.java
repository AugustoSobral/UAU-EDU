package com.uau.android.uau_edu;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.os.Handler;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;
import com.uau.android.uau_edu.Start_Login_Register.StartActivity;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    boolean doubleBackToExitPressedOnce = false;
    private Toast toastExit;

    private TextView text_view_name_header;
    private TextView text_view_email_header;
    private ImageView image_profile_header;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        final NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        View headerView = navigationView.getHeaderView(0);

        text_view_name_header = headerView.findViewById(R.id.text_view_header_name);
        text_view_email_header = headerView.findViewById(R.id.text_view_header_email);
        image_profile_header = headerView.findViewById(R.id.profile_pic_nav_header);

        text_view_email_header.setText("cliente@gmail.com");
        text_view_name_header.setText("Cliente Nome Teste");
        Picasso.get().load(R.drawable.logo_branco).placeholder(R.drawable.logo_branco)
                .into(image_profile_header);


        //Quando a main activity for criada este código abrirá o fragment inicial, usa-se a verificação savedInstance para evitar criação de mais de um fragment em mudanças de config.
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragments_container, new DividasFragment()).commit();
            getSupportActionBar().setTitle("Dívidas");
            navigationView.setCheckedItem(R.id.nav_dividas); //Muda o cursor no NavView para a opção inicial.
        }
    }

    //Configura um ClickListener pra uma dialog box de confirmação para logout.
    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
                case DialogInterface.BUTTON_POSITIVE:
                    //Yes button clicked
                    //signout();
                    Intent intent = new Intent(MainActivity.this, StartActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    break;

                case DialogInterface.BUTTON_NEGATIVE:
                    //No button clicked
                    break;
            }
        }
    };

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        // Handle navigation view item clicks here.
        switch (menuItem.getItemId()) {

            case (R.id.nav_logout):

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("Fazer Logout").setMessage("Tem certeza que deseja sair da sua conta?")
                            .setNegativeButton("Cancelar", dialogClickListener)
                            .setPositiveButton("Sim", dialogClickListener).show();

                break;

            case (R.id.nav_dividas):
                getSupportFragmentManager().beginTransaction().replace(R.id.fragments_container, new DividasFragment()).commit();
                getSupportActionBar().setTitle("Dívidas");
                break;

            case (R.id.nav_interacao):
                getSupportFragmentManager().beginTransaction().replace(R.id.fragments_container, new SolucoesFragment()).commit();
                getSupportActionBar().setTitle("Tela 5");
                break;

            case (R.id.nav_tela6):
                getSupportFragmentManager().beginTransaction().replace(R.id.fragments_container, new DicasFragment()).commit();
                getSupportActionBar().setTitle("Tela 6");
                break;
        }

        drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //Duplo click para fechar o app.
    @Override
    public void onBackPressed() {
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.fragments_container);

        if (getSupportFragmentManager().getBackStackEntryCount() == 0 || currentFragment instanceof DividasFragment || currentFragment instanceof DicasFragment || currentFragment instanceof SolucoesFragment) {
            drawer = findViewById(R.id.drawer_layout);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            }
            //Duplo click em voltar para fechar o aplicativo, qnd o drawer não está a mostra, senão ele só fecha o drawer.
            else {
                if (doubleBackToExitPressedOnce) {
                    finishAffinity();
                    return;
                }
                this.doubleBackToExitPressedOnce = true;
                toastExit = Toast.makeText(this, "Pressione novamente para sair", Toast.LENGTH_LONG);
                toastExit.show();

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        doubleBackToExitPressedOnce = false;
                    }
                }, 2000);
            }
        } else {
            getSupportFragmentManager().popBackStack();
        }
    }

    //Fechar a toastExit mais rápido depois que o app fechar.
    @Override
    protected void onDestroy() {
        if (toastExit != null)
            toastExit.cancel();
        super.onDestroy();
    }
}
