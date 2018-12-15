package roerohan.com.dscvitapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    ListView listView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listView = (ListView) findViewById(R.id.listview);
        //installedApps();

        ArrayList<String> arrayList = new ArrayList<>();
        List<PackageInfo> packagelist = getPackageManager().getInstalledPackages(0);
        final String appVersion[] = new String[packagelist.size()];
        final String datadir[] = new String[packagelist.size()];
        for(int i = 0,k=1; i<packagelist.size();i++){
            PackageInfo packageInfo = packagelist.get(i);
            if((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM)==0){
                String appName = packageInfo.applicationInfo.loadLabel(getPackageManager()).toString();
                Log.e("App Name:"+Integer.toString(k++),appName);
                arrayList.add(Integer.toString(k-1)+". "+ appName);
                appVersion[k-2] = packageInfo.versionName;
                datadir[k-2] = packageInfo.applicationInfo.dataDir;

            }
        }

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
        final ArrayList<String> finalArrayList = arrayList;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String temp = appVersion[position].toString();
                String dir = datadir[position].toString();

                Intent intent = new Intent(HomeActivity.this, DetailsActivity.class);

                intent.putExtra("version",temp);
                intent.putExtra("dir", dir);

                startActivity(intent);
            }
        });


    }
/*   public void installedApps(){
        List<PackageInfo> packagelist = getPackageManager().getInstalledPackages(0);
        for(int i = 0,k=1; i<packagelist.size();i++){
            PackageInfo packageInfo = packagelist.get(i);
            if((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM)==0){
                String appName = packageInfo.applicationInfo.loadLabel(getPackageManager()).toString();
                Log.e("App Name:"+Integer.toString(k++),appName);
                appNames = new String[packagelist.size()];
                appNames[i] = appName;
                size = packagelist.size();
            }
        }
    }*/
}
