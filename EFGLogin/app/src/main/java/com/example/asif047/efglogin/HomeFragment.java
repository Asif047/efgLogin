package com.example.asif047.efglogin;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

<<<<<<< HEAD
=======
import com.example.asif047.efglogin.Divisions.BarishalDivisionActivity;
import com.example.asif047.efglogin.Divisions.ChittagongDivisionActivity;
import com.example.asif047.efglogin.Divisions.DhakaDivisionActivity;
import com.example.asif047.efglogin.Divisions.KhulnaDivisionActivity;
import com.example.asif047.efglogin.Divisions.RajshahiDivisionActivity;
import com.example.asif047.efglogin.Divisions.RangpurDivisionActivity;
import com.example.asif047.efglogin.Divisions.SylhetDivisionActivity;

>>>>>>> local6

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        //new starts

       View view=inflater.inflate(R.layout.fragment_home, container, false);

        Button dhakaBtn=(Button)view.findViewById(R.id.button_dhaka);
        Button rajshahiBtn=(Button)view.findViewById(R.id.button_rajshahi);
        Button rangpurBtn=(Button)view.findViewById(R.id.button_rangpur);
        Button khulnaBtn=(Button)view.findViewById(R.id.button_khulna);
        Button sylhetBtn=(Button)view.findViewById(R.id.button_sylhet);
        Button barishalBtn=(Button)view.findViewById(R.id.button_barishal);
        Button chittagongBtn=(Button)view.findViewById(R.id.button_chittagong);


        dhakaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),DhakaDivisionActivity.class);
                startActivity(intent);

                //Toast.makeText(getActivity(),"Dhaka division",Toast.LENGTH_SHORT).show();
            }
        });


        rajshahiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),RajshahiDivisionActivity.class);
                startActivity(intent);

            }
        });



        rangpurBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),RangpurDivisionActivity.class);
                startActivity(intent);

            }
        });



        sylhetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),SylhetDivisionActivity.class);
                startActivity(intent);

            }
        });



        khulnaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),KhulnaDivisionActivity.class);
                startActivity(intent);

            }
        });



        barishalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),BarishalDivisionActivity.class);
                startActivity(intent);

            }
        });



        chittagongBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),ChittagongDivisionActivity.class);
                startActivity(intent);

            }
        });




        return view;


        //new ends

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            Toast.makeText(context,"Home Fragment Attached",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
