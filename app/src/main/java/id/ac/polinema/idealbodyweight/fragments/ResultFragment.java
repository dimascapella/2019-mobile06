package id.ac.polinema.idealbodyweight.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import id.ac.polinema.idealbodyweight.R;
import id.ac.polinema.idealbodyweight.util.BMIIndex;
import id.ac.polinema.idealbodyweight.util.BrocaIndex;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ResultFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class ResultFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private String information;
    private String subInfo;

    public ResultFragment() {
        // Required empty public constructor
    }

    public void setInformation(String information) {
        this.information = information;
    }
    public void setSubInfo(String subInfo){ this.subInfo = subInfo;}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_result, container, false);
        TextView informationText = view.findViewById(R.id.text_information);
        TextView sub = view.findViewById(R.id.Sub);
        sub.setText(subInfo);
        informationText.setText(information);
        Button tryAgainButton = view.findViewById(R.id.button_try_again);
        tryAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                int last = fm.getBackStackEntryCount() - 1;
                String name = fm.getBackStackEntryAt(last).getName();
                if(mListener != null){
                    mListener.onTryAgainButtonClicked(name);
                }
            }
        });
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
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
        void onTryAgainButtonClicked(String tag);
    }
}
