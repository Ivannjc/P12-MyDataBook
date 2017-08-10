package sg.edu.rp.c346.p12_mydatabook;


import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragBio extends Fragment {


    Button btnEdit;
    TextView tv;

    public FragBio() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frag_bio, container, false);
        btnEdit = (Button)view.findViewById(R.id.btnEditBio);
        tv = (TextView)view.findViewById(R.id.tvBio);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String bio = prefs.getString("bio", "");
        tv.setText(bio);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout ll = (LinearLayout)inflater.inflate(R.layout.bio, null);
                final EditText et = (EditText)ll.findViewById(R.id.et);
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Edit Bio")
                        .setView(ll)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String e = et.getText().toString();
                                Toast.makeText(getActivity(), "You had entered " +
                                        e, Toast.LENGTH_LONG).show();
                                tv.setText(e);

                                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
                                SharedPreferences.Editor prefEdit = prefs.edit();
                                prefEdit.putString("bio", e);
                                prefEdit.commit();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                AlertDialog alertDialog = builder.create();
                alertDialog.setCancelable(false);
                alertDialog.setCanceledOnTouchOutside(false);
                alertDialog.show();
            }
        });

        return view;
    }

}
