package com.example.karigusan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SecondFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SecondFragment() {
        // Required empty public constructor
    }


    public static SecondFragment newInstance(int imageResId, String text) {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putInt("imageResId", imageResId);
        args.putString("text", text);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second_fragment, container, false);

        ImageView imageView = view.findViewById(R.id.imageView);
        TextView textView = view.findViewById(R.id.textView);
        TextView title = view.findViewById(R.id.image_title);



        Bundle args = getArguments();
        if (args != null) {
            int imageResId = args.getInt("imageResId");
            String text = args.getString("text");
            imageView.setImageResource(imageResId);
            title.setText(text);

            if (text == "Cabana Beach Bar and Resort") {
                textView.setText(getResources().getString(R.string.cabana_desc));
            } else if (text == "ZOILO’s SEASIDE PRIVATE RESORT") {
                textView.setText(getResources().getString(R.string.zoilo_desc));
            } else if (text == "Vieness Beach Fron Resort") {
                textView.setText(getResources().getString(R.string.vieness_desc));
            } else if (text == "Don Mariano Beach House Resort") {
                textView.setText(getResources().getString(R.string.donmariano_desc));
            } else if (text ==  "Pambuhan Glamping") {
                textView.setText(getResources().getString(R.string.pambuhan_desc));
            } else if (text == "Palms Farm Resort") {
                textView.setText(getResources().getString(R.string.palms_desc));
            } else if (text ==  "Casanayon Resort") {
                textView.setText(getResources().getString(R.string.casanayon_desc));
            } else if (text == "Dome Place") {
                textView.setText(getResources().getString(R.string.domeplace_desc));
            } else if (text == "Maria Fatima Farm Resort") {
                textView.setText(getResources().getString(R.string.maria_desc));
            } else if (text == "Gardenn's Garden") {
                textView.setText(getResources().getString(R.string.garden_desc));
            } else if (text == "Pook Mirasol") {
                textView.setText(getResources().getString(R.string.pook_desc));
            } else if (text == "Zam’s Garden Resort") {
                textView.setText(getResources().getString(R.string.zams_desc));
            } else if (text == "Selfie Beach Resort") {
                textView.setText(getResources().getString(R.string.selfie_desc));
            } else if (text == "Greenland Resort") {
                textView.setText(getResources().getString(R.string.greenland_desc));
            } else if (text == "Candelaria Resort") {
                textView.setText(getResources().getString(R.string.candelaria_desc));
            } else if (text == "Gumaus Bay Resort") {
                textView.setText(getResources().getString(R.string.gumaus_desc));
            } else if (text == "Mambulao Pacific Resort") {
                textView.setText(getResources().getString(R.string.mambulao_desc));
            } else if (text == "Altheas Dreamland’s Resort") {
                textView.setText(getResources().getString(R.string.althea_desc));
            } else if (text == "Club noah Eco- Resort") {
                textView.setText(getResources().getString(R.string.noah_desc));
            } else if (text == "D’ GARDEN AGRI RESORT") {
                textView.setText(getResources().getString(R.string.agri_desc));
            } else if (text == "The Jars Hotel and Resort") {
                textView.setText(getResources().getString(R.string.jars_desc));
            } else if (text == "Calaguas Paradise Resort") {
                textView.setText(getResources().getString(R.string.calaguas_desc));
            } else if (text == "Mananap Falls") {
                textView.setText(getResources().getString(R.string.mananap_desc));
            }


        }

        Button favButton = view.findViewById(R.id.favBtn);
        favButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(requireContext(), "Added to Favorite", Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }
}