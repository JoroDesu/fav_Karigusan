package com.example.karigusan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class ListImage extends Fragment {

    private static final String[] imageNames = {
            "Cabana Beach Bar and Resort",
            "ZOILO’s SEASIDE PRIVATE RESORT",
            "Vieness Beach Fron Resort",
            "Don Mariano Beach House Resort",
            "Pambuhan Glamping",
            "Palms Farm Resort",
            "Casanayon Resort",
            "Dome Place",
            "Maria Fatima Farm Resort",
            "Gardenn's Garden",
            "Pook Mirasol",
            "Zam’s Garden Resort",
            "Selfie Beach Resort",
            "Greenland Resort",
            "Candelaria Resort",
            "Gumaus Bay Resort",
            "Mambulao Pacific Resort",
            "Altheas Dreamland’s Resort",
            "Club noah Eco- Resort",
            "D’ GARDEN AGRI RESORT",
            "The Jars Hotel and Resort",
            "Calaguas Paradise Resort",
            "Mananap Falls"
    };

    private static final int[] resortImages = {
            R.drawable.cabana2,
            R.drawable.zoilos2,
            R.drawable.vieness,
            R.drawable.donmariano3,
            R.drawable.pambuhan2,
            R.drawable.palms2,
            R.drawable.casanayon,
            R.drawable.domeplace2,
            R.drawable.maria2,
            R.drawable.garden2,
            R.drawable.pook3,
            R.drawable.zams2,
            R.drawable.selfie3,
            R.drawable.greenland,
            R.drawable.candelaria2,
            R.drawable.gumaus,
            R.drawable.mambulao2,
            R.drawable.althea2,
            R.drawable.noah,
            R.drawable.agri,
            R.drawable.jars,
            R.drawable.calaguas2,
            R.drawable.mananap
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_image, container, false);

        GridView gridView = view.findViewById(R.id.gridView);
        GridAdapter gridViewAdapter = new GridAdapter(requireContext(), resortImages, imageNames);
        gridView.setAdapter(gridViewAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(requireContext(), "You Clicked on " + imageNames[position], Toast.LENGTH_SHORT).show();
                int imageResId = resortImages[position];
                String text = imageNames[position];

                openSecondFragment(imageResId, text);

            }
        });


        return view;
    }

    private void openSecondFragment(int imageResId, String text) {
        Fragment secondFragment = SecondFragment.newInstance(imageResId, text);
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView2, secondFragment); // Replace fragment_container with your actual container ID
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }
}
