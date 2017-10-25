package com.example.asif047.efglogin.District;

import android.app.ProgressDialog;
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

import com.example.asif047.efglogin.R;
import com.example.asif047.efglogin.Security.ApiInterfaceSecurity;
import com.example.asif047.efglogin.Security.RecyclerAdapterSecurity;
import com.example.asif047.efglogin.Security.Security;
import com.example.asif047.efglogin.Tourist.ApiInterfaceTourist;
import com.example.asif047.efglogin.Tourist.RecyclerAdapterTourist;
import com.example.asif047.efglogin.Tourist.Tourist;

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
 * {@link SecurityFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SecurityFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecurityFragment extends Fragment {





    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapterSecurity adapter;
    private List<Security> securities;
    private ApiInterfaceSecurity apiInterfaceSecurity;




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

    public SecurityFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SecurityFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SecurityFragment newInstance(String param1, String param2) {
        SecurityFragment fragment = new SecurityFragment();
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
        View view= inflater.inflate(R.layout.fragment_tourist, container, false);



        //new starts
        final ProgressDialog mProgressDialog = new ProgressDialog(getActivity());
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage("Loading...");
        mProgressDialog.show();
        //new ends


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




        try
        {
            recyclerView= (RecyclerView) view.findViewById(R.id.recylerview_tourist);
            layoutManager=new LinearLayoutManager(getActivity());

            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setHasFixedSize(true);

            //apiInterfaceTourist=ApiClientTourist.getApiClient().create(ApiInterfaceTourist.class);

            apiInterfaceSecurity=retrofit.create(ApiInterfaceSecurity.class);

            Call<List<Security>> call=apiInterfaceSecurity.getSecurity();

            call.enqueue(new Callback<List<Security>>() {
                @Override
                public void onResponse(Call<List<Security>> call, Response<List<Security>> response) {


                    //new starts

                    if (mProgressDialog.isShowing())
                        mProgressDialog.dismiss();
                    //new ends


                    securities=response.body();
                    //tourists.get(0).getAddress();
                    //  Toast.makeText(getContext(),tourists.get(0).getAddress().toString(),Toast.LENGTH_LONG).show();
                    adapter=new RecyclerAdapterSecurity(getApplicationContext(),securities);


                    recyclerView.setAdapter(adapter);

                }

                @Override
                public void onFailure(Call<List<Security>> call, Throwable t) {

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
            Toast.makeText(context,"Security Fragment Attached",Toast.LENGTH_LONG).show();
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
