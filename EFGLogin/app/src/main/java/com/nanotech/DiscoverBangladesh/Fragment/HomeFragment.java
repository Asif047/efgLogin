package com.nanotech.DiscoverBangladesh.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.nanotech.DiscoverBangladesh.R;
import com.nanotech.DiscoverBangladesh.ShowDistrict.ShowDistrictActivity;
import com.nanotech.DiscoverBangladesh.SoundService;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {





    //new starts
    public static final String DEFAULT="N/A";
    //new ends



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
        View view= inflater.inflate(R.layout.fragment_home, container, false);

        Button btnDhaka=(Button)view.findViewById(R.id.dhaka_division_button);
        Button btnRangpur=(Button)view.findViewById(R.id.rangpur_division_button);
        Button btnRajshahi=(Button)view.findViewById(R.id.rajshahi_division_button);
        Button btnSylhet=(Button)view.findViewById(R.id.sylhet_division_button);
        Button btnKhulna=(Button)view.findViewById(R.id.khulna_division_button);
        Button btnBarishal=(Button)view.findViewById(R.id.barishal_division_button);
        Button btnChittagong=(Button)view.findViewById(R.id.chittagong_division_button);


//        //new starts
//        Button btnMymensingh=(Button)view.findViewById(R.id.mymensingh_division_button);
//        //new ends


        TextView mymensinghTV=(TextView)view.findViewById(R.id.mymensingh_textview);








        //new starts

        SharedPreferences sharedPreferences=this.getActivity().getSharedPreferences("SoundData",getActivity().MODE_PRIVATE);

        String soundInfo=sharedPreferences.getString("sound_info",DEFAULT);

        if(soundInfo.equals("Sound on"))
        {
            getActivity().startService(new Intent(getActivity(), SoundService.class));

        }
        else
        {

            getActivity().stopService(new Intent(getActivity(), SoundService.class));
        }

        //new ends














        btnDhaka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),ShowDistrictActivity.class);

                //new starts
                intent.putExtra("id","1");
                //new ends

                startActivity(intent);
            }
        });

        btnRajshahi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),ShowDistrictActivity.class);

                //new starts
                intent.putExtra("id","3");
                //new ends

                startActivity(intent);
            }
        });

        btnRangpur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),ShowDistrictActivity.class);

                //new starts
                intent.putExtra("id","7");
                //new ends

                startActivity(intent);
            }
        });



        btnSylhet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),ShowDistrictActivity.class);

                //new starts
                intent.putExtra("id","6");
                //new ends

                startActivity(intent);
            }
        });



        btnKhulna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),ShowDistrictActivity.class);

                //new starts
                intent.putExtra("id","4");
                //new ends

                startActivity(intent);
            }
        });

        btnBarishal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),ShowDistrictActivity.class);

                //new starts
                intent.putExtra("id","5");
                //new ends

                startActivity(intent);
            }
        });


        btnChittagong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),ShowDistrictActivity.class);

                //new starts
                intent.putExtra("id","2");
                //new ends

                startActivity(intent);
            }
        });



        //new starts
      mymensinghTV.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent=new Intent(getActivity(),ShowDistrictActivity.class);

              //new starts
              intent.putExtra("id","8");
              //new ends

              startActivity(intent);
          }
      });


        //new ends

        return view;

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
           // Toast.makeText(context,"Home Fragment Attached",Toast.LENGTH_LONG).show();
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
