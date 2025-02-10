package com.example.launcher;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AppAdapter extends ArrayAdapter<ResolveInfo> {
    private final PackageManager packageManager;

    public AppAdapter(Context context, int resource, List<ResolveInfo> apps, PackageManager packageManager) {
        super(context, resource, apps);
        this.packageManager = packageManager;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_lista, parent, false);
        }

        ResolveInfo appInfo = getItem(position);
        ImageView imageViewAppIcon = convertView.findViewById(R.id.app_icon);
        TextView textViewAppName = convertView.findViewById(R.id.app_name);

        imageViewAppIcon.setImageDrawable(appInfo.loadIcon(packageManager));
        textViewAppName.setText(appInfo.loadLabel(packageManager));

        return convertView;
    }
}