package com.example.asif047.efglogin.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asif047.efglogin.R;
import com.example.asif047.efglogin.SoundService;


public class SettingsFragment extends Fragment implements CompoundButton.OnCheckedChangeListener{


    Switch soundSwitch;

    TextView soundTV;




    int sound;





    //new starts
    public static final String DEFAULT="N/A";
    //new ends



    private OnFragmentInteractionListener mListener;

    public SettingsFragment() {
        // Required empty public constructor
    }





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);










    }











    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_settings, container, false);







        return view;





    }








    //new starts

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //new starts
        soundSwitch=(Switch)getActivity().findViewById(R.id.sound_switch);
        soundTV=(TextView)getActivity().findViewById(R.id.sound_textview);

        soundSwitch.setOnCheckedChangeListener(SettingsFragment.this);








        SharedPreferences sharedPreferences=this.getActivity().getSharedPreferences("SoundData",getActivity().MODE_PRIVATE);

        String soundInfo=sharedPreferences.getString("sound_info",DEFAULT);


           // Toast.makeText(getContext(),"Data loaded successfully",Toast.LENGTH_LONG).show();

            if(soundInfo.equals("Sound off"))
            {

               // getActivity().stopService(new Intent(getActivity(), SoundService.class));
                soundSwitch.setChecked(false);

            }
            else
            {
               // getActivity().startService(new Intent(getActivity(), SoundService.class));
                soundSwitch.setChecked(true);
            }




        //new ends


    }


    //new ends







    //new starts

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("sound",sound);
    }

    //new ends













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
            Toast.makeText(context,"Settings Fragment",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {





        if(soundSwitch.isChecked())
        {
            sound=1;

            soundTV.setText("Sound on");



            SharedPreferences preferences = this.getActivity().getSharedPreferences("SoundData", Context.MODE_PRIVATE);

            SharedPreferences.Editor editor=preferences.edit();
            editor.putString("sound_info",soundTV.getText().toString());
            editor.commit();



            getActivity().startService(new Intent(getActivity(), SoundService.class));


        }
        else
        {
            sound=0;

            soundTV.setText("Sound off");

            SharedPreferences preferences = this.getActivity().getSharedPreferences("SoundData", Context.MODE_PRIVATE);

            SharedPreferences.Editor editor=preferences.edit();
            editor.putString("sound_info",soundTV.getText().toString());
            editor.commit();



            getActivity().stopService(new Intent(getActivity(), SoundService.class));
        }




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
