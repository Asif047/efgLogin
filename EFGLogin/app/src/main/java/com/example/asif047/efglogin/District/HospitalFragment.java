package com.example.asif047.efglogin.District;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.asif047.efglogin.Hospital.ApiInterfaceHospital;
import com.example.asif047.efglogin.Hospital.Hospital;
import com.example.asif047.efglogin.Hospital.RecyclerAdapterHospital;
import com.example.asif047.efglogin.Hotel.ApiInterface;
import com.example.asif047.efglogin.Hotel.Hotel;
import com.example.asif047.efglogin.Hotel.RecyclerAdapter;
import com.example.asif047.efglogin.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HospitalFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HospitalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HospitalFragment extends Fragment {



    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapterHospital adapter;
    private List<Hospital> hospitals;
    private ApiInterfaceHospital apiInterfaceHospital;



    //new starts
    public  String BASE_URL="";
    public Retrofit retrofit=null;



    private String apiId="";

    //new ends


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public HospitalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HospitalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HospitalFragment newInstance(String param1, String param2) {
        HospitalFragment fragment = new HospitalFragment();
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


        View view= inflater.inflate(R.layout.fragment_hospital, container, false);



//        //new starts
//
//        //String id=getIntent().getStringExtra("id");
//
//
//
//        DistrictActivity activity = (DistrictActivity) getActivity();
//        apiId = activity.getMyData();
//
//
//        //String id=getIntent().getStringExtra("id");
//
//        Toast.makeText(getContext(),""+apiId,Toast.LENGTH_LONG).show();



        //new data get starts
        apiId=getActivity().getIntent().getStringExtra("district_id");

        //new data get ends




        BASE_URL="http://discover.nanotech.com.bd/api/place/"+apiId+"/";

        if(retrofit==null)
        {
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        //new ends




        try {


            recyclerView= (RecyclerView) view.findViewById(R.id.recylerview_hospital);
            layoutManager=new LinearLayoutManager(getActivity());

            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setHasFixedSize(true);

            //apiInterfaceTourist=ApiClientTourist.getApiClient().create(ApiInterfaceTourist.class);

            apiInterfaceHospital=retrofit.create(ApiInterfaceHospital.class);

            Call<List<Hospital>> call=apiInterfaceHospital.getHospital();

            call.enqueue(new Callback<List<Hospital>>() {
                @Override
                public void onResponse(Call<List<Hospital>> call, Response<List<Hospital>> response) {
                    hospitals=response.body();
                    //tourists.get(0).getAddress();
                    //Toast.makeText(getContext(),hospitals.get(0).getAddress().toString(),Toast.LENGTH_LONG).show();
                    adapter=new RecyclerAdapterHospital(getApplicationContext(),hospitals);

                    recyclerView.setAdapter(adapter);

                }

                @Override
                public void onFailure(Call<List<Hospital>> call, Throwable t) {

                }
            });


        }
        catch (Exception e)
        {

        }




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
            Toast.makeText(context,"Hospital Fragment Attached",Toast.LENGTH_LONG).show();
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
