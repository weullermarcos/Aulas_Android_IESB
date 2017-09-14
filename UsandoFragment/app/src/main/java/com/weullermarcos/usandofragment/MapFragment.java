package com.weullermarcos.usandofragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.weullermarcos.usandofragment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment {

    Button btnMarket;
    boolean isExtend = true;

    public MapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_map, container, false);


        btnMarket = (Button) view.findViewById(R.id.btnMarket);


        btnMarket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Toast.makeText(getActivity().getApplicationContext(), "Meu texto", Toast.LENGTH_LONG).show();

                MainActivity mainActivity = (MainActivity) getActivity();

                LinearLayout.LayoutParams param;

                if(isExtend) {

                    param = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            30.0f
                    );

                    isExtend = false;

                }
                else{


                    param = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            0.0f
                    );

                    isExtend = true;

                }

                mainActivity.lltMap.setLayoutParams(param);

            }
        });

        return view;

    }
}
