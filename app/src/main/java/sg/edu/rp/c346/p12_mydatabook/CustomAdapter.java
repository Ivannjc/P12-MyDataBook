package sg.edu.rp.c346.p12_mydatabook;

/**
 * Created by 15017608 on 11/8/2017.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class CustomAdapter extends ArrayAdapter<String> {
    private ArrayList<String> items;
    private Context context;
    private TextView tvTitle;
    private ImageView iv;

    public CustomAdapter(Context context, int resource, ArrayList<String> objects) {
        super(context, resource, objects);
        items = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);
        tvTitle = (TextView) rowView.findViewById(R.id.tvTitle);
        iv = (ImageView) rowView.findViewById(R.id.imageView);

        String current = items.get(position);
        tvTitle.setText(current);

        if (current == "Bio") {
            iv.setImageResource(android.R.drawable.ic_menu_info_details);
        } else if (current == "Vaccination") {
            iv.setImageResource(android.R.drawable.ic_menu_edit);
        } else if (current == "Anniversary") {
            iv.setImageResource(android.R.drawable.ic_menu_today);
        } else if (current == "About Us") {
            iv.setImageResource(android.R.drawable.btn_star_big_on);
        }

        return rowView;
    }
}
